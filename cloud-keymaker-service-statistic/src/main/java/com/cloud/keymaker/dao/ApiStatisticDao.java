package com.cloud.keymaker.dao;

import com.cloud.keymaker.entity.ApiStatistic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.dao
 * @ClassName: ApiStatisticDao
 * @Description: This is ApiStatisticDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 20:38
 */
@Mapper
public interface ApiStatisticDao {
    int insertOne(ApiStatistic apiStatistic);

    int getCount(ApiStatistic apiStatistic);

    Long getSum(ApiStatistic apiStatistic);

    ApiStatistic selectOne(ApiStatistic apiStatistic);

    int addCountById(Long id);
}
