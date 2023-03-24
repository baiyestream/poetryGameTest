package com.poetrygame.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2022/12/13
 * @Time: 15:29
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_player_information")
public class PlayerInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long playerId;
    private String aliasName;
    private String weixinId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registeTime;
    private Integer playerLevel;
    private Integer lifeCount;
    private Integer lifeLimit;
    private Integer restPrompt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date exitTime;
    private Long playerBuildingId;
    private String password;
    private String realName;
    private Integer sex;
    private String phoneNumber;
    private String idCardNumber;
    private Integer status;
    private Integer warnTimes;
    private Integer activeValue;
}
