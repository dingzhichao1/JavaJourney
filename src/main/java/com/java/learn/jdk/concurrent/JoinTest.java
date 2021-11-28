package com.java.learn.jdk.concurrent;

/**
 * @Auther: DingZhichao
 * @Date: 2019/11/25 12:51
 * @Description:
 */
public class JoinTest {
    /**
     * join方法，如果A线程中调用了B.join(),那么A线程会等B线程执行成功之后再执行
     *
     */

    public static void main(String[] args) {
        Thread.currentThread().setDaemon(true);
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(() -> joinTest.joinTestMethod());

        try {
            //thread.join();

          //  thread.setDaemon(true);

            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("主线程执行完。。。。。。。。。");

    }

    public void joinTestMethod(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程线程执行啦。。。。");

    }
}
