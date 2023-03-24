package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/17
 * @Time: 8:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class buildingTopic {

    private Integer topicCount;

    private Long playerBuildingId;

    private Long playerTopicId;
}
