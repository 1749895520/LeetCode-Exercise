package com.datastructure.string.p1541.java.stack;

public class Solution {
    public int minInsertions(String s) {
        int res = 0, need = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    need--;
                    res++;
                }
            } else {
                need--;
            }
            if (need == -1) {
                need = 1;
                res++;
            }
        }
        return res + need;
    }
}
