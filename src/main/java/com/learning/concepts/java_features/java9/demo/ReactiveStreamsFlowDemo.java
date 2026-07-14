package com.learning.concepts.java_features.java9.demo;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * Demonstrates the Reactive Streams API introduced in Java 9 via the
 * {@link Flow} interfaces.
 * <p>
 * This sample uses {@link SubmissionPublisher} as a simple publisher and a
 * custom subscriber that requests one item at a time.
 */
public class ReactiveStreamsFlowDemo {

    /**
     * Minimal subscriber that prints each item and manually requests the next
     * one to illustrate backpressure-aware flow.
     */
    static class PrintSubscriber implements Flow.Subscriber<String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println("Received: " + item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("Error: " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("Completed");
        }
    }

    /**
     * Publishes a few strings to a sample subscriber.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Reactive Streams (Flow API) - Java 9 ===");

        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {
            PrintSubscriber subscriber = new PrintSubscriber();
            publisher.subscribe(subscriber);
            List.of("Java", "Flow", "API").forEach(publisher::submit);
        }
    }
}

