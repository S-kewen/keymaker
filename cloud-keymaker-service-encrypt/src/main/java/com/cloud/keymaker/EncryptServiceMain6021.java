package com.cloud.keymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: EncryptServiceMain6021
 * @Description: This is EncryptServiceMain6021 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-08 23:39
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class EncryptServiceMain6021 {
    public static void main(String[] args) {
        SpringApplication.run(EncryptServiceMain6021.class, args);
        System.out.println("EncryptServiceMain6021-启动完毕!");
    }
}
