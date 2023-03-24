package com.poetrygame.topicService;

import com.poetrygame.dto.topicSum;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:19
 * @Description:
 */
public interface topicSumService {

    topicSum getTopicSum(Long playerTopicId);
    topicSum getTopicSumNull(Long playerTocId);
}
