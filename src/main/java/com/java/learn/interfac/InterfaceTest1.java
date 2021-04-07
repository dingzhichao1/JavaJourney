package com.java.learn.interfac;

/**
 * Description：接口2
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/3/26 10:12
 */
public interface InterfaceTest1 {

    default void test1(){

        System.out.println("InterfaceTest1的默认方法");
    }
}
