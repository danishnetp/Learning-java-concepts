# Stream Examples - Java 8

This folder contains practical examples demonstrating Java 8 Streams API features.

## Overview

Streams provide a functional style for processing sequences of elements. Each example below focuses on a specific stream capability.

## Examples

### 1. StreamSortingExample
**File:** `StreamSortingExample.java`

**Demonstrates:** Sorting strings in ascending and descending order using streams.

**Key concepts:**
- `sorted()` - natural order (ascending)
- `sorted(Comparator.reverseOrder())` - reverse order (descending)
- `collect(Collectors.toList())` - terminal operation to collect results

**Usage:**
```bash
java -cp ../../../build/classes/java/main \
    com.learning.concepts.features.java8.stream.StreamSortingExample
```

---

### 2. StreamIntegerSortingExample
**File:** `StreamIntegerSortingExample.java`

**Demonstrates:** Sorting integers using comparators for both ascending and descending order.

**Key concepts:**
- `Comparator.naturalOrder()` - natural numeric order
- `Comparator.reverseOrder()` - reverse numeric order
- Method references for comparators

**Usage:**
```bash
java -cp ../../../build/classes/java/main \
    com.learning.concepts.features.java8.stream.StreamIntegerSortingExample
```

---

### 3. StreamReduceExample
**File:** `StreamReduceExample.java`

**Demonstrates:** The reduce terminal operation for combining stream elements into a single result.

**Key concepts:**
- `reduce(identity, BinaryOperator)` - reduces with initial value
- `reduce(BinaryOperator)` - reduces without initial value (returns Optional)
- `Integer::sum` - method reference
- `Integer::max` - method reference for finding maximum

**Common use cases:**
- Summing all elements
- Finding max/min value
- Finding longest string
- Combining values with custom logic

**Usage:**
```bash
java -cp ../../../build/classes/java/main \
    com.learning.concepts.features.java8.stream.StreamReduceExample
```

---

### 4. MapSortingExample
**File:** `MapSortingExample.java`

**Demonstrates:** Sorting a Map by key and by value using stream operations.

**Key concepts:**
- `Map.Entry.comparingByKey()` - sort by key ascending
- `Map.Entry.comparingByKey(Comparator.reverseOrder())` - sort by key descending
- `Map.Entry.comparingByValue()` - sort by value ascending
- `Map.Entry.comparingByValue(Comparator.reverseOrder())` - sort by value descending
- `LinkedHashMap` - preserves insertion order
- `Collectors.toMap()` - collect back into a map

**Usage:**
```bash
java -cp ../../../build/classes/java/main \
    com.learning.concepts.features.java8.stream.MapSortingExample
```

---

## Stream Operations Reference

### Intermediate Operations (return Stream)
- `filter(Predicate)` - retains elements matching a condition
- `map(Function)` - transforms each element
- `flatMap(Function)` - flattens nested structures
- `distinct()` - removes duplicates
- `sorted()` - sorts elements
- `peek(Consumer)` - performs action without modifying
- `limit(long)` - limits number of elements
- `skip(long)` - skips first n elements

### Terminal Operations (consume Stream)
- `forEach(Consumer)` - performs action for each element
- `collect(Collector)` - gathers into collection/summary
- `reduce(BinaryOperator)` - combines into single result
- `count()` - returns number of elements
- `anyMatch(Predicate)` - true if any element matches
- `allMatch(Predicate)` - true if all elements match
- `noneMatch(Predicate)` - true if no elements match
- `findFirst()` - returns first element (Optional)
- `findAny()` - returns any element (Optional)
- `min(Comparator)` - returns minimum element
- `max(Comparator)` - returns maximum element

## Running All Examples

From the project root:

```bash
./gradlew.bat classes

java -cp build/classes/java/main com.learning.concepts.features.java8.stream.StreamSortingExample
java -cp build/classes/java/main com.learning.concepts.features.java8.stream.StreamIntegerSortingExample
java -cp build/classes/java/main com.learning.concepts.features.java8.stream.StreamReduceExample
java -cp build/classes/java/main com.learning.concepts.features.java8.stream.MapSortingExample
```

## Quick Reference

**Sort a list:**
```java
List<String> sorted = list.stream().sorted().collect(Collectors.toList());
```

**Sort in reverse:**
```java
List<String> reversed = list.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
```

**Reduce (sum):**
```java
int sum = numbers.stream().reduce(0, Integer::sum);
```

**Sort map by key:**
```java
Map<K, V> sorted = map.entrySet().stream()
    .sorted(Map.Entry.comparingByKey())
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, 
             (old, new) -> old, LinkedHashMap::new));
```

**Sort map by value:**
```java
Map<K, V> sorted = map.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
             (old, new) -> old, LinkedHashMap::new));
```

## Java 8 Compatibility

All examples in this folder are fully Java 8 compatible:
- Uses `Arrays.asList()` instead of `List.of()`
- Uses `Collectors.toList()` instead of `toList()`
- Uses `LinkedHashMap` for ordered map results
- No use of Java 9+ features

## Related Documentation

See `../java8-doc.txt` for comprehensive Java 8 features overview.

