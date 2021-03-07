package com.cloud.keymaker.entity;

import lombok.Data;

/**
 * @PackageName: com.cloud.keymaker.entity
 * @ClassName: IPResult
 * @Description: This is IPResult class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 23:29
 */
@Data
public class IPResult {
    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String city;
    private String zip;
    private float lat;
    private float lon;
    private String timezone;
    private String isp;
    private String org;
    private String as;
    private String query;
}
