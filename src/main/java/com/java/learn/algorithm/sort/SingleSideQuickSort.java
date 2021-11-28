package com.java.learn.algorithm.sort;

/**
 * @Auther: DingZhichao
 * @Date: 2021/7/13 23:33
 * @Description:单边快排
 */
public class SingleSideQuickSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(20);
        ArrayUtils.printArray(arr);
        quickSort(arr);
        ArrayUtils.printArray(arr);
    }

    public static void quickSort(int[]arr){
        if(arr==null){
            throw new RuntimeException();
        }
        quickSort(arr,0,arr.length-1);

    }

    /**
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void quickSort(int[]arr,int start,int end){
        if(start>=end){
            return;
        }
        int index = partition(arr, start, end);

        quickSort(arr,start,index-1);
        quickSort(arr,index+1,end);
    }


    private static int partition(int[]arr,int start,int end){
        //选取标准元素
        int pivot = arr[start];
        //设置起始的指针，这个指针左边的都是小于标准值，右边都是大于的
        int mark=start;
        for (int i = start+1; i <=end ; i++) {
            if(arr[i]<pivot){
                //标记加一
                mark++;
                //开始交换标记指针和当前遍历的元素
                int temp=arr[i];
                arr[i]=arr[mark];
                arr[mark]=temp;

            }

        }
        //等到这轮结束后，交换mark和pivot元素
        int temp=arr[mark];
        arr[mark]=arr[start];
        arr[start]=temp;
        return mark;
    }
}
