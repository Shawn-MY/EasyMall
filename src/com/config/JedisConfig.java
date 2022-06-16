package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @author MingYu
 * @Date 2022/3/13
 */
@Configuration
public class JedisConfig {
    @Bean
    public JedisPool jedisPool()
    {
        return new JedisPool();
    }
}
