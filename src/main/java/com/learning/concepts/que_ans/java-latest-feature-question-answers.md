# Java 8 to Java 21 - Latest Feature Interview Questions and Answers

This file captures open/current interview questions across Java versions from Java 8 to Java 21.

---

## Java 8

**Q1: What are the most important features introduced in Java 8?**  
A: Lambda expressions, functional interfaces, Stream API, default/static interface methods, Optional, new Date/Time API, CompletableFuture.

Example:

```java
List<Integer> nums = Arrays.asList(1, 2, 3, 4);
List<Integer> evens = nums.stream()
	.filter(n -> n % 2 == 0)
	.collect(Collectors.toList());
```

**Q2: Why were default methods added in interfaces?**  
A: To evolve interfaces without breaking existing implementations.

Example:

```java
interface Printer {
	default void print(String msg) {
		System.out.println(msg);
	}
}
```

**Q3: Why is Stream API important?**  
A: It enables declarative data processing pipelines with lazy intermediate operations.

Example:

```java
List<String> names = Arrays.asList("alice", "bob");
List<String> upper = names.stream()
	.map(String::toUpperCase)
	.collect(Collectors.toList());
```

---

## Java 9

**Q1: What is JPMS?**  
A: Java Platform Module System (`module-info.java`) for strong encapsulation and explicit dependencies.

Example:

```java
module com.example.app {
	requires java.sql;
	exports com.example.api;
}
```

**Q2: What stream enhancements came in Java 9?**  
A: `takeWhile`, `dropWhile`, `iterate(seed, hasNext, next)`, `Stream.ofNullable`.

Example:

```java
List<Integer> list = Stream.of(1, 2, 3, 0, 4)
	.takeWhile(n -> n > 0)
	.collect(Collectors.toList());
// [1, 2, 3]
```

**Q3: Why are `List.of/Set.of/Map.of` significant?**  
A: Compact immutable collection factories.

Example:

```java
Set<String> roles = Set.of("ADMIN", "USER");
```

---

## Java 10

**Q1: What is `var` in Java 10?**  
A: Local variable type inference for local variables with initializer.

Example:

```java
var names = new ArrayList<String>();
```

**Q2: Where can `var` not be used?**  
A: Fields, method parameters, return types.

**Q3: What new collection convenience methods were added?**  
A: `List.copyOf`, `Set.copyOf`, `Map.copyOf`.

Example:

```java
List<String> copy = List.copyOf(Arrays.asList("A", "B"));
```

---

## Java 11 (LTS)

**Q1: What are headline Java 11 features?**  
A: Standard HttpClient, new String APIs (`isBlank`, `lines`, `strip`, `repeat`), `Files.readString/writeString`, single-file source launch.

Example:

```java
String text = "  hi  ".strip();
boolean blank = "   ".isBlank();
```

**Q2: Why is Java 11 HttpClient interview-relevant?**  
A: Modern synchronous/asynchronous HTTP client with HTTP/2 support.

Example:

```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder(URI.create("https://example.com")).build();
```

**Q3: What major removals happened in Java 11?**  
A: Java EE and CORBA modules removed from JDK.

---

## Java 12

**Q1: What Java 12 language feature is commonly asked?**  
A: Switch expressions (preview).

Example:

```java
int numLetters = switch (day) {
	case SATURDAY, SUNDAY -> 6;
	default -> 7;
};
```

**Q2: What is `Collectors.teeing`?**  
A: Combines results of two collectors in one pass.

Example:

```java
var result = Stream.of(1, 2, 3, 4)
	.collect(Collectors.teeing(
		Collectors.counting(),
		Collectors.summingInt(Integer::intValue),
		(count, sum) -> count + ":" + sum
	));
```

---

## Java 13

**Q1: What is the key feature in Java 13?**  
A: Text Blocks (preview) and switch expression improvements (`yield`).

Example:

```java
String json = """
	{
	  "name": "Java"
	}
	""";
```

---

## Java 14

**Q1: What was finalized in Java 14?**  
A: Switch expressions.

Example:

```java
String type = switch (code) {
	case 1 -> "ONE";
	case 2 -> "TWO";
	default -> "OTHER";
};
```

**Q2: Which preview features appeared in Java 14?**  
A: Records (preview), pattern matching for `instanceof` (preview).

Example:

```java
if (obj instanceof String s) {
	System.out.println(s.length());
}
```

---

## Java 15

**Q1: What was finalized in Java 15?**  
A: Text Blocks.

Example:

```java
String sql = """
	select *
	from users
	where id = 10
	""";
```

**Q2: Which major feature was previewed?**  
A: Sealed classes (preview).

Example:

```java
sealed interface Shape permits Circle, Rectangle {}
```

---

## Java 16

**Q1: What got finalized in Java 16?**  
A: Records and pattern matching for `instanceof`.

Example:

```java
record Point(int x, int y) {}
```

**Q2: Why are records important?**  
A: Concise immutable data carriers with generated methods.

Example:

```java
record Employee(String name, int age) {}
```

---

## Java 17 (LTS)

**Q1: What major feature was finalized in Java 17?**  
A: Sealed classes.

Example:

```java
sealed class Vehicle permits Car, Bike {}
final class Car extends Vehicle {}
non-sealed class Bike extends Vehicle {}
```

**Q2: What preview feature is commonly asked from Java 17?**  
A: Pattern matching for switch (preview).

Example idea:

```java
// switch (obj) { case String s -> ... }
```

---

## Java 18

**Q1: What interview-relevant Java 18 feature is commonly discussed?**  
A: Simple Web Server (for local development/testing) and continuation of pattern matching previews.

Example:

```bash
java -m jdk.httpserver
```

---

## Java 19

**Q1: What is the most discussed Java 19 feature?**  
A: Virtual Threads (preview, Project Loom).

Example:

```java
Thread.startVirtualThread(() -> System.out.println("hello"));
```

**Q2: What are virtual threads?**  
A: Lightweight threads for massive concurrency with thread-per-task style code.

Example use case:

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
	executor.submit(() -> callRemoteService());
}
```

---

## Java 20

**Q1: What is Java 20 mainly known for in interviews?**  
A: Further preview iterations (virtual threads, pattern matching, record patterns) ahead of Java 21 finalization.

Example idea:

```java
// More preview refinement before Java 21 finalization
```

---

## Java 21 (LTS)

**Q1: What are major finalized features in Java 21?**  
A: Virtual Threads, Record Patterns, Pattern Matching for switch, Sequenced Collections.

Example:

```java
try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
	executor.submit(() -> System.out.println("virtual thread task"));
}
```

**Q2: Why are Virtual Threads a game changer?**  
A: Enable scalable blocking-style code with much higher concurrency than platform threads.

Example use case:

```java
// HTTP call per request with virtual threads
```

**Q3: What are Sequenced Collections?**  
A: Ordered collection APIs with explicit first/last semantics and reversible views.

Example:

```java
SequencedSet<String> set = new LinkedHashSet<>();
String first = set.getFirst();
String last = set.getLast();
```

---

## Cross-Version Current Interview Questions

**Q1: Which LTS versions should candidates know deeply today?**  
A: Java 8, 11, 17, and 21.

**Q2: What changed most from Java 8 to Java 21?**  
A: Language ergonomics (records, pattern matching), runtime/module model, modern HTTP API, and concurrency model via virtual threads.

Example progression:

```text
Java 8  -> lambdas/streams
Java 9  -> modules
Java 11 -> HttpClient/String APIs
Java 16 -> records
Java 17 -> sealed classes
Java 21 -> virtual threads
```

**Q3: Why does preview vs finalized status matter in interviews?**  
A: Preview features are not stable contracts and require enabling flags; finalized features are production-ready.

**Q4: What migration talking points are important (8 -> 21)?**  
A:
- module encapsulation awareness
- removed modules/tools in newer JDKs
- code modernization with records/pattern matching
- concurrency redesign opportunities with virtual threads

---

## Quick one-liner

Java 8 introduced functional-style modern Java, Java 9-20 evolved language/runtime progressively, and Java 21 LTS finalized major features especially around concurrency and data modeling.

