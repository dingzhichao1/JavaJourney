package com.java.learn.algorithm.string;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/19 20:21
 * @Description:异位词
 *
 * 思路用加减代替比较（尤其是重复的比较）
 */
public class YiWeiCi {
    public static void main(String[] args) {
        String  str ="abcabcdH";
        String  str1 ="Habcadcb";
        String  str2 ="abcdefghi";
        String  str3 ="abcabcd";

        //boolean b = methodOne(str3, str);
        boolean b = methodTwo(str, str1);
        System.out.println(b);
    }

    /**
     * 转化为HashMap
     *
     * 有点实现简单，但是空间复杂度大
     * 时间复杂度位2n
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean methodOne(String str1,String str2){

        if(str1.equals(str2)){
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            if(map1.containsKey(chars1[i])){
                map1.put(chars1[i],map1.get(chars1[i])+1);
            }else{
                map1.put(chars1[i],1);
            }
        }

        for (int i = 0; i < chars2.length; i++) {
            if(map2.containsKey(chars2[i])){
                map2.put(chars2[i],map2.get(chars2[i])+1);
            }else{
                map2.put(chars2[i],1);
            }
        }

        if(map1.equals(map2)){
            return true;
        }

        return false;

    }

    /**
     * 基于methodOne的魔改
     * 一个进行数量加操作，一个进行数量减操作
     * 想比一节省了一个map空间
     * @param str1
     * @param str2
     * @return
     */
    public static boolean methodTwo(String str1,String str2){
        if(str1.equals(str2)){
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            if(map.containsKey(chars1[i])){
                map.put(chars1[i],map.get(chars1[i])+1);
            }else{
                map.put(chars1[i],1);
            }
            if(map.containsKey(chars2[i])){
                map.put(chars2[i],map.get(chars2[i])-1);
            }else{
                map.put(chars2[i],-1);
            }
        }
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next!=0){
                return false;
            }
        }
        return true;
    }

}
