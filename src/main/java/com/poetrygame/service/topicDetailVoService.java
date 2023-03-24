package com.poetrygame.service;

import com.poetrygame.vo.topicDetailVo;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 16:31
 * @Description:
 */
public interface topicDetailVoService {

    // 根据玩家题目表的玩家题目ID来查询玩家游历建筑表的城市建筑ID，分配题目数量，完成题目数量
    topicDetailVo getTopicDetailVo(Long playerTopicId);
}
