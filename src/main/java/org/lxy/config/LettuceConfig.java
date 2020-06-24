package org.lxy.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.time.Duration;

/**
 * lettuce advocates single connection per application
 * If you don't use any transactions/blocking commands, then there is almost no reason for connection pooling.
 * Lettuce connections are thread-safe and can be shared amongst multiple threads.
 * Lettuce is an event-driven client that handles commands asynchronously.
 * @see <a href="https://github.com/lettuce-io/lettuce-core/issues/360">https://github.com/lettuce-io/lettuce-core/issues/360</a>
 * 2020/6/24
 */
@Configuration()
@DependsOn(value = "redisServer")
public class LettuceConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Bean
    public RedisClient initLettuce() {
        return RedisClient.create(new RedisURI(redisHost, redisPort, Duration.ofSeconds(10)));
    }

    @Bean
    public StatefulRedisConnection lettuceConnection(RedisClient redisClient) {
        return redisClient.connect();
    }
}
