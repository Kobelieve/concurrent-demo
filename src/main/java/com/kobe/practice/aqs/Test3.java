package com.kobe.practice.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Test1
 * @Description 启动了1000个线程，每个线程执行完业务操作后，必须休眠3s，如果不用countdownlatch的话，则有可能打印了没有执行完的num
 *              countdownlatch保证了线程结束的精准时间
 * @Author Tao
 * @Date 2019-06-30 19:32
 * @Version 1.0
 */
public class Test3 {

    public static int num = 0;

    public static CountDownLatch countDownLatch = new CountDownLatch(100);

    public static void main(String[] args) throws Exception {

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                synchronized (Test3.class) {
                    for (int j = 0; j < 1000; j++) {
                        num++;
                    }
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }

        countDownLatch.await();

        System.out.println(num);

    }

}
