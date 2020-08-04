package org.lxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 2020/6/24
 */
@SpringBootApplication
@Slf4j
@EnableAspectJAutoProxy
public class BootDemo {

    public static void main(String[] args) {
        SpringApplication.run(BootDemo.class, args);
        log.info("---------------BootDemo Start Success------------");
    }

}
