package com.learning.concepts.thread.synchronize;

public class StaticSynchronizedMethodDemo1 {
    public static void main(String[] args) {
        Display display1 = new Display();
        Display display2 = new Display();

        DisplayThread displayThread1 = new DisplayThread(display1, "Dhooni");
        DisplayThread displayThread2 = new DisplayThread(display2, "Yovaraj");

        displayThread1.start();
        displayThread2.start();
    }
}

class DisplayThread extends Thread{
    Display display;
    String name;
    DisplayThread(Display display, String name){
        this.display = display;
        this.name = name;
    }

    public void run(){
        display.wish(name);
    }
}

class Display {
    synchronized static void wish(String name) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello " + name);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.err.println("Exception :" + ex);
        }

    }
}
