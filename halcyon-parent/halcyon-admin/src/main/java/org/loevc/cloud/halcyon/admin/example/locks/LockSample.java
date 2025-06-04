package org.loevc.cloud.halcyon.admin.example.locks;

import java.util.concurrent.locks.*;

public class LockSample {


    /**
     * lock method 1
     * synchronized
     */
    private void lock(){
        lockBySynchronized();
        synchronized (this) {
            // do sth
        }

    }

    private synchronized void lockBySynchronized() {
    }


    /**
     * lock method 2
     * Lock (interface)
     * ReentrantLock (implement)
     */
    private void lock2() {
        Lock lock = new ReentrantLock();

        lock.lock();
        lock.unlock();
    }


    /**
     * lock method 22
     * ReadWriteLock
     */
    private void lock22(){
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        rwLock.readLock();
        rwLock.writeLock();
    }


    /**
     * lock method 3
     * StampedLock
     */
    private void lock3(){
        StampedLock lock = new StampedLock();

    }


    /**
     * lock method 4
     * Condition
     */
    private void lock4() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        condition.await();
        condition.signal();
    }

    /**
     * volatile
     * not the lock method 5
     */
    class VolatileSample {
        private volatile boolean flag = true;

    }


}
