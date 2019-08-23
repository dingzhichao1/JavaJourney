package com.java.learn.Pattern.factory;
/**
* @ClassName:     FactoryMethodPattern
* @Description:    工厂方法设计模式
* @Author:         DZC
* @CreateDate:     2019/8/23 9:51
* @Version:        1.0
*/
public class BeanFactory {

    public static Bean createBean(String beanType){
        if("one".equals(beanType)){
            return new BeanOne();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        BeanFactory.createBean("one").run();
    }

}
