package org.lxy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lxy.dao.BookMapper;
import org.lxy.model.Book;
import org.lxy.service.CrawlBookService;
import org.lxy.service.CrawlBookDouBanServiceImpl;
import org.lxy.service.QueryBookService;
import org.lxy.service.QueryBookServiceImpl;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.LinkedList;
import java.util.List;

/**
 * 2020/6/24
 */
@RunWith(MockitoJUnitRunner.class)
public class BookMockTest {

    private QueryBookService queryBookService;

    @Mock
    private BookMapper bookMapper;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        queryBookService = new QueryBookServiceImpl();
    }

    @Test
    public void testQueryByName() {
        String bookName = "Java Concurrency In Practise";
        Book book = Book.builder()
                .bookName(bookName)
                .remark("Awesome Concurrent Programming Book")
                .build();
        List<Book> books = new LinkedList<>();
        books.add(book);

        BDDMockito.when(bookMapper.selectList(new QueryWrapper<Book>().eq("book_name", bookName)))
                .thenReturn(books);
        List<Book> concurrencyBooks = queryBookService.queryByName(bookName);
//        Assert.assertNotNull(concurrencyBooks.get(0));
//        Assert.assertEquals(concurrencyBooks.get(0).getBookName(), bookName);
    }
}
