package com.java.learn.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * Description：关于Integer和int类型的内存占用
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/10/19 9:33
 */
public class IntegerTest {

    /**
     * 分析：普通对象
     *
     *  对象头：
     *      MarkWord:  4 byte ->32 bit
     *          锁标志：两位
     *          偏向锁：一位
     *
     *
     *
     *
     *      ClassPoint:
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        int int1=127;
        Integer integer1 = new Integer(127);
        Integer integer2 = new Integer(129);
        System.out.println(ClassLayout.parseInstance(integer1).toPrintable());
        System.out.println(ClassLayout.parseInstance(integer2).toPrintable());
        System.out.println(ClassLayout.parseInstance(int1).toPrintable());


    }

}
