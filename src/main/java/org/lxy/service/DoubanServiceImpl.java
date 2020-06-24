package org.lxy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.lxy.api.BasePageRequest;
import org.lxy.dao.BookMapper;
import org.lxy.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class DoubanServiceImpl implements DoubanService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public void crawlDouban() {
        Consumer<List<Book>> bookListConsumer = books -> books.forEach(book -> bookMapper.insert(book));
        List<List<Book>> collect = getURLList().parallelStream()
                .map(this::parseDoubanBook)
                .collect(Collectors.toList());
        log.info("{}", collect.size());

        collect.forEach(bookListConsumer);
    }

    private List<String> getURLList() {
        final String top250BooksBaseUrl = "https://book.douban.com/top250?start=";
        return IntStream.range(0, 2)
                .mapToObj(a -> top250BooksBaseUrl + String.valueOf(a))
                .collect(Collectors.toList());
    }

    private List<Book> parseDoubanBook(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36")
                    .get();
        } catch (Exception e) {
            log.error("parseDoubanBook url:{}", url, e);
            throw new RuntimeException("parseDoubanBookErrorWithUrl:{}" + url);
        }
        Elements bookTables = document.select("#content > div > div.article > div > table");
        return bookTables.stream()
                .map(element ->
                        Book.builder()
                                .bookName(element.select(".pl2").text())
                                .remark(element.select(".pl").text())
                                .rating(element.select(".star").text())
                                .quote(element.select(".quote").text())
                                .build()
                )
                .collect(Collectors.toList());

    }

    @Override
    public List<Book> page(BasePageRequest request) {
        log.info("-----query page--- request:{}", request);
        return bookMapper.selectPage(new Page<>(request.getPageNo(), request.getPageSize()),
                new QueryWrapper<Book>())
                .getRecords();
    }

    @Override
    public List<Book> queryByName(String bookName) {
        return bookMapper.selectList(new QueryWrapper<Book>()
                .eq("book_name", bookName));
    }
}
