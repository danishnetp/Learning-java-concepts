# Java Stream API - Complete Details

The Java Stream API provides a functional, declarative way to process data. A stream is **not** a data structure; 
it is a pipeline over a data source such as a collection, array, generator, file lines, or numeric range.

Streams are mainly used for:

- filtering data
- transforming data
- sorting
- aggregation
- grouping and partitioning
- parallel data processing

---

## 1) Core Stream concepts

### A stream pipeline has 3 parts

1. **Source**
   - `list.stream()`
   - `Arrays.stream(array)`
   - `Stream.of(...)`
   - `IntStream.range(...)`

2. **Intermediate operations**
   - `filter`
   - `map`
   - `sorted`
   - `distinct`

3. **Terminal operation**
   - `collect`
   - `forEach`
   - `reduce`
   - `count`

### Important properties

- **Lazy:** Intermediate operations do not run until a terminal operation is called.
- **Single-use:** A stream can be consumed only once.
- **Functional style:** Operations usually do not modify the source.
- **Possible parallelism:** Streams can run sequentially or in parallel.

---

## 2) Main packages involved

- `java.util.stream`
- `java.util.function`
- `java.util`

---

## 3) Main Stream interfaces and classes

### Core interfaces

#### `BaseStream<T, S extends BaseStream<T, S>>`

Parent interface for all stream types.

**Main methods:**

- `Iterator<T> iterator()`
- `Spliterator<T> spliterator()`
- `boolean isParallel()`
- `S sequential()`
- `S parallel()`
- `S unordered()`
- `S onClose(Runnable closeHandler)`
- `void close()`

#### `Stream<T>`

Generic object stream.

#### `IntStream`

Primitive stream for `int` values.

#### `LongStream`

Primitive stream for `long` values.

#### `DoubleStream`

Primitive stream for `double` values.

#### `Collector<T, A, R>`

Defines mutable reduction logic for `collect(...)`.

#### `Spliterator<T>`

Supports traversal and partitioning of elements, especially for parallel streams.

### Utility classes

#### `Collectors`

Factory methods for common collectors.

#### `StreamSupport`

Creates streams from `Spliterator` or custom traversal logic.

#### Summary statistics classes

- `IntSummaryStatistics`
- `LongSummaryStatistics`
- `DoubleSummaryStatistics`

---

## 4) Functional interfaces commonly used with Streams

### Generic functional interfaces

- `Predicate<T>` -> `boolean test(T t)`
- `Function<T, R>` -> `R apply(T t)`
- `Consumer<T>` -> `void accept(T t)`
- `Supplier<T>` -> `T get()`
- `UnaryOperator<T>` -> `T apply(T t)`
- `BinaryOperator<T>` -> `T apply(T a, T b)`
- `Comparator<T>` -> `int compare(T a, T b)`
- `BiConsumer<T, U>`
- `BiFunction<T, U, R>`
- `BiPredicate<T, U>`

### Primitive specializations often used with Streams

- `IntPredicate`
- `LongPredicate`
- `DoublePredicate`
- `IntFunction<R>`
- `LongFunction<R>`
- `DoubleFunction<R>`
- `ToIntFunction<T>`
- `ToLongFunction<T>`
- `ToDoubleFunction<T>`
- `IntConsumer`
- `LongConsumer`
- `DoubleConsumer`
- `IntSupplier`
- `LongSupplier`
- `DoubleSupplier`

---

## 5) Stream creation methods

### `Stream<T>` static factory methods

- `Stream.empty()`
- `Stream.of(T... values)`
- `Stream.ofNullable(T value)` *(Java 9+)*
- `Stream.builder()`
- `Stream.iterate(T seed, UnaryOperator<T> f)`
- `Stream.iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)` *(Java 9+)*
- `Stream.generate(Supplier<T> s)`
- `Stream.concat(Stream<? extends T> a, Stream<? extends T> b)`

### Collection/array based creation

- `collection.stream()`
- `collection.parallelStream()`
- `Arrays.stream(array)`

### Primitive stream creation

#### `IntStream`

- `IntStream.empty()`
- `IntStream.of(int... values)`
- `IntStream.range(int startInclusive, int endExclusive)`
- `IntStream.rangeClosed(int startInclusive, int endInclusive)`
- `IntStream.iterate(int seed, IntUnaryOperator f)`
- `IntStream.iterate(int seed, IntPredicate hasNext, IntUnaryOperator next)` *(Java 9+)*
- `IntStream.generate(IntSupplier s)`
- `IntStream.concat(IntStream a, IntStream b)`

#### `LongStream`

- `LongStream.empty()`
- `LongStream.of(long... values)`
- `LongStream.range(long startInclusive, long endExclusive)`
- `LongStream.rangeClosed(long startInclusive, long endInclusive)`
- `LongStream.iterate(long seed, LongUnaryOperator f)`
- `LongStream.iterate(long seed, LongPredicate hasNext, LongUnaryOperator next)` *(Java 9+)*
- `LongStream.generate(LongSupplier s)`
- `LongStream.concat(LongStream a, LongStream b)`

#### `DoubleStream`

- `DoubleStream.empty()`
- `DoubleStream.of(double... values)`
- `DoubleStream.iterate(double seed, DoubleUnaryOperator f)`
- `DoubleStream.iterate(double seed, DoublePredicate hasNext, DoubleUnaryOperator next)` *(Java 9+)*
- `DoubleStream.generate(DoubleSupplier s)`
- `DoubleStream.concat(DoubleStream a, DoubleStream b)`

---

## 6) `Stream<T>` intermediate methods

Intermediate operations return another stream and are lazy.

### Filtering / slicing

- `filter(Predicate<? super T> predicate)`
- `distinct()`
- `limit(long maxSize)`
- `skip(long n)`
- `takeWhile(Predicate<? super T> predicate)` *(Java 9+)*
- `dropWhile(Predicate<? super T> predicate)` *(Java 9+)*

### Mapping / transformation

- `map(Function<? super T, ? extends R> mapper)`
- `mapToInt(ToIntFunction<? super T> mapper)`
- `mapToLong(ToLongFunction<? super T> mapper)`
- `mapToDouble(ToDoubleFunction<? super T> mapper)`
- `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`
- `flatMapToInt(Function<? super T, ? extends IntStream> mapper)`
- `flatMapToLong(Function<? super T, ? extends LongStream> mapper)`
- `flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper)`
- `mapMulti(BiConsumer<? super T, ? super Consumer<R>> mapper)` *(Java 16+)*
- `mapMultiToInt(BiConsumer<? super T, ? super IntConsumer> mapper)` *(Java 16+)*
- `mapMultiToLong(BiConsumer<? super T, ? super LongConsumer> mapper)` *(Java 16+)*
- `mapMultiToDouble(BiConsumer<? super T, ? super DoubleConsumer> mapper)` *(Java 16+)*

### Sorting / inspection

- `sorted()`
- `sorted(Comparator<? super T> comparator)`
- `peek(Consumer<? super T> action)`

### Mode / configuration methods from `BaseStream`

- `sequential()`
- `parallel()`
- `unordered()`
- `onClose(Runnable closeHandler)`

---

## 7) `Stream<T>` terminal methods

Terminal operations consume the stream.

### Traversal

- `forEach(Consumer<? super T> action)`
- `forEachOrdered(Consumer<? super T> action)`
- `toArray()`
- `toArray(IntFunction<A[]> generator)`
- `toList()` *(Java 16+)*

### Reduction

- `reduce(T identity, BinaryOperator<T> accumulator)`
- `reduce(BinaryOperator<T> accumulator)`
- `reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`

### Mutable reduction / collecting

- `collect(Collector<? super T, A, R> collector)`
- `collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)`

### Aggregation / search

- `min(Comparator<? super T> comparator)`
- `max(Comparator<? super T> comparator)`
- `count()`
- `anyMatch(Predicate<? super T> predicate)`
- `allMatch(Predicate<? super T> predicate)`
- `noneMatch(Predicate<? super T> predicate)`
- `findFirst()`
- `findAny()`

---

## 8) Primitive stream methods

Primitive streams have all relevant base/intermediate/terminal methods plus extra numeric operations.

### Common extra methods on `IntStream`, `LongStream`, `DoubleStream`

- `sum()`
- `min()`
- `max()`
- `average()`
- `summaryStatistics()`
- `boxed()`

### Conversion methods

#### `IntStream`

- `asLongStream()`
- `asDoubleStream()`
- `boxed()`
- `map(IntUnaryOperator mapper)`
- `mapToObj(IntFunction<? extends U> mapper)`
- `mapToLong(IntToLongFunction mapper)`
- `mapToDouble(IntToDoubleFunction mapper)`
- `flatMap(IntFunction<? extends IntStream> mapper)`
- `filter(IntPredicate predicate)`
- `peek(IntConsumer action)`
- `sorted()`
- `distinct()`
- `limit(long maxSize)`
- `skip(long n)`
- `takeWhile(IntPredicate predicate)` *(Java 9+)*
- `dropWhile(IntPredicate predicate)` *(Java 9+)*
- `reduce(int identity, IntBinaryOperator op)`
- `reduce(IntBinaryOperator op)`
- `collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R, R> combiner)`
- `anyMatch(IntPredicate predicate)`
- `allMatch(IntPredicate predicate)`
- `noneMatch(IntPredicate predicate)`
- `findFirst()`
- `findAny()`

#### `LongStream`

- `asDoubleStream()`
- `boxed()`
- `map(LongUnaryOperator mapper)`
- `mapToObj(LongFunction<? extends U> mapper)`
- `mapToInt(LongToIntFunction mapper)`
- `mapToDouble(LongToDoubleFunction mapper)`
- `flatMap(LongFunction<? extends LongStream> mapper)`
- `filter(LongPredicate predicate)`
- `peek(LongConsumer action)`
- `sorted()`
- `distinct()`
- `limit(long maxSize)`
- `skip(long n)`
- `takeWhile(LongPredicate predicate)` *(Java 9+)*
- `dropWhile(LongPredicate predicate)` *(Java 9+)*
- `reduce(long identity, LongBinaryOperator op)`
- `reduce(LongBinaryOperator op)`
- `collect(Supplier<R> supplier, ObjLongConsumer<R> accumulator, BiConsumer<R, R> combiner)`
- `anyMatch(LongPredicate predicate)`
- `allMatch(LongPredicate predicate)`
- `noneMatch(LongPredicate predicate)`
- `findFirst()`
- `findAny()`

#### `DoubleStream`

- `boxed()`
- `map(DoubleUnaryOperator mapper)`
- `mapToObj(DoubleFunction<? extends U> mapper)`
- `mapToInt(DoubleToIntFunction mapper)`
- `mapToLong(DoubleToLongFunction mapper)`
- `flatMap(DoubleFunction<? extends DoubleStream> mapper)`
- `filter(DoublePredicate predicate)`
- `peek(DoubleConsumer action)`
- `sorted()`
- `distinct()`
- `limit(long maxSize)`
- `skip(long n)`
- `takeWhile(DoublePredicate predicate)` *(Java 9+)*
- `dropWhile(DoublePredicate predicate)` *(Java 9+)*
- `reduce(double identity, DoubleBinaryOperator op)`
- `reduce(DoubleBinaryOperator op)`
- `collect(Supplier<R> supplier, ObjDoubleConsumer<R> accumulator, BiConsumer<R, R> combiner)`
- `anyMatch(DoublePredicate predicate)`
- `allMatch(DoublePredicate predicate)`
- `noneMatch(DoublePredicate predicate)`
- `findFirst()`
- `findAny()`

---

## 9) Collector and `Collectors` details

### What `Collector` does

A collector defines how stream elements are accumulated into a final result.

Collector type parameters:

- `T` -> input element type
- `A` -> mutable accumulation type
- `R` -> final result type

### Important `Collector` components

- supplier
- accumulator
- combiner
- finisher
- characteristics

### Common `Collectors` factory methods

#### Collection builders

- `toList()`
- `toSet()`
- `toCollection(Supplier<C> collectionFactory)`
- `toUnmodifiableList()` *(Java 10+)*
- `toUnmodifiableSet()` *(Java 10+)*
- `toUnmodifiableMap(...)` *(Java 10+)*

#### Mapping and post-processing

- `mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)`
- `flatMapping(Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream)` *(Java 9+)*
- `filtering(Predicate<? super T> predicate, Collector<? super T, A, R> downstream)` *(Java 9+)*
- `collectingAndThen(Collector<T, A, R> downstream, Function<R, RR> finisher)`

#### String collectors

- `joining()`
- `joining(CharSequence delimiter)`
- `joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)`

#### Numeric collectors

- `counting()`
- `summingInt(ToIntFunction<? super T> mapper)`
- `summingLong(ToLongFunction<? super T> mapper)`
- `summingDouble(ToDoubleFunction<? super T> mapper)`
- `averagingInt(ToIntFunction<? super T> mapper)`
- `averagingLong(ToLongFunction<? super T> mapper)`
- `averagingDouble(ToDoubleFunction<? super T> mapper)`
- `summarizingInt(ToIntFunction<? super T> mapper)`
- `summarizingLong(ToLongFunction<? super T> mapper)`
- `summarizingDouble(ToDoubleFunction<? super T> mapper)`

#### Grouping / partitioning

- `groupingBy(Function<? super T, ? extends K> classifier)`
- `groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)`
- `groupingBy(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)`
- `groupingByConcurrent(...)`
- `partitioningBy(Predicate<? super T> predicate)`
- `partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)`

#### Map collectors

- `toMap(keyMapper, valueMapper)`
- `toMap(keyMapper, valueMapper, mergeFunction)`
- `toMap(keyMapper, valueMapper, mergeFunction, mapSupplier)`
- `toConcurrentMap(...)`

#### Reducing collectors

- `reducing(BinaryOperator<T> op)`
- `reducing(T identity, BinaryOperator<T> op)`
- `reducing(U identity, Function<? super T, ? extends U> mapper, BinaryOperator<U> op)`
- `minBy(Comparator<? super T> comparator)`
- `maxBy(Comparator<? super T> comparator)`

#### Tee collector

- `teeing(Collector<? super T, A1, R1> downstream1, Collector<? super T, A2, R2> downstream2, BiFunction<? super R1, ? super R2, R> merger)` *(Java 12+)*

---

## 10) `Spliterator` overview

`Spliterator` is the traversal mechanism often used underneath streams.

Important methods:

- `tryAdvance(Consumer<? super T> action)`
- `forEachRemaining(Consumer<? super T> action)`
- `trySplit()`
- `estimateSize()`
- `characteristics()`

Common characteristics:

- `ORDERED`
- `DISTINCT`
- `SORTED`
- `SIZED`
- `NONNULL`
- `IMMUTABLE`
- `CONCURRENT`
- `SUBSIZED`

---

## 11) Sequential vs parallel streams

### Sequential stream

Processes elements one by one in encounter order.

```java
List<Integer> result = numbers.stream()
	.filter(n -> n % 2 == 0)
	.map(n -> n * 2)
	.toList();
```

### Parallel stream

Processes data across multiple threads using the common fork-join pool.

```java
List<Integer> result = numbers.parallelStream()
	.filter(n -> n % 2 == 0)
	.map(n -> n * 2)
	.toList();
```

### Use parallel carefully

Good for:

- large data sets
- stateless operations
- CPU-heavy transformations

Avoid when:

- tasks are tiny
- ordering is critical and expensive to preserve
- shared mutable state exists
- operations block on I/O

---

## 12) Common examples

### Filter + map + collect

```java
List<String> names = people.stream()
	.filter(person -> person.getAge() >= 18)
	.map(Person::getName)
	.collect(Collectors.toList());
```

### Grouping

```java
Map<String, List<Employee>> byDepartment = employees.stream()
	.collect(Collectors.groupingBy(Employee::getDepartment));
```

### Counting by group

```java
Map<String, Long> countByDepartment = employees.stream()
	.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
```

### Flat map

```java
List<String> phones = customers.stream()
	.flatMap(customer -> customer.getPhoneNumbers().stream())
	.collect(Collectors.toList());
```

### Reduce

```java
int total = numbers.stream().reduce(0, Integer::sum);
```

---

## 13) Important rules and best practices

- Do not reuse a consumed stream.
- Prefer pure/stateless lambda expressions.
- Avoid modifying the source while streaming.
- Avoid shared mutable state inside `forEach` or parallel streams.
- Use primitive streams for numeric performance when possible.
- Use `collect(...)` instead of manually mutating external collections.
- Use `peek(...)` mainly for debugging, not business logic.
- Prefer `map` for one-to-one transformation and `flatMap` for one-to-many flattening.

---

## 14) Common mistakes

- Calling stream twice on the same consumed stream.
- Using `forEach` when `collect` or `map` is more appropriate.
- Using parallel streams on small inputs.
- Writing side effects inside intermediate operations.
- Forgetting that `sorted()` may be expensive.
- Using boxed streams when primitive streams would be better.

---

## 15) Important differences: `map` vs `flatMap` vs `mapMulti`

### `map`

One input -> one output.

### `flatMap`

One input -> zero, one, or many outputs through a nested stream.

### `mapMulti`

One input -> zero, one, or many outputs without creating an inner stream object each time.

---

## 16) Stream-related classes outside `java.util.stream`

These are also commonly used together with streams:

- `Optional<T>`
- `Comparator`
- `Arrays`
- `Collections`
- `Map.Entry`
- `Files.lines(Path)`
- `Pattern.splitAsStream(...)`
- `Random.ints()`, `Random.longs()`, `Random.doubles()`

---

## 17) Quick interview summary

- Stream is a pipeline, not a container.
- Intermediate operations are lazy.
- Terminal operations trigger execution.
- `map` transforms; `flatMap` flattens.
- `collect` performs mutable reduction.
- Primitive streams avoid boxing overhead.
- Parallel streams are powerful but not always faster.
- `Collectors.groupingBy` and `partitioningBy` are very common in real applications.

---

## 18) Related examples in this project

- `src/main/java/com/learning/concepts/features/java8/demo/stream/StreamSortingExample.java`
- `src/main/java/com/learning/concepts/features/java8/demo/stream/StreamIntegerSortingExample.java`
- `src/main/java/com/learning/concepts/features/java8/demo/stream/StreamReduceExample.java`
- `src/main/java/com/learning/concepts/features/java8/demo/stream/MapSortingExample.java`

