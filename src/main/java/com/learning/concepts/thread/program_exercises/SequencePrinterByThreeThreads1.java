package com.learning.concepts.thread.program_exercises;

public class SequencePrinterByThreeThreads1 {
    static void main() {
        Thread thread1 = new Thread(new DisplayNumber(1, 10));
        Thread thread2 = new Thread(new DisplayNumber(2, 10));
        Thread thread3 = new Thread(new DisplayNumber(0, 10));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class DisplayNumber implements Runnable {
    private final int remainder;
    private final Object LOCK = new Object();
    private final int totalThreads = 3;
    private int counter = 1;
    private final int maxNumber;

    DisplayNumber(int remainder, int maxNumber) {
        this.remainder = remainder;
        this.maxNumber = maxNumber;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LOCK) {
                if (counter > maxNumber) {
                    break;
                }
                while (counter % totalThreads != remainder) {
                    try {
                        LOCK.wait();
                        if(counter > maxNumber){
                            return;
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                System.out.println(Thread.currentThread().getName()+" : "+counter);
                counter++;
                // Wake up all other threads to evaluate the updated counter
                LOCK.notifyAll();
            }
        }
    }
}
