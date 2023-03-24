package com.poetrygame.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/2/24
 * @Time: 13:41
 * @Description:  根据玩家题目信息表的topic_static以及player_building_id查出题目信息表的content
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicVoOne {

    private Long playerBuildingId;

    private Integer topicStatus;

    private Long topicId;

    private String content;
}
