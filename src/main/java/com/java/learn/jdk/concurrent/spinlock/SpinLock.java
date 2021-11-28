package com.java.learn.jdk.concurrent.spinlock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/8 16:46
 * @Description: 自定义实现自旋锁
 */
public class SpinLock {

    private AtomicReference<Thread> atomicReference=new AtomicReference<>();

    private volatile int lockCount=0;


    public void lock(){
        Thread current = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,current)){
            //System.out.println(current+"未获取锁。。。");
        }
        //System.out.println("获取锁成功。。。");
    }
    public void  unlock(){
        Thread current = Thread.currentThread();
        atomicReference.compareAndSet(current,null);

    }




}
class Demo implements Runnable{
    int i = 0;

    //自旋锁
    private SpinLock spinLock = new SpinLock();

    //可重入锁（互斥锁）
    private ReentrantLock reentrantLock =new ReentrantLock();

    @Override
    public void run() {
        spinLock.lock();
        //reentrantLock.lock();
        //这个方法不是原子性了
        i++;
        int k=0;
        try {
           // spinLock.lock();
            //Thread.sleep(1000);

                //System.out.println(Thread.currentThread().getName()+"执行中");
            //spinLock.unlock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("执行任务了"+i);
        spinLock.unlock();
        //reentrantLock.unlock();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Demo demo = new Demo();
        //15023毫秒
        //15011毫秒
        try {
            for (int i = 0; i <1000 ; i++) {
                Thread t1 = new Thread(demo);
                t1.setName("线程一");
                t1.start();
                t1.join();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+(end-start)+"毫秒");
    }
}


class TestSpinLock{
    private AtomicReference<Thread> atomicReference=new AtomicReference<>();

    private volatile int lockCount=0;


    public void lock(){
        Thread current = Thread.currentThread();
        System.out.println(current);

//        if(atomicReference.getAndUpdate()){
//
//        }

        while (!atomicReference.compareAndSet(null,current)){
            System.out.println(current+"未获取锁。。。");
        }
        //System.out.println("获取锁成功。。。");
    }
    public void  unlock(){
        Thread current = Thread.currentThread();
        atomicReference.compareAndSet(current,null);

    }

}
