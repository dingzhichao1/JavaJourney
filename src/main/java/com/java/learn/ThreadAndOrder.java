package com.java.learn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/23 18:53
 * @Description: 多线程顺序执行
 */
public class ThreadAndOrder {
    /**
     * @param args
     */


    public static void main(String[] args) {

        Task task = new Task();

        PrintService ps = new PrintService();
        Thread threadA = new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                try {
                    ps.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread threadB = new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                ps.printB();
            }

        });
        Thread threadC = new Thread(()->{
            for (int i = 0; i <5 ; i++) {
                ps.printC();
            }

        });

        threadA.setName("A");
        threadB.setName("B");
        threadC.setName("C");

        threadA.start();
        threadB.start();
        threadC.start();


    }


}

/**
 * 每个线程中执行的任务
 */
class Task implements Runnable {

    private AtomicInteger priority = new AtomicInteger(1);
    private  Object obj=new Object();


    @Override
    public void run() {
        synchronized (obj){
            Thread currentThread = Thread.currentThread();
            for (int i = 0; i < 5; i++) {
                printThreadName(currentThread);
            }

        }


    }

    public  void printThreadName(Thread currentThread){
        System.out.println(priority.get()+currentThread.getName());
        switch (priority.get()){
            case 1:
                if ("A".equals(currentThread.getName())){
                    System.out.println(currentThread.getName());
                    priority.set(2);
                    synchronized (obj){
                        obj.notifyAll();
                    }

                }else{
                    try {
                        synchronized (obj){
                            //System.out.println("等待线程"+currentThread);
                            obj.wait();
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if("B".equals(currentThread.getName())){
                    System.out.println(currentThread.getName());
                    priority.set(3);
                    synchronized (obj){
                        obj.notifyAll();
                    }
                }else{
                    try {
                        synchronized (obj){
                            //System.out.println("等待线程"+currentThread);
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                if("C".equals(currentThread.getName())){
                    System.out.println(currentThread.getName());
                    priority.set(1);
                    synchronized (obj){
                        obj.notifyAll();
                    }
                }else{
                    try {
                        synchronized (obj){
                            //System.out.println("等待线程"+currentThread);
                            obj.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;

        }
    }



}

class PrintService{
    private volatile int  state=1;
    Object obj =new Object();
    
    public void printA() throws InterruptedException {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        while (!(threadName.equals("A")&&state==1)){
            synchronized (obj){
                obj.wait();
            }

        }
        System.out.print(threadName);
        synchronized (obj){
            state=2;
            obj.notifyAll();
        }


    }

    public void printB(){
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();

        while (!(threadName.equals("B")&&state==2)){


        }
        System.out.print(threadName);
        synchronized (obj){
            state=3;
            obj.notifyAll();
        }
    }

    public void printC(){
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();

        while (!(threadName.equals("C")&&state==3)){


        }
        System.out.print(threadName);
        synchronized (obj){
            state=1;
            obj.notifyAll();
        }
    }

    


}