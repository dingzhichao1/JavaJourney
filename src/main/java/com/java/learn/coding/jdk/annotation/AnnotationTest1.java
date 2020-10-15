package com.java.learn.coding.jdk.annotation;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/10/14 14:01
 */
public class AnnotationTest1 {

    public static void main(String[] args) {
        AnnotationTest1 AnnotationTest1 = new AnnotationTest1();
        AnnotationTest1.test();
    }

    @Flush(value = "aaaa")
    public void  test(){


    }

}
