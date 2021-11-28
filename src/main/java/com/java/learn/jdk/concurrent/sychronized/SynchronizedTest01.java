package com.java.learn.jdk.concurrent.sychronized;

/**
 * @Auther: DingZhichao
 * @Date: 2021/8/15 16:05
 * @Description: Sychronized 的睡眠唤醒
 */
public class   SynchronizedTest01 {

    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                synchronized (lock){
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"已经获取到锁"+"!!!!");
                    //未加synchronizad时会爆java.lang.IllegalMonitorStateException
                    //wait在等待时会出让锁资源，此时其它线程会获取到锁
                    lock.wait();
                    System.out.println(name+"执行完成!!!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

//        new Thread(()->{
//            try {
//                synchronized (lock){
//                    String name = Thread.currentThread().getName();
//                    System.out.println(name+"已经获取到锁"+"!!!!");
//                    //未加synchronizad时会爆java.lang.IllegalMonitorStateException
//                    //wait在等待时会出让锁资源，此时其它线程会获取到锁
//                    Thread.sleep(1000);
//                    System.out.println(name+"执行完成!!!");
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();


        new Thread(()->{
            synchronized (lock){
                String name = Thread.currentThread().getName();
                System.out.println(name+"已经获取到锁");
                lock.notify();
            }
        }).start();



    }

}
