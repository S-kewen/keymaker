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
 * @ClassName: IPFeignService
 * @Description: This is IPFeignService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 21:45
 */
@Component
@FeignClient(value = "cloud-keymaker-service-ip",fallback=FallbackService.class,configuration = FeignConfig.class)
public interface IpFeignService {
    @RequestMapping("/v1/api/open/ip/discovery")
    public Result discovery();

    @RequestMapping("/v1/api/open/ip/getServiceInfo")
    public Result getServiceInfo();

    @RequestMapping("/v1/api/open/ip/select")
    public Result select(@RequestParam("ip") String ip);
}
