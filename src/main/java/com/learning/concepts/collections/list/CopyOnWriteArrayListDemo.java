package com.learning.concepts.collections.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * CopyOnWriteArrayListDemo — demonstrates key CopyOnWriteArrayList behaviors
 * covered in interview Q&A:
 *
 *  1.  Basic operations (add / get / remove)
 *  2.  Snapshot iterator — never throws ConcurrentModificationException
 *  3.  Thread-safe concurrent reads while writes happen simultaneously
 *  4.  O(n) write cost — full array copy on every mutation
 *  5.  Null elements allowed
 *  6.  CopyOnWriteArrayList vs Collections.synchronizedList() —
 *      why manual sync is required for iteration with synchronizedList
 *  7.  Read-heavy use case — event listener registry pattern
 *  8.  Why NOT to use it for write-heavy workloads (throughput comparison)
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) throws InterruptedException {
        basicOperations();
        snapshotIterator();
        concurrentReadWrite();
        writeOverheadNote();
        nullElements();
        synchronizedListIterationTrap();
        listenerRegistryPattern();
        writeHeavyWarning();
    }

    // -------------------------------------------------------------------------
    // 1. Basic operations
    // -------------------------------------------------------------------------
    static void basicOperations() {
        System.out.println("=== 1. Basic Operations ===");

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("List     : " + list);
        System.out.println("get(1)   : " + list.get(1));   // O(1) snapshot read

        list.set(1, "Blueberry");
        System.out.println("After set(1, \"Blueberry\") : " + list);

        list.remove("Apple");
        System.out.println("After remove(\"Apple\")     : " + list);

        // addIfAbsent — atomic, useful to avoid duplicates
        boolean added = list.addIfAbsent("Blueberry");
        System.out.println("addIfAbsent(\"Blueberry\") added: " + added + " (already present)");

        added = list.addIfAbsent("Date");
        System.out.println("addIfAbsent(\"Date\") added: " + added);
        System.out.println("List : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 2. Snapshot iterator — never throws ConcurrentModificationException
    // -------------------------------------------------------------------------
    static void snapshotIterator() {
        System.out.println("=== 2. Snapshot Iterator ===");

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(
                Arrays.asList("A", "B", "C"));

        System.out.println("Iterating and adding \"D\" mid-loop (no exception expected):");
        for (String s : list) {
            System.out.print(s + " ");
            list.add("D");   // structural modification — safe for COWAL iterator
            break;           // only do it once to keep output clean
        }
        System.out.println();

        // The iterator captured a snapshot at start; "D" won't appear in the iteration
        System.out.println("Iterator sees snapshot — \"D\" added during iteration is NOT visible mid-loop");
        System.out.println("List after loop : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 3. Concurrent reads and writes from multiple threads
    // -------------------------------------------------------------------------
    static void concurrentReadWrite() throws InterruptedException {
        System.out.println("=== 3. Concurrent Read + Write ===");

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) list.add(i);

        int threadCount = 4;
        CountDownLatch latch = new CountDownLatch(threadCount);
        LongAdder readCount  = new LongAdder();
        LongAdder writeCount = new LongAdder();

        ExecutorService pool = Executors.newFixedThreadPool(threadCount);

        // 2 reader threads
        for (int t = 0; t < 2; t++) {
            pool.submit(() -> {
                for (Integer val : list) {  // snapshot read — no lock
                    readCount.increment();
                }
                latch.countDown();
            });
        }

        // 2 writer threads
        for (int t = 0; t < 2; t++) {
            int base = t * 10;
            pool.submit(() -> {
                for (int i = base; i < base + 5; i++) {
                    list.add(i);            // creates new array copy each time
                    writeCount.increment();
                }
                latch.countDown();
            });
        }

        latch.await();
        pool.shutdown();

        System.out.println("Total reads  : " + readCount.sum());
        System.out.println("Total writes : " + writeCount.sum());
        System.out.println("Final list size : " + list.size() + " (original 5 + 10 writes = 15)");
        System.out.println("No ConcurrentModificationException — COWAL handles concurrent access safely");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 4. O(n) write cost — each mutation copies entire array
    // -------------------------------------------------------------------------
    static void writeOverheadNote() {
        System.out.println("=== 4. O(n) Write Cost Demonstration ===");

        int size = 100_000;
        CopyOnWriteArrayList<Integer> cowal = new CopyOnWriteArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Pre-fill both with same data
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        cowal.addAll(arrayList);

        // Time 1000 sequential writes
        int writes = 1_000;

        long start = System.nanoTime();
        for (int i = 0; i < writes; i++) {
            arrayList.add(i);
        }
        long arrayListTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < writes; i++) {
            cowal.add(i);   // each add copies 100 000 + i elements
        }
        long cowalTime = System.nanoTime() - start;

        System.out.printf("ArrayList    — %d writes : %,d ms%n", writes, arrayListTime / 1_000_000);
        System.out.printf("COWAL        — %d writes : %,d ms%n", writes, cowalTime / 1_000_000);
        System.out.println("COWAL writes are significantly slower due to full array copy per write.");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 5. Null elements are allowed
    // -------------------------------------------------------------------------
    static void nullElements() {
        System.out.println("=== 5. Null Elements ===");

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add(null);
        list.add("B");
        list.add(null);

        System.out.println("List           : " + list);
        System.out.println("contains(null) : " + list.contains(null));
        System.out.println("indexOf(null)  : " + list.indexOf(null));
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 6. Collections.synchronizedList iteration trap
    //    — manual sync needed; CopyOnWriteArrayList does NOT need it
    // -------------------------------------------------------------------------
    static void synchronizedListIterationTrap() {
        System.out.println("=== 6. synchronizedList() Iteration Trap ===");

        List<String> syncList = Collections.synchronizedList(
                new ArrayList<>(Arrays.asList("A", "B", "C")));

        // WRONG — no external sync around the iteration block
        // Another thread could modify syncList between hasNext() and next() calls.
        // We demonstrate the safe pattern:
        System.out.println("Safe iteration over synchronizedList:");
        synchronized (syncList) {                   // external lock required
            for (String s : syncList) {
                System.out.print(s + " ");
            }
        }
        System.out.println();

        // CopyOnWriteArrayList — NO external sync needed for safe iteration
        CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<>(
                Arrays.asList("A", "B", "C"));

        System.out.println("Safe iteration over CopyOnWriteArrayList (no external sync needed):");
        for (String s : cowal) {                    // snapshot-based — always safe
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 7. Listener registry pattern — ideal read-heavy use case
    // -------------------------------------------------------------------------
    static void listenerRegistryPattern() throws InterruptedException {
        System.out.println("=== 7. Listener Registry Pattern ===");

        // Common pattern: listeners registered/removed rarely, notified (read) frequently
        CopyOnWriteArrayList<Runnable> listeners = new CopyOnWriteArrayList<>();

        listeners.add(() -> System.out.println("  Listener-1 notified"));
        listeners.add(() -> System.out.println("  Listener-2 notified"));
        listeners.add(() -> System.out.println("  Listener-3 notified"));

        System.out.println("Firing event (reads listeners — no lock needed):");
        for (Runnable listener : listeners) {   // safe snapshot iteration
            listener.run();
        }

        // Unregister listener-2 — O(n) copy, but rare
        listeners.remove(1);
        System.out.println("After removing Listener-2, firing event again:");
        for (Runnable listener : listeners) {
            listener.run();
        }
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 8. Write-heavy warning — use ConcurrentLinkedDeque or other structures
    // -------------------------------------------------------------------------
    static void writeHeavyWarning() {
        System.out.println("=== 8. Write-Heavy Workload Warning ===");
        System.out.println("CopyOnWriteArrayList copies the ENTIRE array on every write.");
        System.out.println("For write-heavy workloads, consider:");
        System.out.println("  - Collections.synchronizedList(new ArrayList<>()) for simple sync");
        System.out.println("  - ConcurrentLinkedDeque for concurrent queue/deque needs");
        System.out.println("  - LinkedBlockingDeque for bounded blocking concurrent deque");
        System.out.println("  - Manually synchronized ArrayList with ReadWriteLock for mixed workloads");
        System.out.println();

        // Quick illustration: reads are zero-cost (no lock), writes are expensive
        System.out.println("Rule of thumb: reads >> writes  →  CopyOnWriteArrayList");
        System.out.println("              writes frequent   →  other concurrent structures");
    }
}

