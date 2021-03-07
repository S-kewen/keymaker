package com.cloud.keymaker.entity;

import lombok.Data;

import java.util.Date;

/**
 * @PackageName: com.cloud.keymaker.entity
 * @ClassName: ApiParameter
 * @Description: This is ApiParameter class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-07 21:27
 */
@Data
public class ApiParameter {
    private Long id;
    private Long aid;
    private int type;
    private int state;
    private String column_name;
    private String column_must;
    private String column_type;
    private String column_explain;
    private String remark;
    private Date add_time;
}
