package com.kobe.practice.cdl;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {

    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                System.out.println("t1 over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("t2 over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        });

        t1.start();
        t2.start();

        System.out.println("wait all child thread over...");
        countDownLatch.await();
        System.out.println("all thread over...");
    }

}
