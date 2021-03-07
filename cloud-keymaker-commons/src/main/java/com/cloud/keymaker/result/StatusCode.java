package com.cloud.keymaker.result;

/**
 * @PackageName: com.boot.hellokebbi.pattern.result
 * @ClassName: StatusCode
 * @Description: This is StatusCode class by Skwen.
 * @Author: Skwen
 * @Date: 2020-12-13 17:41
 */
public class StatusCode {
    public static final int OK = 200;//成功
    public static final int NOTFOUND = 404;//404
    public static final int ERROR = 500;//失败
    public static final int FALLBACK = 502;//服务降级
    public static final int BREAK = 503;//服务熔断
    public static final int INSERTFAIL = -1000;//插入数据失败
    public static final int SELECTFAIL = -1001;//查询数据失败
    public static final int UPDATEFAIL = -1002;//更新数据失败
    public static final int PARAMERROR = -1003;//参数错误

}
