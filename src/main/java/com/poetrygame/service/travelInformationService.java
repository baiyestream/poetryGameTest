package com.poetrygame.service;

import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/3/28
 * @Time: 16:27
 * @Description:
 */
public interface travelInformationService {

    Integer getTravelInformationOne(Long playerId);
    Integer getTravelInformationTwo(Long playerId);
    Integer getTravelInformationThree(Long playerId);
    List<Integer> getTravelInformationFour(Long playerId);
    List<Integer> getTravelInformationFive(Long playerId);
    List<Integer> getTravelInformationSix(Long playerId);
    List<Integer> getTravelInformationSeven(Long playerId);
    Integer getTravelInformationEight(Long playerId);
}
