package com.java.learn.pattern.proxy;


import com.java.learn.pattern.proxy.statics.StaticsProxySubject;

public class ProxyTest {

    public static void main(String[] args) {
        Subject staticsProxySubject = new StaticsProxySubject(new RcalSubject());
        staticsProxySubject.execute();
    }
}
