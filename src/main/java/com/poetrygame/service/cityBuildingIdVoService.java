package com.poetrygame.service;

import com.poetrygame.vo.cityBuildingIdVo;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 16:32
 * @Description:
 */
public interface cityBuildingIdVoService {

    // 根据玩家基础信息表的player_id查出城市建筑关联表的城市建筑ID,城市ID,建筑ID
    cityBuildingIdVo getCityBuildingId(Long playerId);
}
