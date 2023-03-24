package com.poetrygame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poetrygame.pojo.topicPlayDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 10:54
 * @Description:
 */
@Mapper
public interface topicPlayDetailMapper extends BaseMapper<topicPlayDetail> {

    //批量插入:将playerBuildingId,topicId,topicStatus插入到玩家题目明细表,长度为对应建筑物的题目容量
    Integer insertBatch(List<topicPlayDetail> list);
    //根据玩家题目明细表的玩家建筑id，题目id,玩家id来查出唯一玩家题目id
    Long selectPlayTopicId(Long playerId,Long playerBuildingId,Long topicId);
    // 将题目的具体信息更新到数据库
    Integer updateTopic(Integer topicStatus, String startTime, Long usedTime, Long playerTopicId);

    Integer isExist(Long playId);

    // 查询玩家是否完成所有题目
    Integer undoneCount(Long playerId);

}
