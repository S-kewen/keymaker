package com.cloud.keymaker.dao;

import com.cloud.keymaker.entity.ApiParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.cloud.keymaker.dao
 * @ClassName: ApiParameterDao
 * @Description: This is ApiParameterDao interface by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 21:37
 */
@Mapper
public interface ApiParameterDao {
    List<Map<String, Object>> getList(ApiParameter apiParameter);

    int insertOne(ApiParameter apiParameter);

    int deleteOne(ApiParameter apiParameter);

    int updateOne(ApiParameter apiParameter);

    int getCount(ApiParameter apiParameter);
}
