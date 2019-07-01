package com.kobe.practice;

/**
 * @ClassName AssertDemo
 * @Description TODO
 * @Author Tao
 * @Date 2019-06-30 19:13
 * @Version 1.0
 */
public class AssertDemo {

    public static void main(String[] args) {
        int num = 200;
        System.out.println("start...");
        assert num == 1 : "num的值错误";
        System.out.println("end...");
    }

}
