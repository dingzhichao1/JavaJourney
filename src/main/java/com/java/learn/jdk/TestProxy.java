package com.java.learn.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/5/8 9:58
 */
public class TestProxy<T> implements InvocationHandler {

    private TestTarget testTarget;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Test Proxy");

        return null;
    }
}
