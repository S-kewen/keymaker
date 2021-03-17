package com.cloud.keymaker.config;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.config
 * @ClassName: RedisConfig
 * @Description: This is RedisConfig class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-09 23:23
 */
//@Configuration
public class RedisConfig {// extends CachingConfigurerSupport
//    @Autowired
//    private Properties properties;
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
//
//
//        RedisCacheConfiguration cacheConfiguration =
//                RedisCacheConfiguration.defaultCacheConfig()
//                        .entryTtl(Duration.ofMinutes(10))
//                        .disableCachingNullValues()
//                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new
//                                GenericJackson2JsonRedisSerializer()));
//        return RedisCacheManager.builder(factory).cacheDefaults(cacheConfiguration).build();
//    }
}