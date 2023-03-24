package com.poetrygame.service;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 12:40
 * @Description:
 */
public interface playerGameAccountService {

    // 判断用户是否是第一次玩游戏,非空判断
    Integer getIsOnly(Long playerId);
}
