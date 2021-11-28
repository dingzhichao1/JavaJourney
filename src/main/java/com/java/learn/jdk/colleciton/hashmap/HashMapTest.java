package com.java.learn.jdk.colleciton.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class HashMapTest{


    public static void main(String[] args) {
        Map<String,Object> map =  new HashMap<>();
        CountDownLatch downLatch = new CountDownLatch(10);
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}