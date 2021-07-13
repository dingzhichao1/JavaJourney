package com.java.learn.sort;

/**
 * @Auther: DingZhichao
 * @Date: 2021/7/3 13:23
 * @Description: 冒泡算法
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = ArrayUtils.generateRandomArray(20);


    }

    /**
     *  冒泡排序算法基础版
     *  1、双层
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort0(int [] array){
        //外层循环决定的是循环的次数，对于一个元素为n的数组，它的循环次数为n-1
        for (int i = 0; i < array.length-1; i++) {
            
            //内层循环控制每次循环，需要进行比较的元素。每次需要从0索引开始，xiang到某个范围进行比较，也可以从后往前
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j++]){
                    int temp=array[j];
                }
            }
            
            
        }
        return null;
    }
}
