package com.java.learn.collection.list;

import java.util.*;

/**
 * @Auther: DingZhichao
 * @Date: 2020/5/7 10:43
 * @Description:
 */
public class ListTest {

    public static void main(String[] args) {
        //util包下得直接子类
        //扩容通过System.arrayCopy来实现，
        //fastremove通过System.arrayCopy来实现，arr[--size]=null   让GC进行垃圾回收
        ArrayList<Integer> arrayList = new ArrayList<>();


        //transient关键字，被该关键字修饰的属性不需要序列化
        LinkedList<Integer> linkedList = new LinkedList<>();
        Vector<Integer> vector = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = Collections.synchronizedList(arrayList);


    }
    
}
