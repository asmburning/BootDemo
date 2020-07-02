package org.lxy.controller;

import lombok.extern.slf4j.Slf4j;
import org.lxy.api.BasePageRequest;
import org.lxy.service.CrawlBookService;
import org.lxy.service.QueryBookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Resource
    private QueryBookService queryBookService;

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
}
