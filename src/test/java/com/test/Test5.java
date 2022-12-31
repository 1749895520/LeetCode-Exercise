package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 7 3
 * P1:9
 * P2:7
 * P3:8
 * P4:4
 * P5:2
 * P6:1
 * P7:3
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        N = sc.nextInt();
        M = sc.nextInt();
        List<Play> plays = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            String number = line.substring(0, 3);
            int time = Integer.parseInt(line.substring(3));
            plays.add(new Play(number, time));
        }
        plays.sort((a, b) -> b.getTime() - a.getTime());
        String[] list = new String[N];
        int[] times = new int[M];
        int index = 0, flag = 1, num = 1, listIndex = 0;
        for (Play play : plays) {
            if (index == M || index == -1) {
                flag = -flag;
                index += flag;
                num++;
            }
            list[listIndex++] = play.getNumber() + (index + 1 + "") + "-" + (num + "");
            times[index] += play.getTime();
            index += flag;
        }
        Arrays.sort(times);
        Arrays.sort(list, (a, b) -> {
            int i1 = a.charAt(1) - '0';
            int i2 = b.charAt(1) - '0';
            return i1 - i2;
        });
        System.out.println(Arrays.toString(times));
        System.out.println(times[times.length - 1]);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class Play {
    private String number;
    private int time;

    public Play() {
    }

    public Play(String number, int time) {
        this.number = number;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Play{" +
                "number='" + number + '\'' +
                ", time=" + time +
                '}';
    }
}

