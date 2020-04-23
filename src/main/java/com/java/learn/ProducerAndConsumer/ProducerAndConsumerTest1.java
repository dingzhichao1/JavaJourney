package com.java.learn.ProducerAndConsumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/7 15:33
 * @Description: 利用BlockingQueue实现生产者消费者模型
 */
public class ProducerAndConsumerTest1 {
    BlockingQueue blockingQueue = new LinkedBlockingQueue<Integer>();

    private volatile  boolean isStopProduce=false;  //当生产者确定停止生产的状态
    private static int   CUNSUMER_CAPACITY=1000;  //消费者的容量，达到最大数量集中处理一次
    private static int   PRODUCER_CAPACITY=10005;  //生产者的最大容量


    public static void main(String[] args) {
        ProducerAndConsumerTest1 producerAndConsumerTest1 = new ProducerAndConsumerTest1();
        Producer producer = producerAndConsumerTest1.new Producer();
        Consumer consumer = producerAndConsumerTest1.new Consumer();

        Thread producerThread = new Thread(producer);
        Thread consumerThread1 = new Thread(consumer);
        Thread consumerThread2 = new Thread(consumer);
        Thread consumerThread3 = new Thread(consumer);
        Thread consumerThread4 = new Thread(consumer);

        consumerThread1.setName("消费者一");
        consumerThread2.setName("消费者二");
        consumerThread3.setName("消费者三");
        consumerThread4.setName("消费者四");

        producerThread.start();
//        consumerThread1.start();
//        consumerThread2.start();
//        consumerThread3.start();
//        consumerThread4.start();

        try {
            producerThread.join();
            System.out.println(producerAndConsumerTest1.blockingQueue);
            consumerThread1.join();
            consumerThread2.join();
            consumerThread3.join();
            consumerThread4.join();
            consumerThread1.join();
            System.out.println("执行完毕。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    /**
     * 生产者
     */
    class  Producer implements Runnable{

        @Override
        public void run() {
            int random =(int) Math.random();
            for (int i = 0; i <PRODUCER_CAPACITY ; i++) {
                blockingQueue.offer(i);
            }

            //停止生产
            isStopProduce=true;

        }

    }


    /**
     * 消费者
     */
    class Consumer implements Runnable{

        @Override
        public void run() {
            int count=0;
            List<Object> list = new ArrayList<>();
            while (true) {

                if(count<CUNSUMER_CAPACITY){
                    Object poll = blockingQueue.poll();
                    if(poll!=null){
                        list.add(poll);
                        count++;
                    }else if(isStopProduce){
                        if(!list.isEmpty()){
                            System.out.println(Thread.currentThread().getName()+"最后消费"+list.size());
                        }
                        break;
                    }

                }else {
                    System.out.println(Thread.currentThread().getName()+"消费"+list.size());
                    list.clear();
                    count=0;
                }
            }

        }

    }


}

