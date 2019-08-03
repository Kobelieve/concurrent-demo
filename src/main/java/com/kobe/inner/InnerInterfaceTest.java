package com.kobe.inner;

public class InnerInterfaceTest {

    public interface InnerInterface {
        void test();
    }

    public class InnerInterfaceImpl implements InnerInterface {
        @Override
        public void test() {
            System.out.println("内部接口的实现类...");
        }
    }

    public static void main(String[] args) {
        InnerInterfaceTest innerInterfaceTest = new InnerInterfaceTest();
        InnerInterface innerInterface = innerInterfaceTest.new InnerInterfaceImpl();
        innerInterface.test();
    }

}
