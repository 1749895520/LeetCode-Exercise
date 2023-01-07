package com.datastructure.linkedList.p146.java.cache;

import java.util.LinkedHashMap;

/**
 * @Description Solution
 * @Author ZFiend
 * @Create 2023.01.07 23:17
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Integer value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        get(key);
        cache.put(key, value);
        if (cache.size() > capacity) {
            Integer removeKey = cache.keySet().iterator().next();
            cache.remove(removeKey);
        }
    }
}
