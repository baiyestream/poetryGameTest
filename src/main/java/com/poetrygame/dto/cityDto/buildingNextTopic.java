package com.poetrygame.dto.cityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/16
 * @Time: 15:31
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class buildingNextTopic {

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

    private Long playerId;

    private Integer topicCount;

    private Integer topicLimit;
}
