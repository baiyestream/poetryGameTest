package com.poetrygame.commonTest;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class commonResponse<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String message; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> commonResponse<T> successByRegister(T object){
        commonResponse<T> r = new commonResponse<T>();
        r.message = "注册成功";
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> commonResponse<T> successByLogin(T object){
        commonResponse<T> r = new commonResponse<T>();
        r.message = "登录成功";
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> commonResponse<T> success(T object) {
        commonResponse<T> r = new commonResponse<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> commonResponse<T> error(String message) {
        commonResponse r = new commonResponse();
        r.message = message;
        r.code = 0;
        return r;
    }

    public commonResponse<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public static commonResponse fail(final String message) {
        /*
         * 412代表未满足条件
         */
        final commonResponse r = new commonResponse();
        r.setCode(200);
        r.setMessage(message);

        return r;
    }
}
