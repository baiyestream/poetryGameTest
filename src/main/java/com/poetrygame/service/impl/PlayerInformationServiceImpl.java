package com.poetrygame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poetrygame.mapper.PlayInformationMapper;
import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.service.PlayerInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zzw
 * @Date: 2022/12/13
 * @Time: 20:29
 * @Description:
 */
@Service
public class PlayerInformationServiceImpl extends ServiceImpl<PlayInformationMapper,PlayerInformation> implements PlayerInformationService  {

    @Resource
    private PlayInformationMapper playInformationMapper;


    @Override
    public int register(PlayerInformation playerInformation) {
        return playInformationMapper.insert(playerInformation);
    }

    // 测试:登录接口
    @Override
    public int loginTest(PlayerInformation playerInformation) {
        return playInformationMapper.insertTest(playerInformation);
    }
    // 测试：查询openId返回给前端
    @Override
    public Long getOpenId(String openId) {
        return playInformationMapper.openId(openId);
    }
    // 测试：获取玩家昵称，并将玩家昵称保存到数据库
    @Override
    public int getSaveAliasName(String aliasName,String weixinId) {
        return playInformationMapper.saveAliasName(aliasName,weixinId);
    }

    @Override
    public PlayerInformation getLifeInformation(String weixinId) {
        return playInformationMapper.lifeInformation(weixinId);
    }




}
