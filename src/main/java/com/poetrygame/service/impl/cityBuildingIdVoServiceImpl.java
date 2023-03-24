package com.poetrygame.service.impl;

import com.poetrygame.mapper.cityBuildingIdVoMapper;
import com.poetrygame.service.cityBuildingIdVoService;
import com.poetrygame.vo.cityBuildingIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 16:33
 * @Description:
 */
@Service
public class cityBuildingIdVoServiceImpl implements cityBuildingIdVoService {

    @Autowired
    private cityBuildingIdVoMapper cityBuildingIdVoMapper;

    // 根据玩家基础信息表的player_id查出城市建筑关联表的城市建筑ID,城市ID,建筑ID
    @Override
    public cityBuildingIdVo getCityBuildingId(Long playerId) {
        return cityBuildingIdVoMapper.cityBuildingId(playerId);
    }
}
