package com.java.learn.jdk.concurrent.reentranlock;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/23 18:01
 * @Description: 死锁案例
 */
public class DeadLock {

    public static void main(String[] args) {
        Object objOne = new Object();
        Object objTwo = new Object();
        TaskOne taskOne = new TaskOne(objOne, objTwo);
        TaskTwo taskTwo = new TaskTwo(objOne, objTwo);

        Thread t1 = new Thread(taskOne);
        Thread t2 = new Thread(taskTwo);
        t1.start();
        t2.start();

    }

}


class TaskOne implements Runnable{

    private Object objOne;

    private  Object objTwo;

    public TaskOne (Object objOne,Object objTwo){
        this.objOne=objOne;
        this.objTwo=objTwo;

    }

    @Override
    public void run() {
        synchronized (objTwo){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objOne){
                System.out.println("执行任务一");
            }
        }


    }

}

class TaskTwo implements Runnable{

    private Object objOne;

    private  Object objTwo;

    public TaskTwo (Object objOne,Object objTwo){
        this.objOne=objOne;
        this.objTwo=objTwo;

    }

    @Override
    public void run() {
        synchronized (objOne){
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (objTwo){
                System.out.println("执行任务二");
            }
        }


    }

}