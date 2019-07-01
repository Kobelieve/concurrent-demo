package com.kobe.practice;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName ParkTest
 * @Description TODO
 * @Author Tao
 * @Date 2019-06-25 22:13
 * @Version 1.0
 */
public class ParkTest {

    public static void main(String[] args) {
        System.out.println("begin");
        // 使当前线程获取到许可证
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end");
    }

}
