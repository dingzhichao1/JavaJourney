package com.java.learn.interfac;

/**
 * Description：测试default方法的接口
 *
 * <p>java1.8之前是不允许定义非抽象的方法的，因此一旦新增了方法会导致实现类必须实现新增的方法，而加入了default
 * 之后实现类可以不去实现该方法。
 *
 * </p>
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/3/26 9:41
 */
public interface InterfaceTest {

    int num=10;

    void test();

    default void test1(){

        System.out.println("InterfaceTest的默认方法");
    }


}
