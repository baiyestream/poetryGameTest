package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/3
 * @Time: 12:45
 * @Description:  根据player_building_id查询城建筑id,建筑名称,城市id,城市名称,国家id,国家名称
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class gisInformation {

    private Integer cityBuildingId;

    private Integer countryCityId;

    private Integer cityId;

    private Integer buildingId;

    private Integer countryId;

    private String buildingName;

    private String countryName;

    private String cityName;

    private Long playerBuildingId;

    private Long topicId;

    private Integer topicStatus;

    private Long playerTopicId;

    private String content;
}
