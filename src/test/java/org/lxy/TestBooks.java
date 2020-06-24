package org.lxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxy.api.BasePageRequest;
import org.lxy.model.Book;
import org.lxy.utils.JsonUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 2020/6/24
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class TestBooks {
    @Resource
    private TestRestTemplate testRestTemplate;

    @Test
    public void testBookPagePost() {
        ResponseEntity<String> response = testRestTemplate.postForEntity("/book/page",
                new BasePageRequest(3, 4),
                String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        List<Book> books = JsonUtils.toList(response.getBody(), Book.class);
        Assert.assertSame(books.size(), 4);
        books.forEach(book -> log.info(book.getBookName()));
    }

    @Test
    public void testBookPage() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/book/getPage?pageNo=1&pageSize=4", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        List<Book> books = JsonUtils.toList(response.getBody(), Book.class);
        Assert.assertSame(books.size(), 4);
        books.forEach(book -> log.info(book.getBookName()));
    }

    @Test
    public void testBookPageRest() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/book/restPage/5/2", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        List<Book> books = JsonUtils.toList(response.getBody(), Book.class);
        Assert.assertSame(books.size(), 5);
        books.forEach(book -> log.info(book.getBookName()));
    }

    @Test
    public void testBookNameQuery() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/book/queryByName?bookName=红楼梦", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        List<Book> books = JsonUtils.toList(response.getBody(), Book.class);
        Assert.assertSame(books.size(), 1);
        books.forEach(book -> log.info(book.getBookName()));
    }
}
