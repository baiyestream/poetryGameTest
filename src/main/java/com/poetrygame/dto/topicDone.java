package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:55
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicDone {

    private Integer doneTopic;

    private Long playerBuildingId;

    private Long playerTopicId;
}
