package com.java.learn.current;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: DingZhichao
 * @Date: 2020/3/20 09:22
 * @Description:测试一下Arthas
 */
public class ArthasTest {

    public static void main(String[] args) {
        RejectedExecutionHandler rejectedHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ScheduledThreadPoolExecutor schedulThreadPool = new ScheduledThreadPoolExecutor(50,rejectedHandler);
        schedulThreadPool.scheduleAtFixedRate(new Task1(),1,3, TimeUnit.SECONDS);
    }





}

class  Task1 implements Runnable{


    @Override
    public void run() {
        System.out.println("开始执行任务。。。。");
        try {
            Thread.sleep(5);
            System.out.println("任务执行完毕。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}