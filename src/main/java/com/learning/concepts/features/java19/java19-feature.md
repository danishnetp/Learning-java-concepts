# Java 19 Features

Java 19 was released in September 2022 (JDK 19). It is a feature release
(not LTS) and includes preview/incubator language and platform features,
along with portability and performance improvements.

---

## 1) Pattern Matching for `switch` (Third Preview)
- Continued preview evolution of pattern matching in `switch`.
- Supports clearer type-based branching in switch expressions/statements.
- Requires preview flags when compiling/running on JDK 19.

```java
String result = switch (obj) {
    case String s -> "String: " + s;
    case Integer i -> "Integer: " + i;
    default -> "Unknown";
};
```

## 2) Record Patterns (Preview)
- First preview in Java 19 (JEP 405).
- Allows deconstruction of record components during pattern checks.
- Reduces boilerplate when working with nested records.

```java
record Point(int x, int y) {}
if (obj instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);
}
```

## 3) Virtual Threads (Preview)
- Introduced as preview in Java 19 (JEP 425).
- Lightweight threads designed for high-throughput concurrent workloads.
- Requires preview flags in Java 19.

## 4) Structured Concurrency (Incubator)
- Introduced as incubator in Java 19 (JEP 428).
- Treats related concurrent tasks as one unit of work.
- Improves cancellation, error propagation, and lifecycle handling.

## 5) Scoped Values (Incubator)
- Introduced as incubator in Java 19 (JEP 429).
- Provides safer, immutable context sharing for call trees.
- Intended as a cleaner alternative to some ThreadLocal use cases.

## 6) Foreign Function & Memory API (Preview)
- Re-previewed in Java 19 (JEP 424).
- Safer and more maintainable native interop compared with JNI-heavy code.
- Continues to evolve toward a stable API.

## 7) Vector API (Fourth Incubator)
- Fourth incubator iteration in Java 19 (JEP 426).
- Supports explicit vector computations for predictable SIMD performance.

## 8) Linux/RISC-V Port
- Java 19 adds Linux/RISC-V port support (JEP 422).
- Improves portability across additional CPU architectures.

## 9) JVM/Tooling Updates
- Ongoing improvements in diagnostics, performance, and maintenance.
- Continues modernization of JDK internals and developer tooling.

---

## Sample classes in this project

- Pattern matching switch preview info: `PatternMatchingSwitchPreviewInfoDemo19`
- Record patterns preview info: `RecordPatternsPreviewInfoDemo19`
- Virtual threads preview info: `VirtualThreadsPreviewInfoDemo19`
- Structured concurrency incubator info: `StructuredConcurrencyIncubatorInfoDemo19`
- Scoped values incubator info: `ScopedValuesIncubatorInfoDemo19`
- Foreign function/memory preview info: `ForeignFunctionMemoryPreviewInfoDemo19`
- Vector API fourth incubator info: `VectorApiFourthIncubatorInfoDemo19`
- Linux/RISC-V port info: `LinuxRiscVPortInfoDemo19`
- Runner: `Java19AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java19.demo.Java19AllFeaturesRunner
```

