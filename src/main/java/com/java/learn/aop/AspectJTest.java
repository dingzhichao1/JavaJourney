package com.java.learn.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description：定义Test的相关切面
 * <p>
 * 1、加入依赖aspectjweaver和aspectjrt
 * 2、定义切入点
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/3/29 14:23
 */
@Aspect
public class AspectJTest {

    /**
     * 修饰符  返回值格式  类  方法格式  方法参数
     */
    @Pointcut(value = "execution(public * com.java.learn.aop.AspectJMain.test())")
    public void testPointcut() {

    }

    @Before(value = "testPointcut()")
    public void before(){
        System.out.println("before test  !!!");

    }



}
