package com.poetrygame.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 16:14
 * @Description:  根据玩家基础信息表的player_id查出城市建筑关联表的城市建筑ID,城市ID,建筑ID
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cityBuildingIdVo {

    private Long playerId;

    private Long playerTopicId;

    private Long playerBuildingId;

    private Integer cityBuildingId;

    private Integer countryCityId;

    private Integer cityId;

    private Integer buildingId;
}
