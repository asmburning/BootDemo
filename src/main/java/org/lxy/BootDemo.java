package org.lxy;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 2020/6/24
 */
@SpringBootApplication
@Slf4j
public class BootDemo {

    public static void main(String[] args) {
        SpringApplication.run(BootDemo.class, args);
        log.info("---------------BootDemo Start Success------------");
    }
}
