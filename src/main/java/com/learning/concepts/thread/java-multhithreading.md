# Java Multithreading in Java - Topic-wise Details

This document covers multithreading in Java topic by topic, in an interview-friendly way.

---

## 1) What is multithreading in Java?

**A:** Multithreading means executing multiple threads concurrently within the same process.

It is useful when:

- tasks are independent
- tasks are CPU-bound or I/O-bound
- responsiveness matters
- concurrency can improve throughput

Example:

```java
Thread t1 = new Thread(() -> System.out.println("Task 1"));
Thread t2 = new Thread(() -> System.out.println("Task 2"));
t1.start();
t2.start();
```

---

## 2) JVM memory model with multithreading

**A:** In Java:

- **Heap** is shared across all threads
- **Stack** is private to each thread
- **Method area / Metaspace** stores class metadata and static information

### Heap

- stores objects and arrays
- shared across threads
- shared mutable objects need synchronization

### Stack

- stores method frames
- local primitive variables are thread-confined
- each thread has its own stack

### Why this matters

If two threads access the same heap object, race conditions can happen.

Example:

```java
class Counter {
	int count = 0;

	void increment() {
		count++;
	}
}
```

If the same `Counter` is shared between threads, `count++` is not safe.

---

## 3) Java Memory Model (JMM)

**A:** The Java Memory Model defines how threads interact with memory, how visibility works, and when writes from one thread become visible to another.

Important idea:

- **happens-before** relationship

If A happens-before B, then B is guaranteed to see the effects of A.

### Examples of happens-before

- unlocking a monitor happens-before another thread locks the same monitor
- a write to a `volatile` variable happens-before a later read of that variable
- starting a thread happens-before the actions inside that started thread

---

## 4) Thread life cycle

**A:** A thread goes through these states:

- `NEW` — created but not started
- `RUNNABLE` — ready to run or currently running
- `BLOCKED` — waiting to acquire a monitor lock
- `WAITING` — waiting indefinitely for another thread
- `TIMED_WAITING` — waiting for a limited time
- `TERMINATED` — completed execution

### Example methods causing states

- `start()` → `RUNNABLE`
- `sleep()` → `TIMED_WAITING`
- `wait()` → `WAITING`
- waiting for monitor lock → `BLOCKED`

---

## 5) Thread creation

**A:** Common ways:

- extend `Thread`
- implement `Runnable`
- implement `Callable` + use `ExecutorService`

### Example using Runnable

```java
Thread t = new Thread(() -> System.out.println("Hello from thread"));
t.start();
```

### Why prefer Runnable/Callable?

- better separation of task and thread
- more flexible with thread pools
- supports returning results with `Callable`

---

## 6) `start()` vs `run()`

**A:**

- `start()` creates a new thread and executes `run()` asynchronously
- `run()` is just a normal method call if invoked directly

Example:

```java
Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
t.start(); // new thread
// t.run(); // would run in current thread only
```

---

## 7) `sleep()` vs `wait()`

**A:**

- `sleep()` pauses the current thread and does **not** release the lock
- `wait()` pauses the current thread and **releases the monitor lock**

### Difference table

| Feature                       | `sleep()` | `wait()`     |
|-------------------------------|-----------|--------------|
| Releases lock                 | No        | Yes          |
| Requires synchronized block   | No        | Yes          |
| Used for                      | Delays    | Coordination |

---

## 8) `join()` and `yield()`

**A:**

- `join()` makes one thread wait for another thread to finish
- `yield()` hints to the scheduler that the current thread is willing to let others run

Example:

```java
Thread t = new Thread(() -> doWork());
t.start();
t.join(); // wait for t to complete
```

---

## 9) Synchronization

**A:** Synchronization is used to control access to shared resources so only one thread enters a critical section at a time.

It helps with:

- mutual exclusion
- memory visibility
- preventing race conditions

### `synchronized` keyword

```java
class Counter {
	private int count;

	synchronized void increment() {
		count++;
	}
}
```

### Synchronized block

```java
synchronized (lock) {
	// critical section
}
```

### What is the lock?

- instance synchronized method → lock on `this`
- static synchronized method → lock on the `Class` object
- synchronized block → lock on the provided object

---

## 10) `volatile`

**A:** `volatile` ensures visibility of changes across threads and prevents certain instruction reordering.

It does **not** make compound operations atomic.

Example:

```java
volatile boolean running = true;
```

If one thread sets `running = false`, another thread reading it will see the updated value promptly.

### When to use `volatile`

- stop flags
- status indicators
- one-writer-many-readers cases

---

## 11) Race condition

**A:** A race condition happens when the result depends on the timing/interleaving of threads.

Example:

```java
count++;
```

This is not atomic, so updates can be lost.

### Fix options

- `synchronized`
- `AtomicInteger`
- `LongAdder` for high contention counters

---

## 12) Atomic classes

**A:** Atomic classes provide lock-free atomic operations using CAS (Compare-And-Swap).

Examples:

- `AtomicInteger`
- `AtomicLong`
- `AtomicBoolean`
- `AtomicReference`

Example:

```java
AtomicInteger count = new AtomicInteger();
count.incrementAndGet();
```

### `LongAdder` vs `AtomicLong`

- `AtomicLong` is good for low contention
- `LongAdder` is better for high contention counters

---

## 13) Deadlock, starvation, livelock

### Deadlock

Two or more threads wait forever for each other’s locks.

### Starvation

A thread never gets enough CPU or lock access to make progress.

### Livelock

Threads keep reacting to each other but still make no progress.

### Prevention of deadlock

- acquire locks in same order
- avoid nested locking when possible
- keep lock scope small
- use timeouts if suitable

---

## 14) Thread communication: `wait()`, `notify()`, `notifyAll()`

**A:** These methods are used for coordination on object monitors.

- `wait()` releases the monitor and waits
- `notify()` wakes one waiting thread
- `notifyAll()` wakes all waiting threads

They must be used inside synchronized context.

### Example idea

Relevant practice file in this project:

- `src/main/java/com/learning/concepts/thread/practices/PrintPrimeAndOddDemo.java`

It demonstrates synchronized coordination using `wait()` and `notifyAll()`.

---

## 15) Thread safety and immutable design

**A:** A class is thread-safe if it behaves correctly when accessed by multiple threads concurrently.

Ways to achieve thread safety:

- immutability
- synchronization
- atomic variables
- concurrent collections
- thread confinement

### Why immutability helps

Immutable objects can be shared safely without synchronization.

---

## 16) ThreadLocal

**A:** `ThreadLocal` provides one separate value per thread.

Use cases:

- request context
- thread-specific caches
- legacy formatter isolation

### Caution

In thread pools, always remove values when done to avoid memory leaks.

---

## 17) Executor framework

**A:** `ExecutorService` manages thread pools and task execution.

Benefits:

- avoids manual thread creation
- reuses threads
- better resource control

### `Runnable` vs `Callable`

- `Runnable` → no return value
- `Callable` → returns a value and can throw checked exceptions

### `Future`

Represents the result of an asynchronous computation.

### `CompletableFuture`

Provides chaining, composition, and async callbacks.

---

## 18) Concurrent collections

**A:** Standard collections are not thread-safe by default.

Examples:

- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `CopyOnWriteArraySet`
- `ConcurrentLinkedQueue`
- `BlockingQueue` implementations

### Why use concurrent collections?

They allow safe multi-threaded access with better performance than coarse-grained external synchronization in many cases.

---

## 19) BlockingQueue family

**A:** `BlockingQueue` is used in producer-consumer problems.

Common behavior:

- producer blocks when queue is full
- consumer blocks when queue is empty

Examples:

- `ArrayBlockingQueue`
- `LinkedBlockingQueue`
- `PriorityBlockingQueue`
- `DelayQueue`
- `SynchronousQueue`

---

## 20) Thread interruption

**A:** `interrupt()` is a cooperative cancellation mechanism.

It sets the interrupt flag and can cause blocking methods to throw `InterruptedException`.

Example:

```java
Thread t = new Thread(() -> {
	while (!Thread.currentThread().isInterrupted()) {
		// work
	}
});
```

---

## 21) Java 19/21 modern threading

### Virtual threads

**A:** Virtual threads are lightweight threads managed by the JVM, designed for massive concurrency.

Example:

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
	executor.submit(() -> System.out.println("virtual thread"));
}
```

### Why virtual threads matter

- scalable blocking-style code
- better throughput for I/O-heavy workloads
- simpler coding model than reactive-style complexity

### Structured concurrency

Treats multiple concurrent tasks as one unit of work, making cancellation and error handling easier.

### Sequenced collections in Java 21

Ordered collection APIs with explicit first/last operations and reversible views.

---

## 22) Common multithreading mistakes

- using `count++` across threads without protection
- assuming `volatile` gives atomicity
- calling `run()` instead of `start()`
- using `wait()` outside synchronized context
- forgetting to release locks
- blocking inside synchronized blocks for too long
- ignoring interrupt handling
- using `ThreadLocal` in pools without cleanup
- assuming all collections are thread-safe

---

## 23) Quick interview recap

- Heap is shared, stack is thread-private
- JMM defines visibility and ordering via happens-before
- `synchronized` gives mutual exclusion and visibility
- `volatile` gives visibility, not compound atomicity
- `wait/notify` coordinate threads via monitors
- atomic classes and concurrent collections are essential for safe concurrency
- thread pools and virtual threads are the modern way to manage high concurrency
