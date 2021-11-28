package com.java.learn.jdk.concurrent;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.concurrent.*;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/1/29 9:22
 */
public class CompleteFutureTest {

    public static void main(String[] args) {

        /**
         * CompletableFuture有两种创建方式，一种是传入自定义的异步线程池，另外一种是默认的ForkJoinPool
         *  前者在执行任务超时不会中断任务，后者会中断任务
         *
         *
         *
         *
         */

        System.out.println(Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        test2();

    }

    /**
     * 测试1
     */
    public void test1() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

//            new Thread(()->{
//                int i1 = 100 / 0;
//
//            }).start();
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int i = 1000;
//            for (int i1 = 0; i1 < i; i1++) {
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(i1);
//            }

            int i = 100 / 0;

            System.out.println("启动");
            //int i1 = 100 / i;
            return "Success";
        });

        try {
            System.out.println("CompleteFuture之外");

            String resutl = future.get(3, TimeUnit.SECONDS);
            System.out.println(resutl);
        } catch (Exception e) {
            // future.cancel(true);
            e.printStackTrace();
        }

    }

    /**
     * 场景2：
     * 子线程在调用父线程时的引用变量
     * 经过测试发现：
     * 子线程并不会因为主线程执行完而中断，并且父线程在改变了引用变量的值之后，子线程
     * 中的变量也会发生相应的变化。
     *
     *
     *
     */
    private static void test2() {


        Thread thread = new Thread(() -> {

            Head head = new Head().setEyeColor("blue");

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    try {
                        if (i == 10) {
                            Thread.sleep(200);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(head);
                }
            });
            thread1.setDaemon(true);
            thread1.start();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            head.setEyeColor("black");
            head.setHair("long");
            System.out.println("父线程" + head);

        });

       
        thread.start();
        System.gc();
    }

}

@Data
@Accessors(chain = true)
class Head {

    private String eyeColor;

    private String hair;


}