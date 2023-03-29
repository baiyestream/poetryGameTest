package com.poetrygame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poetrygame.pojo.topicPlayDetail;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:55
 * @Description:
 */

public interface topicPlayDetailService extends IService<topicPlayDetail> {

    // 批量插入:将playerBuildingId,topicId,topicStatus插入到玩家题目明细表,长度为对应建筑物的题目容量
    Integer getInsertBatch(List<topicPlayDetail> list);
    //根据玩家题目明细表的玩家建筑id，题目id,玩家id来查出唯一玩家题目id
    Long getSelectPlayTopicId(Long playerId,Long playerBuildingId,Long topicId);
    // 将题目的具体信息更新到数据库
    Integer updateTopicToMysql(Integer topicStatus, String startTime, Long usedTime, Long playerTopicId);

    Integer getIsExist(Long playId);

    // 查询玩家是否完成所有题目
    Integer getUndoneCount(Long playerId);
    Integer getCumulativeAnswers(Long playerId);


}
