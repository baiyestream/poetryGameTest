package com.poetrygame.service;

/**
 * @Author: zzw
 * @Date: 2023/3/21
 * @Time: 9:48
 * @Description:
 */
public interface exitGameService {

    Integer getUpdateLimit(String exitTime,Integer lifeCount,String weixinId);
}
