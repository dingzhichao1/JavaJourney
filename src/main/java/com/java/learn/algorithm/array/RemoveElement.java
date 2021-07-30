package com.java.learn.algorithm.array;

import com.java.learn.sort.ArrayUtils;

import java.util.*;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/14 13:34
 * @Description:  从数组中去掉某些元素
 */
public class RemoveElement {
    /**
     * 数组Arr1={a,b,c}   长度为n;
     * 数组Arr2={a,b,c,d,e}  长度为m;
     *
     * 从Arr2中剔除Arr1中的元素
     *
     *
     *
     */

    public static void main(String[] args) {
        int [] arr1={2,3,2,4,5,6,46,4};
        int [] arr2={1,2,3,45,53,46,4,23,4};
        //methodTwo(arr1,arr2);
        //methodThree(arr1,arr2);
        //methodFour(arr1,arr2);

        int[] test = test(arr1, arr2);

        ArrayUtils.printArray(test);
    }

    /**
     * 1、将剔除的元素放入到HashMap中
     * 2、新建一个list集合将不包含的元素放入list中
     * 3、新建一个数组将list元素放入数组中
     *  优点：实现简单
     *  缺点：空间开销较大达到了3n
     *
     */
    private static void  methodOne(int [] arr1,int [] arr2){

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i],null);
        }


        for (int i = 0; i < arr2.length; i++) {
            //调用map的containsKey的时间复杂度是否会减少？
            if(!map.containsKey(arr2[i])){
                list.add(arr2[i]);
            }
        }

        int size = list.size();
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=list.get(i);

        }
        System.out.println(list);
        System.out.println(arr1);


    }

    /**
     *实现比较复杂，需要每次移除元素之后，还要对数组进行缩容处理，还需要考虑每次遍历步数
     *通过system.arrayCopy来进行数组扩容
     * @param arr1
     * @param arr2
     */
    private static void  methodTwo(int [] arr1,int [] arr2){
        int len = arr2.length;
        int step=1;
        for (int i = 0; i <len; i+=step) {
            boolean flag=false;
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i]==arr1[j]){
                    flag=true;
                    break;
                }
            }
            if(flag){
                int [] temp =new int[len-1];
                if(i!=len-1){
                    System.arraycopy(arr2,0,temp,0,i);
                    System.arraycopy(arr2,i+1,temp,i,len-i-1);
                    arr2=temp;
                    step=0;
                }else if(i==0){
                    System.arraycopy(arr2,1,temp,0,i);
                    arr2=temp;
                }else {
                    System.arraycopy(arr2,0,temp,0,i);
                    arr2=temp;
                    step=1;
                }

                len=arr2.length;

            }else {
                step=1;
            }

        }


        for (int i = 0; i <arr2.length ; i++) {
            System.out.println(arr2[i]);
        }


    }

    /**
     *
     * @param arr1
     * @param arr2
     */
    private  static  void methodThree(int [] arr1,int [] arr2){

        //原数组长度
        int len =arr2.length;

        //相同元素的长度
        int sameElementNum=0;
        //数组
        int i=0;
        while ( i < len-sameElementNum) {
            boolean flag=false;
            for (int j = 0; j< arr1.length; j++) {
                if(arr2[i]==arr1[j]){
                    flag=true;
                    sameElementNum++;
                    break;
                }
            }
            if(flag){
                if(i!=len-1){
                    System.arraycopy(arr2,i+1,arr2,i,len-i-1);
                }

            }else {
                i++;
            }

        }
        int newLen = len - sameElementNum;

        arr2 = Arrays.copyOfRange(arr2, 0, newLen );

        for (int  k= 0; k < arr2.length; k++) {
            System.out.println(arr2[k]);
        }

    }

    /**
     *
     * @param arr1
     * @param arr2
     */
    public static  void  methodFour(int [] arr1,int [] arr2){
        
        int index=0;
        Map<Integer, Integer> arr1Map = new HashMap<>();
        int length = arr1.length;
        for (int i = 0; i < length; i++) {
            arr1Map.put(arr1[i],null);
        }


        for (int i = 0; i < arr2.length; i++) {
            boolean flag=false;
            if(arr1Map.containsKey(arr2[i])){
                flag=true;
            }
            if(!flag){
                arr2[index++]=arr2[i];
            }

        }

        arr2 = Arrays.copyOfRange(arr2, 0, index);

        for (int  k= 0; k < arr2.length; k++) {
            System.out.println(arr2[k]);
        }

    }


    /**
     * 两个数组如果用传统的遍历方式，需要进行n*n次遍历，这是一个时间复杂度可以优化的点
     *
     * 另外就是数组移除后，频繁的扩容、数组复制也会消耗资源，如何减少数组扩容的次数这也
     * 是一个优化的点
     *
     * 可以通过移动元素的位置，是元素的一边为不重复的元素，另一边为重复的元素
     *
     *
     *
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private static int [] test(int [] arr1,int [] arr2){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int mark=-1;
        for (int i = 0; i < arr2.length; i++) {
            if(!set.contains(arr2[i])){
                arr2[++mark]=arr2[i];
            }
        }
        if(mark!=-1){
            int[] arr = new int[mark+1];
            System.arraycopy(arr2,0,arr,0,mark+1);
            return arr;
        }
        return arr2;

    }

}
