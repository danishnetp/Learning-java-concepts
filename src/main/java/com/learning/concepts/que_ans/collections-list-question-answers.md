# Java `List` Interface and Implementations - Interview Questions and Answers

This file covers commonly asked and currently relevant Java interview questions on the `List` interface and its major implemented classes: `ArrayList`, `LinkedList`, `Vector`, `Stack`, and `CopyOnWriteArrayList`.

---

# `List` Interface - Question and Answer

## Q1: What is the `List` interface in Java?

**A:** `List` is an ordered collection (also called a sequence) in Java.

Key characteristics:

- preserves insertion order
- allows duplicate elements
- allows `null` elements
- provides positional access by index

Common implementations:

- `ArrayList`
- `LinkedList`
- `Vector`
- `Stack`
- `CopyOnWriteArrayList`

---

## Q2: How is `List` different from `Set`?

**A:**

| Aspect              | `List`                        | `Set`                        |
|---------------------|-------------------------------|------------------------------|
| Duplicates          | Allowed                       | Not allowed                  |
| Order               | Preserved (insertion order)   | Depends on implementation    |
| Index access        | Yes                           | No                           |
| `null` elements     | Allowed                       | At most one `null` (HashSet) |

---

## Q3: How is `List` different from `Map`?

**A:**

- `List` stores individual elements accessible by index
- `Map` stores key-value pairs; values are accessed by key
- `List` allows duplicates; `Map` requires unique keys

---

## Q4: What are the most important methods in the `List` interface?

**A:**

- `add(element)` — appends to end
- `add(index, element)` — inserts at position
- `get(index)` — retrieves element at index
- `set(index, element)` — replaces element at index
- `remove(index)` — removes element at position
- `remove(object)` — removes first occurrence
- `size()` — number of elements
- `contains(object)` — checks presence
- `indexOf(object)` — first occurrence index
- `lastIndexOf(object)` — last occurrence index
- `subList(from, to)` — returns a view of a range
- `iterator()` / `listIterator()` — iteration support
- `sort(comparator)` — in-place sort (Java 8+)

---

## Q5: What is `ListIterator` and how does it differ from `Iterator`?

**A:** `ListIterator` is a bidirectional iterator specific to `List`.

Differences from `Iterator`:

| Feature                        | `Iterator`     | `ListIterator`                           |
|--------------------------------|----------------|------------------------------------------|
| Direction                      | Forward only   | Forward and backward                     |
| Add element during iteration   | No             | Yes (`add()`)                            |
| Replace element                | No             | Yes (`set()`)                            |
| Current index access           | No             | Yes (`nextIndex()`, `previousIndex()`)   |

---

## Q6: What is the difference between `Iterator` and `for-each` on a `List`?

**A:**

- `for-each` is syntactic sugar over `Iterator`
- `Iterator` lets you safely remove elements during traversal via `iterator.remove()`
- Direct structural modification during `for-each` causes `ConcurrentModificationException`

---

## Q7: How do you create an immutable `List` in Java?

**A:**

Several ways:

```java
// Java 9+
List<String> list = List.of("A", "B", "C");

// Java 8
List<String> list = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("A", "B", "C")));

// Java 10+
List<String> list = List.copyOf(existingList);
```

`List.of()` does not allow `null` elements.

---

## Q8: What does `Collections.unmodifiableList()` do?

**A:** It wraps an existing list and throws `UnsupportedOperationException` on any mutation attempt.

Important: the underlying list can still be modified directly. The wrapper only prevents mutation through its own reference.

---

## Q9: How does `subList()` work?

**A:** `subList(fromIndex, toIndex)` returns a **view** backed by the original list.

- changes to the sublist reflect in the original
- structural changes to the original (add/remove) after `subList()` invalidate the sublist

---

## Q10: What is the difference between `remove(int index)` and `remove(Object o)` in a `List<Integer>`?

**A:** This is a common interview trap.

```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));

list.remove(1);        // removes element at index 1 → [1, 3]
list.remove(Integer.valueOf(1)); // removes element with value 1 → [2, 3]
```

When using autoboxing types, be explicit with `Integer.valueOf()` to select the object-based overload.

---

## Interview one-liner

`List` is an ordered, index-based collection that allows duplicates; choose between `ArrayList`, `LinkedList`, `Vector`, or `CopyOnWriteArrayList` depending on your access pattern and thread-safety needs.

---

# `ArrayList` - Question and Answer

## Q1: What is `ArrayList` in Java?

**A:** `ArrayList` is a resizable-array implementation of the `List` interface.

- backed by a `Object[]` array internally
- provides O(1) random access by index
- not thread-safe
- allows `null` elements and duplicates

---

## Q2: How does `ArrayList` grow internally?

**A:** When elements exceed current capacity, `ArrayList` resizes.

In JDK 8+:

- new capacity is approximately `oldCapacity + (oldCapacity >> 1)`, i.e., roughly 1.5× growth
- a new array is allocated and existing elements are copied via `Arrays.copyOf()`

Default initial capacity is `10`.

---

## Q3: What is the time complexity of common `ArrayList` operations?

**A:**

| Operation              | Time complexity |
|------------------------|-----------------|
| `get(index)`           | O(1)            |
| `add(element)` at end  | O(1) amortized  |
| `add(index, element)`  | O(n)            |
| `remove(index)`        | O(n)            |
| `contains(element)`    | O(n)            |
| `size()`               | O(1)            |

---

## Q4: Why is `add(index, element)` O(n) in `ArrayList`?

**A:** Because all elements after the insertion point must be shifted one position to the right to make room.

This involves an `System.arraycopy()` call, which is O(n) in the worst case.

---

## Q5: When should you prefer `ArrayList` over `LinkedList`?

**A:** Prefer `ArrayList` when:

- you read elements frequently by index
- you mostly add/remove from the end of the list
- memory footprint matters (less overhead per element vs `LinkedList`)

---

## Q6: Is `ArrayList` thread-safe?

**A:** No. `ArrayList` has no internal synchronization.

Safe alternatives:

- `Vector` — synchronized, but legacy
- `Collections.synchronizedList(new ArrayList<>())` — synchronized wrapper
- `CopyOnWriteArrayList` — optimized for read-heavy concurrency

---

## Q7: What is `ensureCapacity()` and when should you use it?

**A:** `ensureCapacity(minCapacity)` pre-allocates the backing array to at least `minCapacity`.

Use it when you know in advance approximately how many elements will be added. This prevents repeated resizing, reducing unnecessary array copies.

---

## Q8: What is `trimToSize()` in `ArrayList`?

**A:** `trimToSize()` reduces the backing array capacity to the current number of elements.

Useful to reclaim unused memory after large batch removals.

---

## Q9: How does `ArrayList` handle `null` elements?

**A:** `ArrayList` allows multiple `null` elements.

```java
ArrayList<String> list = new ArrayList<>();
list.add(null);
list.add(null);
System.out.println(list.size()); // 2
```

Be careful when calling methods like `contains(null)` or `indexOf(null)` — they use `== null` checks.

---

## Q10: Are `ArrayList` iterators fail-fast?

**A:** Yes.

Structural modification of the list (add/remove) while iterating using `Iterator` or `for-each` throws `ConcurrentModificationException`.

This is detected via a `modCount` field that changes on structural modification.

---

## Q11: How do you convert an `ArrayList` to an array?

**A:**

```java
ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B"));
String[] arr = list.toArray(new String[0]);
```

Passing `new String[0]` is the recommended modern idiom — the JVM uses reflection to produce the correctly typed array.

---

## Q12: How do you sort an `ArrayList`?

**A:**

```java
Collections.sort(list);                        // natural order
list.sort(Comparator.naturalOrder());          // Java 8+
list.sort(Comparator.reverseOrder());          // descending
list.sort(Comparator.comparing(String::length)); // custom
```

---

## Q13: How does `ArrayList` compare to arrays?

**A:**

| Aspect            | `ArrayList`                         | Array                          |
|-------------------|-------------------------------------|--------------------------------|
| Size              | Dynamic                             | Fixed                          |
| Type              | Generic (Object-based)              | Primitive or Object            |
| Methods           | Rich API (`add`, `remove`, etc.)    | Limited (`length` only)        |
| Performance       | Slight overhead from boxing/bounds  | Slightly faster for primitives |

---

## Interview one-liner

`ArrayList` is the go-to general-purpose list backed by a resizable array, offering O(1) random access and O(n) insertions/deletions in the middle.

---

# `LinkedList` - Question and Answer

## Q1: What is `LinkedList` in Java?

**A:** `LinkedList` is a doubly-linked list implementation of both `List` and `Deque` interfaces.

- each node contains: `item`, `prev`, and `next` pointers
- allows `null` and duplicate elements
- not thread-safe
- implements both queue and stack operations

---

## Q2: What is the internal structure of `LinkedList`?

**A:** Internally, `LinkedList` maintains:

- a `first` node (head)
- a `last` node (tail)
- a `size` counter

Each node (`Node<E>`) contains:

- `E item` — the element
- `Node<E> next` — reference to next node
- `Node<E> prev` — reference to previous node

---

## Q3: What is the time complexity of common `LinkedList` operations?

**A:**

| Operation                            | Time complexity |
|--------------------------------------|-----------------|
| `get(index)`                         | O(n)            |
| `add(element)` at ends               | O(1)            |
| `add(index, element)`                | O(n)            |
| `remove(index)`                      | O(n)            |
| `removeFirst()` / `removeLast()`     | O(1)            |
| `contains(element)`                  | O(n)            |

---

## Q4: When should you prefer `LinkedList` over `ArrayList`?

**A:** Prefer `LinkedList` when:

- you frequently add or remove elements at the **beginning or middle** of the list
- you need a `Deque` (double-ended queue) or stack behavior
- random access by index is rare

Avoid `LinkedList` when:

- you frequently read by index
- memory is tight (each node has significant pointer overhead)

---

## Q5: What `Deque` operations does `LinkedList` support?

**A:** Because `LinkedList` implements `Deque`, it supports:

- `addFirst()` / `addLast()` — O(1) insertions at both ends
- `removeFirst()` / `removeLast()` — O(1) removals from both ends
- `peekFirst()` / `peekLast()` — peek without removing
- `push()` / `pop()` — stack-style operations (LIFO)
- `offer()` / `poll()` — queue-style operations (FIFO)

---

## Q6: Why is `get(index)` O(n) in `LinkedList`?

**A:** Because there is no direct index array. To reach an element at a given index, the traversal starts from `first` or `last` (whichever is closer) and follows `next`/`prev` links.

This traversal is O(n/2) on average, which is still O(n).

---

## Q7: Is `LinkedList` thread-safe?

**A:** No. Like `ArrayList`, `LinkedList` has no internal synchronization.

Use `Collections.synchronizedList()` wrapper or design thread-safe access externally.

---

## Q8: What is the main memory difference between `LinkedList` and `ArrayList`?

**A:**

- `ArrayList` stores elements in a contiguous array — only element references (plus some spare capacity overhead)
- `LinkedList` stores each element in a `Node` object with `prev` and `next` references — roughly 3× memory per element compared to `ArrayList`

---

## Q9: Can `LinkedList` be used as a `Queue` and a `Stack`?

**A:** Yes.

As a Queue (FIFO):

```java
LinkedList<String> queue = new LinkedList<>();
queue.offer("A");    // enqueue
queue.poll();        // dequeue
```

As a Stack (LIFO):

```java
LinkedList<String> stack = new LinkedList<>();
stack.push("A");     // push to front
stack.pop();         // pop from front
```

---

## Q10: What is the difference between `poll()` and `remove()` in `LinkedList`?

**A:**

- `poll()` returns `null` if the list is empty
- `remove()` throws `NoSuchElementException` if the list is empty

Prefer `poll()` in code that handles an empty list gracefully.

---

## Interview one-liner

`LinkedList` is a doubly-linked list that also implements `Deque`; use it for frequent insertions and deletions at the head or tail, but avoid it for random index access.

---

# `Vector` - Question and Answer

## Q1: What is `Vector` in Java?

**A:** `Vector` is a legacy resizable-array implementation of `List` that is **synchronized**.

- every method is synchronized at the method level
- thread-safe but with high lock contention
- part of Java since version 1.0
- considered legacy in modern Java

---

## Q2: How does `Vector` grow internally?

**A:** `Vector` doubles its capacity by default when it runs out of space.

It also allows specifying a custom `capacityIncrement` in its constructor.

Compare to `ArrayList` which grows by ~1.5×.

---

## Q3: What is the difference between `Vector` and `ArrayList`?

**A:**

| Aspect            | `Vector`                            | `ArrayList`                     |
|-------------------|-------------------------------------|---------------------------------|
| Thread safety     | Yes (method-level synchronization)  | No                              |
| Growth strategy   | Doubles capacity by default         | ~1.5× growth                    |
| Performance       | Slower due to lock overhead         | Faster in single-threaded code  |
| Legacy status     | Yes (Java 1.0)                      | No (Java 1.2)                   |

---

## Q4: Why is `Vector` considered legacy?

**A:**

- method-level synchronization is coarse-grained and causes high contention
- modern alternatives (`CopyOnWriteArrayList`, `Collections.synchronizedList()`) offer better options
- `Vector`'s API also has redundant methods inherited from its pre-Collections era design

---

## Q5: When might you still encounter `Vector`?

**A:** Mainly in:

- legacy codebases from Java 1.x / Java 2 era
- `Stack` class (which extends `Vector`)

---

## Interview one-liner

`Vector` is a thread-safe, legacy `ArrayList` equivalent with method-level locking; prefer `CopyOnWriteArrayList` or `Collections.synchronizedList()` in modern code.

---

# `Stack` - Question and Answer

## Q1: What is `Stack` in Java?

**A:** `Stack` is a legacy class that extends `Vector` and models a **LIFO (Last-In-First-Out)** data structure.

Core operations:

- `push(item)` — adds element to top
- `pop()` — removes and returns top element
- `peek()` — returns top element without removing
- `empty()` — checks if stack is empty
- `search(object)` — returns 1-based position from top

---

## Q2: Why is `Stack` considered legacy and what is the modern alternative?

**A:** `Stack` extends `Vector`, inheriting its method-level synchronization and legacy design.

The modern preferred alternative is `Deque`:

```java
Deque<String> stack = new ArrayDeque<>();
stack.push("A");
stack.pop();
```

`ArrayDeque` is faster and not synchronized (use `ConcurrentLinkedDeque` or `LinkedBlockingDeque` for thread-safe use).

---

## Q3: What are the problems with `Stack` extending `Vector`?

**A:**

- exposes all `Vector` methods (e.g., `add(index, element)`) which break the LIFO contract
- inherits coarse synchronization overhead
- design violates proper encapsulation for a pure stack data structure

---

## Interview one-liner

`Stack` is a legacy LIFO class that extends `Vector`; prefer `ArrayDeque` as a stack in modern Java.

---

# `CopyOnWriteArrayList` - Question and Answer

## Q1: What is `CopyOnWriteArrayList` in Java?

**A:** `CopyOnWriteArrayList` is a thread-safe `List` implementation optimized for **read-heavy** concurrency.

Key behavior:

- every write operation (add, remove, set) creates a **fresh copy** of the underlying array
- reads are done on the current snapshot array without locking
- it is in the `java.util.concurrent` package

---

## Q2: How does `CopyOnWriteArrayList` achieve thread safety?

**A:**

- write operations are guarded by an internal `ReentrantLock`
- inside the lock, a new array is allocated, the change applied, and the reference updated atomically
- reads always access the current snapshot array reference (volatile) — no locking needed

---

## Q3: What is the time complexity of operations in `CopyOnWriteArrayList`?

**A:**

| Operation              | Time complexity               |
|------------------------|-------------------------------|
| `get(index)`           | O(1)                          |
| `add(element)` at end  | O(n) — due to full array copy |
| `remove(index)`        | O(n) — due to full array copy |
| `contains(element)`    | O(n)                          |
| Iteration              | O(n), no lock needed          |

---

## Q4: Are iterators of `CopyOnWriteArrayList` fail-fast?

**A:** No. Iterators are **snapshot-based**.

- the iterator operates on the array snapshot at creation time
- it never throws `ConcurrentModificationException`
- it does not reflect writes made after the iterator was created

---

## Q5: When should you use `CopyOnWriteArrayList`?

**A:** Use it when:

- reads vastly outnumber writes
- you need safe iteration in a concurrent environment without external locking
- list contents change rarely but are read frequently (e.g., listener lists, observer patterns, config lists)

Avoid when:

- writes are frequent — the O(n) copy cost becomes a bottleneck

---

## Q6: What is the difference between `CopyOnWriteArrayList` and `Collections.synchronizedList()`?

**A:**

| Aspect                   | `CopyOnWriteArrayList`           | `synchronizedList()`                             |
|--------------------------|----------------------------------|--------------------------------------------------|
| Read locking             | None (snapshot reads)            | Locks on every read                              |
| Write cost               | O(n) array copy                  | O(1) with lock held                              |
| Iteration thread safety  | Safe without external lock       | Requires manual synchronization during iteration |
| Best for                 | Read-heavy, rare writes          | Balanced read/write with simple needs            |

---

## Q7: Why is manual synchronization needed when iterating a `synchronizedList()`?

**A:** `Collections.synchronizedList()` does not lock across the full iteration. You must manually synchronize:

```java
List<String> syncList = Collections.synchronizedList(new ArrayList<>());

synchronized (syncList) {
    for (String s : syncList) {
        System.out.println(s);
    }
}
```

Without the external `synchronized` block, a concurrent modification can corrupt iteration.

`CopyOnWriteArrayList` does not have this problem.

---

## Q8: Can `CopyOnWriteArrayList` hold `null` elements?

**A:** Yes, it allows `null` elements, unlike `ConcurrentHashMap`.

---

## Interview one-liner

`CopyOnWriteArrayList` is a thread-safe list that copies the entire array on every write; ideal for read-dominated scenarios where write performance is not critical.

---

# Comparison Table — All `List` Implementations

| Feature                    | `ArrayList`      | `LinkedList`                         | `Vector`                  | `Stack`                  | `CopyOnWriteArrayList`                                  |
|----------------------------|------------------|--------------------------------------|---------------------------|--------------------------|---------------------------------------------------------|
| Internal structure         | Dynamic array    | Doubly linked list                   | Dynamic array             | Extends Vector           | Dynamic array (copy-on-write)                           |
| Thread-safe                | No               | No                                   | Yes (synchronized)        | Yes (synchronized)       | Yes (copy-on-write)                                     |
| Allows `null`              | Yes              | Yes                                  | Yes                       | Yes                      | Yes                                                     |
| Allows duplicates          | Yes              | Yes                                  | Yes                       | Yes                      | Yes                                                     |
| Random access (get)        | O(1)             | O(n)                                 | O(1)                      | O(1)                     | O(1)                                                    |
| Insert at end              | O(1) amortized   | O(1)                                 | O(1) amortized            | O(1) amortized           | O(n)                                                    |
| Insert at middle           | O(n)             | O(n)                                 | O(n)                      | O(n)                     | O(n)                                                    |
| Iterator type              | Fail-fast        | Fail-fast                            | Fail-fast                 | Fail-fast                | Snapshot (never fails)                                  |
| Implements `Deque`         | No               | Yes                                  | No                        | No                       | No                                                      |
| Legacy                     | No               | No                                   | Yes                       | Yes                      | No                                                      |
| Recommended use            | General purpose  | Queue/deque/frequent head/tail ops   | Legacy sync code          | Legacy LIFO              | Read-heavy concurrent lists                             |

---

# Common Interview Traps and Tips

## Trap 1: `ArrayList` is always faster than `LinkedList`

Not always.

- `LinkedList` beats `ArrayList` for frequent insertions/removals at the front or middle when iterator position is already known
- `ArrayList` wins for random access and iteration

---

## Trap 2: `Vector` is the modern thread-safe `List`

No. `Vector`'s method-level locking is coarse and legacy.

Use:

- `CopyOnWriteArrayList` for read-heavy scenarios
- `Collections.synchronizedList()` for simple synchronization needs

---

## Trap 3: `subList()` creates an independent copy

No. `subList()` returns a **view** backed by the original list. Mutations are reflected in both directions.

---

## Trap 4: `CopyOnWriteArrayList` is good for all concurrent lists

No. Its O(n) write cost makes it unsuitable for write-heavy workloads.

---

## Trap 5: `Stack` is the recommended LIFO structure

No. `Stack` is legacy and extends `Vector`. Prefer:

```java
Deque<String> stack = new ArrayDeque<>();
```

---

## Tip: Choosing the right `List` implementation

```text
Need fast random access?                 → ArrayList
Need fast head/tail insertions (queue)?  → LinkedList or ArrayDeque
Need thread safety (read-heavy)?         → CopyOnWriteArrayList
Need thread safety (general)?            → Collections.synchronizedList(new ArrayList<>())
Need sorted access?                      → Use List + Collections.sort() or TreeSet
```

---

# Quick Run

```powershell
.\gradlew.bat classes
```

Relevant demo files (to be added):

- `src/main/java/com/learning/concepts/collections/list/ArrayListDemo.java`
- `src/main/java/com/learning/concepts/collections/list/LinkedListDemo.java`
- `src/main/java/com/learning/concepts/collections/list/CopyOnWriteArrayListDemo.java`

