package com.poetrygame.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.poetrygame.common.R;
import com.poetrygame.config.WeChatConfig;
import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.pojo.TokenModel;
import com.poetrygame.service.PlayerInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zzw
 * @Date: 2022/12/13
 * @Time: 20:31
 * @Description:
 */

@Api(tags = "玩家模块")
@RestController
@RequestMapping("/playInformation")
@CrossOrigin
public class PlayInformationController {

    @Resource
    private PlayerInformationService playerInformationService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeChatConfig weChatConfig;

    // 测试:获取玩家昵称
    @ApiImplicitParams({
            //参数效验
            @ApiImplicitParam(name="aliasName",value = "玩家昵称",required = true,paramType="string"),
            @ApiImplicitParam(name="openId",value = "openId",required = true,paramType = "string")
    })
    @ApiOperation(value = "通过openId将玩家昵称存入数据库")
    @PostMapping("/getNickname")
    public R<String> getNickname(String aliasName, String openId){

        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId);
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        if(one == null){
            return R.error("用户不存在，保存失败");
        }

        Long playerId = one.getPlayerId();
        int saveAliasName = playerInformationService.getSaveAliasName(aliasName,playerId);
        if(saveAliasName == 0){
            return R.error("保存失败");
        }
        return R.success(null,"保存玩家昵称成功");
    }
    // 微信：用户第一次登录，请求获得openId

    @ApiImplicitParams({
            //参数效验
            @ApiImplicitParam(name="code",value="授权码",required=true,paramType="form"),
    })
    @ApiOperation(value = "微信扫码登录")
    @PostMapping("/login")
    public R<Map<String, String>> appletsLogin(@RequestBody TokenModel tokenModel) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", weChatConfig.getAppid());
        requestMap.put("secret", weChatConfig.getAppSecret());
        requestMap.put("code", tokenModel.getCode());

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, requestMap);
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String openId = jsonObject.getString("openid");

        System.out.println(openId);
        // 先判断openId是否在数据库中存在，如果存在，直接取出openId返回给前端，如果不存在，则存入数据，再返回
        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId );
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        if (one != null) {
            String weixinId = one.getWeixinId();
            Map<String, String> map = new HashMap<>();
            map.put("openid", weixinId);
            return R.successByLogin(map);
        }
        Date date = new Date();

        PlayerInformation playerInformation = new PlayerInformation();
        playerInformation.setWeixinId(openId);
        playerInformation.setRegisteTime(date);
        playerInformation.setLifeLimit(10);
        playerInformation.setLifeCount(10);

        int insertDate = playerInformationService.loginTest(playerInformation);
        if (insertDate != 1) {
            return R.error("数据插入失败");
        }
        String openId1 = playerInformationService.getOpenId(openId);

        Map<String, String> map1 = new HashMap<>();
        map1.put("openid", openId1);
        return R.successByRegister(map1);
    }

}
