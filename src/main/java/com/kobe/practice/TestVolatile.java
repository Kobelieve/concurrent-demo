package com.kobe.practice;

/**
 * @ClassName TestVolatile
 * @Description 证明volatile的可见性特征
 * @Author Tao
 * @Date 2019-06-26 20:53
 * @Version 1.0
 */
public class TestVolatile {

    private static volatile Integer num = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " begin");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num = 3;
            System.out.println(num);
        }).start();

        while (num == 1) {
            // 当num等于1的时候，main线程一直在阻塞
        }

        System.out.println(Thread.currentThread().getName() + " over");
    }

}
