package com.datastructure.string.p20.java.stack;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (!stack.empty() && stack.peek() == getLeft(c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    private Character getLeft(char c) {
        return c == ')' ? '(' : c == '}' ? '{' : '[';
    }
}
