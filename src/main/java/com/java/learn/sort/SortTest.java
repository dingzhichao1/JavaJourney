//package com.java.learn.sort;
//
///**
// * @Auther: DingZhichao
// * @Date: 2021/7/12 22:17
// * @Description: 排序算法回顾
// */
//public class SortTest {
//    public static void main(String[] args) {
//
//        int[] arr = ArrayUtils.generateRandomArray(20);
//        ArrayUtils.printArray(arr);
//        //bubbleSort(arr);
//        quickSort(arr);
//        ArrayUtils.printArray(arr);
//    }
//
//
//    /**
//     * 冒泡算法
//     * @param arr
//     */
//    public static void bubbleSort(int [] arr){
//        if(arr==null){
//            throw new RuntimeException("数组不能为空");
//        }
//        //共有n-1轮排序
//        for (int i = 0; i < arr.length-1; i++) {
//            boolean sorted=true;
//            //每轮比较n-1-i个元素
//            for (int j = 0; j <arr.length-1-i ; j++) {
//                if(arr[j]>arr[j+1]){
//                    int temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//                    sorted=false;
//                }
//            }
//            if(sorted){
//                break;
//            }
//        }
//    }
//
//    /**
//     * 快速排序-双边递归排序
//     * @param arr
//     */
//    public static void quickSort(int[]arr){
//        if(arr==null){
//            throw new RuntimeException("数组不能为空");
//        }
//        quickSort(arr,0,arr.length-1);
//    }
//
//    private static void quickSort(int[]arr,int startIndex,int endIndex){
//
//        int propIndex = sortProp(arr,startIndex,endIndex);
//
//        if(startIndex<propIndex-1){
//            quickSort(arr,startIndex,propIndex-1);
//        }
//        if(propIndex+1<endIndex){
//            quickSort(arr,propIndex+1,endIndex);
//        }
//
//    }
//
//
//    private static int sortProp(int [] arr,int startIndex,int endIndex){
//        //设置目标值
//        int prop = arr[startIndex];
//        int left=startIndex;
//        int right=endIndex;
//        while (left<right){
//
//            while (left<right&&arr[right]>=prop){
//                right--;
//            }
//
//
//            while (left<right && arr[left]<=prop){
//                left++;
//            }
//
//
//
//            if(left<right){
//                int temp = arr[left];
//                arr[left] = arr[right];
//                arr[right]=temp;
//            }
//
//        }
//        //相等交换
//        int temp = arr[left];
//        arr[left]= arr[startIndex];
//        arr[startIndex]=temp;
//
//        //此时left和right相等
//        return left;
//    }
//
//
//}
