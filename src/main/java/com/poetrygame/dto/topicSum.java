package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 13:15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class topicSum {

    private Integer totalSum;

    private Long playerBuildingId;

    private Integer topicStatus;

    private Long playerTopicId;
}
