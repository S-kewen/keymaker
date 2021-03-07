package com.cloud.keymaker.controller;

import com.cloud.keymaker.entity.Api;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;
import com.cloud.keymaker.service.ApiService;
import com.cloud.keymaker.util.Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.controller
 * @ClassName: ApiController
 * @Description: This is ApiController class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:32
 */
@RestController
@RequestMapping("/v1/api/api")
public class ApiController {
    @Autowired
    private ApiService apiService;
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

    @RequestMapping("listApi")
    public Result listApi(int page, int size, String sortName, String sortType, int type, int state, String search) {
        Api api = new Api();
        api.setType(type);
        api.setState(state);
        api.setTitle(search);
        PageHelper.startPage(page, size, Util.sort(sortName, sortType));
        List<Map<String, Object>> select = apiService.getList(api);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(select);
        return new Result(StatusCode.OK, StatusMsg.OK,pageInfo.getList() );
    }

    @RequestMapping("getApiInfo")
    public Result getById(Long id) {
        Api api = apiService.getById(id);
        if (api != null) {
            return new Result(StatusCode.OK, StatusMsg.OK, api);
        }
        return new Result(StatusCode.SELECTFAIL, StatusMsg.SELECTFAIL);
    }

    @RequestMapping("getCount")
    public Result getCount(){
        return new Result(StatusCode.OK, StatusMsg.OK,apiService.getCount(new Api()));
    }
}
