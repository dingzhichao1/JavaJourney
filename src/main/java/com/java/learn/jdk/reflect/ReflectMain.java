package com.java.learn.jdk.reflect;

import java.awt.datatransfer.Transferable;
import java.lang.reflect.Proxy;

/**
 * @Auther: DingZhichao
 * @Date: 2021/5/7 22:24
 * @Description:
 */
public class ReflectMain {

    public static void main(String[] args) {
        TargetInterface target =(TargetInterface) Proxy.newProxyInstance(TargetInterface.class.getClassLoader(), new Class[]{TargetInterface.class}, new ProxyTest());
        target.test();
        Transferable self = target.getSelf();
    }
}   
