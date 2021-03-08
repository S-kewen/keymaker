package com.cloud.keymaker.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: EncryptServiceController
 * @Description: This is EncryptServiceController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-08 23:40
 */
@RestController
@RequestMapping("/v1/api/open/encrypt")
public class EncryptServiceController {
    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String application;
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("discovery")
    public Result discovery() {
        //服务发现
        return new Result(StatusCode.OK, StatusMsg.OK, discoveryClient);
    }

    @RequestMapping("getServiceInfo")
    public Result getServiceInfo() throws UnknownHostException {
        Map<String, Object> map = new HashMap<>();
        map.put("application", application);
        map.put("ipv4", InetAddress.getLocalHost().getHostAddress());
        map.put("port", port);
        return new Result(StatusCode.OK, StatusMsg.OK, map);
    }

    @RequestMapping("createRsaKey")
    public Result createRsaKey() {
        Map<String,Object> map = new HashMap<>();
        KeyPair keyPair = SecureUtil.generateKeyPair("RSA");
        System.out.println(keyPair.getPrivate().toString());
        map.put("private",StrUtil.subBetween(keyPair.getPrivate().toString(),"modulus:","\r\n"));
        map.put("public",StrUtil.subBetween(keyPair.getPublic().toString(),"modulus:","\r\n"));
        ;
        return new Result(StatusCode.OK,StatusMsg.OK,map);
    }
}
