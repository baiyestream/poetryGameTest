package com.poetrygame.mapper;

import com.poetrygame.vo.topicVoOne;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/24
 * @Time: 13:48
 * @Description:
 */
@Mapper
public interface topicVoOneMapper {

    // 根据玩家题目信息表的topic_static以及player_building_id查出题目信息表的content
    topicVoOne topicVoOne(Long playerBuildingId);
}
