package com.java.learn.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: DingZhichao
 * @Date: 2021/5/7 22:19
 * @Description:
 */
public class ProxyTest implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类");

        return null;
    }
}
