package com.java.learn.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: DingZhichao
 * @Date: 2020/3/6 09:07
 * @Description:
 */
public class JavaObjectLayout {

    /**
     * 一个对象的内存分布：
     * 1、对象头：
     *
     *      mark-word :   8个字节，64位
     *      class-pointer:  4个字节，本来应该是8个字节，被压缩后为4个字节
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Object obj = new Object();

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        User user = new User();

        System.out.println(ClassLayout.parseInstance(user).toPrintable());

    }


}
