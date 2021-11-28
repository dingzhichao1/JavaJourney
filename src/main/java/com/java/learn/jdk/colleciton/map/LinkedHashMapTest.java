package com.java.learn.jdk.colleciton.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @Auther: DingZhichao
 * @Date: 2020/11/21 14:15
 * @Description:
 */
public class LinkedHashMapTest {
    /**
     * A:
     * 1、LinkedHashMap的作用  继承HashMap在HashMap的基础上按照插入时的顺序，预测迭代顺序
     * 2、底层的数据结构
     * 3、底层处理流程
     * 4、与HashMap的不同之处
     */


    public static void main(String[] args) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(12, "ssss");
        linkedHashMap.put(2, "ssss");
        linkedHashMap.put(3, "ssss");
        linkedHashMap.put(12, "ccccc");
        System.out.println(linkedHashMap);

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(12, "ssss");
        hashMap.put(2, "ssss");
        hashMap.put(3, "ssss");
        System.out.println(hashMap);
    }

}

//class LinkedHashMapTest {
//
//    public static void main(String[] args) {
//        HashMap<Integer, Object> linkedHashMap0 = new HashMap<>();
//        linkedHashMap0.put(1,"特斯拉");
//        linkedHashMap0.put(2,"保时捷");
//        linkedHashMap0.put(2,"保时捷");
//        System.out.println(linkedHashMap0);
//
//        LinkedHashMap<Integer, Object> linkedHashMap1 = new LinkedHashMap<>();
//        linkedHashMap1.put(1,"特斯拉");
//        linkedHashMap1.put(2,"保时捷");
//        System.out.println(linkedHashMap1);
//
//
//
//    }
//
//
//}
