package org.lxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 2020/7/2
 * simple factory pattern
 * concentrate the create logic, encapsulate the changes
 * if everybody decide what kind of crawlService, once requirements changes,
 * everybody need change their code.
 */
@Component
public class CrawlBookFactory {
    private Map<String, CrawlBookService> crawlBookServiceMap;

    @Autowired
    public void CustomMapFromListDynamicAutowireService(List<CrawlBookService> crawlBookServices) {
        crawlBookServiceMap = crawlBookServices.stream()
                .collect(Collectors.toMap(CrawlBookService::siteName, Function.identity()));
    }

    public void crawlBook(String siteName) {
        CrawlBookService service = crawlBookServiceMap.get(siteName);
        service.crawlBook();
    }

}
