package com.learning.concepts.thread.synchronize;

class Line {
    public synchronized void getLine() {
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
class Train extends Thread {
    Line line;
    Train(Line line){
        this.line = line;
    }
    public void run(){
        line.getLine();
    }
}

public class SynchronizedMethodDemo1 {
    public static void main(String[] args) {
        Line line = new Line();
        Thread thread1 = new Train(line);
        Thread thread2 = new Train(line);

        thread1.start();
        thread2.start();
    }
}
