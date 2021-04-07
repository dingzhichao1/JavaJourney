package com.java.learn.interfac;

/**
 * Description：接口的实现类
 *
 * <p>1、接口当中的default方法是可以被实现类继承并重写</p>
 * <p>2、如果实现的两个接口的default方法完全一样则实现类必须重写该方法</p>
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/3/26 9:41
 */
public class InterfaceTestImp implements InterfaceTest,InterfaceTest1 {
    @Override
    public void test() {
        System.out.println("这是实现类实现的方法");
    }

     @Override
     public void test1(){

        System.out.println("实现类来重写default方法");
    }
}
