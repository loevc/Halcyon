package org.loevc.cloud.halcyon.admin.example.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberPrinter {

    private static final  AtomicInteger count = new AtomicInteger(0);
    private static final int N = 5;
    private static final int M = 100;

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            new Thread(new Printer(i)).start();
        }
    }

    static class Printer implements Runnable {

        private final int threadId;

        public Printer(int threadId) {
            this.threadId = threadId;
        }


        @Override
        public void run() {
            while (count.get() < M) {
                synchronized (Printer.class) {
                    if (count.get() % N == threadId) {
                        System.out.println(Thread.currentThread().getName() + " " + count.getAndIncrement());
                    }
                }
            }
        }
    }
}
