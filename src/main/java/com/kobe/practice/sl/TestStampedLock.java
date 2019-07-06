package com.kobe.practice.sl;

import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName StampedLock
 * @Description TODO
 * @Author Tao
 * @Date: 2019-07-06 13:52
 * @Version 1.0
 */
public class TestStampedLock {

    private double x,y;
    private final StampedLock sl = new StampedLock();

    /**
     * 独占锁
     *
     * @param deltaX
     * @param deltaY
     */
    public void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 乐观锁
     */
    public double distanceFromOrigin() {

        // 尝试获取乐观读锁
        long stamp = sl.tryOptimisticRead();
        // 将变量复制到方法栈中
        double currentX = x, currentY = y;
        // 检查获取读锁后，锁有没被其他线程排他性占抢
        if (!sl.validate(stamp)) {
            // 如果被抢占则获取一个共享读锁
            stamp = sl.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        // 返回计算结果
        return Math.sqrt(currentX * currentX + currentY * currentY);

    }

    /**
     * 使用悲观锁获取读锁，并尝试转换为写锁
     */
    public void moveAtOrigin(double newX, double newY) {

        long stamp = sl.readLock();
        try {
            // 如果当前点在原点则移动
            while (x == 0.0 && y == 0.0) {
                // 尝试将获取的读锁升级为写锁
                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    // 升级成功，更新戳记，并设置坐标，退出循环
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    // 读锁升级写锁失败，显示获取独占锁，循环重试
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }

    }

}
