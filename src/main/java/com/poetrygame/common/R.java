package com.poetrygame.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R<T> {

    private Integer code; //编码：1成功，0和其它数字为失败

    private String message; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> successByRegister(T object){
        R<T> r = new R<T>();
        r.message = "注册成功";
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> successByLogin(T object){
        R<T> r = new R<T>();
        r.message = "登录成功";
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> success(T object,String message) {
        R<T> r = new R<T>();
        r.message = message;
        r.data = object;
        r.code = 1;
        return r;
    }


    public static <T> R<T> error(String message) {
        R r = new R();
        r.message = message;
        r.code = 0;
        return r;
    }

    public static <T> R<T> error(T object,String message) {
        R<T> r = new R<T>();
        r.message = message;
        r.data = object;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public static R fail(final String message) {
        /*
         * 412代表未满足条件
         */
        final R r = new R();
        r.setCode(200);
        r.setMessage(message);

        return r;
    }
}
