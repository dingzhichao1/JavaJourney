package com.java.interview.base;

import java.lang.annotation.Annotation;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/4/7 14:05
 */
public class Base1 {
    /**
     * Linux的相关
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {
        Annotation[] annotations = Base1.class.getAnnotations();
    }



}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len=nums.length;
        if(len>=2&&len<=1000){
            for(int i=0;i<len-1;i++){
                int one=nums[i];
                for(int j=i+1;j<len;j++){
                    if(nums[i]+nums[j]==target){


                    }
                }
            }
        }
        return null;
    }
}