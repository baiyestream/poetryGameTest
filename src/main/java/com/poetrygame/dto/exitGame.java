package com.poetrygame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/21
 * @Time: 9:41
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class exitGame {

    private String openId;

    private Long exitGameTime;

    private Integer lifeCount;
}
