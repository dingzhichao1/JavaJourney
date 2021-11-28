package com.java.learn.pattern.factory;
/**
* @ClassName:     FactoryMethodPattern
* @Description:    工厂方法设计模式
* @Author:         DZC
* @CreateDate:     2019/8/23 9:51
* @Version:        1.0
*/
public class CarFactory<T>{
    /**
     *  工厂模式的目的在于将对象的创建和对象的操作分离。
     *  工厂负责对对象进行统一的创建。
     *  主要组成：
     *      工厂
     *      产品接口    具体产品
     *  优点：
     *      通过统一的方式进行对象的创建
     *  缺点：
     *      违反了开闭原则，如果新增一个产品（对象类型）需要修改工厂的判断逻辑
     *
     *
     */



    public static Car  createCar(Class carClass){
        if(BYDCar.class.equals(carClass)){
            return new BYDCar();
        }
        return null;
    }



    public static void main(String[] args) {
        CarFactory.createCar(BYDCar.class);
    }

}
