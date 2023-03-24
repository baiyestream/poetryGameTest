package com.poetrygame.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 13:42
 * @Description:  玩家非第一次进入游戏，判断上次最后退出游戏之前题目的状态是未做还是已做
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicStatusVo {

    private Long playerTopicId;

    private Long topicId;

    private Integer topicStatus;

    private Long playerId;
}
