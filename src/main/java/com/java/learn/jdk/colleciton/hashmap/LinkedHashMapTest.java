package com.java.learn.jdk.colleciton.hashmap;

import java.util.LinkedHashMap;

/**
 * Description：LinkedHashMap
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/7/16 10:20
 */
public class LinkedHashMapTest{

    public static void main(String[] args) {

        /**
         *  继承HashMap,有好多实现都是HashMap的实现、双链表结构
         *  1、迭代可预测，有顺序
         *  2、accessOrder: true 基于访问顺序   false 基于插入顺序（默认）
         *    false的时候可以将元素按照Key的插入顺序进行排序
         *    true的时候可以用作缓存，将最old的元素进行置前
         *  3、LinkedHashMap已经默认实现了LRU淘汰算法，如果想要实现LRU算法可以继承
         *  LinkedHashMap重写removeEldestEntry方法
         *
         */

        LinkedHashMap<String, String> linkedHashMap = new LRUCache<>(2);
        linkedHashMap.put("AAA","丰台");
        linkedHashMap.put("DDD","朝阳");
        //System.out.println(linkedHashMap.get("AAA"));
        linkedHashMap.put("BBB","海淀");
        //linkedHashMap.put("AAA","房山");
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get("BBB"));
        System.out.println(linkedHashMap);



    }


}
