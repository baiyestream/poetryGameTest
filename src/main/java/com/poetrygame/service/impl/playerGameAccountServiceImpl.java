package com.poetrygame.service.impl;

import com.poetrygame.mapper.playerGameAccountMapper;
import com.poetrygame.service.playerGameAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 12:41
 * @Description:
 */
@Service
public class playerGameAccountServiceImpl implements playerGameAccountService {

    @Autowired
    private playerGameAccountMapper playerGameAccountMapper;

    // 判断用户是否是第一次玩游戏,非空判断
    @Override
    public Integer getIsOnly(Long playerId) {
        return playerGameAccountMapper.isOnly(playerId);
    }
}
