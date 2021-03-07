package com.cloud.keymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: UUIDServiceMain6001
 * @Description: This is UUIDServiceMain6001 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:54
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class IPServiceMain6011 {
    public static void main(String[] args) {
        SpringApplication.run(IPServiceMain6011.class, args);
        System.out.println("IPServiceMain6011-启动完毕!");
    }
}
