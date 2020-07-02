package org.lxy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.lxy.api.BasePageRequest;
import org.lxy.dao.BookMapper;
import org.lxy.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2020/7/2
 */
@Service
@Slf4j
public class QueryBookServiceImpl implements QueryBookService{

    @Resource
    private BookMapper bookMapper;

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
