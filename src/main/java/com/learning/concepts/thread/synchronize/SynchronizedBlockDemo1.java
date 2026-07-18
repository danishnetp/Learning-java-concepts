package com.learning.concepts.thread.synchronize;

class Line2 {
    public void getLine() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.err.println("Exception: " + ex);
                }
            }
        }
    }
}

class Train2 extends Thread {
    Line2 line;

    Train2(Line2 line) {
        this.line = line;
    }

    public void run() {
        line.getLine();
    }
}

public class SynchronizedBlockDemo1 {
    public static void main(String[] args) {
        Line2 line = new Line2();
        Thread thread1 = new Train2(line);
        Thread thread2 = new Train2(line);

        thread1.start();
        thread2.start();
    }
}
