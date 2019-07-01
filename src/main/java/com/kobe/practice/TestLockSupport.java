package com.kobe.practice;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName TestLockSupport
 * @Description LockSupport工具类
 * @Author Tao
 * @Date 2019-06-29 10:38
 * @Version 1.0
 */
public class TestLockSupport {

    @Test
    public void test1() {
        System.out.println("start...");
        LockSupport.park();
        System.out.println("end...");
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("start..");
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread() + "进来了...");
            LockSupport.park();
            System.out.println(Thread.currentThread() + "出去了...");
        });
        t.start();
        Thread.sleep(2000);

        LockSupport.unpark(t);
        System.out.println("end...");

    }

}
