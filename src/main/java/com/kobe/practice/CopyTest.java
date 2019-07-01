package com.kobe.practice;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName CopyTest
 * @Description TODO
 * @Author Tao
 * @Date 2019-06-22 16:11
 * @Version 1.0
 */
public class CopyTest {

    private static volatile CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();

    public static void main(String[] args) throws Exception {

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Thread t = new Thread(() -> {
            list.set(1, 100);
        });

        // 启动线程前，先去获取该list的迭代器
        Iterator<Integer> iterator = list.iterator();

        t.start();

        // 等待t执行完毕
        t.join();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

}
