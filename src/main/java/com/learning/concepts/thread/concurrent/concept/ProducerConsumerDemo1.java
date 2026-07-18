package com.learning.concepts.thread.concurrent.concept;


public class ProducerConsumerDemo1 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (Exception ignored) {
            }
            sharedResource.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            sharedResource.consumeItem();
        });
        producerThread.setName("Producer Thread");
        consumerThread.setName("Consumer Thread");

        producerThread.start();
        consumerThread.start();
    }
}

class SharedResource {
    boolean itemAvailable = false;

    public synchronized void addItem() {
        itemAvailable = true;
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consumed method invoked by: " + Thread.currentThread().getName());
        while (!itemAvailable) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (Exception ignored) {
            }
        }
        System.out.println("Item Consumed by: " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}


