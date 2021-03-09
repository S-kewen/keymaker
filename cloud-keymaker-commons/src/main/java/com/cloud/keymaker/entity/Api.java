package com.cloud.keymaker.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @PackageName: com.cloud.keymaker.entity
 * @ClassName: Api
 * @Description: This is Api class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:15
 */
@Data
public class Api implements Serializable {
    private Long id;
    private Long aid;
    private int type;
    private int state;
    private String title;
    private String description;
    private String url;
    private String request_type;
    private String request_demo;
    private String response_type;
    private String response_demo;
    private String remark;
    private Date add_time;
}
