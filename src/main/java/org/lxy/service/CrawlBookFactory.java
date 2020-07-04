package org.lxy.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 2020/7/2
 */
@Component
public class CrawlBookRouter {
    private Map<String, CrawlBookService> crawlBookServiceMap;

    @Autowired
    public void CustomMapFromListDynamicAutowireService(List<CrawlBookService> regionServices) {
        crawlBookServiceMap = regionServices.stream()
                .collect(Collectors.toMap(CrawlBookService::siteName, Function.identity()));
    }

    public void crawlBook(String siteName) {
        CrawlBookService service = crawlBookServiceMap.get(siteName);
        service.crawlBook();
    }

}
