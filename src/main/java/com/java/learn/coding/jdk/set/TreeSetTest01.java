package com.java.learn.coding.jdk.set;

/**
 * Description：TreeSet源码研究
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/8/5 13:58
 */


import java.util.TreeSet;

/**
 * 1、看集合的继承关系
 * 2、看集合的数据结构
 * 3、扩容方式
 */
public class TreeSetTest01 {
    public static void main(String[] args) {
        /**
         * 继承关系：TreeSet-->AbstractSet-->AbstractCollection
         */
        TreeSet<Product> treeSet = new TreeSet<>();
        Product product = new Product();
        product.setId(1);
        product.setName("cola");
        product.setOrder(1);
        treeSet.add(product);

    }


}

class Product {
    private int id;
    private String name;
    private int order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
