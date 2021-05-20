package com.java.learn.jdk;

import java.lang.reflect.Proxy;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/5/8 9:59
 */
public class TestMain {

    public static void main(String[] args) {
        TestTarget target =(TestTarget) Proxy.newProxyInstance(TestTarget.class.getClassLoader(), new Class[]{TestTarget.class}, new TestProxy());
        target.test();
    }
}
