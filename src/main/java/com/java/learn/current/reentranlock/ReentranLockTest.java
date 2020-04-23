package com.java.learn.current.reentranlock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: DingZhichao
 * @Date: 2019/12/27 10:21
 * @Description:
 */
public class ReentranLockTest {
    ReentrantLock reentrantLock = new ReentrantLock();

    /**
     * 可重入锁（避免自身多次调用，或者间接调用引起的死锁问题）
     *
     *
     */
    public static void main(String[] args) {
        List<Map<Integer, String>> list = new ReentranLockTest().getList();
        System.out.println(list.size()+"集合"+list);
    }

    public List<Map<Integer, String>>  getList(){
        List<Map<Integer, String>> objects = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 1; i <11 ; i++) {
            final int key =i;
            executorService.execute(()->{

                Map<Integer, String> map = new HashMap<>();
                map.put(key,Thread.currentThread().getName());
                synchronized (objects){
                    objects.add(map);
                }
                countDownLatch.countDown();

            });
        }

        try {
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  objects;
    }


}
