package org.lxy.event;

import lombok.extern.slf4j.Slf4j;
import org.lxy.service.DoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class ReadyEvent {

    @Resource
    private DoubanService doubanService;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        log.info("ApplicationReadyEvent");
        doubanService.crawlDouban();
    }
}
