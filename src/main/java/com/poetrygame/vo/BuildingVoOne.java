package com.poetrygame.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/7
 * @Time: 10:46
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingVoOne {
    @ApiModelProperty(value = "建筑id")
    private Integer buildingId;
    @ApiModelProperty(value = "建筑在城市地图上的横轴坐标")
    private Integer positionX;
    @ApiModelProperty(value = "建筑在城市地图上的纵轴坐标")
    private Integer positionY;
}
