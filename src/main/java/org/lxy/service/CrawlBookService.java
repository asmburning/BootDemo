package org.lxy.service;

import org.lxy.api.BasePageRequest;
import org.lxy.model.Book;

import java.util.List;

public interface CrawlBookService {

    String siteName();

    void crawlBook();

}
