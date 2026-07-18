package com.learning.concepts.thread.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Interview-friendly {@link CompletableFuture} example.
 *
 * <p>This class demonstrates the core patterns interviewers usually ask about:
 * <ul>
 *   <li>Start async work ({@code supplyAsync}).</li>
 *   <li>Transform result ({@code thenApply}).</li>
 *   <li>Run two independent async calls in parallel and merge ({@code thenCombine}).</li>
 *   <li>Handle failure ({@code exceptionally}).</li>
 *   <li>Wait for completion ({@code join}).</li>
 * </ul>
 *
 * <p>Easy way to explain:
 * "A CompletableFuture is a promise for a value that will be available later."
 */
public final class CompletableFutureExample {

    private CompletableFutureExample() {
        // Utility demo class.
    }

    /**
     * Runs a complete walkthrough with readable console output.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        try {
            // 1) Start async call: pretend to fetch profile from remote service.
            CompletableFuture<String> profileFuture = CompletableFuture.supplyAsync(
                    () -> fetchUserProfile("u-101"),
                    pool
            );

            // 2) Transform output without blocking the calling thread.
            CompletableFuture<String> profileUpperFuture = profileFuture.thenApply(String::toUpperCase);

            // 3) Start another async call in parallel: fetch loyalty points.
            CompletableFuture<Integer> pointsFuture = CompletableFuture.supplyAsync(
                    () -> fetchLoyaltyPoints("u-101"),
                    pool
            );

            // 4) Combine both async results into one summary object.
            CompletableFuture<UserSummary> summaryFuture = profileUpperFuture.thenCombine(
                    pointsFuture,
                    UserSummary::new
            );

            // 5) Handle errors with fallback value.
            CompletableFuture<String> safeMessageFuture = summaryFuture
                    .thenApply(summary -> "SUMMARY => " + summary)
                    .exceptionally(ex -> "SUMMARY => fallback (reason: " + rootMessage(ex) + ")");

            // join() waits and returns final value (unchecked exception style).
            System.out.println(safeMessageFuture.join());

            // 6) Small failure demo to explain CompletionException + exceptionally.
            CompletableFuture<String> failureDemo = CompletableFuture.supplyAsync(
                    CompletableFutureExample::alwaysFails,
                    pool
            ).exceptionally(ex -> "Recovered from error: " + rootMessage(ex));

            System.out.println(failureDemo.join());
        } finally {
            shutdownGracefully(pool);
        }
    }

    /**
     * Simulates profile fetch latency.
     */
    private static String fetchUserProfile(String userId) {
        sleep(250);
        return "profile-for-" + userId;
    }

    /**
     * Simulates points fetch latency.
     */
    private static int fetchLoyaltyPoints(String userId) {
        sleep(300);
        return 120;
    }

    /**
     * Simulates a failing dependency call.
     */
    private static String alwaysFails() {
        sleep(150);
        throw new IllegalStateException("downstream service unavailable");
    }

    private static String rootMessage(Throwable t) {
        Throwable root = t;
        if (t instanceof CompletionException && t.getCause() != null) {
            root = t.getCause();
        }
        return root.getMessage() != null ? root.getMessage() : root.toString();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted during simulation", e);
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

    /**
     * Small value object for combined result.
     */
    private static final class UserSummary {
        private final String profile;
        private final int points;

        private UserSummary(String profile, int points) {
            this.profile = profile;
            this.points = points;
        }

        @Override
        public String toString() {
            return "UserSummary{profile='" + profile + "', points=" + points + "}";
        }
    }
}

