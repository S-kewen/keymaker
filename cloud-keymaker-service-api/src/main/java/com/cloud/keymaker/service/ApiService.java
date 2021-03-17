package com.cloud.keymaker.service;

import com.cloud.keymaker.entity.Api;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.service
 * @ClassName: ApiService
 * @Description: This is ApiService interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:22
 */
public interface ApiService {
    List<Map<String, Object>> getList(int page, int size,Api api);

    int insertOne(Api api);

    int deleteOne(Api api);

    int updateOne(Api api);

    int getCount(Api api);

    Api getById(@Param("id") Long id);
}
