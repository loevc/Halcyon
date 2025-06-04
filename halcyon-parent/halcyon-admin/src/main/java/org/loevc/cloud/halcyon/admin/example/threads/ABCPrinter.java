package org.loevc.cloud.halcyon.admin.example.threads;

import java.util.concurrent.Semaphore;

public class ABCPrinter {

    private static final Semaphore semaphoreA = new Semaphore(1);
    private static final Semaphore semaphoreB = new Semaphore(0);
    private static final Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> print("A", semaphoreA, semaphoreB), "thread-A").start();
        new Thread(() -> print("B", semaphoreB, semaphoreC), "thread-B").start();
        new Thread(() -> print("C", semaphoreC, semaphoreA), "thread-C").start();
    }

    private static void print(String letter, Semaphore cur, Semaphore next){
        for (int i = 0; i < 10; i++) {
            try {
                cur.acquire();
                System.out.println(Thread.currentThread().getName() + " -> " + letter);
                next.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
