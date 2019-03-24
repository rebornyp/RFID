package com.gastby.springboot.utils;

import java.util.Random;

public class Utils {

    private static Random random;

    private static String[] names;
    private static String[] position;

    static {
        random = new Random();
        names = new String[]{
                "遥控天线1A","遥控天线1B", "遥控天线1C", "测控天线支撑结构",
                "遥测天线1", "遥测天线2", "北蓄电池组A模块", "北蓄电池组B模块",
                "北太阳翼", "南太阳翼"
        };
        position = new String[]{
          "厂房1", "厂房2","厂房3", "厂房4"
        };
    }

    public static String Pid() {
        StringBuilder sb = new StringBuilder();
        int r;
        for (int i=0; i<10; i++) {
            r = random.nextInt(36);
            if (r > 9) sb.append((char)('A' + (r - 10)));
            else sb.append(r);
        }
        return sb.toString();
    }

    public static String name() {
//        System.out.println(names.length);
        return names[random.nextInt(names.length)];
    }

    public static String position() {
        return position[random.nextInt(position.length)];
    }



}
