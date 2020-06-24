package org.lxy.event;

import org.lxy.service.DoubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ReadyEvent {

    @Resource
    private DoubanService doubanService;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        doubanService.crawlDouban();
    }
}
