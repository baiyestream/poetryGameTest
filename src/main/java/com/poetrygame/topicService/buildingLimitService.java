package com.poetrygame.topicService;

import com.poetrygame.dto.getTopic.buildingLimit;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/24
 * @Time: 14:40
 * @Description:
 */
public interface buildingLimitService {

    List<buildingLimit> getBuildingLimitOne();

    Integer getBuildingLimitTwo();

    Integer getBuildingLimitThree();

    Integer getBuildingLimitFour();
}
