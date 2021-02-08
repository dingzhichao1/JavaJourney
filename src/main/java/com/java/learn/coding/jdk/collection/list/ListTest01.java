package com.java.learn.coding.jdk.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/10/15 18:22
 */
public class ListTest01 {
    public static void main(String[] args) {

        //底层实现是数组，有序、支持null、空集合
        /**
         * 数组变量  用来存放数据
         * 数组长度 随着元素的增减而改变
         * 索引  通过索引查找元素
         * 扩容  通过数组复制来实现
         * 迭代  实现迭代接口
         *
         */

        ArrayList<Object> objects = new ArrayList<>();

        List<Integer> list = Collections.unmodifiableList(Stream.of(1, 2, 3, 4, 5, 6, 7,8,9,10,11,12).collect(Collectors.toList()));
        list.stream().forEach(p->{
            System.out.println("functioninterface:"+Thread.currentThread().getName());
        });

        list.parallelStream().forEach(p->{
            System.out.println("parallelStream:"+Thread.currentThread().getName());
        });
    }


}
