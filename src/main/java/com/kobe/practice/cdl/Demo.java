package com.kobe.practice.cdl;

import java.util.concurrent.CountDownLatch;

public class Demo {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("t1 over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("t2 over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("wait all child thread over...");
    }
}
