package org.loevc.cloud.halcyon.admin.example.threads;

import com.sun.jndi.cosnaming.CNCtx;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class PrintString {

    public static void main(String[] args) {

//        executeSimultaneously2();

//        executeAlternate2();

//        printOddEven();
        printOddEven2();

    }

    private static void printOddEven2() {
        new Thread(() -> printOddOrEven(1), "odd  thread").start();
        new Thread(() -> printOddOrEven(0), "odd  thread").start();
    }

    static class OddEvenPrinter{
        private ReentrantLock lock = new ReentrantLock();
        private Condition oddCondition = lock.newCondition();
        private Condition evenCondition = lock.newCondition();
        private int cnt = 1;
        private final int MAX = 101;

    }

    private static void printOddOrEven(int remainder){
//        while ()
    }

    private static void printOddEven() {
        final Object lock = new Object();
//        int cnt = 1;
        AtomicInteger cnt = new AtomicInteger(1);
        final int MAX = 100;

//        new Thread(() -> printOdd(lock, cnt, MAX), "odd -thread").start();
//        new Thread(() -> printEven(lock, cnt, MAX), "even-thread").start();
        new Thread(() -> printOdd2(lock, cnt, MAX), "odd -thread").start();
        new Thread(() -> printEven2(lock, cnt, MAX), "even-thread").start();
    }

    private static void printOdd(Object lock, AtomicInteger cnt, int MAX) {
        while (true) {
            if (((cnt.get() & 1) == 1) && cnt.get() < MAX) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + cnt.getAndIncrement());
                }
            }
        }
    }

    private static void printOdd2(Object lock, AtomicInteger cnt, int MAX) {
        synchronized (lock){
            while (cnt.get() <= MAX){
                if ((cnt.get() & 1) == 1){
                    System.out.println(Thread.currentThread().getName() + " " + cnt.getAndIncrement());
                    lock.notify();
                }else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private static void printEven(Object lock, AtomicInteger cnt, int MAX) {
        while (true) {
            if (((cnt.get() & 1) != 1) && cnt.get() < MAX) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " " + cnt.getAndIncrement());
                }
            }
        }
    }

    private static void printEven2(Object lock, AtomicInteger cnt, int MAX) {
        synchronized (lock){
            while (cnt.get() <= MAX){
                if ((cnt.get() & 1) == 0){
                    System.out.println(Thread.currentThread().getName() + " " + cnt.getAndIncrement());
                    lock.notify();
                }else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    private static void executeAlternate() {

        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);


        new Thread(() -> {
            try {
                semaphoreA.acquire();
                System.out.println("A");
                semaphoreB.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                semaphoreB.acquire();
                System.out.println("B");
                semaphoreC.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try {
                semaphoreC.acquire();
                System.out.println("C");
                semaphoreA.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }


    private static void executeAlternate2() {

        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);


        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                try {
                    semaphoreA.acquire();
//                    semaphoreA.acquire();
                    System.out.println("A");
                    semaphoreB.release();
                    semaphoreB.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                try {
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreC.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                try {
                    semaphoreC.acquire();
                    System.out.println("C");
                    semaphoreA.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }

    /**
     * cpu 性能太好了，小范围的打印，还是不能出现错乱的输出
     */
    private static void executeSimultaneously() {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread threadA = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
                IntStream.range(0, 10).forEach(i -> System.out.println("A"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
                IntStream.range(0, 10).forEach(i -> System.out.println("B"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
                IntStream.range(0, 10).forEach(i -> System.out.println("C"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        countDownLatch.countDown();
    }


    private static void executeSimultaneously2() {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread threadA = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
                for (int i = 0; i < 10; i++) {
                    System.out.println("A");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
                for (int i = 0; i < 10; i++) {
                    System.out.println("B");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                countDownLatch.await();
                System.out.println(System.currentTimeMillis());
                for (int i = 0; i < 10; i++) {
                    System.out.println("C");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        countDownLatch.countDown();
    }
}
