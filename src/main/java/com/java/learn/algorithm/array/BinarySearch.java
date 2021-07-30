package com.java.learn.algorithm.array;

import com.java.learn.sort.ArrayUtils;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/16 14:52
 * @Description:二分法查找 给定一个有序的数组，利用二分法在数组中查找一个元素
 */
public class BinarySearch {

    public static void main(String[] args) {
        //创建一个数组
        //int[] array = ArrayUtils.generateRandomArray(20);
        int[] array = {0,12};
        //1、对数组进行排序
        ArrayUtils.printArray(array);
        //quickSort(array);

        quickSort0(array,0,array.length-1);
        ArrayUtils.printArray(array);

        //2、对排序后的数组进行二分法查找
        int index = binarySearch0(array, 1);

        System.out.println(index);
    }

    /**
     * 使用二分法进行查找（非递归）
     *
     * @param orderArr
     * @param searchNum
     */
    public static int binarySearch(int[] orderArr, int searchNum) {
        /**
         * 1、确定是否为空
         * 2、确定是否排序
         * 3、设置两个引用，用于设置遍历的条件
         */
        //1、获取中间元素，不断去遍历中间元素
        int start = 0;
        int end = orderArr.length - 1;
        //2、设置循环的条件
        while (start < end) {
            int midIndex = (start + end) / 2;
            if (orderArr[midIndex] == searchNum) {
                return midIndex;
            } else if (orderArr[midIndex] > searchNum) {
                //！！！最重要的判断在于重新设置数组的边界时是否
                if ((end = midIndex - 1) < start) {
                    //如果小于start就跳出循环
                    break;
                }
            } else {
                if ((start = midIndex + 1) > end) {
                    break;
                }
            }
        }
        return -1;

    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        quickSort(arr, start, end);

    }

    private static void quickSort(int[] arr, int start, int end) {

        int midIndex = partition(arr, start, end);

        if (start < midIndex - 1) {
            quickSort(arr, start, midIndex - 1);
        }

        if (midIndex + 1 < end) {
            quickSort(arr, midIndex + 1, end);
        }
    }


    private static int partition(int[] arr, int start, int end) {
        //1、获取标准元素
        int target = arr[start];
        //2、设置左右两个指针
        int left = start;
        int right = end;
        //3、遍历指针
        while (left < right) {

            //从右边开始移动指针
            while (left < right && arr[right] >= target) {
                right--;
            }
            //从左边移动指针
            while (left < right && arr[left] <= target) {
                left++;
            }

            //交换左右的两个元素
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        //4、结束遍历后左右指针的位置重合
        int temp = arr[start];
        arr[start] = arr[left];
        arr[left] = temp;
        return left;
    }


    /**
     * 单边快速排序
     *
     * @param arr
     */
    private static void quickSort1(int[] arr) {
        /**
         *  1、选择标准元素、设置指针
         *  2、如果大于标准元素的就放行，直至遇到
         *
         *
         *
         */
        int start=0;
        int target = arr[start];
        int mark = start;

        while (start < arr.length) {
            for (int i = start; i < arr.length; i++) {
                //如果元素小于标准元素就进行操作，否则往后继续遍历
                if (arr[i] < target) {
                    mark++;
                    //交换元素和标记元素
                    int temp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = temp;
                }
            }

            //交换一下准元素和mark的位置

        }


    }


    private static void quickSort0(int [] arr,int start,int end){
        if(start>=end){
            return;
        }

        int midIndex = partition0(arr, start, end);
        if(start<midIndex-1){
            System.out.println(start+":"+(midIndex-1));
            quickSort0(arr,start,midIndex-1);
        }
        if(midIndex+1<end){
            System.out.println((midIndex+1)+":"+end);
            quickSort0(arr,midIndex+1,end);
        }

    }


    private static int partition0(int [] arr,int start,int end){
        int mark=start;
        int target=arr[start];
        for (int i = start+1; i <=end ; i++) {
            if(target>arr[i]){
                mark++;
                int temp=arr[mark];
                arr[mark]=arr[i];
                arr[i]=temp;
            }
        }
        int temp=arr[mark];

        arr[mark]=target;
        arr[start]=temp;

        return mark;

    }


    //数组一般需要通过起始位置来进行控制，也方便后续的分割

    public static int binarySearch0(int [] arr,int targetNum){

        int index=-1;
        if(arr==null){
            throw new RuntimeException("");
        }
        int start=0;
        int end=arr.length;
        
        while (start<end){
            int midIndex = (start + end) / 2;
            if(arr[midIndex]==targetNum){
                return midIndex;
            }else if(arr[midIndex]>targetNum){
                end=midIndex-1;
            }else {
                start=midIndex+1;
            }
        }

        return index;

    }




}
