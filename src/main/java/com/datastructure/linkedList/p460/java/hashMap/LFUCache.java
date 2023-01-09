package com.datastructure.linkedList.p460.java.hashMap;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @Description LFUCache
 * @Author ZFiend
 * @Create 2023.01.08 20:57
 */
public class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (keyToVal.containsKey(key)) {    //  如果存在key则将key对应的映射关系更新
            increaseFreq(key);
            return keyToVal.get(key);
        }
        return -1;
    }

    public void put(int key, int val) {
        if (capacity <= 0) return;  //  如果容量本身小于0，则直接返回
        if (keyToVal.containsKey(key)) {  //  如果存在这个key，则直接更新freq
            increaseFreq(key);
        } else {
            if (keyToFreq.size() == capacity) { //  如果此时容量达到上限，则先将使用次数最少的key去除
                removeMinFreqKey();
            }
            keyToFreq.put(key, 1);  //  将新的key添加到freq = 1 中
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());   // 若freq=1的keys为空，则添加新的map
            freqToKeys.get(1).add(key);    //  将新key添加到set集合中
            this.minFreq = 1;   //  插入新的节点最小的freq一定为1
        }
        keyToVal.put(key, val); //  将key存入keyToVal
    }

    public void increaseFreq(int key) {
        Integer freq = keyToFreq.get(key);//  获取key对应的调用次数
        keyToFreq.put(key, freq + 1);     //  更新key的调用次数
        freqToKeys.get(freq).remove(key);   //  移除旧调用次数的set集合中的val
        if (freqToKeys.get(freq).isEmpty()) { //  如果旧调用次数的set集合为空，则去掉旧调用集合
            freqToKeys.remove(freq);
            if (freq == minFreq) minFreq++; //  如果这个freq正好是minFreq，则更新minFreq
        }
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);  //  将key存入新调用集合
    }

    public void removeMinFreqKey() {
        LinkedHashSet<Integer> minFreqKeysSet = freqToKeys.get(minFreq);    //  获取目前最小freq对应的set集合
        Integer removeKey = minFreqKeysSet.iterator().next();   //  获取需要移除的 key
        keyToVal.remove(removeKey);   //  将key对应的val移除
        keyToFreq.remove(removeKey);    //  将key对应的freq移除
        minFreqKeysSet.remove(removeKey);   //  将set集合中对应的key移除
        if (minFreqKeysSet.isEmpty()) {   //  如果此时set集合大小为0，则移除
            freqToKeys.remove(minFreq);
        }
    }
}
