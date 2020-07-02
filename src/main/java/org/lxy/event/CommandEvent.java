package org.lxy.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 2020/6/30
 */
@Component
@Slf4j
public class CommandEvent implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        log.info("CommandEvent");
    }
}
