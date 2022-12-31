package com.test;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[25];
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        for (int i = 3; i <= 20; i++) {
            if (i % 2 != 0) {
                arr[i] = getJi(arr[i - 2], arr[i - 1]);
            } else {
                arr[i] = getOu(arr[i - 2], arr[i - 1]);
            }
        }
        for (int i = 1; i <= 20; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Random r = new Random(998);
        Set<Integer> randomNums = new HashSet<>();
        while (randomNums.size() < 5) {
            randomNums.add(r.nextInt(20) + 1);
        }
        for (int randomNum : randomNums) {
            System.out.print(randomNum + " ");
        }
        System.out.println();
        for (int randomNum : randomNums) {
            System.out.print(arr[randomNum] + " ");
        }
        System.out.println();
    }

    private static int getOu(int a, int b) {
        return (a + b) % 1000;
    }

    private static int getJi(int a, int b) {
        int num = a * b;
        if (num > 1000) {
            return num / 1000 + num % 100;
        }
        return num;
    }
}
