package com.poetrygame.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2023/2/8
 * @Time: 13:25
 * @Description: 城市地图表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_city_map")
public class cityMap implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "城市ID")
    private Integer cityId;
    @ApiModelProperty(value = "图片ID")
    private Integer pictureId;
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    @ApiModelProperty(value = "主题分类")
    private Integer topicTypeId;
    @ApiModelProperty(value = "概述")
    private String profile;
    @ApiModelProperty(value = "网格起始X")
    private Integer gridStartX;
    @ApiModelProperty(value = "网格起始Y")
    private Integer gridStartY;
    @ApiModelProperty(value = "网格宽")
    private Integer gridWidth;
    @ApiModelProperty(value = "网格高")
    private Integer gridHeight;
    @ApiModelProperty(value = "网格行数")
    private Integer gridRows;
    @ApiModelProperty(value = "网格列数")
    private Integer gridColumns;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "创建人")
    private Integer creatorId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "审批人")
    private Integer approvorId;
    @ApiModelProperty(value = "审批时间")
    private Integer approvrTime;
    @ApiModelProperty(value = "变更人")
    private Integer operatorId;
    @ApiModelProperty(value = "变更原因")
    private String changeReason;
    @ApiModelProperty(value = "变更时间")
    private Date changeTime;
    @ApiModelProperty(value = "关联建筑状态")
    private Integer connBuildingStatus;
    @ApiModelProperty(value = "关联次数")
    private Integer connTimes;
    @ApiModelProperty(value = "关联创建人")
    private Integer connCreatorId;
    @ApiModelProperty(value = "关联创建时间")
    private Date connCreateTime;
    @ApiModelProperty(value = "关联审批人")
    private Integer connApprovorId;
    @ApiModelProperty(value = "关联审批时间")
    private Date connApproveTime;

}
