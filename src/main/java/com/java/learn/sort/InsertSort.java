package com.java.learn.sort;

import java.util.*;

/**
 * @ClassName: InsertSort
 * @Description: 插入排序算法研究
 * @Author: DZC
 * @CreateDate: 2019/8/21 16:13
 * @Version: 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandomArray(300);
        insertSort(ints);
        ArrayUtils.printArray(ints);
    }

    /**
     * 
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]>=arr[i+1]){

            }
        }




    }



}
