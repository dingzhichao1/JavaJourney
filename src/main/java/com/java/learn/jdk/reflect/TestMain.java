package com.java.learn.jdk.reflect;

import java.lang.reflect.Proxy;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/5/8 9:59
 */
public class TestMain {


    /**
     * jdk的动态代理
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 无论是动态代理还是反射都是为了普遍性的对象创建和增强
         *  创建对象由自身去管理，以反射的方式由被调用的方法去创建
         *
         *
         *
         */


        /**
         * 反射和动态代理的关系
         * 反射用于对象创建，旨在提供一种在运行时更加灵活、更加普遍的对象创建方式
         * 动态代理旨在运行时阶段创建代理对象,主要目的是为了增强
         * 反射和jdk动态代理都是reflect包下的，反射是jdk动态代理的基础
         *
         */


        /**
         * JDK的动态代理是对接口进行代理，针对某个接口的实现类进行增强
         *
         * Proxy是jdk进行动态代理时的工具类，通过newProxyInstance创建一个增强的代理对象
         * 1、参数：要被代理的接口的类加载器   要被代理的接口    增强的Handler
         * 在创建过程中要进行类加载
         *
         * 2、返回结果：Proxy.newInstance()得到是目标接接口的代理对象，本质是和目标对象一致的
         *
         *
         *
         */

        TestTarget target = new TestTarget();


        TestInterface proxyInstance =(TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(), new Class[]{TestInterface.class}, new TestProxy<>(target));

        proxyInstance.test();
    }
}
