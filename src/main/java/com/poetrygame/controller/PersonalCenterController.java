package com.poetrygame.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.poetrygame.common.R;
import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.service.PlayerInformationService;
import com.poetrygame.service.topicPlayDetailService;
import com.poetrygame.service.travelInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @Author: zzw
 * @Date: 2023/3/28
 * @Time: 11:05
 * @Description:
 */

@RestController
@RequestMapping("/personalCenterController")
@CrossOrigin
@Slf4j
@Api(tags = "玩家个人中心页")
public class PersonalCenterController {

    @Resource
    private PlayerInformationService playerInformationService;

    @Resource
    private travelInformationService travelInformationService;

    @Resource
    private topicPlayDetailService topicPlayDetailService;

    @GetMapping("/travelInformation")
    @ApiImplicitParam(name = "openId",value = "openId",required = true)
    public R<Object> travelInformation(@RequestParam("openId") String openId){
        LambdaQueryWrapper<PlayerInformation> queryWrapper =
                new LambdaQueryWrapper<>();
        queryWrapper.eq(PlayerInformation::getWeixinId,openId);
        PlayerInformation one = playerInformationService.getOne(queryWrapper);
        if(one == null){
            return R.error("该用户不存在");
        }
        Long playerId = one.getPlayerId();

        // 总建筑数
        Integer totalBuilding = travelInformationService.getTravelInformationOne(playerId);

        // 总城市数
        Integer totalCity = travelInformationService.getTravelInformationTwo(playerId);

        // 总国家数
        Integer totalCountry = travelInformationService.getTravelInformationThree(playerId);

        // 已经玩过的建筑数
        Integer doneBuilding = travelInformationService.getTravelInformationEight(playerId);

        // 已经玩过的城市数
        List<Integer> noneCityList = travelInformationService.getTravelInformationSix(playerId);
        List<Integer> totalCityList = travelInformationService.getTravelInformationSeven(playerId);
        List<Integer> doneCityList =
                totalCityList.stream().filter(item -> !noneCityList.contains(item)).collect(Collectors.toList());
        int doneCity = doneCityList.size();

        // 已经玩过的国家数
        List<Integer> totalCountryList = travelInformationService.getTravelInformationFive(playerId);
        List<Integer> noneCountryList = travelInformationService.getTravelInformationFour(playerId);
        List<Integer> doneCountryList =
                totalCountryList.stream().filter(item -> !noneCountryList.contains(item)).collect(Collectors.toList());
        int doneCountry = doneCountryList.size();
        // 累计登录天数
        Date registrationTime = playerInformationService.getPlayerInformationTwo(playerId);
        long time = registrationTime.getTime();
        Date date = new Date();
        long time1 = date.getTime();
        long cumulativeDays =(time1 - time) / 1000 / 3600 / 24;

        // 活跃度
        Integer activeValue = playerInformationService.getPlayerInformationOne(playerId);

        // 累计答题
        Integer cumulativeAnswers = topicPlayDetailService.getCumulativeAnswers(playerId);

        Map<String,Object> centerInformation = new LinkedHashMap<>();
        centerInformation.put("doneBuilding/totalBuilding",doneBuilding+"/"+totalBuilding);
        centerInformation.put("doneCity/totalCity",doneCity+"/"+totalCity);
        centerInformation.put("doneCountry/totalCountry",doneCountry+"/"+totalCountry);
        centerInformation.put("cumulativeDays",cumulativeDays);
        centerInformation.put("activeValue",activeValue);
        centerInformation.put("cumulativeAnswers",cumulativeAnswers);

        log.info("\n"+"personalCenterController/travelInformation:"+"\n"
        +"已完成建筑数/总建筑数:" + doneBuilding+"/"+totalBuilding+"\n"
        +"已完成城市数/总城市数:" + doneCity+"/"+totalCity+"\n"
        +"已完成国家数/总国家数:" + doneCountry+"/"+totalCountry+"\n"
        +"累计登录天数:" + cumulativeDays+"\n"
        +"活跃度:" + activeValue+"\n"
        +"累计答题:" + cumulativeAnswers);
        return R.success(centerInformation,"doneBuilding/totalBuilding: 已完成建筑数/总建筑数"+
                " doneCity/totalCity: 已完成城市数/总城市数"+
                " doneCountry/totalCountry: 已完成国家数/总国家数"+
                " cumulativeDays: 累计登录天数"+
                " activeValue: 活跃度"+
                " cumulativeAnswers: 累计答题");
    }
}
