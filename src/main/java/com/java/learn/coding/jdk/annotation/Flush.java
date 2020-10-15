package com.java.learn.coding.jdk.annotation;

import java.lang.annotation.*;

/**
 * Description：自定一个注解
 *
 * @Documented   用于doc文档注解
 * @Retention(RetentionPolicy.RUNTIME)   注解保留策略
 * @Target(ElementType.METHOD)      注解目标元素
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/10/14 14:02
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public  @interface Flush {
    String value() default "";
}
