package com.learning.concepts.thread.synchronize;

class Display1 {
    static void wish(String name) {
        synchronized (Display1.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello " + name);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.err.println("Exception :" + ex);
            }
        }
    }
}


class DisplayThread1 extends Thread{
    Display1 display;
    String name;
    DisplayThread1(Display1 display, String name){
        this.display = display;
        this.name = name;
    }

    public void run(){
        display.wish(name);
    }
}

public class StaticSynchronizedBlockDemo1 {
    public static void main(String[] args) {
        Display1 display1 = new Display1();
        Display1 display2 = new Display1();

        DisplayThread1 displayThread1 = new DisplayThread1(display1, "Dhooni");
        DisplayThread1 displayThread2 = new DisplayThread1(display2, "Yovaraj");

        displayThread1.start();
        displayThread2.start();
    }
}

