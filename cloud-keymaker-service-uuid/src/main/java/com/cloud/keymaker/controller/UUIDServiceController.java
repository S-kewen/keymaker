package com.cloud.keymaker.controller;

import cn.hutool.core.util.IdUtil;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: UUIDController
 * @Description: This is UUIDController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:25
 */
@RestController
@RequestMapping("/v1/api/open/uuid")
public class UUIDServiceController {
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

    @RequestMapping("create")
    public Result addCount(int num) {
        if (num <= 0 || num > 100) {
            return new Result(StatusCode.PARAMERROR, StatusMsg.PARAMERROR);
        }
        String[] uuids = new String[num];
        for (int i = 0; i < num; i++) {
            uuids[i] = IdUtil.randomUUID();
        }
        return new Result(StatusCode.OK, StatusMsg.OK, uuids);
    }
}
