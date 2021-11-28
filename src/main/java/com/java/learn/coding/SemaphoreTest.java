package com.java.learn.coding;

import java.util.concurrent.Semaphore;

/**
 * @Auther: DingZhichao
 * @Date: 2021/8/15 18:16
 * @Description:
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行完成");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
            });
        }


        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        
    }

}
