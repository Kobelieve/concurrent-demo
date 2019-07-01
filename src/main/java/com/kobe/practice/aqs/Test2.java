package com.kobe.practice.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author Tao
 * @Date 2019-06-30 20:13
 * @Version 1.0
 */
public class Test2 {

    public static int num = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    lock.lock();
                    for (int j = 0; j < 1000; j++) {
                        num++;
                    }
                } finally {
                    lock.unlock();
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num);
    }

}

