package com.gastby.springboot.utils;

public class MyTimeFormat implements Comparable<MyTimeFormat> {

    private int month, day, year, hour, minute;

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public MyTimeFormat(String info) {
        String[] temp = info.split(" ");
        String[] left = temp[0].split("/");
        String[] right = temp[1].split(":");
        month = Integer.parseInt(left[0]);
        day = Integer.parseInt(left[1]);
        year = Integer.parseInt(left[2]);
        hour = Integer.parseInt(right[0]);
        minute = Integer.parseInt(right[1]);
    }

    @Override
    public int compareTo(MyTimeFormat o) {
        if (year < o.year) return -1;
        else if (year > o.year) return 1;
        if (month < o.month) return -1;
        else if (month > o.month) return 1;
        if (day < o.day) return -1;
        else if (day > o.day) return 1;
        if (hour < o.hour) return -1;
        else if (hour > o.hour) return 1;
        if (minute < o.minute) return -1;
        else if (minute > o.minute) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return year+"/"+month+"/"+day;
    }
}
