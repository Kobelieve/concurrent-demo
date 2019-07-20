package com.kobe.practice;

public class ThreadInterruptDemo {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("I'm still ruuning..");
                    return;
                }
            }
        });
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("begin interrupt t...");
        t.interrupt();
        System.out.println("end interrupt t...");
    }

}
