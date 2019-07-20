package com.kobe.practice;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " in...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                Thread.interrupted();
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println("睡眠的时候被main线程调用interrupt方法，执行到catch模块代码");
            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

}
