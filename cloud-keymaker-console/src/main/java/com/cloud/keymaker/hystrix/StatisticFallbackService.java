package com.cloud.keymaker.hystrix;

import com.cloud.keymaker.feign.StatisticFeignService;
import com.cloud.keymaker.result.Result;
import com.cloud.keymaker.result.StatusCode;
import com.cloud.keymaker.result.StatusMsg;

/**
 * @PackageName: com.cloud.keymaker.hystrix
 * @ClassName: StatisticFallbackService
 * @Description: This is StatisticFallbackService class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 22:54
 */
public class StatisticFallbackService implements StatisticFeignService {
    @Override
    public Result discovery() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result getServiceInfo() {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result addCount(Long aid) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }

    @Override
    public Result getSum(Long aid, String date) {
        return new Result(StatusCode.FALLBACK, StatusMsg.FALLBACK);
    }
}
