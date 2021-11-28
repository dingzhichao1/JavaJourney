package com.java.learn.algorithm.repeat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
* @ClassName:     ArrayRepeat
* @Description:    判断数组元素是否重复
* @Author:         DZC
* @CreateDate:     2019/8/23 9:41
* @Version:        1.0
*/
public class ArrayRepeat {

    /**
     * 判断数组元素是否重复，可以通过HashSet和HashMap的哈希值唯一性来进行判断
     */

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
