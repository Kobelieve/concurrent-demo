package com.kobe.practice.t0;

public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " start...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " into catch");
                System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("after interrupt...isInterrupted: " + Thread.currentThread().isInterrupted());
                Thread.interrupted();
                System.out.println("after interrupted...isInterrupted: " + Thread.currentThread().isInterrupted());
            }

            System.out.println(Thread.currentThread().getName() + " end...");

        });

        t.start();
        Thread.sleep(1000);

        t.interrupt();

        System.out.println("Main thread end...");

    }

}
