package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 9:44
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class playerBuildingId {

    private Long playerBuildingId;

    private Integer cityBuildingId;

    private Integer cityId;

    private Integer topicCount;

    private Integer doneTopic;

    private Long playerId;

    private Integer countryId;

    private Integer buildingId;


}
