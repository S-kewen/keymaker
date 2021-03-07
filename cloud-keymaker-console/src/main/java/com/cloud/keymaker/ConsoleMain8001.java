package com.cloud.keymaker;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @PackageName: com.cloud.keymaker
 * @ClassName: ConsoleMain8001
 * @Description: This is ConsoleMain8001 class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:49
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ConsoleMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(ConsoleMain8001.class, args);
        System.out.println("ConsoleMain8001-启动完毕!");
    }
}
