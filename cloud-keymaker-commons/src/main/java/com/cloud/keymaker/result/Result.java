package com.cloud.keymaker.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @PackageName: com.boot.hellokebbi.pattern.result
 * @ClassName: Result
 * @Description: This is Result class by Skwen.
 * @Author: Skwen
 * @Date: 2020-12-13 17:41
 */
@Data
@NoArgsConstructor
public class Result implements Serializable {
    private Integer code;

    private String msg;

    private long timestamp = System.currentTimeMillis() / 1000;

    private Object data;


    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
