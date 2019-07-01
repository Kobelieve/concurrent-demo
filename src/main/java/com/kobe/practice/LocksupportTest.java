package com.kobe.practice;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName LocksupportTest
 * @Description TODO
 * @Author Tao
 * @Date 2019-06-25 21:23
 * @Version 1.0
 */
public class LocksupportTest {

    public static void main(String[] args) throws Exception {
        Thread a = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            LockSupport.park();
            System.out.println(sum);
        });
        a.start();
        Thread.sleep(1000);
        LockSupport.unpark(a);
    }

}
