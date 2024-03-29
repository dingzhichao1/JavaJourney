package com.java.learn.jdk.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description：动态代理
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/5/8 9:58
 */
public class TestProxy<T> implements InvocationHandler {

    private T target;

    public TestProxy(T target){
        this.target=target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Test Proxy");
       return method.invoke(target,args);
    }
}
