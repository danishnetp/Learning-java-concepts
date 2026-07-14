# Java `Queue` Collections - Interview Questions and Answers

This file covers commonly asked and current interview questions around Java `Queue` collections and major implementation classes.

---

# `Queue` Interface - Question and Answer

## Q1: What is `Queue` in Java?

**A:** `Queue` is a collection designed to hold elements before processing, usually in **FIFO** (First-In-First-Out) order.

Common implementations:

- `LinkedList`
- `ArrayDeque`
- `PriorityQueue`
- `ConcurrentLinkedQueue`
- `ArrayBlockingQueue`
- `LinkedBlockingQueue`
- `PriorityBlockingQueue`
- `DelayQueue`
- `SynchronousQueue`

---

## Q2: What are the core methods of `Queue`?

**A:**

- insert: `add(e)`, `offer(e)`
- remove: `remove()`, `poll()`
- inspect head: `element()`, `peek()`

---

## Q3: What is the difference between `add()` and `offer()`?

**A:**

- `add(e)` throws exception if insertion fails
- `offer(e)` returns `false` if insertion fails

For bounded queues, `offer()` is usually safer.

---

## Q4: What is the difference between `remove()` and `poll()`?

**A:**

- `remove()` throws `NoSuchElementException` when queue is empty
- `poll()` returns `null` when queue is empty

---

## Q5: What is the difference between `element()` and `peek()`?

**A:**

- both read the head without removing
- `element()` throws exception when empty
- `peek()` returns `null` when empty

---

## Q6: Does `Queue` allow `null` elements?

**A:** Most queue implementations do **not** allow `null`, especially concurrent queues, because `null` is commonly used as an empty-result signal (e.g., `poll()`).

---

## Q7: Is `Queue` always FIFO?

**A:** No.

- many queues are FIFO (`LinkedList`, `ArrayDeque`, blocking queues)
- `PriorityQueue` and `PriorityBlockingQueue` order by priority, not insertion order

---

## Q8: How is `Queue` different from `Deque`?

**A:**

- `Queue` is single-ended (insert tail, remove head)
- `Deque` is double-ended (insert/remove at both ends)

`Deque` can act as queue (FIFO) and stack (LIFO).

---

## Q9: How is `Queue` different from `Stack`?

**A:**

- Queue: FIFO
- Stack: LIFO

In modern Java, `Deque` (`ArrayDeque`) is preferred over legacy `Stack`.

---

## Interview one-liner

`Queue` is a processing-oriented collection, usually FIFO, with safer method pairs (`offer/poll/peek`) that avoid exceptions on capacity or emptiness conditions.

---

# `LinkedList` as Queue - Question and Answer

## Q1: Can `LinkedList` be used as a queue?

**A:** Yes. `LinkedList` implements `Queue` and `Deque`.

Example:

```java
Queue<String> q = new LinkedList<>();
q.offer("A");
q.offer("B");
System.out.println(q.poll()); // A
```

---

## Q2: Time complexity for queue ops in `LinkedList`?

**A:**

- enqueue (`offer`) at tail: O(1)
- dequeue (`poll`) at head: O(1)
- head read (`peek`): O(1)

---

## Q3: Is `LinkedList` thread-safe?

**A:** No.

Use concurrent alternatives for multi-threaded producer-consumer use.

---

# `ArrayDeque` - Question and Answer

## Q1: Why is `ArrayDeque` often preferred over `LinkedList` for queue usage?

**A:** `ArrayDeque` is typically faster due to array-backed locality and lower per-element overhead.

---

## Q2: Does `ArrayDeque` allow `null`?

**A:** No.

---

## Q3: Is `ArrayDeque` thread-safe?

**A:** No. It is for single-threaded or externally synchronized usage.

---

# `PriorityQueue` - Question and Answer

## Q1: What is `PriorityQueue`?

**A:** `PriorityQueue` is a heap-based queue where head is highest-priority element (smallest by default), not earliest inserted.

---

## Q2: What is default ordering in `PriorityQueue`?

**A:** Natural ordering (min-heap behavior for comparable elements).

---

## Q3: How to make max-heap behavior?

**A:** Provide reverse comparator.

```java
PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
```

---

## Q4: Time complexity of `PriorityQueue`?

**A:**

- `offer` / `add`: O(log n)
- `poll` / `remove head`: O(log n)
- `peek`: O(1)

---

## Q5: Does `PriorityQueue` preserve insertion order for same priority?

**A:** No guarantee of stable ordering for equal-priority elements.

---

# Concurrent Non-Blocking Queue

## Q1: What is `ConcurrentLinkedQueue`?

**A:** A lock-free, thread-safe FIFO queue using CAS operations; good for high-throughput concurrent access.

---

## Q2: Is `ConcurrentLinkedQueue.size()` cheap?

**A:** No. `size()` is O(n) traversal and may be inaccurate under concurrent updates.

---

# BlockingQueue Family - Question and Answer

## Q1: What is `BlockingQueue`?

**A:** A thread-safe queue where:

- producers can block when queue is full
- consumers can block when queue is empty

Core blocking methods: `put`, `take`, timed `offer/poll`.

---

## Q2: `ArrayBlockingQueue` vs `LinkedBlockingQueue`?

**A:**

| Aspect | `ArrayBlockingQueue` | `LinkedBlockingQueue` |
|---|---|---|
| Storage | Fixed-size array | Linked nodes |
| Bound | Always bounded | Optionally bounded (default effectively very large) |
| Locks | Single lock | Separate put/take locks (better concurrency in many cases) |
| Predictability | Better memory predictability | More allocation overhead |

---

## Q3: What is `PriorityBlockingQueue`?

**A:** Thread-safe priority queue. Unbounded; orders by priority, not FIFO.

---

## Q4: What is `DelayQueue`?

**A:** A blocking queue of delayed elements (`Delayed`). Element is available only after delay expires.

Common use: scheduling retries / expiry tasks.

---

## Q5: What is `SynchronousQueue`?

**A:** A zero-capacity queue: each insert waits for a corresponding remove (direct handoff).

---

# Concurrent Sorted Queue/Deque Notes

## Q1: When to use `LinkedBlockingDeque`?

**A:** When you need blocking semantics and two-ended operations.

---

## Q2: `ConcurrentLinkedDeque` vs `ConcurrentLinkedQueue`?

**A:**

- `ConcurrentLinkedQueue`: FIFO only
- `ConcurrentLinkedDeque`: lock-free operations at both ends

Use deque if both head/tail operations are needed.

---

# Common Interview Mistakes around Queue

- saying every queue is FIFO (`PriorityQueue` is not)
- mixing `add/remove/element` with `offer/poll/peek` semantics
- ignoring blocking vs non-blocking behavior
- using non-thread-safe queue (`LinkedList`, `ArrayDeque`) in concurrent producer-consumer code
- assuming `size()` is always cheap/accurate in concurrent queues
- expecting `PriorityQueue` to keep insertion order for same-priority elements
- forgetting `null` restrictions in most queue implementations

---

# Queue Implementation Quick Comparison

| Implementation | Order | Thread-safe | Blocking | Typical use |
|---|---|---|---|---|
| `LinkedList` | FIFO | No | No | Basic queue/deque in single thread |
| `ArrayDeque` | FIFO/Deque | No | No | Fast general queue/stack |
| `PriorityQueue` | Priority | No | No | Top-N, scheduling by priority |
| `ConcurrentLinkedQueue` | FIFO | Yes | No | High-throughput concurrent queue |
| `ArrayBlockingQueue` | FIFO | Yes | Yes | Bounded producer-consumer |
| `LinkedBlockingQueue` | FIFO | Yes | Yes | Producer-consumer with dynamic capacity needs |
| `PriorityBlockingQueue` | Priority | Yes | Yes (`take`) | Concurrent priority tasks |
| `DelayQueue` | Delay-expiry order | Yes | Yes | Delayed task processing |
| `SynchronousQueue` | Handoff | Yes | Yes | Direct producer-consumer handoff |

---

# Interview one-liner

Choose queue by semantics first (FIFO vs priority vs handoff), then by concurrency model (single-thread, lock-free, or blocking), and finally by capacity requirements (bounded vs unbounded).

