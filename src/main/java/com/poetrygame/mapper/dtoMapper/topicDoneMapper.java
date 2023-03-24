package com.poetrygame.mapper.dtoMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:57
 * @Description:
 */
@Mapper
public interface topicDoneMapper {

    Integer topicDone(Long playerTopicId,Integer doneTopic);
}
