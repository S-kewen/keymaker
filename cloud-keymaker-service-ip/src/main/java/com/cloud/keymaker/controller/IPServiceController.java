package com.cloud.keymaker.controller;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cloud.keymaker.entity.IPResult;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: IPServiceController
 * @Description: This is IPServiceController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 23:21
 */
@RestController
@RequestMapping("/v1/api/open/ip")
public class IPServiceController {
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

    @RequestMapping("select")
    public Result select(String ip) {
        JSONObject jsonObject = JSONUtil.parseObj(HttpUtil.get("http://ip-api.com/json/" + ip, CharsetUtil.CHARSET_UTF_8));
        return new Result(StatusCode.OK, StatusMsg.OK, JSONUtil.toBean(jsonObject, IPResult.class));
    }
}
