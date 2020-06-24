package org.lxy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class TestBooks {
    @Resource
    private TestRestTemplate testRestTemplate;

    @Test
    public void testBookPage() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/book/getPage?pageNo=1&pageSize=4", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        List<Book> books = JsonUtils.toList(response.getBody(), Book.class);
        Assert.assertSame(books.size(), 4);
        books.forEach(book -> System.out.println(book.getBookName()));
    }
}
