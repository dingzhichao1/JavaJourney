package com.java.learn.algorithm.string;

/**
 * @Auther: DingZhichao
 * @Date: 2021/7/12 23:32
 * @Description:    输出最长的重复字符的字符串
 */
public class FindRepeatString {


    public static void main(String[] args) {

        String str="aaccddfffggggrrwwwfwww";

        String longStr="";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            int reverse = reverse(chars, i);
            String substring = str.substring(i, reverse+1);
            if(substring.length()>longStr.length()){
                longStr=substring;
            }
            i=reverse;
        }

        System.out.println(longStr);

    }

    private static int reverse(char[] chars,int index){
        if(index==chars.length-1){
            return index;
        }
        char char0 = chars[index];
        char char1 = chars[index+1];
        if(char0==char1){
            return reverse(chars,index+1);
        }
        return index;
    }


}
