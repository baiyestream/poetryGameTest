package com.poetrygame.service;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 13:50
 * @Description:
 */
public interface buildingService {

    // 根据buildingId在建筑表中取出容纳的题目数
    Integer getTopicLimit(Integer buildingId);

    // 根据buildingId取出建筑名称
    String getBuildingName(Integer buildingId);
}
