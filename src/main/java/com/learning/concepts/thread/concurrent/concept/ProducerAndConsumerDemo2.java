package com.learning.concepts.thread.concurrent.concept;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumerDemo2 {
    public static void main(String[] args) {
        SharedResourceDemo2 sharedResourceDemo2 = new SharedResourceDemo2(3);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedResourceDemo2.producer(i);
                }
            } catch (Exception ignored) {
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 6; i++) {
                    sharedResourceDemo2.consume();
                }
            } catch (Exception ignored) {
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

class SharedResourceDemo2 {
    private final Queue<Integer> sharedBuffered;
    private final int bufferSize;

    SharedResourceDemo2(int bufferSize) {
        this.bufferSize = bufferSize;
        sharedBuffered = new LinkedList<>();
    }

    public synchronized void producer(int item) {
        while (sharedBuffered.size() == bufferSize) {
            System.out.println("Buffer is full, Producer is waiting for consumer.");
            try {
                wait();
            } catch (Exception ignored) {
            }
        }
        sharedBuffered.add(item);
        System.out.println("Produced item : " + item);
        notify();
    }

    public synchronized void consume() {
        while (sharedBuffered.isEmpty()) {
            System.out.println("Buffer is empty, Consumer is waiting for producer.");
            try {
                wait();
            } catch (Exception ignored) {
            }
        }
        int item = sharedBuffered.poll();
        System.out.println("Consumed : " + item);
        notify();
    }
}
