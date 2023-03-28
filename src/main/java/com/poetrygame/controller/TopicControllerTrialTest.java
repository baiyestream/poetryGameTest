package com.poetrygame.controller;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.poetrygame.common.R;
import com.poetrygame.dto.*;
import com.poetrygame.dto.getTopic.buildingLimit;
import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.pojo.playerBuilding;
import com.poetrygame.pojo.topicPlayDetail;
import com.poetrygame.service.*;
import com.poetrygame.topicService.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: zzw
 * @Date: 2023/3/2
 * @Time: 16:33
 * @Description:
 */
@RestController
@RequestMapping("/topicControllerTrialTest")
@CrossOrigin
@Slf4j
@Api(tags = "玩家开始游戏模块")
public class TopicControllerTrialTest {

    /**
     * 发题流程:分为以下四种情况
     *  1.玩家第一次玩游戏:直接进入
     *  2.玩家第一次玩游戏:地图进入
     *  3.玩家非第一次玩游戏:直接进入
     *  4.玩家非第一次玩游戏:地图进入
     */

    @Resource
    private cityBuildingService cityBuildingService;

    @Resource
    private playerBuildingService playerBuildingService;

    @Resource
    private topicInformationService topicInformationService;

    @Resource
    private topicPlayDetailService topicPlayDetailService;

    @Resource
    private playerBuildingIdService playerBuildingIdService;

    @Resource
    private gisInformationService gisInformationService;

    @Resource
    private PlayerInformationService playerInformationService;

    @Resource
    private topicSumService topicSumService;

    @Resource
    private topicDoneService topicDoneService;

    @Resource
    private topicMapDoneService topicMapDoneService;

    @Resource
    private buildingTopicService buildingTopicService;

    @Resource
    private buildingLimitService buildingLimitService;


    @ApiImplicitParams({
            //参数效验
            @ApiImplicitParam(name ="openId",value="openId",required=true),
            @ApiImplicitParam(name ="countryId",value = "国家id"),
            @ApiImplicitParam(name ="cityId",value = "城市id"),
            @ApiImplicitParam(name ="buildingId",value = "建筑id")
    })
    @ApiOperation(value = "开始游戏，直接开始游戏只传openId,点击建筑开始游戏传参全部id")
    @GetMapping("/directAnswer")
    public R<Object> directAnswer(String openId, Integer countryId,
                                  Integer cityId, Integer buildingId){
        // 将openId转化为playerId
        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId);
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        Long playerId = one.getPlayerId();

        // 判断玩家是否第一次玩游戏 1为是 null为否
        Integer isExist = topicPlayDetailService.getIsExist(playerId);

        if(isExist == null){
            // 玩家为第一次玩游戏
            if(playerId != null && countryId == null && cityId == null && buildingId == null){
                // 玩家点击首页,直接开始游戏
                // 可用题目总数
                Integer topicSum = topicInformationService.getTopicSum();
                // 将城市建筑关联表的city_building_id和建筑表的topic_limit插入到玩家游历建筑表
                int remainTopic = topicSum;
                List<buildingLimit> buildingLimits = buildingLimitService.getBuildingLimitOne();
                List<playerBuilding> playerBuildings = new LinkedList<>();
                for(com.poetrygame.dto.getTopic.buildingLimit buildingLimit : buildingLimits ){
                    playerBuilding playerBuilding = new playerBuilding();
                    playerBuilding.setCityBuildingId(buildingLimit.getCityBuildingId());
                    playerBuilding.setPlayerId(playerId);
                    int insertSum = (remainTopic>buildingLimit.getTopicLimit())?
                            buildingLimit.getTopicLimit():remainTopic;
                    playerBuilding.setTopicCount(insertSum);
                    playerBuilding.setDoneTopic(0);
                    playerBuildings.add(playerBuilding);
                    remainTopic = remainTopic-insertSum;
                    if(remainTopic <= 0){
                        break;
                    }
                }
                Integer insertBatch = playerBuildingService.getInsertBatch(playerBuildings);
                if(insertBatch > 0){
                    log.info("插入成功");
                }else{
                    log.info("插入失败");
                }
                //地图难度级别1需要多少题
                Integer levelOneTopicNeed = buildingLimitService.getBuildingLimitTwo();
                Integer levelOneTopic = topicInformationService.topicLevelOne();
                if(levelOneTopic >= levelOneTopicNeed){
                    List<Integer> levelOneTopics =
                            topicInformationService.getTopicLevelOneSelect(levelOneTopicNeed);
                    Integer levelTwoTopicNeed = buildingLimitService.getBuildingLimitThree();
                    Integer levelTwoTopic = topicInformationService.topicLevelTwo();
                    // 地图难度级别2需要多少题,2级别难度的题是不够的,需要从3里拿
                    if(levelTwoTopic < levelTwoTopicNeed){
                        List<Integer> levelTwoTopics =
                                topicInformationService.getTopicLevelTwoSelect(levelTwoTopicNeed);
                        int differTopics = levelTwoTopicNeed - levelTwoTopic;
                        List<Integer> topicLevelThreePart =
                                topicInformationService.getTopicLevelThreeSelect(differTopics);
                        // 在难度为3的题目中去除topicLevelThreePart
                        List<Integer> levelThreeTopic =
                                topicInformationService.getTopicLevelThreeCount();
                        List<Integer> levelThreeTopicRest =
                                levelThreeTopic.stream().filter(item -> !topicLevelThreePart.contains(item)).collect(Collectors.toList());
                        // 如果3级别剩下的题目足够多,取出指定数量插入
                        Integer levelThreeTopicNeed = buildingLimitService.getBuildingLimitFour();
                        if(levelThreeTopicNeed >= levelThreeTopicRest.size()){
                            List<Integer> levelThreeTopics = topicInformationService.getTopicLevelThreeSelect(levelThreeTopicRest.size());
                            List<Integer> topicNeedList = new LinkedList<>();
                            topicNeedList.addAll(levelOneTopics);
                            topicNeedList.addAll(levelTwoTopics);
                            topicNeedList.addAll(topicLevelThreePart);
                            topicNeedList.addAll(levelThreeTopics);
                            List<playerBuilding> playerBuildingId =
                                    playerBuildingService.getPlayerBuildingTest(playerId);
                            Integer topicNumber = playerBuildingService.getTopicNumber(playerId);
                            List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                            int m = 0;
                            for(int i =0;i<topicNumber;i++){
                                for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                    topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                    topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                    topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                    m++;
                                    topicPlayDetail.setPlayerId(playerId);
                                    topicPlayDetail.setTopicStatus(0);
                                    topicPlayDetails.add(topicPlayDetail);
                                }
                            }
                            Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                            if (insertBatch1>0){
                                log.info("玩家题目明细表插入成功");
                            }else{
                                log.info("玩家题目明细表插入失败");
                            }
                        }
                        // 如果3级别剩下的数目不够多,取出全部插入
                        if(levelThreeTopicNeed < levelThreeTopicRest.size()){
                            List<Integer> topicNeedList = new LinkedList<>();
                            List<Integer> levelThreeTopics = topicInformationService.getTopicLevelThreeCount();
                            topicNeedList.addAll(levelOneTopics);
                            topicNeedList.addAll(levelTwoTopics);
                            topicNeedList.addAll(topicLevelThreePart);
                            topicNeedList.addAll(levelThreeTopics);
                            List<playerBuilding> playerBuildingId =
                                    playerBuildingService.getPlayerBuildingTest(playerId);
                            Integer topicNumber = playerBuildingService.getTopicNumber(playerId);
                            List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                            int m = 0;
                            for(int i =0;i<topicNumber;i++){
                                for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                    topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                    topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                    topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                    m++;
                                    topicPlayDetail.setPlayerId(playerId);
                                    topicPlayDetail.setTopicStatus(0);
                                    topicPlayDetails.add(topicPlayDetail);
                                }
                            }
                            Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                            if (insertBatch1>0){
                                log.info("玩家题目明细表插入成功");
                            }else{
                                log.info("玩家题目明细表插入失败");
                            }
                        }
                    }
                    // 地图难度级别2需要多少题,2级别难度的题是够的
                    if(levelTwoTopic >= levelTwoTopicNeed){
                        List<Integer> levelTwoTopics =
                                topicInformationService.getTopicLevelTwoSelect(levelTwoTopicNeed);
                        Integer levelThreeTopicNeed = buildingLimitService.getBuildingLimitFour();
                        Integer levelThreeTopic = topicInformationService.topicLevelThree();
                        // 地图难度级别3需要多少题,3级别难度的题是不够的
                        if(levelThreeTopic < levelThreeTopicNeed){
                            List<Integer> levelThreeTopics = topicInformationService.getTopicLevelThreeCount();
                            List<Integer> topicNeedList = new LinkedList<>();
                            topicNeedList.addAll(levelOneTopics);
                            topicNeedList.addAll(levelTwoTopics);
                            topicNeedList.addAll(levelThreeTopics);
                            List<playerBuilding> playerBuildingId =
                                    playerBuildingService.getPlayerBuildingTest(playerId);
                            Integer topicNumber = playerBuildingService.getTopicNumber(playerId);
                            List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                            int restTopic = topicNeedList.size();
                            int m = 0;
                            for(int i =0;i<topicNumber;i++){
                                for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                    restTopic--;
                                    if(restTopic <0 ){
                                        break;
                                    }
                                    topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                    topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                    topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                    m++;
                                    topicPlayDetail.setPlayerId(playerId);
                                    topicPlayDetail.setTopicStatus(0);
                                    topicPlayDetails.add(topicPlayDetail);
                                }
                            }
                            Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                            if (insertBatch1>0){
                                log.info("玩家题目明细表插入成功");
                            }else{
                                log.info("玩家题目明细表插入失败");
                            }
                        }
                        // 地图难度级别3需要多少题,3级别难度的题是够的
                        if(levelThreeTopic >= levelThreeTopicNeed){
                            List<Integer> levelThreeTopics =
                                    topicInformationService.getTopicLevelThreeSelect(levelThreeTopicNeed);
                            List<Integer> topicNeedList = new LinkedList<>();
                            topicNeedList.addAll(levelOneTopics);
                            topicNeedList.addAll(levelTwoTopics);
                            topicNeedList.addAll(levelThreeTopics);
                            List<playerBuilding> playerBuildingId =
                                    playerBuildingService.getPlayerBuildingTest(playerId);
                            Integer topicNumber = playerBuildingService.getTopicNumber(playerId);
                            List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                            int m = 0;
                            for(int i =0;i<topicNumber;i++){
                                for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                    topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                    topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                    topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                    m++;
                                    topicPlayDetail.setPlayerId(playerId);
                                    topicPlayDetail.setTopicStatus(0);
                                    topicPlayDetails.add(topicPlayDetail);
                                }
                            }
                            Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                            if (insertBatch1>0){
                                log.info("玩家题目明细表插入成功");
                            }else{
                                log.info("玩家题目明细表插入失败");
                            }
                        }
                    }
                }
                // 1级别的题不够,2级别的题不够，3级别的题不够
                if(levelOneTopic < levelOneTopicNeed){
                    int differTopicOneTwo = levelOneTopicNeed - levelOneTopic;
                    Integer levelTwoTopic = topicInformationService.topicLevelTwo();
                    if(differTopicOneTwo > levelTwoTopic){
                        // 取出全部hard_level为1+hard_level为2+部分hard_level为3的differTopic的题目
                        int differTopicTwoThree = differTopicOneTwo - levelTwoTopic;
                        List<Integer> topicLevelOneCount =
                                topicInformationService.getTopicLevelOneCount();
                        List<Integer> topicLevelTwoCount =
                                topicInformationService.getTopicLevelTwoCount();
                        List<Integer> topicLevelThreeSelect =
                                topicInformationService.getTopicLevelThreeSelect(differTopicTwoThree);
                        List<Integer> topicOneList = new LinkedList<>();
                        topicOneList.addAll(topicLevelOneCount);
                        topicOneList.addAll(topicLevelTwoCount);
                        topicOneList.addAll(topicLevelThreeSelect);
                        List<playerBuilding> playerBuildingId =
                                playerBuildingService.getPlayerBuildingTest(playerId);
                        Integer topicNumber = playerBuildingService.getTopicNumber(playerId);
                        List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                        int m = 0;
                        for(int i =0;i<topicNumber;i++){
                            for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                topicPlayDetail.setTopicId(Long.valueOf(topicOneList.get(m)));
                                m++;
                                topicPlayDetail.setPlayerId(playerId);
                                topicPlayDetail.setTopicStatus(0);
                                topicPlayDetails.add(topicPlayDetail);
                            }
                        }
                        Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                        if (insertBatch1>0){
                            log.info("玩家题目明细表插入成功");
                        }else{
                            log.info("玩家题目明细表插入失败");
                        }
                    }
                }
                // 根据玩家的Id,所有的题目都插入到了玩家题目明细表,取出玩家游历建筑表的playerBuildingId1
                playerBuildingId playerBuildingId = playerBuildingIdService.getPlayerBuildingId(playerId);
                Long playerBuildingId1 = playerBuildingId.getPlayerBuildingId();
                // 根据playerBuildingId1找到国家id,城市id,建筑id,国家名称，城市名称,建筑名称,玩家题目id,题目内容
                gisInformation gisInformation = gisInformationService.getGisInformation(playerBuildingId1);
                Long playerTopicId = gisInformation.getPlayerTopicId();
                String content = gisInformation.getContent();
                JSONObject jsonObject = JSONObject.parseObject(content);
                Integer buildingId1 = gisInformation.getBuildingId();
                String buildingName = gisInformation.getBuildingName();
                Integer cityId1 = gisInformation.getCityId();
                String cityName = gisInformation.getCityName();
                Integer countryId1 = gisInformation.getCountryId();
                String countryName = gisInformation.getCountryName();
                Map<String,Object> map = new LinkedHashMap<>();
                map.put("openId",openId);
                map.put("playerTopicId",playerTopicId);
                map.put("buildingId",buildingId1);
                map.put("buildingName",buildingName);
                map.put("cityId",cityId1);
                map.put("cityName",cityName);
                map.put("countryId",countryId1);
                map.put("countryName",countryName);
                map.put("content",jsonObject);
                return R.success(map,"用户为第一次玩游戏,直接进入");
            }
            /**
             * 玩家直接开始游戏:点击地图
             */
            // 将城市建筑关联表的city_building_id和建筑表的topic_limit插入到玩家游历建筑表
            List<cityBuilding> cityBuilding = cityBuildingService.getCityBuilding();
            Integer topicSum = topicInformationService.getTopicSum();
            int remainTopic = topicSum;
            List<playerBuilding> playerBuildings = new LinkedList<>();
            for(com.poetrygame.dto.cityBuilding building : cityBuilding){
                playerBuilding playerBuilding = new playerBuilding();
                playerBuilding.setCityBuildingId(building.getCityBuildingId());
                playerBuilding.setPlayerId(playerId);
                int insertSum = (remainTopic>building.getTopicLimit())?
                        building.getTopicLimit():remainTopic;
                playerBuilding.setTopicCount(insertSum);
                playerBuilding.setDoneTopic(0);
                playerBuildings.add(playerBuilding);
                remainTopic = remainTopic - insertSum;
                if(remainTopic <= 0){
                    break;
                }
            }
            Integer insertBatch = playerBuildingService.getInsertBatch(playerBuildings);
            if(insertBatch > 0){
                log.info("插入成功");
            }else{
                log.info("插入失败");
            }
            //地图难度级别1需要多少题
            Integer levelOneTopicNeed = buildingLimitService.getBuildingLimitTwo();
            Integer levelOneTopic = topicInformationService.topicLevelOne();
            if(levelOneTopic >= levelOneTopicNeed){
                List<Integer> levelOneTopics =
                        topicInformationService.getTopicLevelOneSelect(levelOneTopicNeed);
                Integer levelTwoTopicNeed = buildingLimitService.getBuildingLimitThree();
                Integer levelTwoTopic = topicInformationService.topicLevelTwo();
                // 地图难度级别2需要多少题,2级别难度的题是不够的,需要从3里拿
                if(levelTwoTopic < levelTwoTopicNeed){
                    List<Integer> levelTwoTopics =
                            topicInformationService.getTopicLevelTwoSelect(levelTwoTopicNeed);
                    int differTopics = levelTwoTopicNeed - levelTwoTopic;
                    List<Integer> topicLevelThreePart =
                            topicInformationService.getTopicLevelThreeSelect(differTopics);
                    // 在难度为3的题目中去除topicLevelThreePart
                    List<Integer> levelThreeTopic =
                            topicInformationService.getTopicLevelThreeCount();
                    List<Integer> levelThreeTopicRest =
                            levelThreeTopic.stream().filter(item -> !topicLevelThreePart.contains(item)).collect(Collectors.toList());
                    // 如果3级别剩下的题目足够多,取出指定数量插入
                    Integer levelThreeTopicNeed = buildingLimitService.getBuildingLimitFour();
                    if(levelThreeTopicNeed >= levelThreeTopicRest.size()){
                        List<Integer> levelThreeTopics = topicInformationService.getTopicLevelThreeSelect(levelThreeTopicRest.size());
                        List<Integer> topicNeedList = new LinkedList<>();
                        topicNeedList.addAll(levelOneTopics);
                        topicNeedList.addAll(levelTwoTopics);
                        topicNeedList.addAll(topicLevelThreePart);
                        topicNeedList.addAll(levelThreeTopics);
                        List<playerBuilding> playerBuildingId =
                                playerBuildingService.getPlayerBuildingTest(playerId);
                        Integer topicNumberMap = playerBuildingService.getTopicNumber(playerId);
                        List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                        int m = 0;
                        for(int i =0;i<topicNumberMap;i++){
                            for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                m++;
                                topicPlayDetail.setPlayerId(playerId);
                                topicPlayDetail.setTopicStatus(0);
                                topicPlayDetails.add(topicPlayDetail);
                            }
                        }
                        Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                        if (insertBatch1>0){
                            log.info("玩家题目明细表插入成功");
                        }else{
                            log.info("玩家题目明细表插入失败");
                        }
                    }
                    // 如果3级别剩下的数目不够多,取出全部插入
                    if(levelThreeTopicNeed < levelThreeTopicRest.size()){
                        List<Integer> topicNeedList = new LinkedList<>();
                        List<Integer> levelThreeTopics = topicInformationService.getTopicLevelThreeCount();
                        topicNeedList.addAll(levelOneTopics);
                        topicNeedList.addAll(levelTwoTopics);
                        topicNeedList.addAll(topicLevelThreePart);
                        topicNeedList.addAll(levelThreeTopics);
                        List<playerBuilding> playerBuildingId =
                                playerBuildingService.getPlayerBuildingTest(playerId);
                        Integer topicNumberMap = playerBuildingService.getTopicNumber(playerId);
                        List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                        int m = 0;
                        for(int i =0;i<topicNumberMap;i++){
                            for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                m++;
                                topicPlayDetail.setPlayerId(playerId);
                                topicPlayDetail.setTopicStatus(0);
                                topicPlayDetails.add(topicPlayDetail);
                            }
                        }
                        Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                        if (insertBatch1>0){
                            log.info("玩家题目明细表插入成功");
                        }else{
                            log.info("玩家题目明细表插入失败");
                        }
                    }
                }
                // 地图难度级别2需要多少题,2级别难度的题是够的
                if(levelTwoTopic >= levelTwoTopicNeed){
                    List<Integer> levelTwoTopics =
                            topicInformationService.getTopicLevelTwoSelect(levelTwoTopicNeed);
                    Integer levelThreeTopicNeed = buildingLimitService.getBuildingLimitFour();
                    Integer levelThreeTopic = topicInformationService.topicLevelThree();
                    // 地图难度级别3需要多少题,3级别难度的题是不够的
                    if(levelThreeTopic < levelThreeTopicNeed){
                        List<Integer> levelThreeTopics = topicInformationService.getTopicLevelThreeCount();
                        List<Integer> topicNeedList = new LinkedList<>();
                        topicNeedList.addAll(levelOneTopics);
                        topicNeedList.addAll(levelTwoTopics);
                        topicNeedList.addAll(levelThreeTopics);
                        List<playerBuilding> playerBuildingId =
                                playerBuildingService.getPlayerBuildingTest(playerId);
                        Integer topicNumberMap = playerBuildingService.getTopicNumber(playerId);
                        List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                        int restTopic = topicNeedList.size();
                        int m = 0;
                        for(int i =0;i<topicNumberMap;i++){
                            for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                restTopic--;
                                if(restTopic <0 ){
                                    break;
                                }
                                topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                m++;
                                topicPlayDetail.setPlayerId(playerId);
                                topicPlayDetail.setTopicStatus(0);
                                topicPlayDetails.add(topicPlayDetail);
                            }
                        }
                        Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                        if (insertBatch1>0){
                            log.info("玩家题目明细表插入成功");
                        }else{
                            log.info("玩家题目明细表插入失败");
                        }
                    }
                    // 地图难度级别3需要多少题,3级别难度的题是够的
                    if(levelThreeTopic >= levelThreeTopicNeed){
                        List<Integer> levelThreeTopics =
                                topicInformationService.getTopicLevelThreeSelect(levelThreeTopicNeed);
                        List<Integer> topicNeedList = new LinkedList<>();
                        topicNeedList.addAll(levelOneTopics);
                        topicNeedList.addAll(levelTwoTopics);
                        topicNeedList.addAll(levelThreeTopics);
                        List<playerBuilding> playerBuildingId =
                                playerBuildingService.getPlayerBuildingTest(playerId);
                        Integer topicNumberMap = playerBuildingService.getTopicNumber(playerId);
                        List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                        int m = 0;
                        for(int i =0;i<topicNumberMap;i++){
                            for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                                topicPlayDetail topicPlayDetail = new topicPlayDetail();
                                topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                                topicPlayDetail.setTopicId(Long.valueOf(topicNeedList.get(m)));
                                m++;
                                topicPlayDetail.setPlayerId(playerId);
                                topicPlayDetail.setTopicStatus(0);
                                topicPlayDetails.add(topicPlayDetail);
                            }
                        }
                        Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                        if (insertBatch1>0){
                            log.info("玩家题目明细表插入成功");
                        }else{
                            log.info("玩家题目明细表插入失败");
                        }
                    }
                }
            }
            // 1级别的题不够,2级别的题不够，3级别的题不够
            if(levelOneTopic < levelOneTopicNeed){
                int differTopicOneTwo = levelOneTopicNeed - levelOneTopic;
                Integer levelTwoTopic = topicInformationService.topicLevelTwo();
                if(differTopicOneTwo > levelTwoTopic){
                    // 取出全部hard_level为1+hard_level为2+部分hard_level为3的differTopic的题目
                    int differTopicTwoThree = differTopicOneTwo - levelTwoTopic;
                    List<Integer> topicLevelOneCount =
                            topicInformationService.getTopicLevelOneCount();
                    List<Integer> topicLevelTwoCount =
                            topicInformationService.getTopicLevelTwoCount();
                    List<Integer> topicLevelThreeSelect =
                            topicInformationService.getTopicLevelThreeSelect(differTopicTwoThree);
                    List<Integer> topicOneList = new LinkedList<>();
                    topicOneList.addAll(topicLevelOneCount);
                    topicOneList.addAll(topicLevelTwoCount);
                    topicOneList.addAll(topicLevelThreeSelect);
                    List<playerBuilding> playerBuildingId =
                            playerBuildingService.getPlayerBuildingTest(playerId);
                    Integer topicNumberMap = playerBuildingService.getTopicNumber(playerId);
                    List<topicPlayDetail> topicPlayDetails = new LinkedList<>();
                    int m = 0;
                    for(int i =0;i<topicNumberMap;i++){
                        for(int j =0;j<playerBuildingId.get(i).getTopicCount();j++){
                            topicPlayDetail topicPlayDetail = new topicPlayDetail();
                            topicPlayDetail.setPlayerBuildingId(playerBuildingId.get(i).getPlayerBuildingId());
                            topicPlayDetail.setTopicId(Long.valueOf(topicOneList.get(m)));
                            m++;
                            topicPlayDetail.setPlayerId(playerId);
                            topicPlayDetail.setTopicStatus(0);
                            topicPlayDetails.add(topicPlayDetail);
                        }
                    }
                    Integer insertBatch1 = topicPlayDetailService.getInsertBatch(topicPlayDetails);
                    if (insertBatch1>0){
                        log.info("玩家题目明细表插入成功");
                    }else{
                        log.info("玩家题目明细表插入失败");
                    }
                }
            }
            // 根据玩家的Id,所有的题目都插入到了玩家题目明细表,取出玩家游历建筑表的playerBuildingId1
            playerBuildingId playerBuildingId = playerBuildingIdService.getPlayerBuildingId(playerId);
            Long playerBuildingId1 = playerBuildingId.getPlayerBuildingId();
            gisInformation gisInformationForMap =
                    gisInformationService.getGisInformationForMap(playerBuildingId1, buildingId, cityId, countryId);
            Long playerTopicId = gisInformationForMap.getPlayerTopicId();
            Integer buildingId1 = gisInformationForMap.getBuildingId();
            String buildingName = gisInformationForMap.getBuildingName();
            Integer cityId1 = gisInformationForMap.getCityId();
            String cityName = gisInformationForMap.getCityName();
            Integer countryId1 = gisInformationForMap.getCountryId();
            String countryName = gisInformationForMap.getCountryName();
            String content = gisInformationForMap.getContent();
            JSONObject jsonObject = JSONObject.parseObject(content);
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("openId",openId);
            map.put("playerTopicId",playerTopicId);
            map.put("buildingId",buildingId1);
            map.put("buildingName",buildingName);
            map.put("cityId",cityId1);
            map.put("cityName",cityName);
            map.put("countryId",countryId1);
            map.put("countryName",countryName);
            map.put("content",jsonObject);
            return R.success(map,"用户为第一次玩游戏:地图进入");
        }else{
            // 玩家作为老用户,进入游戏，点击首页开始游戏或者下一题
            if(playerId != null && countryId == null && cityId == null && buildingId == null){

                // 查询玩家是否完成全部题目
                Integer undoneCount = topicPlayDetailService.getUndoneCount(playerId);
                if(undoneCount == 0 ){
                    return R.success(null,"全部题目完成,已通关");
                }
                // 玩家点击首页,直接开始游戏
                // 根据玩家的Id,所有的题目都插入到了玩家题目明细表,取出玩家游历建筑表的playerBuildingId1
                playerBuildingId playerBuildingId = playerBuildingIdService.getPlayerBuildingId(playerId);
                Long playerBuildingId1 = playerBuildingId.getPlayerBuildingId();
                // 根据playerBuildingId1找到国家id,城市id,建筑id,国家名称，城市名称,建筑名称,玩家题目id,题目内容
                gisInformation gisInformation = gisInformationService.getGisInformation(playerBuildingId1);
                Long playerTopicId = gisInformation.getPlayerTopicId();
                String content = gisInformation.getContent();
                JSONObject jsonObject = JSONObject.parseObject(content);
                Integer buildingId1 = gisInformation.getBuildingId();
                String buildingName = gisInformation.getBuildingName();
                Integer cityId1 = gisInformation.getCityId();
                String cityName = gisInformation.getCityName();
                Integer countryId1 = gisInformation.getCountryId();
                String countryName = gisInformation.getCountryName();
                Map<String,Object> map = new LinkedHashMap<>();
                map.put("openId",openId);
                map.put("playerTopicId",playerTopicId);
                map.put("buildingId",buildingId1);
                map.put("buildingName",buildingName);
                map.put("cityId",cityId1);
                map.put("cityName",cityName);
                map.put("countryId",countryId1);
                map.put("countryName",countryName);
                map.put("content",jsonObject);
                return R.success(map,"用户非第一次玩游戏,直接进入");
            }
            /**
             * 老玩家直接开始游戏:点击地图
             */

            // 查询玩家是否完成全部题目
            Integer undoneCount = topicPlayDetailService.getUndoneCount(playerId);
            if(undoneCount == 0 ){
                return R.success(null,"全部题目完成,已通关");
            }

            topicMapDone topicMapDone = topicMapDoneService.getTopicMapDone(playerId, cityId, buildingId);
            Integer doneTopic = topicMapDone.getDoneTopic();
            Integer topicCount = topicMapDone.getTopicCount();
            Long playerBuildingId2 = topicMapDone.getPlayerBuildingId();

            if(doneTopic == topicCount){
                return R.success(null,"当前建筑所有题目玩家都已完成,请重新选择建筑");
            }

            // 根据playerBuildingId1找到国家id,城市id,建筑id,国家名称，城市名称,建筑名称,玩家题目id,题目内容
            gisInformation gisInformationForMap =
                    gisInformationService.getGisInformationForMap(playerBuildingId2, buildingId, cityId, countryId);
            Long playerTopicId = gisInformationForMap.getPlayerTopicId();
            Integer buildingId1 = gisInformationForMap.getBuildingId();
            String buildingName = gisInformationForMap.getBuildingName();
            Integer cityId1 = gisInformationForMap.getCityId();
            String cityName = gisInformationForMap.getCityName();
            Integer countryId1 = gisInformationForMap.getCountryId();
            String countryName = gisInformationForMap.getCountryName();
            String content = gisInformationForMap.getContent();
            JSONObject jsonObject = JSONObject.parseObject(content);
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("openId",openId);
            map.put("playerTopicId",playerTopicId);
            map.put("buildingId",buildingId1);
            map.put("buildingName",buildingName);
            map.put("cityId",cityId1);
            map.put("cityName",cityName);
            map.put("countryId",countryId1);
            map.put("countryName",countryName);
            map.put("content",jsonObject);
            return R.success(map,"用户非第一次玩游戏:地图进入");
        }
    }

    // 接收结果,在数据库更改状态
    @PostMapping("/receiveResults")
    @ApiOperation(value = "将玩完一把游戏的数据传入")
    public R<Object> receiveResults(@RequestBody receiveResults receiveResults){
        // 通过playerTopicId对应玩家题目明细的数据
        // 题目状态
        Integer topicStatus = receiveResults.getTopicStatus();
        // 开始时间
        Long startTime = receiveResults.getStartTime()*1000;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(new Date(startTime));
        // 结束时间
        Long endTime = receiveResults.getEndTime()*1000;
        // 计算用时
        Long usedTime = (endTime - startTime)/1000;
        // 玩家题目ID
        Long playerTopicId = receiveResults.getPlayerTopicId();

        topicPlayDetailService.updateTopicToMysql(topicStatus,format,usedTime,playerTopicId);
        // 根据playerTopicId找到playBuildingId,根据playerBuildingId查出sum(topic_status = 1 )
        topicSum topicSum = topicSumService.getTopicSum(receiveResults.getPlayerTopicId());
        // 玩家在当前建筑已经答过的题目数
        Integer totalSum1 = topicSum.getTotalSum();

        buildingTopic buildingTopic = buildingTopicService.getBuildingTopic(receiveResults.getPlayerTopicId());
        Integer topicCount = buildingTopic.getTopicCount();

        topicDoneService.getTopicDone(playerTopicId,totalSum1);

        return R.success("保存成功");
    }

}