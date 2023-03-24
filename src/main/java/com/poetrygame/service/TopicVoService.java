package com.poetrygame.service;

import com.poetrygame.vo.TopicVo;

/**
 * @Author: zzw
 * @Date: 2023/2/17
 * @Time: 13:35
 * @Description:
 */
public interface TopicVoService {

    // 根据题目信息表以及玩家题目明细表选出其中没有答过的题目发给前端 (传参playerId)
    TopicVo getTopicVoContent(Long playerId);
}
