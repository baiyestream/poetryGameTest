package com.poetrygame.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2023/2/13
 * @Time: 8:34
 * @Description:  玩家题目明细表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_topic_play_detail")
public class topicPlayDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "玩家题目ID")
    private Long playerTopicId;
    @ApiModelProperty(value = "玩家建筑ID")
    private Long playerBuildingId;
    @ApiModelProperty(value = "题目ID")
    private Long topicId;
    @ApiModelProperty(value = "玩家ID")
    private Long playerId;
    @ApiModelProperty(value = "题目状态")
    // 0为未做 1为已完成
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer topicStatus;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "用时")
    private Integer usedTime;
}
