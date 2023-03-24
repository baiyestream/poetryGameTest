package com.poetrygame.common;

import org.springframework.stereotype.Component;

/**
 * @Author: zzw
 * @Date: 2023/3/14
 * @Time: 8:47
 * @Description:
 */
@Component
public class IntegerToTime {
    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second= 0;
        if (time <= 0)
            return "00分00秒";
        else {
            minute = time / 60;
            if (minute <60) {
                second= time % 60;
                timeStr = unitFormat(minute) + "分" + unitFormat(second)+"秒";
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99时59分59秒";
                minute = minute % 60;
                second= time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + "时" + unitFormat(minute) + "分" + unitFormat(second)+"秒";
            }
        }
        return timeStr;
    }
    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i <10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }
}
