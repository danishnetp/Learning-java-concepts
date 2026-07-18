package com.learning.concepts.thread.durga.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo1 {
    public static void main(String[] args) {
        PrintJob[] jobs = {new PrintJob("Durga"),
                new PrintJob("Ravi"),
                new PrintJob("Shiva"),
                new PrintJob("Pavan"),
                new PrintJob("Suresh"),
                new PrintJob("Anil")};

        ExecutorService service = Executors.newFixedThreadPool(2);
        for (PrintJob job : jobs) {
            service.submit(job);
        }
        service.shutdown();
    }
}

class PrintJob implements Runnable {
    String name;

    PrintJob(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + "... Job Started by Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        System.out.println(name + "...Job Completed by Thread: " + Thread.currentThread().getName());
    }
}
