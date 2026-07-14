package com.learning.concepts.collections.list;

import java.util.*;

/**
 * LinkedListDemo — demonstrates key LinkedList behaviors covered in interview Q&A:
 *
 *  1.  Basic add / get / remove
 *  2.  Internal doubly-linked structure (first, last, Node<E>)
 *  3.  O(1) head and tail operations vs O(n) get(index)
 *  4.  Queue (FIFO) usage via offer() / poll() / peek()
 *  5.  Stack (LIFO) usage via push() / pop() / peek()
 *  6.  Deque operations — addFirst / addLast / removeFirst / removeLast
 *  7.  poll() vs remove() — null-safe vs exception-throwing
 *  8.  Memory overhead — each node holds prev + next references
 *  9.  Fail-fast iterator
 * 10.  Safe traversal with ListIterator (bidirectional)
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        basicOperations();
        headAndTailPerformance();
        indexGetPerformance();
        queueUsage();
        stackUsage();
        dequeOperations();
        pollVsRemove();
        memoryOverheadNote();
        failFastIterator();
        listIteratorBidirectional();
    }

    // -------------------------------------------------------------------------
    // 1. Basic add / get / remove
    // -------------------------------------------------------------------------
    static void basicOperations() {
        System.out.println("=== 1. Basic Operations ===");

        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("List     : " + list);
        System.out.println("get(1)   : " + list.get(1));   // O(n) traversal

        list.set(1, "Blueberry");
        System.out.println("After set(1, \"Blueberry\") : " + list);

        list.remove("Apple");
        System.out.println("After remove(\"Apple\")     : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 2. O(1) head and tail insertions / removals
    // -------------------------------------------------------------------------
    static void headAndTailPerformance() {
        System.out.println("=== 2. O(1) Head and Tail Operations ===");

        LinkedList<String> list = new LinkedList<>();

        list.addFirst("Middle");
        list.addFirst("First");   // O(1) — updates 'first' pointer
        list.addLast("Last");     // O(1) — updates 'last' pointer

        System.out.println("List after addFirst/addLast : " + list);

        System.out.println("removeFirst() : " + list.removeFirst());   // O(1)
        System.out.println("removeLast()  : " + list.removeLast());    // O(1)
        System.out.println("List after removes : " + list);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 3. get(index) is O(n) — traverses from nearest end
    // -------------------------------------------------------------------------
    static void indexGetPerformance() {
        System.out.println("=== 3. get(index) is O(n) ===");

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) list.add(i);

        System.out.println("List : " + list);
        // get(0)  -> starts from head (fast)
        // get(9)  -> starts from tail (fast)
        // get(5)  -> starts from whichever end is closer (mid-list)
        System.out.println("get(0) : " + list.get(0));
        System.out.println("get(9) : " + list.get(9));
        System.out.println("get(5) : " + list.get(5));
        System.out.println("All involve pointer traversal — no direct index array like ArrayList");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 4. Queue (FIFO) usage
    // -------------------------------------------------------------------------
    static void queueUsage() {
        System.out.println("=== 4. Queue (FIFO) Usage ===");

        // LinkedList implements Queue — use it as a FIFO queue
        Queue<String> queue = new LinkedList<>();

        queue.offer("Task-1");   // enqueue — adds to tail
        queue.offer("Task-2");
        queue.offer("Task-3");

        System.out.println("Queue     : " + queue);
        System.out.println("peek()    : " + queue.peek());    // look at head, no remove
        System.out.println("poll()    : " + queue.poll());    // remove head — FIFO
        System.out.println("poll()    : " + queue.poll());
        System.out.println("Remaining : " + queue);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 5. Stack (LIFO) usage
    // -------------------------------------------------------------------------
    static void stackUsage() {
        System.out.println("=== 5. Stack (LIFO) Usage ===");

        // LinkedList implements Deque — use it as a LIFO stack
        // Preferred modern alternative: ArrayDeque (faster, no null support needed)
        Deque<String> stack = new LinkedList<>();

        stack.push("First pushed");   // push to front (head)
        stack.push("Second pushed");
        stack.push("Third pushed");

        System.out.println("Stack : " + stack);
        System.out.println("pop() : " + stack.pop());    // remove from head — LIFO
        System.out.println("pop() : " + stack.pop());
        System.out.println("Remaining : " + stack);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 6. Deque operations — full double-ended access
    // -------------------------------------------------------------------------
    static void dequeOperations() {
        System.out.println("=== 6. Deque Operations ===");

        LinkedList<String> deque = new LinkedList<>();

        deque.addFirst("B");
        deque.addFirst("A");     // A is now head
        deque.addLast("C");
        deque.addLast("D");      // D is now tail

        System.out.println("Deque : " + deque);

        System.out.println("peekFirst() : " + deque.peekFirst());   // look at head
        System.out.println("peekLast()  : " + deque.peekLast());    // look at tail

        deque.offerFirst("Z");   // O(1) insert at head
        deque.offerLast("E");    // O(1) insert at tail
        System.out.println("After offerFirst(Z) and offerLast(E) : " + deque);

        System.out.println("pollFirst() : " + deque.pollFirst());
        System.out.println("pollLast()  : " + deque.pollLast());
        System.out.println("Remaining   : " + deque);
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 7. poll() vs remove() — null-safe vs exception
    // -------------------------------------------------------------------------
    static void pollVsRemove() {
        System.out.println("=== 7. poll() vs remove() on empty list ===");

        LinkedList<String> list = new LinkedList<>();

        // poll() returns null when empty — safe
        String polled = list.poll();
        System.out.println("poll() on empty list  : " + polled + " (no exception)");

        // remove() throws NoSuchElementException when empty
        try {
            list.remove();
        } catch (NoSuchElementException e) {
            System.out.println("remove() on empty list : NoSuchElementException thrown — as expected");
        }
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 8. Memory overhead — each node stores 3 references
    // -------------------------------------------------------------------------
    static void memoryOverheadNote() {
        System.out.println("=== 8. Memory Overhead Note ===");
        System.out.println("Each LinkedList node holds:");
        System.out.println("  - item  (the element reference)");
        System.out.println("  - next  (reference to next node)");
        System.out.println("  - prev  (reference to previous node)");
        System.out.println("This is roughly 3x more memory per entry vs ArrayList's plain array slot.");
        System.out.println("For 1 million elements, LinkedList can use significantly more heap.");
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 9. Fail-fast iterator
    // -------------------------------------------------------------------------
    static void failFastIterator() {
        System.out.println("=== 9. Fail-fast Iterator ===");

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));

        try {
            for (String s : list) {
                if (s.equals("B")) {
                    list.remove(s);   // structural modification while iterating
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught — LinkedList iterator is also fail-fast");
        }
        System.out.println();
    }

    // -------------------------------------------------------------------------
    // 10. ListIterator — bidirectional traversal and in-place set/add
    // -------------------------------------------------------------------------
    static void listIteratorBidirectional() {
        System.out.println("=== 10. ListIterator — Bidirectional Traversal ===");

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));

        System.out.print("Forward  : ");
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        System.out.print("Backward : ");
        while (it.hasPrevious()) {
            System.out.print(it.previous() + " ");
        }
        System.out.println();

        // Replace elements in-place while iterating
        it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            it.set(s.toLowerCase());   // safe in-place replacement
        }
        System.out.println("After set to lowercase : " + list);
        System.out.println();
    }
}

