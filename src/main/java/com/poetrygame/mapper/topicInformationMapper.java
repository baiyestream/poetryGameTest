package com.poetrygame.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:13
 * @Description:
 */
@Mapper
public interface topicInformationMapper {

    // 第一次取:随机取出题目信息表里对应建筑容纳量的题目id
    List<Integer> topicId(Integer topicLimit);

    // 根据玩家题目明细表的topic_id查出题目信息表的content
    String topicContent(Long topicId);

    Integer topicSum();
}
