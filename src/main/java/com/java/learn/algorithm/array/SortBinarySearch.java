package com.java.learn.algorithm.array;

import com.java.learn.algorithm.sort.ArrayUtils;

/**
 * Description：排序二分法查找
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/7/30 13:32
 */
public class SortBinarySearch{


    public static void main(String[] args) {
        //int[] array = ArrayUtils.generateRandomArray(20);
        //无序数组
        int [] array={15,81,98,10,77,3,2,14,91,52,82,59,88,43,95,50,83,26,48,2};
        ArrayUtils.printArray(array);
        quickSort(array);
        ArrayUtils.printArray(array);
        int indexBinarySearch = findIndexBinarySearch(array, 52);
        System.out.println(indexBinarySearch);
    }


    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int [] arr){
        if(arr==null){
            throw new RuntimeException("数组不能为空");
        }
        //排序
        quickSort(0,arr.length-1,arr);
    }

    /**
     * 快速排序
     *
     * @param start
     * @param end
     * @param arr
     */
    private static void quickSort(int start,int end,int [] arr){
        int midIndex = partition(start, end, arr);
        if(start<midIndex-1){
            quickSort(start,midIndex-1,arr);
        }
        if(midIndex+1<end){
            quickSort(midIndex+1,end,arr);
        }

    }

    /**
     * 区域排序
     *
     * @param start
     * @param end
     * @param arr
     * @return
     */
    private static int partition(int start,int end,int [] arr){
        int left =start;
        int right =end;
        int target=arr[start];
        while(left<right){
            while (left<right&&arr[right]>=target){
                right--;
            }
            while (left<right&&arr[left]<=target){
                left++;
            }
            if(left<right){
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }

        }
        //
        int temp = arr[left];
        arr[left]=target;
        arr[start]=temp;
        return left;
    }


    public static int findIndexBinarySearch(int [] arr,int e){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int midIndex=(left+right)/2;
            if(arr[midIndex]>e){
                right=midIndex-1;
            }else if(arr[midIndex]<e){
                left=midIndex+1;
            }else {
                return midIndex;
            }

        }
        return -1;
    }

}
