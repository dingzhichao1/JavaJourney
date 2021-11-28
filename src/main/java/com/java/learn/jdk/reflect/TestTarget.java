package com.java.learn.jdk.reflect;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/5/8 9:56
 */
public class TestTarget implements  TestInterface{

    @Override
    public void test(){
        System.out.println("Test Target");
    }
}
