package com.java.learn.coding.jdk.functioninterface;

import java.nio.file.DirectoryStream;
import java.util.Properties;
import java.util.function.Function;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/1/22 9:41
 */
public class Main1 {

    public static void main(String[] args) {

        Function<InterfaceTest, Integer> hashCode = InterfaceTest::hashCode;

        DirectoryStream.Filter<InterfaceTest> isExist = InterfaceTest::isExist;

        Properties properties = System.getProperties();
        System.out.println(properties);

    }
}
