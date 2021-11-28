package com.java.learn.algorithm.sort;

import java.util.Random;

public class ArrayUtils {
    //默认元素值的边界
    private static int DEFUALT_END_BOUND=100;

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int [] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        int length =arr.length;
        for (int i = 0; i <length ; i++) {
            sb.append(arr[i]);
            if(i<length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }


    /**
     * 产生一个固定长度调度随机数
     * @param length
     * @return
     */
    public static int []  generateRandomArray(int length){
       int [] intArr =  new int[length];
        Random random = new Random();
        for (int i = 0; i <length ; i++) {
            intArr[i]=random.nextInt(DEFUALT_END_BOUND);
        }
        return intArr;
    }





}
