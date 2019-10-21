package com.java.learn.Pattern.proxy.dynamic;

import com.java.learn.Pattern.proxy.Subject;

/**
 * 动态代理类
 */
public class DynamicProxySubject implements Subject {
    public void execute() {
        System.out.println("动态代理");
    }
}
