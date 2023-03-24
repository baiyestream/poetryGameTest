package com.poetrygame;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: zzw
 * @Date: 2023/2/21
 * @Time: 15:14
 * @Description:
 */
public class testList {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        List<Integer> reduce1 = list2.stream().filter(item -> !list1.contains(item)).collect(toList());
       /*
            reduce1 = list2 - list1
        */
        System.out.println(reduce1);

    }
}
