package com.learning.concepts.thread.practices;

public class PrintPrimeAndOddDemo {
    static void main(String[] args) {
        PrintPrimeAndOdd printPrimeAndOdd = new PrintPrimeAndOdd(10);

        Thread oddThread = new Thread(printPrimeAndOdd::printOdd);
        oddThread.setName("Odd");

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printPrimeAndOdd.printEvent();
            }
        });
        evenThread.setName("Even");

        oddThread.start();
        evenThread.start();
    }
}

class PrintPrimeAndOdd {
    volatile int counter = 1;
    int limit;

    public PrintPrimeAndOdd(int limit) {
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

