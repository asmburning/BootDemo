package org.lxy.controller;

import io.lettuce.core.RedisFuture;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 2020/6/24
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private StatefulRedisConnection lettuceConnection;

    @RequestMapping("/testSetNxEx")
    public Object testSetNxEx() {
        SetArgs setArgs = SetArgs.Builder
                .ex(30)
                .nx();
        String testNx = lettuceConnection.sync().set("org.lxy:demo:testNx", "testNx", setArgs);
        return StringUtils.equals("OK", testNx);
    }

    @RequestMapping("/testAsync")
    public Object testAsync() throws Exception {
        RedisFuture<String> async = lettuceConnection.async().set("org.lxy:demo:async", "async", SetArgs.Builder.ex(50));
        return async.get(100, TimeUnit.MILLISECONDS);
    }

    @RequestMapping("/testAsync2")
    public Object testAsync2() throws Exception {
        RedisFuture<String> async = lettuceConnection.async().set("org.lxy:demo:asyncAccept", "asyncAccept", SetArgs.Builder.ex(50));
        async.thenAccept(s -> log.info(s));
        return "Processing please wait a moment!";
    }

    @RequestMapping("/testTemplate")
    public Object testTemplate() {
        String key = "org.lxy:demo:template";
        redisTemplate.opsForValue().set(key, "template", 30, TimeUnit.SECONDS);
        return redisTemplate.opsForValue().get(key);
    }
}
