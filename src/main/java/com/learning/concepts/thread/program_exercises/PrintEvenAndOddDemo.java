package com.learning.concepts.thread.program_exercises;

public class PrintEvenAndOddDemo {
    public static void main(String[] args) {
        PrintEvenAndOdd printEvenAndOdd = new PrintEvenAndOdd(10);

        Thread oddThread = new Thread(printEvenAndOdd::printOdd);
        oddThread.setName("Odd");

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printEvenAndOdd.printEvent();
            }
        });
        evenThread.setName("Even");

        oddThread.start();
        evenThread.start();
    }
}

class PrintEvenAndOdd {
    volatile int counter = 1;
    int limit;

    public PrintEvenAndOdd(int limit) {
        this.limit = limit;
    }

    synchronized void printOdd() {
        while (counter <= limit) {
            if (counter % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    synchronized void printEvent() {
        while (counter <= limit) {
            if (counter % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + counter);
                counter++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

