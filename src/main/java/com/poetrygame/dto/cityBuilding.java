package com.poetrygame.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/1
 * @Time: 15:20
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cityBuilding {

    private Integer cityBuildingId;
    private Integer topicLimit;
}
