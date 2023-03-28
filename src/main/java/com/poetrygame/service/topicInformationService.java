package com.poetrygame.service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:14
 * @Description:
 */
public interface topicInformationService {

    // 第一次取:随机取出题目信息表里对应建筑容纳量的题目id
    List<Integer> getTopicId(Integer topicLimit);

    // 根据玩家题目明细表的topic_id查出题目信息表的content
    String getTopicContent(Long topicId);

    Integer getTopicSum();

    Integer topicLevelOne();
    Integer topicLevelTwo();
    Integer topicLevelThree();

    List<Integer> getTopicLevelOneCount();
    List<Integer> getTopicLevelTwoCount();
    List<Integer> getTopicLevelThreeCount();

    List<Integer> getTopicLevelOneSelect(Integer differTopic);
    List<Integer> getTopicLevelTwoSelect(Integer differTopic);
    List<Integer> getTopicLevelThreeSelect(Integer differTopic);
}
