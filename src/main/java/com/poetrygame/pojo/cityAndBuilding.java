package com.poetrygame.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/9
 * @Time: 14:04
 * @Description:  城市建筑关联表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cityAndBuilding implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "城市建筑主键ID")
    private Integer cityBuildingId;
    @ApiModelProperty(value = "城市ID")
    private Integer cityId;
    @ApiModelProperty(value = "建筑ID")
    private Integer buildingId;
    @ApiModelProperty(value = "摆放位置X")
    private Integer positionX;
    @ApiModelProperty(value = "摆放位置Y")
    private Integer positionY;
}
