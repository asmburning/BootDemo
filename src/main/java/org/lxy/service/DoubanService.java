package org.lxy.service;

import org.lxy.api.BasePageRequest;
import org.lxy.model.Book;

import java.util.List;

public interface DoubanService {

    void crawlDouban();

    List<Book> page(BasePageRequest request);

    List<Book> queryByName(String bookName);
}
