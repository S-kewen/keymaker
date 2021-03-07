package com.cloud.keymaker.dao;

import com.cloud.keymaker.entity.Api;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.dao
 * @ClassName: ApiDao
 * @Description: This is ApiDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:17
 */
@Mapper
public interface ApiDao {
    List<Map<String, Object>> getList(Api api);

    int insertOne(Api api);

    int deleteOne(Api api);

    int updateOne(Api api);

    int getCount(Api api);

    Api getById(@Param("id") Long id);
}
