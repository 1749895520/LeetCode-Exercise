package com.datastructure.array.p135.java.greedy;

public class Solution {
    public int candy(int[] ratings) {
        int res = ratings.length;
        int[] candies = new int[ratings.length];
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}
