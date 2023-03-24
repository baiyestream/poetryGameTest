package com.poetrygame.service.impl;

import com.poetrygame.dto.playerBuildingId;
import com.poetrygame.mapper.dtoMapper.playerBuildingIdMapper;
import com.poetrygame.service.playerBuildingIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 10:00
 * @Description:
 */
@Service
public class playerBuildingIdServiceImpl implements playerBuildingIdService {

    @Autowired
    private playerBuildingIdMapper playerBuildingIdMapper;
    @Override
    public playerBuildingId getPlayerBuildingId(Long playerId) {
        return playerBuildingIdMapper.playerBuildingId(playerId);
    }
}
