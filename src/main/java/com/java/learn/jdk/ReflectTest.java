package com.java.learn.jdk;

/**
 * Description：反射测试类
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/5/8 14:26
 */
public class ReflectTest {
    public static void main(String[] args) {
        //
        Class<TestTarget> testTargetClass = TestTarget.class;

        //获取父类
        Class<? super TestTarget> superclass = testTargetClass.getSuperclass();

        //获取接口
        Class<?>[] interfaces = testTargetClass.getInterfaces();







    }


}
