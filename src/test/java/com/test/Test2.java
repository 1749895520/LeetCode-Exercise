package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W, N;
        W = sc.nextInt();
        N = sc.nextInt();
        List<Thing> things = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int num = sc.nextInt();
            things.add(new Thing(weight * num, num));
        }
        things.sort((a, b) -> {
            if (a.getNum() == b.getNum()) {
                return b.getWeight() - a.getWeight();
            }
            return b.getNum() - a.getNum();
        });
        int num = 0;
        for (Thing thing : things) {
            W -= thing.getWeight();
            if (W >= 0) {
                num += thing.getNum();
            } else {
                W += thing.getWeight();
            }
        }
        System.out.println(num);
    }
}

class Thing {
    private int weight;
    private int num;

    public Thing() {
    }

    public Thing(int weight, int num) {
        this.weight = weight;
        this.num = num;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "weight=" + weight +
                ", num=" + num +
                '}';
    }
}
