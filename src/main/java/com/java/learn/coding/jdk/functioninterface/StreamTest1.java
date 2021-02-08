package com.java.learn.coding.jdk.functioninterface;

import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/1/22 9:32
 */
public class StreamTest1 {
    public static void main(String[] args) {
        BiFunction<Stream, Predicate<Integer>, Boolean> allMatch = Stream::allMatch;
    }
}
