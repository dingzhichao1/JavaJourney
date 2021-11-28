package com.java.learn.data_struct.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/14 13:30
 * @Description:
 */


/**
 * 对于一个有序的数组来说，获得
 *
 *
 *
 */
public class AutoOrderList {
    public static void main(String[] args) {
        A a = new A();
        a.addElement(4);
        a.addElement(4);
        a.addElement(6);
        a.addElement(1);


    }

}

class A {

    public A(){

    }
    List<Integer> sorted = new LinkedList<>();
    public void addElement(int n) {
        // TODO

        sorted.add(n);
        int size = sorted.size();

        boolean falg= false;
        int index=0;

        for (int i = 0; i < size; i++) {
            if(sorted.get(i)>n){
                index=i;
                falg=true;
                break;
            }
        }
        if(falg){
            for (int j = size-1; j >index ; j--) {
                sorted.set(j,sorted.get(j-1));
            }
            sorted.set(index,n);

        }


        System.out.println(sorted);





    }
}
