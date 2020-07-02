package org.lxy.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.lxy.dao.BookMapper;
import org.lxy.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2020/7/2
 */
@Service
@Slf4j
public class CrawlBookGoogleServiceImpl implements CrawlBookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public String siteName() {
        return "google";
    }

    @Override
    public void crawlBook() {
        String url = "https://scholar.google.com/scholar?hl=en&as_sdt=0%2C5&q=happiness&oq=happy";
        Document document = getDocument(url);
        Elements elements = document.select("#gs_res_ccl_mid > div");
        List<Book> bookList = elements.stream()
                .filter(element -> null != element.selectFirst(".gs_rt > a") )
                .map(element ->
                Book.builder()
                        .bookName(element.selectFirst(".gs_rt > a").text())
                        .remark(element.selectFirst(".gs_a").text())
                        .rating(element.selectFirst(".gs_fl").text())
                        .build())
                .collect(Collectors.toList());
        for (Book book : bookList) {
            bookMapper.insert(book);
        }

    }


    public Document getDocument(String url) {
        Document document = null;
        try {
            return document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36")
                    .get();
        } catch (Exception e) {
            log.error("JSoupNetworkError url:{}", url);
            throw new RuntimeException("----networkError:{}" + url, e);
        }
    }
}
