package com.learning.concepts.thread.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Interview-oriented working example for {@link Future} methods.
 *
 * <p>This class demonstrates all core methods from the {@link Future} contract:
 * <ul>
 *   <li>{@code get()}</li>
 *   <li>{@code get(timeout, unit)}</li>
 *   <li>{@code cancel(mayInterruptIfRunning)}</li>
 *   <li>{@code isDone()}</li>
 *   <li>{@code isCancelled()}</li>
 * </ul>
 *
 * <p>Easy interview explanation:
 * "Future represents a result of an async computation. You can poll status, wait for result,
 * or cancel it."
 */
public final class FutureMethodsExample {

    private FutureMethodsExample() {
        // Utility demo class.
    }

    /**
     * Runs independent mini-demos for each Future concept.
     */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            demoGetAndIsDone(executor);
            demoGetWithTimeout(executor);
            demoCancelAndIsCancelled(executor);
            demoFailurePath(executor);
        } finally {
            shutdownGracefully(executor);
        }
    }

    /**
     * Demonstrates submit + get + isDone.
     */
    private static void demoGetAndIsDone(ExecutorService executor) {
        System.out.println("\n=== Future: get() and isDone() ===");

        Future<String> future = executor.submit(() -> {
            sleep(250);
            return "Hello from Callable";
        });

        System.out.println("Initially isDone: " + future.isDone());

        try {
            String value = future.get();
            System.out.println("Result from get(): " + value);
            System.out.println("After get() isDone: " + future.isDone());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for result", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Task failed", e.getCause());
        }
    }

    /**
     * Demonstrates timed waiting via get(timeout, unit).
     */
    private static void demoGetWithTimeout(ExecutorService executor) {
        System.out.println("\n=== Future: get(timeout, unit) ===");

        Future<Integer> future = executor.submit(() -> {
            sleep(600);
            return 42;
        });

        try {
            future.get(150, TimeUnit.MILLISECONDS);
            System.out.println("Unexpected: task finished early");
        } catch (TimeoutException e) {
            System.out.println("TimeoutException as expected (task still running)");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during timed wait", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Task failed", e.getCause());
        }

        try {
            Integer value = future.get();
            System.out.println("Value after waiting longer: " + value);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for value", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Task failed", e.getCause());
        }
    }

    /**
     * Demonstrates cancellation and status checks.
     */
    private static void demoCancelAndIsCancelled(ExecutorService executor) {
        System.out.println("\n=== Future: cancel() and isCancelled() ===");

        Future<String> future = executor.submit(longRunningTask());

        sleep(150);
        boolean cancelled = future.cancel(true);

        System.out.println("cancel(true) returned: " + cancelled);
        System.out.println("isCancelled: " + future.isCancelled());
        System.out.println("isDone: " + future.isDone());

        try {
            future.get();
            System.out.println("Unexpected: cancelled future returned value");
        } catch (CancellationException e) {
            System.out.println("get() throws CancellationException for cancelled task");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while reading cancelled task", e);
        } catch (ExecutionException e) {
            throw new RuntimeException("Task failed", e.getCause());
        }
    }

    /**
     * Demonstrates exception wrapping behavior of get().
     */
    private static void demoFailurePath(ExecutorService executor) {
        System.out.println("\n=== Future: failure path (ExecutionException) ===");

        Future<String> failed = executor.submit(() -> {
            throw new IllegalStateException("Simulated service failure");
        });

        try {
            failed.get();
            System.out.println("Unexpected: failure task returned successfully");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for failed task", e);
        } catch (ExecutionException e) {
            System.out.println("Cause from ExecutionException: " + e.getCause().getMessage());
        }
    }

    private static Callable<String> longRunningTask() {
        return () -> {
            for (int i = 1; i <= 10; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException("Task interrupted after cancel");
                }
                sleep(100);
            }
            return "Completed long running task";
        };
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void shutdownGracefully(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}

