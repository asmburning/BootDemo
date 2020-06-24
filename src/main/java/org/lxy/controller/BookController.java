package org.lxy.controller;

import lombok.extern.slf4j.Slf4j;
import org.lxy.api.BasePageRequest;
import org.lxy.service.DoubanService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/book")
public class BookController {

    @Resource
    private DoubanService doubanService;

    @RequestMapping("/getPage")
    public Object getPage(@RequestParam(defaultValue = "1", required = false) int pageNo,
                          @RequestParam(defaultValue = "5", required = false) int pageSize) {
        try {

            return doubanService.page(new BasePageRequest(pageNo, pageSize));
        } catch (Exception e) {
            log.error("getPage error ", e);
            return null;
        }
    }

    @RequestMapping("/restPage/{pageSize}/{pageNo}")
    public Object page(@PathVariable("pageSize") int pageSize,
                       @PathVariable("pageNo") int pageNo) {
        return doubanService.page(new BasePageRequest(pageNo, pageSize));
    }

    @RequestMapping("/page")
    public Object page(@RequestBody BasePageRequest basePageRequest) {
        return doubanService.page(basePageRequest);
    }

    @RequestMapping("/queryByName")
    public Object queryByName(@RequestParam String bookName) {
        return doubanService.queryByName(bookName);
    }
}
