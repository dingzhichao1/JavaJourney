package com.java.learn.Pattern.proxy;


import com.java.learn.Pattern.proxy.statics.StaticsProxySubject;

public class ProxyTest {

    public static void main(String[] args) {
        Subject staticsProxySubject = new StaticsProxySubject(new RcalSubject());
        staticsProxySubject.execute();
    }
}
