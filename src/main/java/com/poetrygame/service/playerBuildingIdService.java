package com.poetrygame.service;

import com.poetrygame.dto.playerBuildingId;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 9:57
 * @Description:
 */
public interface playerBuildingIdService {

    playerBuildingId getPlayerBuildingId(Long playerId);

}
