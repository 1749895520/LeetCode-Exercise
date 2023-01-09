package com.datastructure.array.p380.java.hashMapAndArrayList;

/**
 * @Description RandomizedSet
 * @Author ZFiend
 * @Create 2023.01.09 20:28
 */
public class RandomizedSetTest {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}
