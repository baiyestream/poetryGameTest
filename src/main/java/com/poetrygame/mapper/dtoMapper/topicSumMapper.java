package com.poetrygame.mapper.dtoMapper;

import com.poetrygame.dto.topicSum;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:18
 * @Description:
 */
@Mapper
public interface topicSumMapper {

    topicSum topicSum(Long playerTopicId);
    topicSum topicSumNull(Long playerTocId);
}
