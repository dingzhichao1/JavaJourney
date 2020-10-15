package com.java.learn.coding.jdk.string;

/**
 * Description：字符串研究
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/9/29 15:51
 */
public class StringTest {
    public static void main(String[] args) {
        String aaa="aaa";


        String bbb="aaa";
        String aaaNew = new String("aaa");
        String bbbNew = new String("aaa");
        System.out.println(aaa.equals(aaaNew));
        System.out.println(aaa==(aaaNew));
        System.out.println(aaa==bbb);
        System.out.println(aaa.equals(bbb));
        System.out.println(aaaNew.equals(bbbNew));
        System.out.println(aaaNew==(bbbNew));


    }


}
/**
 * public class com.java.learn.coding.jdk.string.StringTest {
 *
 *   public com.java.learn.coding.jdk.string.StringTest();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: ldc           #2                  // String aaa   常量池中的常量值（int, float, string reference, object reference）入栈。
 *        2: astore_1                                          将栈顶引用类型值保存到局部变量1中。
 *        3: ldc           #2                  // String aaa
 *        5: astore_2
 *        6: new           #3                  // class java/lang/String
 *        9: dup                                                复制栈顶一个字长的数据，将复制后的数据压栈
 *       10: ldc           #2                  // String aaa
 *       12: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V      编译时方法绑定调用方法。
 *       15: astore_3
 *       16: new           #3                  // class java/lang/String
 *       19: dup
 *       20: ldc           #2                  // String aaa
 *       22: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
 *       25: astore        4


 *       27: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;    获取静态字段的值
 *       30: aload_1                              从局部变量1中装载引用类型值入栈
 *       31: aload_3
 *       32: invokevirtual #6                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 *       35: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
 *       38: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       41: aload_1
 *       42: aload_3
 *       43: if_acmpne     50                      //branchbyte2若栈顶两引用类型值不相等则跳转
 *       46: iconst_1                               1(int)值入栈。
 *       47: goto          51                       //无条件跳转到指定位置
 *       50: iconst_0
 *       51: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
 *       54: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       57: aload_1
 *       58: aload_2
 *       59: if_acmpne     66
 *       62: iconst_1
 *       63: goto          67
 *       66: iconst_0
 *       67: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
 *       70: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       73: aload_1
 *       74: aload_2
 *       75: invokevirtual #6                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 *       78: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
 *       81: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       84: aload_3
 *       85: aload         4
 *       87: invokevirtual #6                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 *       90: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
 *       93: getstatic     #5                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       96: aload_3
 *       97: aload         4
 *       99: if_acmpne     106
 *      102: iconst_1
 *      103: goto          107
 *      106: iconst_0
 *      107: invokevirtual #7                  // Method java/io/PrintStream.println:(Z)V
 *      110: return
 * }
 *
 */

