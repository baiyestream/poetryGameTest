package com.poetrygame.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.poetrygame.pojo.PlayerInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2022/12/13
 * @Time: 20:22
 * @Description:
 */
@Mapper
@Repository
public interface PlayInformationMapper extends BaseMapper<PlayerInformation> {

    int insert(PlayerInformation playerInformation);


    // 测试：登录接口
    int insertTest(PlayerInformation playerInformation);
    // 测试：查询openId返回给前端
    Long openId(String openId);
    // 测试：获取玩家昵称，并将玩家昵称保存到数据库
    int saveAliasName(String aliasName,String weixinId);

    PlayerInformation lifeInformation(String weixinId);

    Integer playerInformationOne(Long playerId);
    Date playerInformationTwo(Long playerId);
    Integer addActiveValue(String weixinId);


}
