package com.poetrygame.mapper;

import com.poetrygame.vo.topicDetailVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/23
 * @Time: 16:30
 * @Description:
 */
@Mapper
public interface topicDetailVoMapper {

   // 根据玩家题目表的玩家题目ID来查询玩家游历建筑表的城市建筑ID，分配题目数量，完成题目数量
    topicDetailVo topicDetailVo(Long playerTopicId);
}
