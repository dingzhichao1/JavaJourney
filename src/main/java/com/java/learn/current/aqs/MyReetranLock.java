package com.java.learn.current.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Auther: DingZhichao
 * @Date: 2021/4/25 19:21
 * @Description:
 */

public class MyReetranLock extends AbstractQueuedSynchronizer {

    /**
     * 加锁
     */
    public void lock(){


    }

    /**
     * 释放锁
     */
    public  void unLock(){

    }

    private static class Sync extends AbstractQueuedSynchronizer{

        boolean isSignalled() { return getState() != 0; }




    }


}
