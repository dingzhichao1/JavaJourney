package com.java.learn.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: DingZhichao
 * @Date: 2021/8/15 16:47
 * @Description:
 * 实现一个容器，提供两个方法add() size()
 * 线程一：添加10个元素到容器
 * 线程二：实时监控元素个数、到5个时终端并给出提示
 *
 * 考点：
 * 1、元素的可见性，容器容量对与线程二是可见的
 * 2、线程二必须优先于线程一进行否则就会造成线程一已经执行完，而线程二确没有监控到
 *
 *
 *
 */
public class TaoBaoTest01 {

    public static void main(String[] args) {
        Container<Integer> container = new Container<>();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                LockSupport.park();
                container.add(i);
                System.out.println("add" + i);
            }


        },"t1");
        t1.start();


        new Thread(()->{
            for (;;){

                System.out.println(container.size());
                if(container.size()==5){
                    break;
                }
                LockSupport.unpark(t1);
            }

            System.out.println("结束");

        },"t2").start();


    }

    static class Container<T>{

        private  volatile List<T> list=null;

        public Container(){
            list=new ArrayList<>();
        }

        public void add(T t){
            list.add(t);
        }

        public int size(){
            return list.size();
        }
    }


}
