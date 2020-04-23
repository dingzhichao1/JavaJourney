package com.java.learn.algorithm.array;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/16 14:52
 * @Description:二分法查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] orderArr={1,2,3,4,7,8,12,23,45};
        methodOne(orderArr,1);
    }

    /**
     * 使用二分法进行查找
     *
     * @param orderArr
     * @param searchNum
     */
    public static void methodOne(int [] orderArr,int searchNum){
        int targetIndex=-1;
        int startIndex=0;
        int endIndex=orderArr.length-1;
        int len=endIndex-startIndex+1;
        int midIndex=(startIndex+endIndex)/2;
        while (startIndex<endIndex){
            if(orderArr[midIndex]==searchNum){
                targetIndex=midIndex;

                return;
            }else if(orderArr[midIndex]<searchNum){
                startIndex=midIndex+1;
                midIndex=(startIndex+endIndex)/2;

            }else{
                endIndex=midIndex-1;
                midIndex=(startIndex+endIndex)/2;

            }

        }

    }

    /**
     * 使用二分法进行查找（非递归）
     *
     * @param orderArr
     * @param searchNum
     */
    public static void methodTwo(int [] orderArr,int searchNum){
        int targetIndex=-1;
        int startIndex=0;
        int endIndex=orderArr.length-1;
        int midIndex=(startIndex+endIndex)/2;


    }


}
