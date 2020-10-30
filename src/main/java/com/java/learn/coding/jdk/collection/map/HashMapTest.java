package com.java.learn.coding.jdk.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/8/13 14:47
 */
public class HashMapTest {

    public static void main(String[] args) {
        System.out.println(Math.pow(2,2));
        System.out.println(1<<2);

        Map<String, Object> map = new HashMap<>();
        map.put("aaa","aaa");
        map.put("aaa","bbb");
        System.out.println(map);
    }



}
