package com.kobe.practice.aqs;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * @ClassName TestLock
 * @Description TODO
 * @Author Tao
 * @Date: 2019-07-05 9:33
 * @Version 1.0
 */
public class TestLock {

    private final static MyReentrantLock lock = new MyReentrantLock();
    private final static Condition notFull = lock.newCondition();
    private final static Condition notEmpty = lock.newCondition();

    private static Queue<String> queue = new LinkedBlockingQueue<>();
    private static int queueSize = 10;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            // 获取独占锁
            lock.lock();

            try {
                // 如果队列满了，就等待
                while (queue.size() == queueSize) {
                    notEmpty.await();
                }

                // 添加元素到队列
                queue.add("element~");

                // 唤醒消费者线程
                notFull.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        });

        Thread consumer = new Thread(() -> {
           lock.lock();

            try {
                while (queue.size() == 0) {
                    notFull.await();
                }

                // 消费一个元素
                String ele = queue.poll();
                // 唤醒生产线程
                notEmpty.signalAll();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        producer.start();
        consumer.start();

    }

}
