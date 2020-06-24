package org.lxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

/**
 * 2020/6/24
 */
@Configuration
public class RedisEmbeddedServerConfig {

    @Bean(name = "redisServer", initMethod = "start", destroyMethod = "stop")
    public RedisServer initServer() {
        return new RedisServer(6379);
    }
}
