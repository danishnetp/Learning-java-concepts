package com.learning.concepts.thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLockSharedResource resource = new ReadWriteLockSharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread(() ->{
            resource.producer(lock);
        });

        Thread thread2 = new Thread(() ->{
            resource.producer(lock);
        });

        ReadWriteLockSharedResource resource1 = new ReadWriteLockSharedResource();

        Thread thread3 = new Thread(() ->{
            resource.consume(lock);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ReadWriteLockSharedResource {
    boolean isAvailable = true;

    public void producer(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            System.out.println("Read Lock required by: " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(8000);
        } catch (Exception ignored) {
        } finally {
            lock.readLock().unlock();
            System.out.println("Read Lock release by: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock) {
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception ignored) {
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock release by: " + Thread.currentThread().getName());
        }

    }
}
