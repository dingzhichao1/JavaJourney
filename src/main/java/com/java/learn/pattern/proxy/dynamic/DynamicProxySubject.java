package com.java.learn.pattern.proxy.dynamic;

import com.java.learn.pattern.proxy.Subject;

/**
 * 动态代理类
 */
public class DynamicProxySubject implements Subject {
    public void execute() {
        System.out.println("动态代理");
    }
}
