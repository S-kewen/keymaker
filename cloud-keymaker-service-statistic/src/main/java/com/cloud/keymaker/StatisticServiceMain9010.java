package com.cloud.keymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: StatisticServiceMain9010
 * @Description: This is StatisticServiceMain9010 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 20:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StatisticServiceMain9010 {

    public static void main(String[] args) {
        SpringApplication.run(StatisticServiceMain9010.class, args);
        System.out.println("StatisticServiceMain9010-启动完毕!");
    }
}
