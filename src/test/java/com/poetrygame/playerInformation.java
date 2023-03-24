package com.poetrygame;

import com.poetrygame.pojo.PlayerInformation;
import com.poetrygame.service.PlayerInformationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zzw
 * @Date: 2023/2/20
 * @Time: 15:20
 * @Description:
 */
@SpringBootTest
public class playerInformation {

    @Resource
    private PlayerInformationService playerInformationService;

    /**
     * 批量新增玩家
     */
    @Test
    void test(){

        List<PlayerInformation> list = new LinkedList<>();
        for(int i = 0;i<100;i++){
            PlayerInformation playerInformation = new PlayerInformation();
            playerInformation.setWeixinId("weiXinId"+i);
            playerInformation.setLifeCount(10);
            playerInformation.setLifeLimit(10);

            list.add(playerInformation);
        }
        playerInformationService.saveBatch(list);
    }


}
