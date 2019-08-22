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
        int[] ints = ArrayUtils.generateRamdomArray(300);
        insertSort(ints);
        boolean hashRepeateByHashMap = isHashRepeateByHashMap(ints);
        System.out.println(hashRepeateByHashMap);
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

    /**
     * 判断数组中是否含有重复的元素
     * 该算法的时间复杂度为：n
     * 空间复杂度为：n
     *
     * @param arr
     * @return
     */
    public static boolean isHashRepeateByHashMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                return  true;
            }else{
                map.put(arr[i],i);
            }
        }
        return false;
    }


    /**
     * 判断数组中是否含有重复的元素
     * 该算法的时间复杂度为：n
     * 空间复杂度为：n
     *
     * @param arr
     * @return
     */
    public static boolean isHashRepeateByHashSet(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr)){
                return  true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }


}
