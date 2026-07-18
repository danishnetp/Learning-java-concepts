package com.learning.concepts.thread.durga.concurrency;

public class InheritableThreadLocalDemo1 {
    public static void main(String[] args) {
        ParentThread parentThread = new ParentThread();
        parentThread.start();
    }
}

class ChildThread extends ParentThread {
    public void run() {
        System.out.println("Child Thread value---" + ParentThread.inheritableThreadLocal.get());
    }
}

class ParentThread extends Thread {
    public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal() {
        public Object childValue(Object p) {
            return "cc";
        }
    };

    public void run() {
        inheritableThreadLocal.set("pp");
        System.out.println("Parent Thread Value--" + inheritableThreadLocal.get());
        ChildThread childThread = new ChildThread();
        childThread.start();
    }
}
