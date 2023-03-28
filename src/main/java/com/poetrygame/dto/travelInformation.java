package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/28
 * @Time: 16:11
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class travelInformation {

    private Integer buildingId;

    private Integer cityBuildingId;

    private Long playerId;

    private Integer cityId;

    private Integer countryId;

    private Integer countryCityId;

    private Integer topicCount;

    private Integer doneTopic;

}
