package com.poetrygame.mapper;

import com.poetrygame.vo.cityBuildingIdVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 16:35
 * @Description:
 */
@Mapper
public interface cityBuildingIdVoMapper {

    // 根据玩家基础信息表的player_id查出城市建筑关联表的城市建筑ID,城市ID,建筑ID
    cityBuildingIdVo cityBuildingId(Long playerId);
}
