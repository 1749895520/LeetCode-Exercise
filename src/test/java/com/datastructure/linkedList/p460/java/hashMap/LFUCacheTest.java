package com.datastructure.linkedList.p460.java.hashMap;

/**
 * @Description LFUCacheTest
 * @Author ZFiend
 * @Create 2023.01.08 21:31
 */
public class LFUCacheTest {
    public static void main(String[] args) {
        test01();
        System.out.println("----------------------");
        test02();
        System.out.println("----------------------");
        test03();
    }

    public static void test01() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }

    public static void test02() {
        LFUCache lfuCache = new LFUCache(0);
        lfuCache.put(0, 0);
        System.out.println(lfuCache.get(0));
    }

    public static void test03() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(2));
        lfuCache.put(1, 1);
        lfuCache.put(4, 1);
        System.out.println(lfuCache.get(2));
    }
}
