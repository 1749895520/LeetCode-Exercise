package com.datastructure.array.p455.java.greedy;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0, cookies = 0;
        while (cookies < s.length && children < g.length) {
            if (g[children] <= s[cookies++]) children++;
        }
        return children;
    }
}
