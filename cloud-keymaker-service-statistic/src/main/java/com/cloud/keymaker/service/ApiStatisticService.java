package com.cloud.keymaker.service;

import com.cloud.keymaker.entity.ApiStatistic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @PackageName: com.cloud.keymaker.service
 * @ClassName: ApiStatisticService
 * @Description: This is ApiStatisticService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 20:48
 */

public interface ApiStatisticService {
    int insertOne(ApiStatistic apiStatistic);

    int getCount(ApiStatistic apiStatistic);

    Long getSum(ApiStatistic apiStatistic);

    ApiStatistic selectOne(ApiStatistic apiStatistic);

    int addCountById(@Param("id")Long id);
}
