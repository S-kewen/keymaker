package com.cloud.keymaker.config;

import com.google.common.collect.Maps;

import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.config
 * @ClassName: Properties
 * @Description: This is Properties class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-09 23:54
 */
@Configuration
public class Properties {

    private final Map<String, Duration> initCaches = Maps.newHashMap();

    public Map<String, Duration> getInitCaches() {

        return initCaches;

    }

}
