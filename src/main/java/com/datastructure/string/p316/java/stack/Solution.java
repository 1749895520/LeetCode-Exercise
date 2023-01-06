package com.datastructure.string.p316.java.stack;

import java.util.Stack;

/**
 * @Description Solution
 * @Author ZFiend
 * @Create 2023.01.06 23:26
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] isInStack = new boolean[256];
        int[] count = new int[256];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar]++;
        }
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]--;
            if (isInStack[chars[i]]) continue;
            while (!stack.isEmpty() && stack.peek() > chars[i]) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                isInStack[stack.pop()] = false;
            }
            stack.push(chars[i]);
            isInStack[chars[i]] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        return sb.toString();
    }
}
