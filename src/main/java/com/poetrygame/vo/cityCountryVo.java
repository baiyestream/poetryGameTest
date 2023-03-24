package com.poetrygame.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/16
 * @Time: 15:44
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class cityCountryVo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "城市id")
    private Integer cityId;
    @ApiModelProperty(value = "国家id")
    private Integer countryId;
    @ApiModelProperty(value = "国家名称")
    private String countryName;

    private String savedAddr;

    private Integer pictureId;



}
