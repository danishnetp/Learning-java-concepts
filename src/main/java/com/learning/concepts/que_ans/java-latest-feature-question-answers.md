# Java 8 to Java 21 - Latest Feature Interview Questions and Answers

This file captures open/current interview questions across Java versions from Java 8 to Java 21.

---

## Java 8

**Q1: What are the most important features introduced in Java 8?**  
A: Lambda expressions, functional interfaces, Stream API, default/static interface methods, Optional, new Date/Time API, CompletableFuture.

**Q2: Why were default methods added in interfaces?**  
A: To evolve interfaces without breaking existing implementations.

**Q3: Why is Stream API important?**  
A: It enables declarative data processing pipelines with lazy intermediate operations.

---

## Java 9

**Q1: What is JPMS?**  
A: Java Platform Module System (`module-info.java`) for strong encapsulation and explicit dependencies.

**Q2: What stream enhancements came in Java 9?**  
A: `takeWhile`, `dropWhile`, `iterate(seed, hasNext, next)`, `Stream.ofNullable`.

**Q3: Why are `List.of/Set.of/Map.of` significant?**  
A: Compact immutable collection factories.

---

## Java 10

**Q1: What is `var` in Java 10?**  
A: Local variable type inference for local variables with initializer.

**Q2: Where can `var` not be used?**  
A: Fields, method parameters, return types.

**Q3: What new collection convenience methods were added?**  
A: `List.copyOf`, `Set.copyOf`, `Map.copyOf`.

---

## Java 11 (LTS)

**Q1: What are headline Java 11 features?**  
A: Standard HttpClient, new String APIs (`isBlank`, `lines`, `strip`, `repeat`), `Files.readString/writeString`, single-file source launch.

**Q2: Why is Java 11 HttpClient interview-relevant?**  
A: Modern synchronous/asynchronous HTTP client with HTTP/2 support.

**Q3: What major removals happened in Java 11?**  
A: Java EE and CORBA modules removed from JDK.

---

## Java 12

**Q1: What Java 12 language feature is commonly asked?**  
A: Switch expressions (preview).

**Q2: What is `Collectors.teeing`?**  
A: Combines results of two collectors in one pass.

---

## Java 13

**Q1: What is the key feature in Java 13?**  
A: Text Blocks (preview) and switch expression improvements (`yield`).

---

## Java 14

**Q1: What was finalized in Java 14?**  
A: Switch expressions.

**Q2: Which preview features appeared in Java 14?**  
A: Records (preview), pattern matching for `instanceof` (preview).

---

## Java 15

**Q1: What was finalized in Java 15?**  
A: Text Blocks.

**Q2: Which major feature was previewed?**  
A: Sealed classes (preview).

---

## Java 16

**Q1: What got finalized in Java 16?**  
A: Records and pattern matching for `instanceof`.

**Q2: Why are records important?**  
A: Concise immutable data carriers with generated methods.

---

## Java 17 (LTS)

**Q1: What major feature was finalized in Java 17?**  
A: Sealed classes.

**Q2: What preview feature is commonly asked from Java 17?**  
A: Pattern matching for switch (preview).

---

## Java 18

**Q1: What interview-relevant Java 18 feature is commonly discussed?**  
A: Simple Web Server (for local development/testing) and continuation of pattern matching previews.

---

## Java 19

**Q1: What is the most discussed Java 19 feature?**  
A: Virtual Threads (preview, Project Loom).

**Q2: What are virtual threads?**  
A: Lightweight threads for massive concurrency with thread-per-task style code.

---

## Java 20

**Q1: What is Java 20 mainly known for in interviews?**  
A: Further preview iterations (virtual threads, pattern matching, record patterns) ahead of Java 21 finalization.

---

## Java 21 (LTS)

**Q1: What are major finalized features in Java 21?**  
A: Virtual Threads, Record Patterns, Pattern Matching for switch, Sequenced Collections.

**Q2: Why are Virtual Threads a game changer?**  
A: Enable scalable blocking-style code with much higher concurrency than platform threads.

**Q3: What are Sequenced Collections?**  
A: Ordered collection APIs with explicit first/last semantics and reversible views.

---

## Cross-Version Current Interview Questions

**Q1: Which LTS versions should candidates know deeply today?**  
A: Java 8, 11, 17, and 21.

**Q2: What changed most from Java 8 to Java 21?**  
A: Language ergonomics (records, pattern matching), runtime/module model, modern HTTP API, and concurrency model via virtual threads.

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

