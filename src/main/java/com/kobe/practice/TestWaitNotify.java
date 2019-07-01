package com.kobe.practice;

/**
 * @ClassName TestWaitNotify
 * @Description TODO
 * @Author Tao
 * @Date 2019-06-25 21:10
 * @Version 1.0
 */
public class TestWaitNotify {

    public static void main(String[] args) throws Exception {
        final Object obj = new Object();
        new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(sum);
        }).start();
//        Thread.sleep(1000);
        synchronized (obj) {
            obj.notify();
        }
    }

}
