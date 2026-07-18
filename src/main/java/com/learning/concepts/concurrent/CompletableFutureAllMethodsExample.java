package com.learning.concepts.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Interview-oriented working examples of commonly used {@link CompletableFuture} methods.
 *
 * <p>This class focuses on high-value methods interviewers usually expect:
 * <ul>
 *   <li>Creation: {@code supplyAsync}, {@code runAsync}, {@code completedFuture},
 *       {@code failedFuture}</li>
 *   <li>Transforms: {@code thenApply}, {@code thenAccept}, {@code thenRun}</li>
 *   <li>Async transforms: {@code thenApplyAsync}</li>
 *   <li>Composition: {@code thenCompose}, {@code thenCombine}</li>
 *   <li>Error handling: {@code exceptionally}, {@code handle}, {@code whenComplete}</li>
 *   <li>Coordination: {@code allOf}, {@code anyOf}</li>
 *   <li>Terminal: {@code join}, {@code getNow}</li>
 *   <li>Manual completion: {@code complete}, {@code completeExceptionally}</li>
 * </ul>
 *
 * <p>Note: Java has many additional variants (especially async overloads). This file is intended
 * to be concise yet interview-complete for day-to-day usage.
 */
public final class CompletableFutureAllMethodsExample {

    private CompletableFutureAllMethodsExample() {
        // Utility demo class.
    }

    /**
     * Runs all demos sequentially with clear console separators.
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {
            demoCreation(pool);
            demoTransforms(pool);
            demoComposition(pool);
            demoErrorHandling(pool);
            demoCoordination(pool);
            demoTerminalAndManualCompletion();
        } finally {
            shutdownGracefully(pool);
        }
    }

    private static void demoCreation(ExecutorService pool) {
        System.out.println("\n=== CompletableFuture: creation methods ===");

        CompletableFuture<String> supplied = CompletableFuture.supplyAsync(() -> "value-from-supplyAsync", pool);
        CompletableFuture<Void> runOnly = CompletableFuture.runAsync(() -> sleep(80), pool);
        CompletableFuture<String> completed = CompletableFuture.completedFuture("already-complete");
        CompletableFuture<String> failed = CompletableFuture.failedFuture(new IllegalStateException("simulated failure"));

        System.out.println("supplyAsync -> " + supplied.join());
        runOnly.join();
        System.out.println("runAsync -> completed with no value");
        System.out.println("completedFuture -> " + completed.join());

        try {
            failed.join();
        } catch (CompletionException ex) {
            System.out.println("failedFuture -> " + rootMessage(ex));
        }
    }

    private static void demoTransforms(ExecutorService pool) {
        System.out.println("\n=== CompletableFuture: transform methods ===");

        CompletableFuture<String> chain = CompletableFuture
                .supplyAsync(() -> "java", pool)
                .thenApply(String::toUpperCase)
                .thenApplyAsync(text -> text + "-21", pool);

        chain.thenAccept(value -> System.out.println("thenAccept observed -> " + value))
                .thenRun(() -> System.out.println("thenRun executed after thenAccept"))
                .join();
    }

    private static void demoComposition(ExecutorService pool) {
        System.out.println("\n=== CompletableFuture: composition methods ===");

        CompletableFuture<String> composed = CompletableFuture
                .supplyAsync(() -> "user-7", pool)
                .thenCompose(userId -> CompletableFuture.supplyAsync(() -> "profile-for-" + userId, pool));

        CompletableFuture<Integer> pointsFuture = CompletableFuture.supplyAsync(() -> 250, pool);

        CompletableFuture<String> combined = composed.thenCombine(pointsFuture,
                (profile, points) -> profile + " with points=" + points);

        System.out.println("thenCompose + thenCombine -> " + combined.join());
    }

    private static void demoErrorHandling(ExecutorService pool) {
        System.out.println("\n=== CompletableFuture: error handling methods ===");

        CompletableFuture<String> mayFail = CompletableFuture.supplyAsync(() -> {
            throw new IllegalArgumentException("bad input");
        }, pool);

        CompletableFuture<String> handled = mayFail
                .exceptionally(ex -> "exceptionally fallback: " + rootMessage(ex))
                .handle((value, ex) -> ex == null ? value : "handle fallback")
                .whenComplete((value, ex) -> {
                    if (ex == null) {
                        System.out.println("whenComplete observed success -> " + value);
                    }
                });

        System.out.println("Final after handlers -> " + handled.join());
    }

    private static void demoCoordination(ExecutorService pool) {
        System.out.println("\n=== CompletableFuture: allOf and anyOf ===");

        CompletableFuture<String> serviceA = CompletableFuture.supplyAsync(() -> {
            sleep(220);
            return "A";
        }, pool);

        CompletableFuture<String> serviceB = CompletableFuture.supplyAsync(() -> {
            sleep(120);
            return "B";
        }, pool);

        CompletableFuture<String> serviceC = CompletableFuture.supplyAsync(() -> {
            sleep(180);
            return "C";
        }, pool);

        CompletableFuture<Void> allDone = CompletableFuture.allOf(serviceA, serviceB, serviceC);
        allDone.join();
        System.out.println("allOf -> " + serviceA.join() + serviceB.join() + serviceC.join());

        Object first = CompletableFuture.anyOf(serviceA, serviceB, serviceC).join();
        System.out.println("anyOf first completed -> " + first);
    }

    private static void demoTerminalAndManualCompletion() {
        System.out.println("\n=== CompletableFuture: join/getNow/complete methods ===");

        CompletableFuture<String> pending = new CompletableFuture<>();
        System.out.println("getNow before completion -> " + pending.getNow("default-value"));

        boolean completed = pending.complete("manually-completed");
        System.out.println("complete() returned -> " + completed);
        System.out.println("join after complete -> " + pending.join());

        CompletableFuture<String> failed = new CompletableFuture<>();
        boolean failedMarked = failed.completeExceptionally(new RuntimeException("manual failure"));
        System.out.println("completeExceptionally() returned -> " + failedMarked);

        try {
            failed.join();
        } catch (CompletionException ex) {
            System.out.println("join on exceptional future -> " + rootMessage(ex));
        }
    }

    private static String rootMessage(Throwable t) {
        Throwable root = t;
        while (root.getCause() != null) {
            root = root.getCause();
        }
        return root.getMessage() != null ? root.getMessage() : root.toString();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during simulated async work", e);
        }
    }

    private static void shutdownGracefully(ExecutorService pool) {
        pool.shutdown();
        try {
            if (!pool.awaitTermination(3, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            pool.shutdownNow();
        }
    }
}

