package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/14
 * @Time: 13:49
 * @Description:
 */
@Mapper
public interface buildingMapper {

    // 根据buildingId在建筑表中取出容纳的题目数
    Integer topicLimit(Integer buildingId);

    // 根据buildingId取出建筑名称
    String buildingName(Integer buildingId);
}
