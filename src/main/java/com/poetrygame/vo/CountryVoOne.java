package com.poetrygame.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zzw
 * @Date: 2023/3/7
 * @Time: 11:20
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryVoOne {

    @ApiModelProperty(value = "城市id")
    private Integer cityId;
    @ApiModelProperty(value = "城市在国家地图上的横轴坐标")
    private Integer positionX;
    @ApiModelProperty(value = "城市在国家地图上的纵轴坐标")
    private Integer positionY;
}
