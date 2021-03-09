package com.cloud.keymaker.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName: com.cloud.keymaker.entity
 * @ClassName: ApiStatistic
 * @Description: This is ApiStatistic class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 20:32
 */
@Data
public class ApiStatistic implements Serializable {
    private Long id;
    private Long aid;
    private Long count;
    private String statistic_date;
    private Date add_time;
}
