package com.java.learn.current;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: DingZhichao
 * @Date: 2019/11/14 18:25
 * @Description:
 */

/**
 * 本次测试，通过一个线程陷入死循环，而另一个线程修改死循环的判断值，
 * 然后看死循环线程能否跳出死循环。
 * 经过测试没有volatile修饰的变量在修改后，依然能跳出死循环，两者之间差异并不明显，不知道
 * 为什么？
 *
 * 对于非volatile修饰的变量，尽管jvm的优化，会导致变量的可见性问题，但这种可见性的问题也只是在短时间内高并发的情况下发生，CPU执行时会很快刷新Cache，一般的情况下很难出现，而且出现这种问题是不可预测的，与jvm, 机器配置环境等都有关。
 *
 *
 */
public class VolitileTest {
    //static volatile  int ageV=0;

    //static boolean  flag=false;

    //volatile boolean flag=false;

    AtomicInteger atomicInteger= new AtomicInteger();
    boolean flag=false;

    public static void main(String[] args) throws InterruptedException {

        //对列中只维护一定数量的线程任务
        final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(20);

        /**
         *  任务队列中维护了一定数量的任务,并且优先执行队列中的任务
         *
         *  IF  workQueueCapacity <= maximumPoolSize  && needThreadNum <=  maximumPoolSize  THEN  threadNum=needThreadNum
         *
         *  IF  workQueue的capacity>maximumPoolSize  THRN   threadNum=corePoolSize
         *
         *
         *
         */

        final VolitileTest volitileTest = new VolitileTest();

        RejectedExecutionHandler rejectedExecutionHandler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 100, TimeUnit.SECONDS, workQueue, rejectedExecutionHandler);

       // threadPoolExecutor.execute(()->volitileTest.print());

        //threadPoolExecutor.execute(()->volitileTest.update());

        Thread thread = new Thread(() -> volitileTest.print());
        thread.start();
       // Thread.sleep(2000);
        new Thread(()->volitileTest.update()).start();


    }

    /**
     * 判断能否看见共享变量的值
     */
    public void print(){
        while (!flag) {
            System.out.println("被困住了");
        }
        System.out.println("逃出生天");
    }

    /**
     * 修改共享变量的值
     */
    public void update() {
        flag=true;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改完成");
    }
}

