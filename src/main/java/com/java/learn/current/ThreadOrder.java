package com.java.learn.current;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: DingZhichao
 * @Date: 2020/1/26 10:59
 * @Description:
 */
public class ThreadOrder {


    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Task task = new Task();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName());
                synchronized (obj1){
                    try {
                        obj1.wait();
                        synchronized (obj2){
                            obj2.notifyAll();
                            synchronized (obj3){
                                obj3.notifyAll();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

        });
        Thread t2 = new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                    synchronized (obj1){
                        try {
                            obj1.notifyAll();
                            synchronized (obj2){
                                obj2.wait();
                                synchronized (obj3){
                                    obj3.notifyAll();
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {

                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                    synchronized (obj1){
                        try {
                            obj1.notifyAll();
                            synchronized (obj2){
                                obj2.notifyAll();
                                synchronized (obj3){
                                    obj3.wait();
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        t1.setName("A");
        t2.setName("B");
        t3.setName("C");

        t1.start();
        t2.start();
        t3.start();


    }



}

class  Task implements Runnable{
    private AtomicInteger AtomicState=new AtomicInteger(0);

    private volatile int volatileState=0;

    private Object obj =new Object();

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        System.out.println(name);
//        if("A".equals(name)&&volatileState==0){
//
//        }else if("B".equals(name)&&volatileState==1){
//
//        }else if("C".equals(name)&&volatileState==2){
//
//        }else{
//            synchronized (obj){
//                try {
//                    obj.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }




//        for (int i = 0; i < 5; i++) {
//            while (volatileState==0){
//
//            }
//            while (volatileState==1){
//
//
//            }
//
//        }


        
        

    }



}