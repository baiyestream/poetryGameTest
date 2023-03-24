package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 8:42
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class receiveResults {

    private String openId;

    private Long playerTopicId;

    private Integer topicStatus;

    private Integer countryId;

    private Integer cityId;

    private Integer buildingId;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long startTime;

    private Long endTime;
}
