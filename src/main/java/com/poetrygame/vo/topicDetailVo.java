package com.poetrygame.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 16:18
 * @Description: 通过玩家题目明细表的player_building_id去获取玩家游历建筑表的city_building_id,topic_count,done_topic
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicDetailVo {

    private Integer cityBuildingId;
    private Integer topicCount;
    private Integer doneTopic;
    private Long playerTopicId;
    private Long playerBuildingId;
}
