package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.buildingTopic;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/17
 * @Time: 8:53
 * @Description:
 */
@Mapper
public interface buildingTopicMapper {
    buildingTopic buildingTopic(Long playerTopicId);
}
