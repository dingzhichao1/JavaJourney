package com.java.learn.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/6/8 10:23
 */
public class ThreadTest {
    private final static Integer SIZE = 100;

    private static AtomicInteger conut = new AtomicInteger();

    public void handle() {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        // 分页获取旧数据 每10000条处理一次
        int current = 1;
        int size = SIZE;
        long total = 1000;

        int index = 0;
        int endIndex = size;
        while (true) {
            // 批量处理并插入新数据
            List<Integer> idList = new ArrayList<>();
            for (int i = index; i < endIndex; i++) {
                idList.add(i);
            }
            System.out.println("第" + current + "页" + idList.size());
            transferData(idList, executor);

            if (total <= current * size) {
                break;
            }
            index = endIndex;
            endIndex += size;
            current++;
        }

        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start));

        executor.shutdown();


//        while (true){
//            if(executor.isTerminated()){
//                long end = System.currentTimeMillis();
//                System.out.println("耗时"+(end-start));
//                break;
//
//            }
//
//        }


    }

    private void transferData(List<Integer> idList, ThreadPoolExecutor executor) {
        CountDownLatch downLatch = new CountDownLatch(idList.size());

//        if(idList.size()!=SIZE){
//            System.out.println(idList.size());
//            throw new RuntimeException("任务有问题");
//        }
        System.out.println("*************" + Thread.currentThread().getName());
        List<Future<?>> futures = new ArrayList<>(SIZE);
        idList.forEach(id -> {
            try {
                Runnable task = () -> {
                    System.out.println(Thread.currentThread().getName() + "#############" + id);
                    System.out.println("执行任务");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    downLatch.countDown();
                    conut.incrementAndGet();
                };
                Future<?> submit = executor.submit(task);
                futures.add(submit);

            } catch (Exception e) {

            }
        });
//        try {
//            downLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while (true) {
            if (executor.getTaskCount() == executor.getCompletedTaskCount()) {
                break;
            }
        }


        boolean success = false;
//        while (!success) {
//
//
//            //为什么要用循环删除
//            futures.removeIf(Future::isDone);
//            if (futures.size() <= 0) {
//                success = true;
//            }
////            try {
////                Thread.sleep(100);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//        }
    }

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        long start = System.currentTimeMillis();
        ThreadTest threadTest = new ThreadTest();
        threadTest.handle();
        long end = System.currentTimeMillis();
        int i = conut.get();
        System.out.println(i + "结束。。。。。。。。。。。。。");


        //CountDownLatch   25681

        //25424   25347

    }

}
