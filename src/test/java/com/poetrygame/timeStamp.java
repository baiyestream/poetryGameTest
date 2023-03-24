package com.poetrygame;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @Author: zzw
 * @Date: 2023/3/6
 * @Time: 9:24
 * @Description:
 */
@SpringBootTest
public class timeStamp {



    // 计算时间戳差值
    @Test
    void test(){

        long time3 = (1678066070-1678066191);
        System.out.println(time3);
    }

    @Test
    void test1(){
        Date date = new Date();
        long time = date.getTime()/1000;
        long time1 = 1679287519;
        long time2 = (time-time1)/60/10;
        System.out.println(time);
        System.out.println(time2);
    }

}
