package com.java.learn.collection.hashmap;

import java.util.Map;
import java.util.Objects;

/**
 * @Auther: DingZhichao
 * @Date: 2020/5/1 12:36
 * @Description:
 */
public class MyHashMap {
    //序列号
    private static final long serialVersionUID = 362498820763181275L;

    /**
     * 初始容量 - 必须是2的倍数
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // 默认 16（10000）


    /**
     * 最大容量是2的倍数，且小于2^30
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;  //默认 2^30()

    /**
     * 默认负载因子，用于扩容时使用
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;


    /**
     * 树化的阈值，链表节点数大于8就会转化为红黑树
     */
    static final int TREEIFY_THRESHOLD = 8;


    /**
     * 取消树化的阈值，当进行删除操作时，红黑树的节点小于6时会转化为列表
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     */
    static final int MIN_TREEIFY_CAPACITY = 64;


    /**
     * 基本的Hash箱节点 used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     */
    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        MyHashMap.Node<K, V> next;

        Node(int hash, K key, V value, MyHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }



    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        int keyCode = Objects.hashCode("name");
        int valueCode = Objects.hashCode("秦始皇");
        System.out.println(keyCode+"="+valueCode);
        System.out.println(keyCode^valueCode);
        System.out.println(1^14);
        //Node<String, Object> objectNode = new Node<>();
    }


}
