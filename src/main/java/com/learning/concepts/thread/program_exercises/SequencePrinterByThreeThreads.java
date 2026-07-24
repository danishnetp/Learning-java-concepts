package com.learning.concepts.thread.program_exercises;

public class SequencePrinterByThreeThreads {
    private static final Object LOCK = new Object(); // Shared lock for synchronization
    private static final int TOTAL_THREADS = 3;
    private static int counter = 1; // Start sequence at 1
    private final int maxNumber;

    public SequencePrinterByThreeThreads(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    static void main(String[] args) {
        int n = 10; // Change this value to your preferred 'N'
        SequencePrinterByThreeThreads printer = new SequencePrinterByThreeThreads(n);

        // Create 3 threads with distinct remainder assignments
        // Thread 1 handles numbers where counter % 3 == 1 (e.g., 1, 4, 7)
        // Thread 2 handles numbers where counter % 3 == 2 (e.g., 2, 5, 8)
        // Thread 3 handles numbers where counter % 3 == 0 (e.g., 3, 6, 9)
        Thread t1 = new Thread(printer.new NumberRunnable(1), "Thread-1");
        Thread t2 = new Thread(printer.new NumberRunnable(2), "Thread-2");
        Thread t3 = new Thread(printer.new NumberRunnable(0), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

    class NumberRunnable implements Runnable {
        private final int remainder;

        public NumberRunnable(int remainder) {
            this.remainder = remainder;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    // Stop executing if counter exceeds N
                    if (counter > maxNumber) {
                        break;
                    }

                    // Wait until it is this thread's turn
                    while (counter % TOTAL_THREADS != remainder) {
                        try {
                            LOCK.wait();
                            // Re-check termination condition after waking up
                            if (counter > maxNumber) {
                                return;
                            }
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    // Double-check condition before printing
                    System.out.println(Thread.currentThread().getName() + " : " + counter);
                    counter++;

                    // Wake up all other threads to evaluate the updated counter
                    LOCK.notifyAll();
                }
            }
        }
    }
}
