package com.learning.concepts.thread.synchronize;

class Line1 {
    public void getLine() {
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
class Train1 extends Thread {
    Line1 line;
    Train1(Line1 line){
        this.line = line;
    }
    public void run(){
        line.getLine();
    }
}

public class NonSynchronizedMethodDemo1 {
    public static void main(String[] args) {
        Line1 line = new Line1();
        Thread thread1 = new Train1(line);
        Thread thread2 = new Train1(line);

        thread1.start();
        thread2.start();
    }
}
