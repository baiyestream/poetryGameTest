package com.poetrygame.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.poetrygame.common.R;
import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.service.PlayerInformationService;
import com.poetrygame.service.travelInformationService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
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

    @GetMapping("/travelInformation")
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
        Integer doneCity = doneCityList.size();
        // 已经玩过的国家数
        List<Integer> totalCountryList = travelInformationService.getTravelInformationFive(playerId);
        List<Integer> noneCountryList = travelInformationService.getTravelInformationFour(playerId);
        List<Integer> doneCountryList =
                totalCountryList.stream().filter(item -> !noneCountryList.contains(item)).collect(Collectors.toList());
        Integer doneCountry = doneCountryList.size();
        // 累计游戏
        // 把指定时间转化为时间戳
        
        return null;
    }
}
