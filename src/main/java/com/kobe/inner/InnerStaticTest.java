package com.kobe.inner;

public class InnerStaticTest {

    public static class InnerStatic {
        private static int num = 200;
        public static void test() {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        InnerStaticTest.InnerStatic.test();
    }

}
