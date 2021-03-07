package com.cloud.keymaker.feign;

import com.cloud.keymaker.config.FeignConfig;
import com.cloud.keymaker.hystrix.FallbackService;
import com.cloud.keymaker.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @PackageName: com.cloud.keymaker.feign
 * @ClassName: UuidFeignService
 * @Description: This is UuidFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:35
 */
@Component
@FeignClient(value = "cloud-keymaker-service-uuid",fallback=FallbackService.class,configuration = FeignConfig.class)
public interface UuidFeignService {
    @RequestMapping("/v1/api/open/uuid/discovery")
    public Result discovery();

    @RequestMapping("/v1/api/open/uuid/getServiceInfo")
    public Result getServiceInfo();

    @RequestMapping("/v1/api/open/uuid/create")
    public Result create(@RequestParam("num") int num);
}
