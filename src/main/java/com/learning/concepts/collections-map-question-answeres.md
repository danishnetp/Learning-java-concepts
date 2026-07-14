# Java `Map`, `HashMap`, and `ConcurrentHashMap` - Interview Questions and Answers

This file collects commonly asked and currently relevant Java interview questions around the `Map` API, `HashMap`, and `ConcurrentHashMap`.

---

# `Map` - Question and Answer

## Q1: What is `Map` in Java?

**A:** `Map` is an interface in Java that stores data as **key-value pairs**.

- each key must be unique
- values can be duplicated
- it is used when you want to look up a value by key efficiently

Examples of implementations:

- `HashMap`
- `LinkedHashMap`
- `TreeMap`
- `ConcurrentHashMap`
- `Hashtable`

---

## Q2: Is `Map` part of the `Collection` interface?

**A:** No. `Map` is part of the Java Collections Framework, but it does **not** extend `Collection`.

Reason:

- `Collection` models a group of individual elements
- `Map` models **associations** between keys and values

---

## Q3: What happens if you insert the same key again into a `Map`?

**A:** The old value is replaced by the new value.

Example:

```java
Map<Integer, String> map = new HashMap<>();
map.put(1, "A");
map.put(1, "B");

System.out.println(map.get(1));
```

Output:

```text
B
```

---

## Q4: What is the difference between `put()` and `putIfAbsent()`?

**A:**

- `put(key, value)` always writes the value
- `putIfAbsent(key, value)` writes only if the key is not already present

This becomes especially important in concurrent code when using `ConcurrentHashMap`.

---

## Q5: What is the difference between `keySet()`, `values()`, and `entrySet()`?

**A:**

- `keySet()` returns all keys
- `values()` returns all values
- `entrySet()` returns key-value pairs as `Map.Entry<K,V>`

For iterating both key and value, `entrySet()` is usually the best choice because it avoids extra lookups.

---

## Q6: How does a `Map` decide whether two keys are the same?

**A:** In hash-based maps such as `HashMap`, keys are compared using:

1. `hashCode()` to locate the bucket
2. `equals()` to confirm the exact key match

If `equals()` and `hashCode()` are not implemented correctly, map behavior becomes inconsistent.

---

## Q7: Why are immutable keys recommended in a `Map`?

**A:** If a key changes after insertion, its `hashCode()` or `equals()` result may change.

That can make the entry effectively unreachable, even though it is still stored in the map.

Good key choices:

- `String`
- boxed primitives
- immutable custom classes

---

## Q8: What are the most common `Map` implementations and when should you use them?

**A:**

| Implementation         | Ordering                         | Thread-safe    | Typical use case                    |
|------------------------|----------------------------------|----------------|-------------------------------------|
| `HashMap`              | No guaranteed order              | No             | General-purpose fast lookup         |
| `LinkedHashMap`        | Insertion or access order        | No             | Predictable iteration, LRU patterns |
| `TreeMap`              | Sorted by key                    | No             | Sorted data / range queries         |
| `ConcurrentHashMap`    | No guaranteed order              | Yes            | Shared maps in multi-threaded code  |
| `Hashtable`            | No guaranteed order              | Yes            | Legacy synchronized map             |

---

## Q9: What is the difference between `HashMap`, `LinkedHashMap`, and `TreeMap`?

**A:**

- `HashMap` gives fast average lookup with no order guarantee
- `LinkedHashMap` maintains insertion order or access order
- `TreeMap` keeps keys sorted using natural ordering or a comparator

Time complexity in typical interviews:

- `HashMap`: O(1) average
- `LinkedHashMap`: O(1) average
- `TreeMap`: O(log n)

---

## Q10: What are the newer and commonly asked default methods on `Map`?

**A:** Important methods introduced and widely used in modern Java are:

- `getOrDefault()`
- `putIfAbsent()`
- `compute()`
- `computeIfAbsent()`
- `computeIfPresent()`
- `merge()`
- `replace()` / `replaceAll()`
- `forEach()`

These methods reduce boilerplate and are often safer than manual read-modify-write code.

---

## Q11: When should you use `computeIfAbsent()`?

**A:** Use `computeIfAbsent()` when you want to create and insert a value **only if the key is currently not mapped**.

It is most useful for:

- lazy initialization of expensive objects
- grouping values in maps of collections
- frequency/counter maps
- cache-style population logic

Without `computeIfAbsent()`, code is usually verbose and error-prone:

```java
List<String> users = groups.get("admin");
if (users == null) {
    users = new ArrayList<>();
    groups.put("admin", users);
}
users.add("Alice");
```

With `computeIfAbsent()`:

```java
Map<String, List<String>> groups = new HashMap<>();
groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Alice");
groups.computeIfAbsent("admin", k -> new ArrayList<>()).add("Bob");
```

Result:

```text
{admin=[Alice, Bob]}
```

Important behavior points interviewers ask:

- if key already has a non-null value, mapping function is not called
- if key is absent (or mapped to `null`), mapping function is called
- if mapping function returns `null`, no mapping is recorded
- if mapping function throws exception, map remains unchanged for that key

Concurrency note:

- in `ConcurrentHashMap`, this method is atomic per key and preferred over manual `get()` then `put()`

This avoids manual null checks and makes intent clearer.

---

## Q12: What is the difference between fail-fast and weakly consistent iteration?

**A:**

- **Fail-fast** iterators usually throw `ConcurrentModificationException` when the map is structurally modified during iteration
- **Weakly consistent** iterators tolerate concurrent updates and may reflect some or all of them without throwing that exception

Examples:

- `HashMap` -> fail-fast
- `ConcurrentHashMap` -> weakly consistent

---

## Q13: What is the best way to choose a `Map` implementation in interviews?

**A:** A simple decision rule:

- need fast lookup only -> `HashMap`
- need predictable iteration order -> `LinkedHashMap`
- need sorted keys -> `TreeMap`
- need concurrency without external locking -> `ConcurrentHashMap`

---

## Interview one-liner

`Map` stores unique keys and associated values; the best implementation depends on whether you need ordering, sorting, or concurrency.

---

# `HashMap` - Question and Answer

## Q1: What is `HashMap` in Java?

**A:** `HashMap` is a hash-table based implementation of the `Map` interface.

- average-case `put`, `get`, and `remove` are O(1)
- it does not preserve insertion order
- it is not thread-safe
- it allows one `null` key and multiple `null` values

---

## Q2: How does `HashMap` work internally?

**A:** Internally, `HashMap` uses an array of buckets.

Basic flow:

1. compute hash of the key
2. calculate bucket index
3. if bucket is empty, insert node
4. if bucket already has entries, handle collision
5. if same key exists, replace its value

In JDK 8+, buckets can be:

- linked lists for normal collisions
- red-black trees for heavy collisions

---

## Q3: How is bucket index calculated in `HashMap`?

**A:** In simplified form:

```java
index = (n - 1) & hash
```

where `n` is the table length.

This is why `HashMap` keeps capacity as a power of 2.

---

## Q4: What is a collision in `HashMap`?

**A:** A collision happens when multiple keys map to the same bucket index.

`HashMap` handles collisions by storing multiple entries in the same bucket:

- first as a linked list
- later as a tree when collision count becomes high enough

---

## Q5: What is treeification in `HashMap`?

**A:** Treeification means converting a heavily-collided bucket from a linked list into a red-black tree.

This improves worst-case lookup from O(n) to near O(log n) for that bucket.

In common interview discussion for JDK 8+:

- treeify threshold is commonly 8
- minimum capacity before treeification is commonly 64

---

## Q6: What is load factor in `HashMap`?

**A:** Load factor decides when the map should resize.

Formula:

```java
threshold = capacity * loadFactor
```

Default load factor is `0.75`, which is a practical balance between memory usage and collision rate.

---

## Q7: What happens during resize or rehash in `HashMap`?

**A:** When size crosses the threshold:

- capacity usually doubles
- entries are redistributed into new buckets
- lookup performance is preserved by keeping bucket chains smaller on average

Resize is costly, so interviewers may ask about choosing a good initial capacity.

---

## Q8: Why is `HashMap` not thread-safe?

**A:** `HashMap` has no internal synchronization.

If multiple threads modify it at the same time:

- data races can happen
- lost updates can happen
- readers may observe inconsistent state

For concurrent writes, use `ConcurrentHashMap` or external synchronization.

---

## Q9: Can `HashMap` have `null` keys and values?

**A:** Yes.

- it allows one `null` key
- it allows multiple `null` values

This is an important difference from `ConcurrentHashMap`.

---

## Q10: Why must `equals()` and `hashCode()` be implemented properly for custom keys?

**A:** Because `HashMap` uses both.

- `hashCode()` decides where to search
- `equals()` decides whether the found key is the same key

If two logically equal objects return different hash codes, retrieval may fail.

---

## Q11: Why are mutable keys dangerous in `HashMap`?

**A:** If the fields participating in `equals()` or `hashCode()` change after insertion, the object may remain in the old bucket but no longer be found correctly.

That is why immutable keys are strongly preferred.

---

## Q12: What is the time complexity of `HashMap` operations?

**A:**

- `get` -> O(1) average
- `put` -> O(1) average
- `remove` -> O(1) average

Worst case can degrade to O(n), though treeified buckets improve heavy-collision cases.

---

## Q13: Are `HashMap` iterators fail-fast?

**A:** Yes, generally.

If the map is structurally modified after iterator creation, the iterator may throw `ConcurrentModificationException`.

It is called fail-fast because it detects unsafe concurrent structural modification quickly, but it is not a hard thread-safety guarantee.

---

## Q14: What is the difference between `HashMap` and `Hashtable`?

**A:**

| Aspect            | `HashMap`                        | `Hashtable` |
|-------------------|----------------------------------|-------------|
| Thread safety     | No                               | Yes         |
| Performance       | Better in single-threaded code   | More lock contention |
| `null` key/value  | Allows one `null` key and null values | Does not allow `null` |
| API age           | Modern, preferred                | Legacy      |

---

## Q15: How do you size a `HashMap` for better performance?

**A:** If you already know the approximate number of entries, choose an initial capacity that reduces resizing.

Interview tip:

- too small -> more rehashing
- too large -> more memory usage

In performance-sensitive code, pre-sizing can noticeably reduce overhead.

---

## Q16: What are common interview mistakes around `HashMap`?

**A:**

- saying it preserves insertion order
- forgetting that it is not thread-safe
- ignoring `equals()` and `hashCode()` contract
- using mutable objects as keys
- assuming O(1) is guaranteed in all cases

---

## Interview one-liner

`HashMap` is the default general-purpose map in Java: fast on average, unordered, allows `null`, and depends heavily on correct `hashCode()` and `equals()` implementations.

---

# `ConcurrentHashMap` - Question and Answer

## Q1: What is `ConcurrentHashMap` in Java?

**A:** `ConcurrentHashMap` is a thread-safe implementation of `Map` designed for high concurrency. It allows multiple threads to read and update the map efficiently without locking the entire map.

---

## Q2: How locking works internally in `ConcurrentHashMap` (JDK 8+)

- **Reads (`get`) are mostly lock-free:** They typically use volatile reads and do not block.
- **Writes are fine-grained:** Instead of one global lock, locking is done at bucket/bin level when needed.
- **CAS + bin-lock strategy:**
  - Empty bucket insert can happen with CAS (compare-and-swap) without locking.
  - If a bucket already has entries (collision), it synchronizes on that bin head while updating.
- **Resize is cooperative:** Multiple threads can help with transfer during rehash, improving scalability.

---

## Q3: Does `ConcurrentHashMap` still use segments?

**A:** This is a very common interview trap.

- In older Java versions, segmented locking was a key design point
- In JDK 8+, the implementation is different and is primarily based on CAS, bin-level locking, and cooperative resize

So in modern Java interviews, avoid saying that current `ConcurrentHashMap` is still segment-based in the old sense.

---

## Q4: How does collision handling work in `ConcurrentHashMap`?

**A:**

- Like `HashMap`, collisions start as linked lists in a bucket
- On high collision count, a bucket can be treeified (red-black tree style) to improve worst-case lookup
- Updates in colliding bins are protected by per-bin synchronization

---

## Q5: Why does `ConcurrentHashMap` not allow `null` keys or values?

**A:** It avoids ambiguity in concurrent code.

If `get(key)` returns `null`, Java must be able to interpret it clearly as:

- key absent

and not as:

- key present but mapped to `null`

That makes concurrent logic safer and simpler.

---

## Q6: What is the difference between `ConcurrentHashMap` and `HashMap`?

**A:**

| Aspect             | `ConcurrentHashMap`                  | `HashMap`                                        |
|--------------------|--------------------------------------|--------------------------------------------------|
| Thread safety      | Yes, designed for concurrent use     | No                                               |
| Locking model      | Fine-grained/bin-level locking + CAS | No internal synchronization                      |
| Read behavior      | Mostly lock-free                     | Not safe under concurrent writes                 |
| `null` key/value   | Not allowed                          | 1 `null` key, multiple `null` values allowed     |
| Iterator behavior  | Weakly consistent, not fail-fast     | Fail-fast                                        |
| Typical use case   | Multi-threaded shared maps           | Single-threaded or externally synchronized usage |

---

## Q7: Are iterators of `ConcurrentHashMap` fail-fast?

**A:** No.

They are **weakly consistent**:

- they do not throw `ConcurrentModificationException`
- they may reflect some updates made during iteration
- they are not a full snapshot of the map

---

## Q8: Is `get()` in `ConcurrentHashMap` locked?

**A:** Usually no. Most reads are lock-free and rely on volatile visibility and carefully designed internal state transitions.

This is one major reason it performs better than coarse-grained synchronization for read-heavy workloads.

---

## Q9: What atomic methods are important in `ConcurrentHashMap`?

**A:** Commonly asked atomic methods are:

- `putIfAbsent()`
- `replace()`
- `remove(key, value)`
- `compute()`
- `computeIfAbsent()`
- `computeIfPresent()`
- `merge()`

These are safer than manual `get()` followed by `put()` in concurrent logic.

---

## Q10: Why is `get()` followed by `put()` dangerous in concurrent code?

**A:** Because it is a non-atomic read-modify-write sequence.

Example problem:

1. thread A reads old value
2. thread B updates the same key
3. thread A writes based on stale value

Correct approach:

- use `compute`, `merge`, or other atomic map methods

---

## Q11: What happens during resize in `ConcurrentHashMap`?

**A:** Resize is cooperative.

- one thread may initiate transfer
- other mutating threads may help move bucket ranges
- forwarding nodes guide operations to the new table during transfer

This design improves scalability during resizing.

---

## Q12: Is `size()` always exact in `ConcurrentHashMap`?

**A:** Under heavy concurrent updates, computing an exact size is more expensive.

In practice, `size()` may need retries and aggregation, so interview discussions often describe it as potentially transient under active mutation.

---

## Q13: When should you use `ConcurrentHashMap`?

**A:** Use it when many threads read and write shared key-value data and you want better throughput than synchronized map approaches.

Typical examples:

- caches
- frequency counters
- per-user session metadata
- shared registries

---

## Q14: When should you avoid heavy work inside `compute()` or `merge()`?

**A:** Because those operations may hold per-key/bin update coordination while executing the mapping function.

So avoid:

- blocking I/O
- slow database calls
- long CPU-heavy logic

inside those lambdas in hot concurrent paths.

---

## Q15: What is a common scalable counting pattern with `ConcurrentHashMap`?

**A:** Use `LongAdder` values with `computeIfAbsent()`.

Example:

```java
ConcurrentHashMap<String, java.util.concurrent.atomic.LongAdder> freq = new ConcurrentHashMap<>();
freq.computeIfAbsent("api:/orders", k -> new java.util.concurrent.atomic.LongAdder()).increment();
```

This reduces contention better than repeatedly boxing integers for high-frequency counters.

---

## Q16: What is the difference between `ConcurrentHashMap`, `Collections.synchronizedMap()`, and `Hashtable`?

**A:**

- `Hashtable` is legacy and synchronizes broadly
- `Collections.synchronizedMap()` wraps a map with external synchronization around map operations
- `ConcurrentHashMap` is designed specifically for scalable concurrent access with better throughput

For most modern multi-threaded use cases, `ConcurrentHashMap` is the preferred choice.

---

## Interview one-liner

`ConcurrentHashMap` is a high-performance, thread-safe map that avoids map-wide locking by combining lock-free reads, CAS, and bucket-level synchronization.

---

# LinkedHashMap - Question and Answer

## Q: How does `LinkedHashMap` maintain insertion order or access order?

**A:** `LinkedHashMap` extends `HashMap` and maintains order by combining two data structures:

- a **hash table** for fast lookup by key
- a **doubly linked list** for predictable iteration order

Each entry stores extra links like:

- `before` -> previous entry
- `after` -> next entry

Because of these links, `LinkedHashMap` can iterate entries in a consistent order.

---

## 1) How insertion order is maintained

By default, `LinkedHashMap` maintains **insertion order**.

That means:

- when a new key is inserted, it is added at the **end** of the doubly linked list
- when iterating, entries are returned in the same order they were inserted
- if an existing key is updated, its position usually does **not** change

Example:

```text
Map<Integer, String> map = new LinkedHashMap<>();
map.put(3, "C");
map.put(1, "A");
map.put(2, "B");

System.out.println(map);
```

Output order:

```text
{3=C, 1=A, 2=B}
```

---

## 2) How access order is maintained

`LinkedHashMap` can also maintain **access order** instead of insertion order.

This is enabled using the constructor:

```text
new LinkedHashMap<>(initialCapacity, loadFactor, true)
```

The third argument `true` means **access-order mode**.

In this mode, whenever an entry is accessed using operations like:

- `get(key)`
- `put(key, value)` on existing key
- `putIfAbsent(key, value)`

that entry is moved to the **end** of the doubly linked list.

So iteration order becomes:

- least recently accessed -> first
- most recently accessed -> last

Example:

```text
Map<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);
map.put(1, "A");
map.put(2, "B");
map.put(3, "C");

map.get(1);
map.get(2);

System.out.println(map);
```

Possible order after access:

```text
{3=C, 1=A, 2=B}
```

Here `1` and `2` were accessed later, so they moved toward the end.

---

## 3) Internal implementation idea

Internally, `LinkedHashMap` uses:

- `HashMap` bucket logic for O(1) average lookup
- a doubly linked list across all entries
- head and tail style linking to preserve traversal order

So each entry participates in:

1. a bucket chain/tree for hashing
2. a global linked order for iteration

That is why `LinkedHashMap` is slightly heavier than `HashMap`, but gives predictable order.

---

## 4) Difference between insertion order and access order

| Mode              | Behavior                                                  |
|-------------------|-----------------------------------------------------------|
| Insertion order   | Entries remain in the order they were originally inserted |
| Access order      | Entries move to the end when accessed                     |

---

## 5) Why access-order mode is useful

Access-order `LinkedHashMap` is commonly used to build **LRU cache** behavior.

Because the least recently used item stays near the beginning, it can be removed easily.

`LinkedHashMap` provides `removeEldestEntry()` which can be overridden for this purpose.

---

## Interview one-liner

`LinkedHashMap` maintains order by adding a doubly linked list on top of `HashMap`; 
insertion-order keeps original insert sequence, while access-order moves recently accessed entries to the end.

---

# `HashMap` and `ConcurrentHashMap` - Internal Implementation Details

HashMap is a hash-table based implementation of `Map` that stores data as key-value pairs.
It gives very fast average-case operations for insert (`put`), read (`get`), and delete (`remove`).

---

## 1) What HashMap is

- Stores entries as `key -> value`.
- Does not preserve insertion order (use `LinkedHashMap` if order matters).
- Is not thread-safe (use `ConcurrentHashMap` for concurrent access).
- Allows one `null` key and multiple `null` values.

---

## 2) Internal data structures

In JDK 8+ (simplified view), `HashMap` mainly uses:

- `Node<K,V>[] table`: Array of buckets.
- `Node`: Linked-list node containing `hash`, `key`, `value`, and `next` pointer.
- `TreeNode`: Red-black tree node used when a single bucket gets too many collisions.

Bucket index is calculated as:

```java
index = (table.length - 1) & hash
```

This works efficiently because table length is maintained as a power of 2.

---

## 3) How put(key, value) works

1. Compute hash of key.
2. Find bucket index.
3. If bucket is empty, insert a new node.
4. If bucket is not empty (collision):
   - Traverse linked list (or tree) in that bucket.
   - If same key found (`hash` + `equals`), update value.
   - Else append a new node at the end of the linked list.
5. Increase `size` for a new key.
6. If `size > threshold`, resize and rehash entries.

---

## 4) Collision handling and linked-list maintenance

When multiple keys map to the same bucket index, HashMap maintains a chain using `next` pointers.

- `head = table[index]`
- Traverse with `prev` and `curr`
- On key match: update `curr.value` only
- If no key match until tail: `tail.next = new Node(...)`

On remove:

- Removing head node: `table[index] = head.next`
- Removing middle/tail node: `prev.next = curr.next`

If bucket chain length grows large:

- Treeify condition: bucket size reaches threshold (commonly 8)
- Minimum table capacity condition must also be met (commonly 64)
- Bucket converts from linked list to red-black tree for better worst-case lookup

---

## 5) Resize and rehash

HashMap resizes when `size > threshold`, where:

```java
threshold = capacity * loadFactor
```

Default load factor is `0.75`.

During resize:

- Capacity usually doubles
- Entries are redistributed to new buckets
- This keeps average bucket length small

---

## 6) Time complexity (typical)

- `put`: O(1) average, O(n) worst case (before treeification)
- `get`: O(1) average, O(n) worst case
- `remove`: O(1) average, O(n) worst case
- With treeified buckets, worst-case per bucket operations become close to O(log n)

---

## 7) Important behavior notes

- Key equality depends on both `hashCode()` and `equals()`.
- Mutable keys are risky: changing key state after insertion can break lookups.
- Iterators are fail-fast (structural modification during iteration can throw `ConcurrentModificationException`).

---

## 8) Visual references in this project

- Internal implementation diagrams:
  - `hasp-map-internal-implementations.puml`
- Demo class:
  - `src/main/java/com/learning/concepts/collections/map/HashMapDemo1.java`
  - `src/main/java/com/learning/concepts/collections/map/HashMapVsConcurrentHashMapDemo.java`

---

## 9) Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.collections.map.HashMapDemo1
java -cp build\classes\java\main com.learning.concepts.collections.map.HashMapVsConcurrentHashMapDemo
```

---

## 10) How ConcurrentHashMap works internally (JDK 8+)

`ConcurrentHashMap` is designed for high-concurrency reads/writes without locking the whole map.

- Uses `Node<K,V>[] table` buckets, similar to `HashMap`.
- Uses lock-free reads in common cases (`get` usually reads volatile state only).
- Uses CAS (compare-and-swap) for some updates and bucket initialization.
- Uses per-bucket locking (synchronizing on first node of a bin) for contended writes.
- Uses tree bins (`TreeBin`) for heavy collisions, like HashMap treeification.

### Why it scales better than Hashtable

- `Hashtable` synchronizes almost every method at map level.
- `ConcurrentHashMap` limits contention to a bucket/bin, allowing many threads to update different bins in parallel.

### Internal write flow (`put`) simplified

1. Compute spread hash.
2. If table not initialized, initialize lazily with CAS/size control.
3. Find bucket index.
4. If bucket empty, CAS-insert new node (no lock path).
5. If bucket has data:
   - If bucket is forwarding node, resize is in progress; help transfer.
   - Else lock that bin head and perform linked-list or tree update.
6. Update count using striped counters (`baseCount`/`counterCells`).
7. If threshold exceeded, trigger/assist resize.

### Collision handling in ConcurrentHashMap

- Collisions are handled per bucket as linked list, then optionally treeified.
- Under bin lock, traversal and pointer updates are thread-safe.
- Treeification is applied for long bins, with capacity checks, to avoid frequent rehash-only growth.

### Resize internals (cooperative)

- Resize is not done by only one thread.
- A thread detecting resize pressure can start transfer.
- Other mutating threads may help move bucket ranges to the new table.
- Moved bins are marked with `ForwardingNode`, directing operations to the new table.

### Counting and size semantics

- Exact global size is expensive under contention.
- Uses striped counters (`CounterCell[]`) to reduce contention on a single counter.
- `size()` may require retries/aggregation and can be approximate during active concurrent updates.

### Iterator behavior

- Iterators are weakly consistent (not fail-fast like `HashMap`).
- They reflect map state at or after iterator creation, and may miss or include concurrent updates.

### Important differences vs HashMap

- Does not allow `null` keys or `null` values.
- Safer for concurrent access without external synchronization.
- Better throughput under multi-threaded workloads.

### Core internal fields you should know

- `table`: main bucket array (volatile) used for reads/writes.
- `sizeCtl`: controls initialization and resize state.
  - `0`: uninitialized
  - positive: next resize threshold
  - `-1`: initialization in progress
  - negative (other): resize in progress with helper threads
- `baseCount` + `CounterCell[]`: striped counters to reduce contention.

### Read path (`get`) internals

1. Compute spread hash (`h ^ (h >>> 16)`).
2. Read table reference and bucket head (volatile reads).
3. If head matches key, return directly.
4. If head is `ForwardingNode`, follow to new table during resize.
5. Else traverse list/tree in that bin.

Read path is usually lock-free, which is the main reason read throughput is high.

### Remove path (`remove`) internals

1. Compute hash and locate bucket.
2. If bucket empty, return `null`.
3. Lock bin head when structural change is needed.
4. Traverse list/tree and unlink matching node.
5. Update striped count.

Like `put`, remove contention is mostly localized to a single bin.

### Tree bin details under high collision

- Long linked-list bins can be converted to tree bins (`TreeBin`) for faster worst-case lookups.
- Tree bins in `ConcurrentHashMap` include additional synchronization mechanics for safe concurrent updates.
- If collisions reduce (for example after resize), bins can be untreeified back to linked list form.

### Atomic APIs and when to use them

Use atomic map operations instead of manual read-modify-write:

```java
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

map.putIfAbsent("count", 0);
map.compute("count", (k, v) -> v == null ? 1 : v + 1);
map.merge("count", 1, Integer::sum);
```

Why: they execute atomically for that key and avoid race conditions.

### Common mistakes to avoid

- Calling `get` then `put` for updates in concurrent code (non-atomic sequence).
- Using long/blocking logic inside `compute`/`merge` lambdas (can reduce throughput due to bin lock hold time).
- Assuming iteration is snapshot-consistent.
- Expecting `null` semantics similar to `HashMap`.

### Practical performance guidance

- Prefer immutable keys with stable `hashCode()`/`equals()`.
- Keep hash distribution healthy to reduce bin contention.
- Avoid very expensive mapping functions in hot paths.
- For counters, `LongAdder` values in map can scale better than frequent integer boxing.

Example pattern:

```java
ConcurrentHashMap<String, java.util.concurrent.atomic.LongAdder> freq = new ConcurrentHashMap<>();
freq.computeIfAbsent("api:/orders", k -> new java.util.concurrent.atomic.LongAdder()).increment();
```

### ConcurrentHashMap interview Q&A

**Q1: Why is `ConcurrentHashMap` faster than `Hashtable` in multi-threaded code?**  
A: It avoids single global lock contention by using lock-free reads + bin-level synchronization.

**Q2: Does `ConcurrentHashMap` lock on `get`?**  
A: Usually no. Most reads are lock-free (volatile/CAS-based visibility guarantees).

**Q3: Why are `null` keys/values disallowed?**  
A: It avoids ambiguity in concurrent lookups (`null` could mean missing key or mapped `null`).

**Q4: Is `size()` always exact?**  
A: Under concurrent updates it may require retries/aggregation and can be transiently approximate.

**Q5: What happens during resize while threads are writing?**  
A: Writers may help transfer bins; forwarding markers redirect operations to the new table.

**Q6: Are iterators fail-fast?**  
A: No. They are weakly consistent and tolerate concurrent modification.

