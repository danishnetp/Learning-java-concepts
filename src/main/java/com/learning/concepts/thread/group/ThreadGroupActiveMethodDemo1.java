package com.learning.concepts.thread.group;

public class ThreadGroupActiveMethodDemo1 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Parent thread group");
        System.out.println("Thread name : " + threadGroup.getName());
        System.out.println("Parent : " + threadGroup.getParent());

        ThreadGroupActiveMethodDemo1Thread1 thread1 = new ThreadGroupActiveMethodDemo1Thread1(threadGroup, "One");
        System.out.println("Starting one");
        System.out.println("Parent : " + thread1.getThreadGroup().getName());
        System.out.println("Thread Group Parent : " + thread1.getThreadGroup().getParent());

        ThreadGroupActiveMethodDemo1Thread1 thread2 = new ThreadGroupActiveMethodDemo1Thread1(threadGroup, "Two");
        System.out.println("Starting two");
        System.out.println("Parent : " + thread2.getThreadGroup().getName());

        System.out.println("Active thread : " + threadGroup.activeCount());
    }
}

class ThreadGroupActiveMethodDemo1Thread1 extends Thread {

    ThreadGroupActiveMethodDemo1Thread1(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
        start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Exception encountered.");
            }
        }
    }
}
