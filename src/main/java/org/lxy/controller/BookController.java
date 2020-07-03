package org.lxy.controller;

import lombok.extern.slf4j.Slf4j;
import org.lxy.api.BasePageRequest;
import org.lxy.dao.BookMapper;
import org.lxy.model.Book;
import org.lxy.service.CrawlBookService;
import org.lxy.service.QueryBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Resource
    private QueryBookService queryBookService;
    @Resource
    private BookMapper bookMapper;

    @RequestMapping("/getPage")
    public Object getPage(@RequestParam(defaultValue = "1", required = false) int pageNo,
                          @RequestParam(defaultValue = "5", required = false) int pageSize) {
        return queryBookService.page(new BasePageRequest(pageNo, pageSize));
    }

    @RequestMapping("/restPage/{pageSize}/{pageNo}")
    public Object page(@PathVariable("pageSize") int pageSize,
                       @PathVariable("pageNo") int pageNo) {
        return queryBookService.page(new BasePageRequest(pageNo, pageSize));
    }

    @RequestMapping("/page")
    public Object page(@RequestBody BasePageRequest basePageRequest) {
        return queryBookService.page(basePageRequest);
    }

    @RequestMapping("/queryByName")
    public Object queryByName(@RequestParam String bookName) {
        return queryBookService.queryByName(bookName);
    }

    @RequestMapping("/testUpdate")
    public Object testUpdate(){
        Book book = queryBookService.page(new BasePageRequest(1, 1)).get(0);
        if (null != book){
            book.setQuote("Whatever it takes -- Imagine Dragons " + new Random().nextInt(100));
            bookMapper.updateById(book);
            return book;
        }
        return "No Book in Database";
    }
}
