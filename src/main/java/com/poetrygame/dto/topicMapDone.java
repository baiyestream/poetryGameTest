package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/7
 * @Time: 8:27
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicMapDone {

    private Integer doneTopic;

    private Integer topicCount;

    private Long playerId;

    private Integer cityBuildingId;

    private Integer cityId;

    private Integer buildingId;

    private Long playerBuildingId;
}
