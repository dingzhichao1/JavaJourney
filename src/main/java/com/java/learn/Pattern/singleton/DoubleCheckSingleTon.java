package com.java.learn.Pattern.singleton;


/**
 * Description：双重检验单例模式
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/4/8 18:05
 */
public class DoubleCheckSingleTon {
    private volatile static Instance  instance = null;

    public  static  Instance getInstance()  {
        if(instance==null){
            /**
             * 在多个线程去创建对象的时候可以通过synchronized来保证只有一个对象创建成功
             * 但是synchronized不能防止指令的重排序
             */
            synchronized (DoubleCheckSingleTon.class){
                if(instance==null){

                    /**
                     * 该代码在编译程字节码指令的时候并不是原子性操作
                     * 主要分为三步：
                     * ①分配内存空间
                     * ②对象实例化
                     * ③引用指向对象
                     * 出于性能的考虑JIT会对上述指令进行重排序，有①②③变为①③②，单线程的情况下不会产生影响
                     * 但是在多线程的情况下会产生问题synchronized不能保证内部的代码按照顺序执行，就会出现问题
                     * 所以需要通过volatile进行内存屏障的插入来保证指令有序执行
                     *
                     *
                     */
                    instance=new Instance();
                }
            }

        }
        return instance;

    }


    static class Instance {

        //私有方法
        private Instance(){

        }


    }


    public static void main(String[] args) {



    }
}




