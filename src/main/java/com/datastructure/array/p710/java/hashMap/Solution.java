package com.datastructure.array.p710.java.hashMap;

import java.util.*;

/**
 * @Description Solution
 * @Author ZFiend
 * @Create 2023.01.10 22:47
 */
public class Solution {
    Map<Integer, Integer> map;
    Random random;
    int len;

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        random = new Random();
        len = n - blacklist.length;
        Set<Integer> blackBeyondLen = new HashSet<>();
        for (int black : blacklist) {
            if (black >= len) blackBeyondLen.add(black);
        }
        int index = len;
        for (int black : blacklist) {
            if (black < len) {
                while (blackBeyondLen.contains(index)) {
                    index++;
                }
                map.put(black, index++);
            }
        }
    }

    public int pick() {
        int index = random.nextInt(len);
        return map.getOrDefault(index, index);
    }
}
