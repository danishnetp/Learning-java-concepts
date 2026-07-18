package com.learning.concepts.thread.concurrent.concept;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentReadWriteLockDemo1 {
    public static void main(String[] args) {
        ReentReadWriteLockSharedResource reentReadWriteLockSharedResource = new ReentReadWriteLockSharedResource();
        Thread readThread1 = new Thread(reentReadWriteLockSharedResource::read);
        Thread readThread2 = new Thread(reentReadWriteLockSharedResource::read);
        Thread readThread3 = new Thread(reentReadWriteLockSharedResource::read);

        Thread writeThread1 = new Thread(() -> reentReadWriteLockSharedResource.write(5));
        Thread writeThread2 = new Thread(() -> reentReadWriteLockSharedResource.write(7));
        Thread writeThread3 = new Thread(() -> reentReadWriteLockSharedResource.write(9));

        readThread1.start();
        readThread2.start();
        readThread3.start();

        writeThread1.start();
        writeThread2.start();
        writeThread3.start();
    }
}

class ReentReadWriteLockSharedResource {
    private int value = 0;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public void read() {
        readLock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            System.out.println(Thread.currentThread().getName() + " read value as " + value);
        } finally {
            readLock.unlock();
        }
    }

    public void write(int newValue) {
        writeLock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }
            value = newValue;
            System.out.println(Thread.currentThread().getName() + " write value as " + value);
        } finally {
            writeLock.unlock();
        }
    }
}
