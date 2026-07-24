package com.learning.concepts.thread.program_exercises;


public class DisplayTwoThreadDemo {
    static void main() {
        System.out.println("Hello World.");
        Print print = new Print(10);

        Thread thread1 = new Thread(print::print1);
        Thread thread2 = new Thread(print::print2);

        thread1.setName("Thread1");
        thread1.setPriority(Thread.MAX_PRIORITY);

        thread2.setName("Thread2");
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }

}

class Print {
    int counter = 0;
    int limit;

    Print(int limit) {
        this.limit = limit;
    }

    synchronized void print1() {
        while (counter <= limit) {
            if (counter % 2 == 0) {
                System.out.println(Thread.currentThread().getName());
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    synchronized void print2() {
        while (counter <= limit) {
            if (counter % 2 == 1) {
                System.out.println(Thread.currentThread().getName());
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException ignored ) {
                }
            }
        }
    }
}
