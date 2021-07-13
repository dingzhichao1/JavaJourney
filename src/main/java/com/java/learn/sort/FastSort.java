package com.java.learn.sort;

/**
 * @Auther: DingZhichao
 * @Date: 2021/7/6 23:10
 * @Description: 快速排序
 * <p>
 * 核心思想：选择一个元素作为标准元素，设置左右两个指针，通过指针的移动
 * 如果两个指针都不移动就相互交换，如果两个指针重回就交换元素
 */
public class FastSort {

    public static void main(String[] args) {
        int[] arr = ArrayUtils.generateRandomArray(20);
        ArrayUtils.printArray(arr);
        sort0(arr);
        ArrayUtils.printArray(arr);
    }

    /**
     * 双边递归法
     * 1、设置left  和right两个索引
     * 2、通过递归方法来实现
     *
     * @param arr
     */
    public static void sort0(int[] arr) {
        //1、判断数组为空
        //2、设置左右索引的起始值
        //设置标准元素
        recurseQuickSort(arr,0,arr.length-1);

    }

    /**
     *
     * 快速排序递归方法
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private static void recurseQuickSort(int[] arr, int startIndex, int endIndex) {
        //进行第一轮排序，并返回第一轮排序后的索引值，作为递归的的起始的分界限
        int pivotIndex = getPivotIndex(arr, startIndex, endIndex);
        if(startIndex<pivotIndex-1){
            recurseQuickSort(arr,startIndex,pivotIndex-1);
        }

        if(pivotIndex+1<endIndex){
            recurseQuickSort(arr,pivotIndex+1,endIndex);
        }

    }


    /**
     * 获取支点的索引
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int getPivotIndex(int[] arr, int startIndex, int endIndex) {
        //保存支持点（中间轴的点），作为标准（任选一个元素），一般来说以第一个元素作为标准
        //注意：如果选中的元素是极值那么会导致最坏的情况，这时时间复杂度由原来的O(log n)变成
        //了O(n^2)
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        //当left小于right时才不断移动指针/或者交换元素
        while (left < right) {

            //注意在移动指针必须保证，left<right以防出现左右交错
            //右边移动指针
            while (left < right && arr[right] >= pivot) {
                //右指针向左移动
                right--;
            }

            while (left < right && arr[left] <= pivot) {
                left++;
            }

            //出现了右边的小于标准值，左边大于标准值，这是需要交换元素
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }


        }
        //跳出循环后，此时left=right
        //当左右的指针相等时，说明遍历到了支撑点，交换位置
        int temp = arr[left];
        arr[left] =arr[startIndex] ;  //此时left=right
        arr[startIndex] = temp;
        return left;
    }

}
