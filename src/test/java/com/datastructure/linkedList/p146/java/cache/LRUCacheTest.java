package com.datastructure.linkedList.p146.java.cache;

/**
 * @Description LRUCacheTest
 * @Author ZFiend
 * @Create 2023.01.07 23:23
 */
public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        System.out.println(lruCache.get(1));
    }
}
