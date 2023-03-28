package com.poetrygame.service.impl;

import com.poetrygame.mapper.dtoMapper.travelInformationMapper;
import com.poetrygame.service.travelInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/28
 * @Time: 16:28
 * @Description:
 */
@Service
public class travelInformationServiceImpl implements travelInformationService {

    @Resource
    private travelInformationMapper travelInformationMapper;

    @Override
    public Integer getTravelInformationOne(Long playerId) {
        return travelInformationMapper.travelInformationOne(playerId);
    }

    @Override
    public Integer getTravelInformationTwo(Long playerId) {
        return travelInformationMapper.travelInformationTwo(playerId);
    }

    @Override
    public Integer getTravelInformationThree(Long playerId) {
        return travelInformationMapper.travelInformationThree(playerId);
    }

    @Override
    public List<Integer> getTravelInformationFour(Long playerId) {
        return travelInformationMapper.travelInformationFour(playerId);
    }

    @Override
    public List<Integer> getTravelInformationFive(Long playerId) {
        return travelInformationMapper.travelInformationFive(playerId);
    }

    @Override
    public List<Integer> getTravelInformationSix(Long playerId) {
        return travelInformationMapper.travelInformationSix(playerId);
    }

    @Override
    public List<Integer> getTravelInformationSeven(Long playerId) {
        return travelInformationMapper.travelInformationSeven(playerId);
    }

    @Override
    public Integer getTravelInformationEight(Long playerId) {
        return travelInformationMapper.travelInformationEight(playerId);
    }
}
