package com.java.learn.jdk.concurrent.reentranlock;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/17 09:50
 * @Description:
 */
public class TreadLocalTest {



    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ThreadLocalTask threadLocalTask = new ThreadLocalTask();
        for (int i = 0; i <10 ; i++) {
            executorService.execute(threadLocalTask);
        }

    }




}

class ThreadLocalTask implements  Runnable{

    private Integer  shareVar=0;

    private static  ThreadLocal threadLocal = new ThreadLocal<Integer>();

    @Override
    public void run() {
        threadLocal.set(shareVar);
        int random = new Random().nextInt(100);
        Integer integer =(Integer) threadLocal.get();
        integer+=random;
        System.out.println("随机数"+random+"共享变量"+integer);
        threadLocal.remove();
    }


    public void exeTask(){


    }
}