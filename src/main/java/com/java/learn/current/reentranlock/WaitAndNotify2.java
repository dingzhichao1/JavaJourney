package com.java.learn.current.reentranlock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/22 11:47
 * @Description: 等待通知实现方式二
 */
public class WaitAndNotify2 {

    private  static BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {
            System.out.println("进入线程一");
            try {
                blockingQueue.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完线程一");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("进入线程二");
            try {
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行完线程二");

        });

        thread1.start();
        thread2.start();


    }
}
