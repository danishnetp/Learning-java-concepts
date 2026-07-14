# Java Stream API - Interview Questions and Answers

## Q1: What is a Stream in Java?

**A:** A Stream in Java is a sequence of elements that supports functional-style operations such as filtering, mapping, sorting, and reducing. 
It is not a data structure; it is a pipeline used to process data from a source like a collection, array, or generator.

---

## Q2: What are the main benefits of the Stream API?

**A:** Main benefits are:

- less boilerplate code
- declarative programming style
- easy chaining of operations
- support for parallel processing
- better readability for collection transformations

---

## Q3: What are the 3 parts of a stream pipeline?

**A:** A stream pipeline has:

1. **Source** - collection, array, file lines, generator, range
2. **Intermediate operations** - `filter`, `map`, `sorted`, `distinct`
3. **Terminal operation** - `collect`, `forEach`, `reduce`, `count`

---

## Q4: What is the difference between collection and stream?

**A:**

- **Collection** stores data in memory.
- **Stream** processes data and does not store elements itself.
- Collections can be iterated many times.
- A stream is generally single-use and gets consumed after a terminal operation.

---

## Q5: Are streams lazy?

**A:** Yes, intermediate operations are lazy. They do not execute until a terminal operation is called.

Example:

```text
list.stream()
	.filter(x -> x > 10)
	.map(x -> x * 2);
```

Nothing runs until a terminal operation such as `collect()` or `count()` is added.

---

## Q6: What is the difference between intermediate and terminal operations?

**A:**

- **Intermediate operations** return another stream and are lazy.
- **Terminal operations** produce a final result or side effect and trigger execution.

Examples:

- Intermediate: `filter`, `map`, `sorted`, `distinct`
- Terminal: `collect`, `forEach`, `reduce`, `findFirst`

---

## Q7: Can a stream be reused?

**A:** No. Once a terminal operation is executed, the stream is consumed and cannot be reused.

---

## Q8: How do you create a stream in Java?

**A:** Common ways:

- `list.stream()`
- `list.parallelStream()`
- `Arrays.stream(array)`
- `Stream.of(1, 2, 3)`
- `IntStream.range(1, 5)`
- `Stream.generate(...)`
- `Stream.iterate(...)`

---

## Q9: What is the difference between `map()` and `flatMap()`?

**A:**

- `map()` transforms each input element into exactly one output element.
- `flatMap()` transforms each input element into zero, one, or many output elements and flattens them into a single stream.

Example idea:

- `map(List::size)` -> one size per list
- `flatMap(List::stream)` -> all nested elements into one stream

---

## Q10: What does `filter()` do?

**A:** `filter(Predicate)` keeps only the elements that satisfy the given condition.

---

## Q11: What does `peek()` do, and when should it be used?

**A:** `peek()` performs an action on each element while passing it through the stream unchanged. It is mainly used for debugging, logging, or tracing pipeline behavior.

It should not be used for important business side effects.

---

## Q12: What is the difference between `forEach()` and `forEachOrdered()`?

**A:**

- `forEach()` may not preserve encounter order in parallel streams.
- `forEachOrdered()` preserves order but may reduce parallel performance.

---

## Q13: What is `reduce()` in Stream API?

**A:** `reduce()` combines stream elements into a single result.

Examples:

- sum of numbers
- maximum value
- concatenating strings

Common forms:

- `reduce(BinaryOperator)`
- `reduce(identity, BinaryOperator)`
- `reduce(identity, accumulator, combiner)`

---

## Q14: What is the difference between `reduce()` and `collect()`?

**A:**

- `reduce()` is used for immutable reduction into a single value.
- `collect()` is used for mutable reduction, especially into collections, maps, summaries, or grouped results.

Examples:

- `reduce()` -> sum, max, concatenation
- `collect()` -> list, set, map, grouping, partitioning

---

## Q15: What does `collect()` do?

**A:** `collect()` gathers stream elements into a final result such as:

- `List`
- `Set`
- `Map`
- joined `String`
- grouped data
- summary statistics

It commonly uses the `Collectors` utility class.

---

## Q16: What are common `Collectors` methods?

**A:** Common collector methods are:

- `toList()`
- `toSet()`
- `toMap()`
- `joining()`
- `groupingBy()`
- `partitioningBy()`
- `counting()`
- `mapping()`
- `collectingAndThen()`
- `summingInt()` / `averagingInt()` / `summarizingInt()`

---

## Q17: What is `groupingBy()`?

**A:** `Collectors.groupingBy()` groups elements by a classifier function and returns a `Map`.

Example use case:

- group employees by department
- group students by grade

---

## Q18: What is `partitioningBy()`?

**A:** `Collectors.partitioningBy()` splits elements into two groups based on a boolean condition.

Result type is usually:

```text
Map<Boolean, List<T>>
```

---

## Q19: What is the difference between `findFirst()` and `findAny()`?

**A:**

- `findFirst()` returns the first element in encounter order.
- `findAny()` may return any element, especially useful in parallel streams for performance.

---

## Q20: What are primitive streams in Java?

**A:** Primitive streams are specialized streams for numeric primitive types:

- `IntStream`
- `LongStream`
- `DoubleStream`

They help avoid boxing and unboxing overhead.

---

## Q21: Why use `IntStream`, `LongStream`, or `DoubleStream` instead of `Stream<Integer>`?

**A:** Primitive streams are more efficient for numeric processing because they avoid boxing/unboxing and provide numeric helper methods like:

- `sum()`
- `average()`
- `min()`
- `max()`
- `summaryStatistics()`

---

## Q22: What is `Optional` in stream operations?

**A:** Some terminal operations may return `Optional` because a stream can be empty.

Examples:

- `findFirst()`
- `findAny()`
- `min()`
- `max()`
- `reduce(BinaryOperator)`

---

## Q23: What is the difference between `sorted()` and `distinct()`?

**A:**

- `sorted()` arranges elements in natural or custom order.
- `distinct()` removes duplicates based on `equals()` and `hashCode()`.

---

## Q24: What is a parallel stream?

**A:** A parallel stream processes elements using multiple threads, usually through the common fork-join pool.

You can create it using:

- `collection.parallelStream()`
- `stream.parallel()`

---

## Q25: Are parallel streams always faster?

**A:** No. Parallel streams are not always faster.

They are beneficial mainly when:

- data set is large
- work per element is substantial
- operations are CPU-bound
- there is little shared mutable state

They may be slower for small data, ordered pipelines, blocking work, or heavy coordination.

---

## Q26: What are the risks of parallel streams?

**A:** Risks include:

- thread contention
- wrong results with shared mutable state
- overhead for small tasks
- harder debugging
- ordering costs

---

## Q27: Is Stream API thread-safe?

**A:** A stream pipeline itself is not automatically thread-safe if you use shared mutable data in operations. Stateless and side-effect-free operations are safest, especially with parallel streams.

---

## Q28: Why should side effects be avoided in streams?

**A:** Side effects make code harder to reason about and can cause incorrect behavior, especially in parallel pipelines.

Bad practice example idea:

```text
List<String> result = new ArrayList<>();
list.stream().forEach(result::add);
```

Better:

```text
List<String> result = list.stream().collect(Collectors.toList());
```

---

## Q29: What is the difference between `stream()` and `parallelStream()`?

**A:**

- `stream()` creates a sequential stream.
- `parallelStream()` creates a parallel stream.

Sequential is usually easier to predict; parallel may improve performance for the right workload.

---

## Q30: What is encounter order in streams?

**A:** Encounter order is the natural order in which elements are seen from the source.

Examples:

- `List` usually has encounter order
- `HashSet` usually does not guarantee stable order

Operations like `forEachOrdered()` and `findFirst()` are affected by encounter order.

---

## Q31: What is a stateless operation in streams?

**A:** A stateless operation depends only on the current element, not on previously processed elements.

Examples:

- `map()`
- `filter()`

Stateful operations include:

- `sorted()`
- `distinct()`

---

## Q32: Why is `sorted()` considered a stateful intermediate operation?

**A:** Because it must see all required elements before it can produce fully sorted output.

---

## Q33: What is the difference between `limit()` and `skip()`?

**A:**

- `limit(n)` keeps only the first `n` elements.
- `skip(n)` ignores the first `n` elements.

---

## Q34: Can streams be infinite?

**A:** Yes. Streams created with `generate()` or `iterate()` can be infinite.

Example:

```text
Stream.iterate(1, n -> n + 1)
```

Such streams should usually be controlled with `limit()`.

---

## Q35: What is the difference between `iterate()` and `generate()`?

**A:**

- `iterate()` creates elements based on the previous element.
- `generate()` creates elements independently using a supplier.

---

## Q36: What does `flatMap()` solve in real projects?

**A:** It is used to flatten nested collections or structures.

Examples:

- list of list of strings -> one stream of strings
- customers -> all phone numbers
- orders -> all order items

---

## Q37: What is `mapMulti()`?

**A:** `mapMulti()` is a newer stream operation that allows one input element to emit zero, one, or many output elements without creating inner stream objects like `flatMap()` does. It can be more efficient in some cases.

---

## Q38: What is `Spliterator`?

**A:** `Spliterator` is the underlying traversal and partitioning mechanism often used by streams, especially parallel streams.

It supports:

- traversing elements
- splitting work into parts
- describing source characteristics

---

## Q39: What is the role of `Collector`?

**A:** A `Collector` defines how elements are accumulated into a final result during `collect()`.

It conceptually includes:

- supplier
- accumulator
- combiner
- finisher

---

## Q40: What is the difference between `anyMatch()`, `allMatch()`, and `noneMatch()`?

**A:**

- `anyMatch()` -> true if at least one element matches
- `allMatch()` -> true if all elements match
- `noneMatch()` -> true if no element matches

These are short-circuiting terminal operations.

---

## Q41: What is short-circuiting in Stream API?

**A:** A short-circuiting operation can finish without processing all elements.

Examples:

- `findFirst()`
- `findAny()`
- `anyMatch()`
- `allMatch()`
- `noneMatch()`
- `limit()`

---

## Q42: Why is `collect(Collectors.toList())` common?

**A:** Because after transforming or filtering data, we often want the result back as a list. It is one of the most common terminal operations in real-world stream usage.

---

## Q43: What is the difference between `Collectors.toList()` and `Stream.toList()`?

**A:**

- `Collectors.toList()` is available since Java 8.
- `Stream.toList()` was added later (Java 16).
- `Stream.toList()` typically returns an unmodifiable-style list implementation.

In Java 8-compatible code, `Collectors.toList()` is preferred.

---

## Q44: Can Stream API modify the original collection?

**A:** Stream operations typically do not modify the source collection. They process elements and produce results separately unless the code explicitly performs side effects.

---

## Q45: What are common interview examples for Stream API?

**A:** Very common examples are:

- filter even numbers
- sort strings
- count frequency using grouping
- group employees by department
- find duplicate elements
- flatten nested lists
- find max/min/sum
- convert list to map

---

## Q46: How do you find duplicates using streams?

**A:** A common approach is to use a helper set and filter repeated values, though this uses side effects and should be used carefully.

Safer interview explanation:

- use `groupingBy(..., counting())`
- then filter counts greater than 1

---

## Q47: How do you count element frequency using streams?

**A:** Example idea:

```text
Map<String, Long> freq = list.stream()
	.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
```

---

## Q48: How do streams improve readability?

**A:** They express *what* should happen instead of *how* to iterate manually. This reduces loops, temporary variables, and nested conditions for many data-processing tasks.

---

## Q49: When should you avoid streams?

**A:** Avoid streams when:

- logic is very simple and a loop is clearer
- there are many side effects
- debugging step-by-step control is critical
- performance is harmed by overusing abstractions in hot paths

---

## Q50: Give an interview one-liner for Stream API.

**A:** Java Stream API is a functional pipeline for processing data declaratively through lazy intermediate operations and terminal operations such as collect, reduce, and match.

---

## Quick interview recap

- Stream is not a collection; it is a processing pipeline.
- Intermediate operations are lazy.
- Terminal operations trigger execution.
- `map` transforms, `flatMap` flattens.
- `collect` is used for mutable reduction.
- Primitive streams improve numeric performance.
- Parallel streams help only for suitable workloads.
- Avoid side effects in stream pipelines.

