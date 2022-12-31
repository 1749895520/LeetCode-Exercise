package com.test;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String date = new Scanner(System.in).next();
        String[] splits = date.split("-");
        int year = Integer.parseInt(splits[0]);
        int month = Integer.parseInt(splits[1]);
        int day = Integer.parseInt(splits[2]);
        LocalDateTime startTime = LocalDateTime.of(2022, 10, 1, 0, 0);
        LocalDateTime todayTime = LocalDateTime.of(year, month, day, 0, 0);
        int days = todayTime.compareTo(startTime) + 1;
        String[] plays = {"长跑", "长跑", "长跑", "爬山", "爬山", "爬山", "徒步远足", "徒步远足"};
        String todayPlay = plays[days % 8 - 1];
        System.out.println(todayPlay);
    }
}
