package com.java.learn.coding.jdk.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/2/8 17:55
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, Object> linkedHashMap0 = new HashMap<>();
        linkedHashMap0.put(1,"特斯拉");
        linkedHashMap0.put(2,"保时捷");
        linkedHashMap0.put(2,"保时捷");
        System.out.println(linkedHashMap0);

        LinkedHashMap<Integer, Object> linkedHashMap1 = new LinkedHashMap<>();
        linkedHashMap1.put(1,"特斯拉");
        linkedHashMap1.put(2,"保时捷");
        System.out.println(linkedHashMap1);



    }


}
