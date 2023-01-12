package com.datastructure.string.p224.java.string;

/**
 * @Description Solution
 * @Author ZFiend
 * @Create 2023.01.12 22:14
 */
public class Solution {
    int index = 0;

    public int calculate(String s) {
        int sign = 1, res = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c - '0' >= 0 && c - '0' <= 9) {
                res += sign * getNum(s);
            } else {
                switch (c) {
                    case '+':
                        sign = 1;
                        break;
                    case '-':
                        sign = -1;
                        break;
                    case '(':
                        index += 1;
                        res += sign * calculate(s);
                        break;
                    case ')':
                        return res;
                }
                index++;
            }
        }
        return res;
    }

    private int getNum(String s) {
        int num = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            num = num * 10 + (s.charAt(index) - '0');
            index++;
        }
        return num;
    }
}
