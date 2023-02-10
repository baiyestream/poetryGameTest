package com.poetrygame.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 8:07
 * @Description: 国家地图上所对应的城市坐标点
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryVO implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "城市id")
    private Integer cityId;
    @ApiModelProperty(value = "城市在国家地图上的横轴坐标")
    private Integer positionX;
    @ApiModelProperty(value = "城市在国家地图上的纵轴坐标")
    private Integer positionY;
}
