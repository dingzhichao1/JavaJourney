package com.java.learn.coding.jdk.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/8/13 14:47
 */
public class HashMapTest {
    /**
     * HashMap如何答：
     * Q:
     * 1、HashMap是啥？用来干啥
     * 2、HahMap的数据结构是什么？为什么要用这种数据结构
     * 3、底层实现的流程
     * 4、迭代
     * hash、扩容（hash值再次与新容量的最大索引值做与运算）
     *
     *
     *
     *
     *
     * A:
     * 1、用来存取K-V映射关系的容器
     * 2、数组+单链表/红黑树
     *  数组：查询快
     *  单链表：解决Hash冲突
     *  红黑树：解决单链表查找慢的问题
     * 3、
     *  关系映射：通过key去映射数组索引
     *  高低位充分参与运算，使结果更加混乱，在数组中的分布更加均匀
     *  hash =  (h = key.hashCode()) ^ (h >>> 16)   hash为哈希值
     *
     *  i=hash&(n-1)    n是数组容量，i是数组索引值
     *
     *  添加容器：
     *  if  tab==null   扩容
     *
     *  if tab[i]==null   创建Node添加元素
     *
     *  else if
     *
     *      if(key1.equals(key0))   覆盖原来的元素
     *
     *      else if(node instanceof TreeNode)  放入到树中
     *
     *      else
     *           创建新节点
     *          判断是否需要树化
     *          插入
     *
     *  判断是否需要扩容: 有元素的数组槽/数组容量>0.75 ,扩容按照2的幂次进行扩容
     *
     *  resize()    newTab[hash&(newCap-1)]
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */


    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        for (int i = 0; i <16 ; i++) {
            map.put(i,"AAAA");
        }

       int k=16;
        do{
            System.out.println(k--);
        }while (k!=0);


    }



}
