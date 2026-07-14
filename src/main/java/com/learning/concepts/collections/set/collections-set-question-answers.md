# Java `Set` Interface and Implementations - Interview Questions and Answers

This file covers commonly asked and currently relevant Java interview questions on the `Set` interface and its major implemented classes: `HashSet`, `LinkedHashSet`, `TreeSet`, `CopyOnWriteArraySet`, and `EnumSet`.

---

# `Set` Interface - Question and Answer

## Q1: What is the `Set` interface in Java?

**A:** `Set` is an unordered collection that stores **unique elements only**.

Key characteristics:

- does not allow duplicate elements
- no guaranteed order (depends on implementation)
- provides no index-based access
- allows at most one `null` element (in most implementations)

Common implementations:

- `HashSet`
- `LinkedHashSet`
- `TreeSet`
- `CopyOnWriteArraySet`
- `EnumSet`

---

## Q2: How is `Set` different from `List`?

**A:**

| Aspect              | `Set`                            | `List`                          |
|---------------------|----------------------------------|---------------------------------|
| Duplicates          | Not allowed                      | Allowed                         |
| Order               | Depends on implementation        | Preserves insertion order (most) |
| Index access        | No                               | Yes                             |
| `null` elements     | Usually one allowed              | Multiple `null` allowed         |
| Use case            | Unique values, membership tests  | Ordered collections, iteration  |

---

## Q3: How is `Set` different from `Map`?

**A:**

- `Set` stores individual unique elements
- `Map` stores key-value pairs with unique keys
- `Set` focuses on membership; `Map` focuses on associations

---

## Q4: What are the most important methods in the `Set` interface?

**A:**

- `add(element)` — adds element if not present
- `remove(object)` — removes element
- `contains(object)` — checks membership
- `size()` — number of elements
- `isEmpty()` — checks if empty
- `clear()` — removes all elements
- `iterator()` — iteration support
- `addAll(collection)` — adds all from collection
- `removeAll(collection)` — removes common elements
- `retainAll(collection)` — keeps only common elements
- `stream()` — Java 8+ stream support

---

## Q5: What is the difference between `add()` on a `Set` vs `List`?

**A:**

- `Set.add()` returns `boolean`: `true` if added, `false` if duplicate
- `List.add()` returns `boolean`: always `true` (always adds, allows duplicates)

Example:

```java
Set<String> set = new HashSet<>();
boolean added = set.add("Apple"); // true
boolean added2 = set.add("Apple"); // false (duplicate)

List<String> list = new ArrayList<>();
list.add("Apple"); // returns true
list.add("Apple"); // returns true (duplicates allowed)
```

---

## Q6: Can a `Set` contain `null`?

**A:** It depends on the implementation:

- `HashSet` — allows one `null`
- `TreeSet` — does not allow `null` (requires `compareTo` on all elements)
- `LinkedHashSet` — allows one `null`
- `EnumSet` — does not allow `null`
- `CopyOnWriteArraySet` — allows one `null`

---

## Q7: What happens when you add a duplicate to a `Set`?

**A:**

```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Apple"); // returns false, not added
System.out.println(set.size()); // 1
```

The duplicate is not added, and `add()` returns `false`.

---

## Q8: How do you create an immutable `Set`?

**A:**

Several ways:

```java
// Java 9+
Set<String> set = Set.of("A", "B", "C");

// Java 8
Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("A", "B", "C")));

// Java 10+
Set<String> set = Set.copyOf(existingSet);
```

`Set.of()` does not allow `null`.

---

## Q9: What is the best way to choose a `Set` implementation in interviews?

**A:**

- need fast membership tests → `HashSet`
- need insertion order preservation → `LinkedHashSet`
- need sorted order → `TreeSet`
- need enum values only → `EnumSet`
- need thread-safe reads → `CopyOnWriteArraySet`

---

## Interview one-liner

`Set` stores unique elements with no guaranteed order; choose implementation based on whether you need speed, order, sorting, or thread safety.

---

# `HashSet` - Question and Answer

## Q1: What is `HashSet` in Java?

**A:** `HashSet` is a hash-table based implementation of the `Set` interface.

- backed by a `HashMap` internally
- provides O(1) average-case `add`, `contains`, `remove`
- does not preserve insertion order
- not thread-safe
- allows one `null` element

---

## Q2: How does `HashSet` work internally?

**A:** `HashSet` uses a `HashMap` internally where:

- each element is stored as a **key** in the map
- a dummy `Object` (e.g., `new Object()`) is stored as the **value**
- `add()` calls `map.put(element, dummyValue)`
- `contains()` calls `map.containsKey(element)`

This is why `HashSet` performance mirrors `HashMap`.

---

## Q3: What is the time complexity of `HashSet` operations?

**A:**

| Operation              | Time complexity |
|------------------------|-----------------|
| `add(element)`         | O(1) average    |
| `remove(object)`       | O(1) average    |
| `contains(object)`     | O(1) average    |
| `size()`               | O(1)            |
| `iterator()`           | O(n)            |

Worst case can be O(n) with poor hash distribution.

---

## Q4: Are `HashSet` iterators fail-fast?

**A:** Yes.

If the set is structurally modified during iteration (add/remove), the iterator may throw `ConcurrentModificationException`.

Safe pattern:

```java
Iterator<String> it = set.iterator();
while (it.hasNext()) {
    if (it.next().equals("target")) {
        it.remove(); // safe
    }
}
```

Unsafe pattern:

```java
for (String s : set) {
    set.remove(s); // may throw ConcurrentModificationException
}
```

---

## Q5: Is `HashSet` thread-safe?

**A:** No.

For concurrent access, use:

- `Collections.synchronizedSet(new HashSet<>())`
- `CopyOnWriteArraySet` (better for read-heavy)

---

## Q6: How do you convert a `HashSet` to an array?

**A:**

```java
HashSet<String> set = new HashSet<>(Arrays.asList("A", "B"));
String[] arr = set.toArray(new String[0]);
```

---

## Q7: What are common interview mistakes around `HashSet`?

**A:**

- assuming order is preserved (it is not)
- forgetting it is not thread-safe
- ignoring `equals()` and `hashCode()` contract
- using mutable objects as elements
- assuming O(1) is guaranteed (worst case can be O(n))
- not understanding it's backed by `HashMap`

---

## Interview one-liner

`HashSet` is a fast, unordered set backed by `HashMap`; ideal for membership tests with O(1) average performance.

---

# `LinkedHashSet` - Question and Answer

## Q1: What is `LinkedHashSet` in Java?

**A:** `LinkedHashSet` is an ordered implementation of `Set` that maintains **insertion order**.

- backed by a `LinkedHashMap` internally
- preserves insertion order of elements
- O(1) average `add`, `contains`, `remove`
- slightly heavier than `HashSet` due to linked list overhead
- not thread-safe
- allows one `null` element

---

## Q2: How does `LinkedHashSet` maintain order?

**A:** Like `LinkedHashMap`, it maintains a doubly-linked list across all elements:

- each element participates in the hash table (for O(1) lookup)
- each element also participates in a linked list (for order preservation)
- iteration follows the linked list order, not hash bucket order

---

## Q3: What is the time complexity of `LinkedHashSet` operations?

**A:**

| Operation              | Time complexity |
|------------------------|-----------------|
| `add(element)`         | O(1) average    |
| `remove(object)`       | O(1) average    |
| `contains(object)`     | O(1) average    |
| `iterator()`           | O(n)            |

Same as `HashSet` for operations, but iteration order is predictable (insertion order).

---

## Q4: When should you use `LinkedHashSet`?

**A:** Use when you need:

- fast membership tests (like `HashSet`)
- predictable iteration order (insertion order)
- no sorting required

Example: processing a sequence of unique IDs in the order they were first seen.

---

## Q5: How does `LinkedHashSet` compare to `HashSet` and `TreeSet`?

**A:**

| Aspect          | `HashSet`            | `LinkedHashSet`      | `TreeSet`           |
|-----------------|----------------------|----------------------|---------------------|
| Order           | No guaranteed        | Insertion order      | Sorted order        |
| Performance     | O(1) average         | O(1) average         | O(log n)            |
| Memory          | Less overhead        | More (linked list)   | More (tree nodes)   |
| `null` support  | One allowed          | One allowed          | Not allowed         |

---

## Interview one-liner

`LinkedHashSet` maintains insertion order while preserving `HashSet`'s O(1) performance; ideal when both speed and order matter.

---

# `TreeSet` - Question and Answer

## Q1: What is `TreeSet` in Java?

**A:** `TreeSet` is a sorted implementation of the `Set` interface using a **red-black tree** internally.

- maintains elements in sorted order
- `add`, `remove`, `contains` are O(log n)
- does not allow `null` elements (requires comparison on all elements)
- not thread-safe
- implements `SortedSet` and `NavigableSet`

---

## Q2: How does `TreeSet` sort elements?

**A:** `TreeSet` sorts using:

- **natural ordering** (via `Comparable`), or
- **custom comparator** (passed in constructor)

Example:

```java
// Natural order
TreeSet<Integer> set = new TreeSet<>();
set.add(3);
set.add(1);
set.add(2);
System.out.println(set); // [1, 2, 3]

// Custom order (reverse)
TreeSet<Integer> set2 = new TreeSet<>(Comparator.reverseOrder());
set2.add(3);
set2.add(1);
set2.add(2);
System.out.println(set2); // [3, 2, 1]
```

---

## Q3: What is the time complexity of `TreeSet` operations?

**A:**

| Operation              | Time complexity |
|------------------------|-----------------|
| `add(element)`         | O(log n)        |
| `remove(object)`       | O(log n)        |
| `contains(object)`     | O(log n)        |
| `first()`              | O(log n)        |
| `last()`               | O(log n)        |
| `iterator()`           | O(n)            |

All operations are O(log n) due to tree balancing.

---

## Q4: What special methods does `TreeSet` provide?

**A:** As a `NavigableSet`, `TreeSet` provides:

- `first()` — smallest element
- `last()` — largest element
- `lower(E e)` — largest element < e
- `higher(E e)` — smallest element > e
- `floor(E e)` — largest element <= e
- `ceiling(E e)` — smallest element >= e
- `subSet(E from, E to)` — elements in range [from, to)
- `headSet(E toElement)` — elements < toElement
- `tailSet(E fromElement)` — elements >= fromElement

---

## Q5: Why does `TreeSet` not allow `null`?

**A:** Because `TreeSet` needs to **compare all elements** to maintain sorted order.

Calling `compareTo(null)` would throw `NullPointerException`.

---

## Q6: When should you use `TreeSet`?

**A:** Use when you need:

- sorted iteration over unique elements
- range queries (`subSet`, `headSet`, `tailSet`)
- first/last element access
- custom sorting via `Comparator`

---

## Q7: Is `TreeSet` thread-safe?

**A:** No.

For concurrent sorted access, use `Collections.synchronizedSortedSet()` wrapper.

---

## Interview one-liner

`TreeSet` maintains sorted order via red-black tree, providing O(log n) operations and rich navigation methods.

---

# `EnumSet` - Question and Answer

## Q1: What is `EnumSet` in Java?

**A:** `EnumSet` is a specialized, highly efficient `Set` implementation for enum values only.

- backed by a **bit vector** internally (extremely compact)
- all operations are O(1) constant time
- no `null` support
- very fast iteration
- not thread-safe

---

## Q2: How is `EnumSet` more efficient than `HashSet`?

**A:** `EnumSet` uses a bit vector where each bit represents one enum constant:

- each bit = 0 (not in set) or 1 (in set)
- `add` / `remove` / `contains` are single bit operations (O(1))
- memory usage is minimal: roughly `numConstants / 8` bytes
- iteration is very fast (just scans bit vector)

Compare to `HashSet`:

- `HashSet` uses buckets and hashing (more overhead)
- `EnumSet` is 3-5× faster for enum workloads

---

## Q3: How do you create an `EnumSet`?

**A:**

```java
enum Color { RED, GREEN, BLUE }

// All values
EnumSet<Color> all = EnumSet.allOf(Color.class);

// No values (empty)
EnumSet<Color> empty = EnumSet.noneOf(Color.class);

// Specific values
EnumSet<Color> subset = EnumSet.of(Color.RED, Color.GREEN);

// Range
EnumSet<Color> range = EnumSet.range(Color.RED, Color.GREEN);
```

---

## Q4: When should you use `EnumSet`?

**A:** Use when:

- working exclusively with enum constants
- need maximum performance for set operations
- want minimal memory footprint
- enum values are known at compile time

Common use case: flags, permission sets

---

## Interview one-liner

`EnumSet` is a blazingly fast, memory-efficient set for enum values, backed by bit vectors.

---

# `CopyOnWriteArraySet` - Question and Answer

## Q1: What is `CopyOnWriteArraySet` in Java?

**A:** `CopyOnWriteArraySet` is a thread-safe `Set` implementation optimized for read-heavy concurrency.

- backed by `CopyOnWriteArrayList` internally
- every write operation copies the underlying array
- reads are lock-free
- write operations are O(n) due to array copy
- does not allow `null` elements
- weakly consistent iterators (not fail-fast)

---

## Q2: How does `CopyOnWriteArraySet` achieve thread safety?

**A:**

- write operations (`add`, `remove`) lock and create a new array copy
- read operations (`contains`, iteration) use lock-free snapshot reads
- readers always see a consistent snapshot

---

## Q3: What is the time complexity of `CopyOnWriteArraySet` operations?

**A:**

| Operation              | Time complexity       |
|------------------------|------------------------|
| `add(element)`         | O(n) due to copy     |
| `remove(object)`       | O(n) due to copy     |
| `contains(object)`     | O(n) but no lock     |
| `iterator()`           | O(n), no lock needed |

---

## Q4: When should you use `CopyOnWriteArraySet`?

**A:** Use when:

- reads vastly outnumber writes
- need safe concurrent iteration without locks
- set contents change rarely
- write performance is not critical

Example: listener sets, observer patterns, permission sets in servers.

---

## Q5: Why not use it for write-heavy workloads?

**A:** Because every `add()` or `remove()` copies the entire array (O(n)).

For write-heavy scenarios, use `Collections.synchronizedSet()` or manually synchronized patterns.

---

## Interview one-liner

`CopyOnWriteArraySet` sacrifices write performance for lock-free reads and safe iteration; ideal for read-dominated concurrent workloads.

---

# Common Interview Mistakes around Sets

**A:**

- thinking `HashSet` preserves order
- assuming `Set.add()` always succeeds (duplicate returns false)
- forgetting `TreeSet` does not allow `null`
- using `Set` when `List` is needed (no index access)
- ignoring thread-safety requirements
- not understanding `LinkedHashSet` is not sorted, just ordered
- using `TreeSet` for unordered sets when `HashSet` is faster
- confusing `TreeSet` with `LinkedHashSet`
- assuming `CopyOnWriteArraySet` is good for all concurrent workloads
- not knowing `EnumSet` exists for enum values
- trying to add mutable objects (or to sets with weak comparators)
- assuming `Set` iteration order across runs/JDK versions

---

# Comparison Table — All `Set` Implementations

| Feature                  | `HashSet`            | `LinkedHashSet`      | `TreeSet`            | `EnumSet`                 | `CopyOnWriteArraySet`     |
|--------------------------|----------------------|----------------------|----------------------|---------------------------|---------------------------|
| Internal structure       | Hash table           | Hash table + linked list | Red-black tree       | Bit vector               | Resizable array            |
| Ordering                 | No guaranteed        | Insertion order      | Sorted               | N/A (enum order)          | Insertion order            |
| Thread-safe              | No                   | No                   | No                   | No                        | Yes                        |
| `add` complexity         | O(1) avg             | O(1) avg             | O(log n)             | O(1)                      | O(n)                       |
| `contains` complexity    | O(1) avg             | O(1) avg             | O(log n)             | O(1)                      | O(n), lock-free            |
| `null` support           | 1 allowed            | 1 allowed            | Not allowed          | Not allowed               | Not allowed                |
| Iterator behavior        | Fail-fast            | Fail-fast            | Fail-fast            | Fail-fast                 | Snapshot (weakly consistent) |
| Recommended use          | General purpose      | Order + speed        | Sorted data          | Enum values only          | Read-heavy concurrent      |

---

# Interview Tips

- **Choose quickly**: HashSet for speed, TreeSet for sorted, LinkedHashSet for order
- **Thread safety**: Always mention it; default implementations are not thread-safe
- **Null handling**: HashSet/LinkedHashSet allow 1 null; TreeSet/EnumSet do not
- **EnumSet**: Mention if they're asking about enum workloads — huge performance win
- **CopyOnWriteArraySet**: Mention for listener/observer patterns in concurrent code
- **Common trap**: Confusing order preservation (LinkedHashSet) with sorting (TreeSet)

---

# Quick Run

```powershell
.\gradlew.bat classes
```

Relevant demo files (to be added):

- `src/main/java/com/learning/concepts/collections/set/HashSetDemo.java`
- `src/main/java/com/learning/concepts/collections/set/TreeSetDemo.java`
- `src/main/java/com/learning/concepts/collections/set/LinkedHashSetDemo.java`
- `src/main/java/com/learning/concepts/collections/set/EnumSetDemo.java`
- `src/main/java/com/learning/concepts/collections/set/CopyOnWriteArraySetDemo.java`

