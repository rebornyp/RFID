package com.study;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class MyTwoNumbers {

    final static AtomicInteger a = new AtomicInteger(0);
    static volatile boolean flag = true;
    final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a.get() < 100) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + ":"+a.get());
                        a.incrementAndGet();
                        flag = false;
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a.get() < 100) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + ":"+a.get());
                        a.incrementAndGet();
                        flag = true;
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "t2").start();
    }

}
