package org.lxy.event;

import lombok.extern.slf4j.Slf4j;
import org.lxy.service.CrawlBookStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class ReadyEvent {

    @Value("${crawl.site}")
    private String crawlSite;

    @Resource
    private CrawlBookStrategy crawlBookStrategy;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        log.info("ApplicationReadyEvent");
        crawlBookStrategy.crawlBook(crawlSite);
    }
}
