package com.java.learn.Pattern.proxy.statics;

import com.java.learn.Pattern.proxy.Subject;

/**
 * 静态代理实现
 */
public class StaticsProxySubject implements Subject {

    private  Subject subject;
    public void execute() {
       subject.execute();
    }

    public  StaticsProxySubject(Subject subject) {
        this.subject = subject;
    }

    public StaticsProxySubject(){

    }

}
