package com.java.learn.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description：ArrayList解析
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/7/12 14:13
 */
@SuppressWarnings("unchecked")
public class ArrayListTest {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        //failTest1();
        failTest2(integers);
    }


    /**
     *  失败机制测试（fail-fast和fail-safe）
     *
     *  迭代器遍历-移除元素
     *
     */
    public static void failTest1(List<Integer> integers){

        //使用迭代器进行删除修改
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            iterator.remove();
        }
    }
    /**
     *  失败机制测试（fail-fast和fail-safe）
     *
     *  增强for循环遍历-移除元素
     *
     */
    public static void failTest2(List<Integer> integers){
        int i=0;
        for (Integer integer : integers) {
            integers.remove(i);
            i++;
        }
    }

}
