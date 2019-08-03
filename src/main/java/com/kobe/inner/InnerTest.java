package com.kobe.inner;

public class InnerTest {

    private int num = 100;

    public class Inner {

        // 普通内部类不能定义static
        private int num = 200;

        public void test() {
            int num = 300;
            System.out.println("局部变量num: " + num);
            // 通过this引用内部类的成员变量
            System.out.println("内部类num: " + this.num);
            // 通过外部类名.this的方式引用外部类的成员变量分
            System.out.println("外部类num: " + InnerTest.this.num);
        }

    }

    public static void main(String[] args) {
        InnerTest innerTest = new InnerTest();
        Inner inner = innerTest.new Inner();
        inner.test();
    }

}
