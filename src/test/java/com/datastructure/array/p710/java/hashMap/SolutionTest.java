package com.datastructure.array.p710.java.hashMap;

/**
 * @Description Solution
 * @Author ZFiend
 * @Create 2023.01.10 23:09
 */
public class SolutionTest {
    public static void main(String[] args) {
        Solution solution = new Solution(7, new int[]{2, 3, 5});
        for (int i = 0; i < 20; i++) {
            System.out.println(solution.pick());
        }
    }
}
