package org.loevc.cloud.halcyon.admin.example;

import java.util.concurrent.locks.ReentrantLock;

public class LockSample {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        lock.tryLock();
        lock.unlock();
        lock.unlock();



    }
}
