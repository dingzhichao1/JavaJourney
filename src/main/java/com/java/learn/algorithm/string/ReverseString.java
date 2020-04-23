package com.java.learn.algorithm.string;

/**
 * @Auther: DingZhichao
 * @Date: 2020/4/19 20:01
 * @Description:字符串的反转
 */
public class ReverseString {
    public static void main(String[] args) {
        String  str ="abcdefghi";
        //String s = methodOne(str);
        String s = methodTwo(str);
        //System.out.println(s);
    }

    /**
     * 方法一，通过java的StringBuffer
     *
     * 最简单的实现方式，但是需要另外开辟空间
     * @param str
     * @return
     */
    public static String methodOne(String str){
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();

    }

    /**
     * 方法二、先转化为字符数组，再进行倒序排序
     * 设计前后两个指针，交换、移动
     *
     * @param str
     * @return
     */
    public  static String methodTwo(String str){
        char[] chars = str.toCharArray();
        int headIndex=0;
        int endIndex=chars.length-1;
        while(headIndex<endIndex){
            char temp=chars[headIndex];
            chars[headIndex]=chars[endIndex];
            chars[endIndex]=temp;
            headIndex++;
            endIndex--;
        }

        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }

        return chars.toString();


    }


//    public static  String  methodThree(String str){
//        String[] split = str.split("");
//
//
//    }



}
