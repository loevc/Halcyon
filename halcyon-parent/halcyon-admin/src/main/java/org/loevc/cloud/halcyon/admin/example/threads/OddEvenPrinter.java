package org.loevc.cloud.halcyon.admin.example.threads;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenPrinter {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition oddCondition = lock.newCondition();
    private static Condition evenCondition = lock.newCondition();
    private static int cnt = 1;
    private static final int MAX = 101;

    public static void main(String[] args) throws InterruptedException {
        Object objLock = new Object();
        System.out.println(ClassLayout.parseInstance(objLock).toPrintable());
        Thread.sleep(1000);
        System.err.println("lock op");
        Thread.sleep(1000);
        synchronized (objLock) {
            System.out.println(ClassLayout.parseInstance(objLock).toPrintable());
        }
        try {
            // 使用 objLock 前， 需要用 synchronized 关键字 获取对应的 对象监视器， 才可以使用
            objLock.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> print(1), "odd -thread").start();
        new Thread(() -> print(0), "even-thread").start();
    }

    private static void print(int remainder) {
        while (cnt < MAX) {
            lock.lock();
            try {
                while ((cnt & 1) != remainder) {
                    if (remainder == 1) {
                        oddCondition.await();
                    } else {
                        evenCondition.await();
                    }
                }
                if (cnt < MAX) {
                    System.out.println(Thread.currentThread().getName() + " " + cnt++);
                }
                if (remainder == 1) {
                    evenCondition.signal();
                } else {
                    oddCondition.signal();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

}
