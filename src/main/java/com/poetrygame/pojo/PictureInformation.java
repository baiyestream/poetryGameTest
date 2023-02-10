package com.poetrygame.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2023/2/7
 * @Time: 21:58
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictureInformation {

    @ApiModelProperty(value = "图片id")
    private Integer pictureId;
    @ApiModelProperty(value = "设计人id")
    private Integer designerId;
    @ApiModelProperty(value = "图片名称")
    private String pictureName;
    @ApiModelProperty(value = "用途分类")
    private Integer purposeId;
    @ApiModelProperty(value = "图片宽度")
    private Integer width;
    @ApiModelProperty(value = "图片高度")
    private Integer height;
    @ApiModelProperty(value = "引用次数")
    private Integer usedTimes;
    @ApiModelProperty(value = "状态")
    private Integer status;
    @ApiModelProperty(value = "图片地址")
    private String savedAddr;
    @ApiModelProperty(value = "创建人")
    private Integer creatorId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "审批人")
    private Integer approvorId;
    @ApiModelProperty(value = "审批时间")
    private Date approveTime;
    @ApiModelProperty(value = "变更人")
    private Integer operatorId;
    @ApiModelProperty(value = "变更原因")
    private String changeReason;
    @ApiModelProperty(value = "变更时间")
    private Date changeTime;

}
