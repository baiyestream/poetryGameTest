package com.poetrygame.dto.getTopic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/24
 * @Time: 14:02
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class buildingLimit {

    private Integer hardLevel;

    private Integer countryId;

    private Integer countryCityId;

    private Integer buildingId;

    private Integer cityBuildingId;

    private Integer topicLimit;
}
