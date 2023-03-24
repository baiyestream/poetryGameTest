package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 12:40
 * @Description:
 */
@Mapper
public interface playerGameAccountMapper {

    // 判断用户是否是第一次玩游戏,非空判断
    Integer isOnly(Long playerId);
}
