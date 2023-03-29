package com.poetrygame.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.poetrygame.common.R;
import com.poetrygame.config.WeChatConfig;
import com.poetrygame.dto.exitGame;
import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.service.PlayerInformationService;
import com.poetrygame.service.exitGameService;
import com.poetrygame.service.workArgsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
@Slf4j
public class PlayInformationController {

    @Resource
    private PlayerInformationService playerInformationService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeChatConfig weChatConfig;

    @Autowired
    private workArgsService workArgsService;

    @Autowired
    private exitGameService exitGameService;


    // 测试:获取玩家昵称
    @ApiImplicitParams({
            //参数效验
            @ApiImplicitParam(name="aliasName",value = "玩家昵称",required = true,paramType="string"),
    })
    @ApiOperation(value = "通过openId将玩家昵称存入数据库")
    @GetMapping("/getNickname")
    public R<String> getNickname(String aliasName,String openId){

        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId);
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        if(one == null){
            return R.error("用户不存在，保存失败");
        }

        int saveAliasName = playerInformationService.getSaveAliasName(aliasName,openId);
        if(saveAliasName == 0){
            return R.error("保存失败");
        }
        return R.success(null,"保存玩家昵称成功");
    }
    // 微信：用户第一次登录，请求获得openId

//    @ApiImplicitParams({
//            //参数效验
//            @ApiImplicitParam(name="code",value="授权码",required=true,paramType="form")
//    })
    @ApiOperation(value = "微信扫码登录")
    @GetMapping("/login")
    public R<Object> appletsLogin(String code) {

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", weChatConfig.getAppid());
        requestMap.put("secret", weChatConfig.getAppSecret());
        requestMap.put("code", code);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, requestMap);
        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        String openId = jsonObject.getString("openid");

        System.out.println(openId);
        // 先判断openId是否在数据库中存在，如果存在，直接取出openId对应的playerId返回给前端，如果不存在，则存入数据，再返回
        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId );
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        if (one != null) {
            Map<String,String> map = new HashMap<>();
            map.put("openId", openId);
            return R.successByLogin(map);
        }
        Date date = new Date();
        PlayerInformation playerInformation = new PlayerInformation();
        playerInformation.setWeixinId(openId);
        playerInformation.setRegisteTime(date);
        playerInformation.setActiveValue(0);
        Integer lifeLimit = workArgsService.getLifeLimit();
        playerInformation.setLifeLimit(lifeLimit);
        playerInformation.setLifeCount(lifeLimit);

        int insertDate = playerInformationService.loginTest(playerInformation);
        if (insertDate != 1) {
            return R.error("数据插入失败");
        }

//        Long playerId = playerInformationService.getOpenId(openId);
        Map<String,String> map1 = new HashMap<>();
        map1.put("openId", openId);
        //
        return R.successByRegister(map1);
    }

    @GetMapping("/signIn")
    @ApiOperation("登录游戏时传参openId,进入游戏时间")
    @ApiImplicitParams({
            //参数效验
            @ApiImplicitParam(name = "openId",value = "openId",required = true,paramType="string"),
            @ApiImplicitParam(name = "enterGameTime",value = "进入游戏时间，10位时间戳",required = true,paramType = "Long")
    })
    public R<Object> signIn(@RequestParam("openId") String openId,
                            @RequestParam("enterGameTime") Long enterGameTime){
        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId);
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        Date exitTime = one.getExitTime();
        // exitTime为null证明玩家为第一次玩游戏
        if(exitTime == null){
            PlayerInformation lifeInformation = playerInformationService.getLifeInformation(openId);
            // 活跃度+1
            playerInformationService.getAddActiveValue(openId);
            // openId
            String openId1 = lifeInformation.getWeixinId();
            // 体力值
            Integer lifeCount = lifeInformation.getLifeCount();
            // 体力值上限
            Integer lifeLimit = lifeInformation.getLifeLimit();
            // 游戏内体力值恢复时间间隔
            Integer lifeResumeOnline = workArgsService.getLifeResumeOnline();
            Map<String,Object> lifeMap = new LinkedHashMap();
            lifeMap.put("openId",openId1);
            lifeMap.put("lifeCount",lifeCount);
            lifeMap.put("lifeLimit",lifeLimit);
            lifeMap.put("lifeResumeOnline",lifeResumeOnline);
            return R.success(lifeMap,"lifeCount:体力值"+" "+
                    "lifeLimit:体力值上限"+" "+
                    "lifeResumeOnline:游戏内每多少分钟恢复一点体力");
        }
        PlayerInformation lifeInformation = playerInformationService.getLifeInformation(openId);
        // 活跃度+1
        playerInformationService.getAddActiveValue(openId);
        // openId
        String openId1 = lifeInformation.getWeixinId();
        // 体力值
        Integer lifeCount = lifeInformation.getLifeCount();
        // 体力值上限
        Integer lifeLimit = lifeInformation.getLifeLimit();

        // exitTime不为null证明玩家不是第一次玩游戏,date转时间戳
        long time = exitTime.getTime()/1000;
        long differTime = enterGameTime - time;
        // 体力值应该加多少
        Integer lifeResumeOnline = workArgsService.getLifeResumeOnline();
        long time1 = differTime /60/lifeResumeOnline;
        // 如果time1高于体力值上限,则直接将体力值上限赋值给体力值
        if(time1 >= lifeLimit){
            Map<String,Object> lifeMap = new LinkedHashMap<>();
            lifeMap.put("openId",openId1);
            lifeMap.put("lifeCount",lifeLimit);
            lifeMap.put("lifeLimit",lifeLimit);
            lifeMap.put("lifeResumeOnline",lifeResumeOnline);
            return R.success(lifeMap,"lifeCount:体力值"+" "+
                    "lifeLimit:体力值上限"+" "+
                    "lifeResumeOnline:游戏内每多少分钟恢复一点体力");
        }
        // 如果time1不高于体力上限,但time1加上lifeCount大于体力值上限,则直接上体力值上限赋值给体力值
        if( time1 < lifeLimit && time1 + lifeCount >= lifeLimit){
            Map<String,Object> lifeMap = new LinkedHashMap<>();
            lifeMap.put("openId",openId1);
            lifeMap.put("lifeCount",lifeLimit);
            lifeMap.put("lifeLimit",lifeLimit);
            lifeMap.put("lifeResumeOnline",lifeResumeOnline);
            return R.success(lifeMap,"lifeCount:体力值"+" "+
                    "lifeLimit:体力值上限"+" "+
                    "lifeResumeOnline:游戏内每多少分钟恢复一点体力");
        }
        Map<String,Object> lifeMap = new LinkedHashMap<>();
        lifeMap.put("openId",openId1);
        lifeMap.put("lifeCount",time1+lifeCount);
        lifeMap.put("lifeLimit",lifeLimit);
        lifeMap.put("lifeResumeOnline",lifeResumeOnline);
        return R.success(lifeMap,"lifeCount:体力值"+" "+
                "lifeLimit:体力值上限"+" "+
                "lifeResumeOnline:游戏内每多少分钟恢复一点体力");
    }

    @PostMapping("/exitGame")
    @ApiOperation(value = "退出游戏时传入退出时间:10位时间戳,剩余体力值,openId")
    public R<Object> exitGame(@RequestBody exitGame exitGame){

        Integer lifeCount = exitGame.getLifeCount();
        String openId = exitGame.getOpenId();
        Long exitGameTime1 = exitGame.getExitGameTime()*1000;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(new Date(exitGameTime1));
        int updateLimit = exitGameService.getUpdateLimit(format,lifeCount,openId);
        if(updateLimit>0){
            log.info("playInformation/exitGame:退出游戏数据\n"+"退出游戏时间:"+format+"\n"+
                    "体力值:"+lifeCount+"\n"+"openId:"+openId);
            return R.success(null,"退出数据保存成功");
        }
        return R.error("退出数据保存失败");
    }

}
