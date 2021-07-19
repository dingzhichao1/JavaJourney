package com.java.learn.sort;

/**
 * Description：快速排序算法
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/7/13 9:11
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = ArrayUtils.generateRandomArray(20);
        ArrayUtils.printArray(array);
        quickSort(array);
        ArrayUtils.printArray(array);
    }


    public static void quickSort(int []arr){
        if(arr==null){
            throw new RuntimeException("");
        }
        quickSort(arr,0,arr.length-1);

    }

    private static void quickSort(int [] arr,int start,int end){
        //
        int partition = partition(arr, start, end);
        if(start<partition-1){
            quickSort(arr,start,partition-1);
        }
        if(end>partition+1){
            quickSort(arr,partition+1,end);
        }


    }


    private static int partition(int [] arr,int start ,int end){
        //选择元素作为标准元素
        int target = arr[end];
        int left=start;
        int right=end;
        while (left<right){

            //!!!假设一条中位线将数组一分为二，如果以左边的元素为标准元素，必须对右边先进行遍历，反之亦然
            while (left<right&&arr[left]<=target){
                left++;
            }
            while (left<right&&arr[right]>=target){
                right--;
            }

            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        int temp=arr[left];
        arr[left]=arr[end];
        arr[end]=temp;
        return left;
    }
}
