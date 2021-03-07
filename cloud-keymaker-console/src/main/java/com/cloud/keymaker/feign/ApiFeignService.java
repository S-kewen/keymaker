package com.cloud.keymaker.feign;

import com.cloud.keymaker.config.FeignConfig;
import com.cloud.keymaker.hystrix.ApiFallbackService;
import com.cloud.keymaker.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @PackageName: com.cloud.keymaker.feign
 * @ClassName: ConsoleFeignService
 * @Description: This is ConsoleFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 19:02
 */
@Component
@FeignClient(value = "cloud-keymaker-service-api", fallback = ApiFallbackService.class, configuration = FeignConfig.class)
public interface ApiFeignService {
    @RequestMapping("/v1/api/api/discovery")
    public Result discovery();

    @RequestMapping("/v1/api/api/getServiceInfo")
    public Result getServiceInfo();

    @RequestMapping("/v1/api/api/listApi")
    public Result listApi(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sortName") String sortName, @RequestParam("sortType") String sortType, @RequestParam("type") int type, @RequestParam("state") int state,@RequestParam("search") String search);

    @RequestMapping("/v1/api/api/getApiInfo")
    public Result getById(@RequestParam("id") Long id);

    @RequestMapping("/v1/api/api/getCount")
    public Result getCount();
}
