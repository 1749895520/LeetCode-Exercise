package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        int W, N, M;
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
        int[] stones = new int[N];
        int[] differ = new int[N + 1];
        for (int i = 0; i < N; i++) {
            stones[i] = sc.nextInt();
        }
        differ[0] = stones[0];
        for (int i = 1; i < N; i++) {
            differ[i] = stones[i] - stones[i - 1];
        }
        differ[N] = W - stones[N - 1];
        Arrays.sort(differ);
        Map<Integer, Integer> lens = new HashMap<>();
        for (int d : differ) {
            lens.put(d, lens.getOrDefault(d, 0) + 1);
        }
        int maxNum = 0, num = 0, num1 = 0, num2 = 0;
        while (M-- > 0) {
            Integer[] keys = lens.keySet().toArray(new Integer[0]);
            for (int i = keys.length - 1; i >= 0; i--) {
                int n = lens.get(i);
                if (n != 0) {
                    num = lens.get(i);
                    if (n == 1) {
                        lens.remove(keys[i]);
                    } else {
                        lens.put(keys[i], n - 1);
                    }
                    break;
                }
            }
            num1 = num / 2;
            num2 = num - num1;
            lens.put(num1, lens.getOrDefault(num1, 0) + 1);
            lens.put(num2, lens.getOrDefault(num2, 0) + 1);
        }
/*        for (Map.Entry<Integer, Integer> integerIntegerEntry : lens.entrySet()) {
            System.out.println(integerIntegerEntry);
        }*/
        for (Integer key : lens.keySet()) {
            if (lens.get(key) != 0) {
                maxNum = Math.max(maxNum, key);
            }
        }
        System.out.println(maxNum);
    }
}
