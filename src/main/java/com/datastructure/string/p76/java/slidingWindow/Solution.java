package com.datastructure.string.p76.java.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, len = Integer.MAX_VALUE, start = 0, end = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == need.get(c)) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
                char g = s.charAt(left++);
                if (need.containsKey(g)) {
                    if (window.get(g) == need.get(g)) {
                        valid--;
                    }
                    window.put(g, window.getOrDefault(g, 0) - 1);
                }
            }
        }
        return len == Integer.MIN_VALUE ? "" : s.substring(start, end);
    }
}
