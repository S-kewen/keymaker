package com.cloud.keymaker.util;

/**
 * @PackageName: com.cloud.keymaker.util
 * @ClassName: Util
 * @Description: This is Util class by Skwen.
 * @Author: Skwen
 * @Date: 2021-03-06 18:47
 */
public class Util {
    public static String sort(String sortName, String sortType) {
        String sort = "";
        if (sortName != null && sortName != "") {
            sort = sortName;
            if (sortType != null && sortType != "") {
                sort += " " + sortType;
            }
        }
        return sort;
    }
}
