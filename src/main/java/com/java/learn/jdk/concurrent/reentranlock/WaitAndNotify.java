package com.java.learn.jdk.concurrent.reentranlock;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/17 17:10
 * @Description:
 */
public class WaitAndNotify {
    final static Object obj = new Object();
    private final static Lock lock=new ReentrantLock();
    private final static Condition waitConditon =lock.newCondition();





    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("线程一开始执行。。。");
            try {
                synchronized (obj){
                    obj.wait();  //在执行wait时必须先获取到锁
                }
                System.out.println("线程一苏醒继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread t2 = new Thread(() -> {
            System.out.println("线程二开始执行。。。");
            synchronized (obj){
                obj.notifyAll();   //唤醒线程
            }

        });

        //t1.start();
        //t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println("线程一开始执行。。。");
            try {
                lock.lock();
                waitConditon.await();
                lock.unlock();
                System.out.println("线程一苏醒继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread t4 = new Thread(() -> {
            System.out.println("线程二开始执行。。。");
            lock.lock();
            waitConditon.signalAll();
            lock.unlock();

        });

        t3.start();
        t4.start();



    }
}


class Productor implements  Runnable{

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


}