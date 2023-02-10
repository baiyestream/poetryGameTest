package com.poetrygame.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 14:13
 * @Description: 城市地图上所对应的建筑坐标点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuildingVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "建筑id")
    private Integer buildingId;
    @ApiModelProperty(value = "建筑在城市地图上的横轴坐标")
    private Integer positionX;
    @ApiModelProperty(value = "建筑在城市地图上的纵轴坐标")
    private Integer positionY;
}
