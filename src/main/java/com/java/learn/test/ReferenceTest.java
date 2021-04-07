package com.java.learn.test;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Description：引用测试
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/2/23 12:38
 */
public class ReferenceTest {
    public static void main(String[] args) {
        /**
         * 测试目的：java中到底是引用传递还是值传递？对于基本数据类型来说是值传递，对形参值的修改不会改变实参，那么引用
         * 对象呢？
         */
        User user = new User().setAge(18).setHigh(165).setName("宋大胆");
        System.out.println(user);
        test1(user);
        System.out.println(user);
        test2(user);
        System.out.println(user);

        /**
         * 结果：
         * User(age=18, name=宋大胆, high=165)
         * User(age=88, name=宋傻子, high=175)
         * User(age=88, name=宋傻子, high=175)
         *
         * 结论：
         * java还真是值传递，即使是引用对象传递，传递的也是yinyong
         *
         *
         */
    }

    /**
     * 改变引用对应对象的属性
     * @param user
     */
    public static void test1(User user){
        user.setAge(88).setHigh(175).setName("宋傻子");
    }


    /**
     * 改变引用对应对象的值
     * @param user
     */
    public static void test2(User user){
        user= new User().setAge(188).setHigh(135).setName("宋疯子");
    }


}
@Data
@Accessors(chain = true)
class User{
    private Integer age;
    private String name;
    private int high;

}