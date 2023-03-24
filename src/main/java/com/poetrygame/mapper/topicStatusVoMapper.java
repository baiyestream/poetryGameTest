package com.poetrygame.mapper;

import com.poetrygame.vo.topicStatusVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/2/22
 * @Time: 13:55
 * @Description:
 */
@Mapper
public interface topicStatusVoMapper {

    // 根据playerId获取topic_id和topic_status
    topicStatusVo topicStatus(Long playerId);
}
