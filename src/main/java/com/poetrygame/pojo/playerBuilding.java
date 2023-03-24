package com.poetrygame.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 8:15
 * @Description:  玩家游历建筑表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_player_building")
public class playerBuilding implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "玩家建筑ID")
    private Long playerBuildingId;
    @ApiModelProperty(value = "城市建筑ID")
    private Integer cityBuildingId;
    @ApiModelProperty(value = "玩家ID")
    private Long playerId;
    @ApiModelProperty(value = "分配题目数量")
    private Integer topicCount;
    @ApiModelProperty(value = "完成题目数量")
    private Integer doneTopic;
}
