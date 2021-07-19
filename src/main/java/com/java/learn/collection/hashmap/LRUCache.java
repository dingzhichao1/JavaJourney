package com.java.learn.collection.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Description：基于LRU算法的本地缓存
 *
 * LRU会获取
 *
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2021/7/16 11:21
 */
public class LRUCache<K,V> extends LinkedHashMap {

    /**
     * 默认的最大的容量
     */
    private static final int DEFAULT_MAX_SIZE=1000;

    /**
     * 实际的最大容量
     */
    private int maxSize ;


    public LRUCache(){
        this(DEFAULT_MAX_SIZE);
    }


    public LRUCache(int maxSize){
        super(16,0.75f,true);
        this.maxSize=maxSize;
    }



    /**
     * LinkeedHashMap 的默认实现是false,不需要进行
     * @param eldest
     * @return
     */
    @Override
    public boolean removeEldestEntry(HashMap.Entry eldest) {
        return size()>maxSize;
    }


}
