package com.datastructure.string.p921.java.stack;

public class Solution {
    public int minAddToMakeValid(String s) {
        int res = 0, need = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                need++;
            } else {
                need--;
            }
            if (need == -1) {
                need = 0;
                res++;
            }
        }
        return res + need;
    }
}
