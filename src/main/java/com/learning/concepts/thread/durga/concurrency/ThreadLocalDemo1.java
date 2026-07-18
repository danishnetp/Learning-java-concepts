package com.learning.concepts.thread.durga.concurrency;

public class ThreadLocalDemo1 {
    public static void main(String[] args) {
        CustomerThread thread1 = new CustomerThread("Customer thread-1");
        CustomerThread thread2 = new CustomerThread("Customer thread-2");
        CustomerThread thread3 = new CustomerThread("Customer thread-3");
        CustomerThread thread4 = new CustomerThread("Customer thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class CustomerThread extends Thread {
    static Integer cusId = 0;
    private static ThreadLocal threadLocal = new ThreadLocal<>() {
        protected Integer initialValue() {
            return ++cusId;
        }
    };

    CustomerThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing with customer id: " + threadLocal.get() + " and hashcode: " + threadLocal.get().hashCode());
    }
}
