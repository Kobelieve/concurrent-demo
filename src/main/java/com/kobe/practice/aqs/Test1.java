package com.kobe.practice.aqs;

/**
 * @ClassName Test1
 * @Description 如果没有加锁，导致num最终结果有可能不等于1000000
 * @Author Tao
 * @Date 2019-06-30 19:32
 * @Version 1.0
 */
public class Test1 {

    public static int num = 0;

    public static void main(String[] args) throws Exception {

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (Test1.class) {
                    for (int j = 0; j < 1000; j++) {
                        num++;
                    }
                }
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }

        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println(num);

    }

}
