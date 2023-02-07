package com.poetrygame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poetrygame.pojo.PlayerInformation;

/**
 * @Author: zzw
 * @Date: 2022/12/13
 * @Time: 20:28
 * @Description:
 */
public interface PlayerInformationService extends IService<PlayerInformation> {

    int register(PlayerInformation playerInformation);

    // 测试:登录接口
    int loginTest(PlayerInformation playerInformation);
    // 测试：查询openId返回给前端
    String getOpenId(String openId);
    // 测试：获取玩家昵称，并将玩家昵称保存到数据库
    int getSaveAliasName(String aliasName,Long playerId);




}
