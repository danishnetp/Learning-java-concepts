# Java 20 Features

Java 20 was released in March 2023 (JDK 20). It is a feature release
(not LTS) and continues Project Loom, pattern matching, and native interop
enhancements through preview and incubator updates.

---

## 1) Pattern Matching for `switch` (Fourth Preview)
- Continued preview evolution in Java 20 (JEP 433).
- Improves type-based branching in switch expressions/statements.
- Requires preview flags when compiling/running on JDK 20.

```java
String result = switch (obj) {
    case String s -> "String: " + s;
    case Integer i -> "Integer: " + i;
    default -> "Unknown";
};
```

## 2) Record Patterns (Second Preview)
- Refined as second preview in Java 20 (JEP 432).
- Supports concise deconstruction of record components.
- Requires preview flags when compiling/running on JDK 20.

```java
record Point(int x, int y) {}
if (obj instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);
}
```

## 3) Virtual Threads (Second Preview)
- Continued as second preview in Java 20 (JEP 436).
- Lightweight threads designed for scalable concurrency.
- Requires preview flags when compiling/running on JDK 20.

## 4) Structured Concurrency (Second Incubator)
- Continued incubator update in Java 20 (JEP 437).
- Groups related tasks into a single unit of work.
- Simplifies cancellation, error handling, and task lifecycle.

## 5) Scoped Values (Incubator)
- Introduced as incubator API in Java 20 (JEP 429).
- Offers safer immutable context propagation for call chains.
- Intended as a cleaner alternative for some ThreadLocal use cases.

## 6) Foreign Function & Memory API (Second Preview)
- Re-previewed in Java 20 (JEP 434).
- Improves safe native interop and off-heap memory access.
- Continues API refinement toward long-term stability.

## 7) Vector API (Fifth Incubator)
- Fifth incubator iteration in Java 20 (JEP 438).
- Enables explicit SIMD-style vector computations for performance workloads.

## 8) Core Libraries / Runtime Updates
- Ongoing library, runtime, and tooling improvements.
- Continued focus on performance, maintainability, and developer experience.

---

## Sample classes in this project

- Pattern matching switch fourth preview info: `PatternMatchingSwitchFourthPreviewInfoDemo20`
- Record patterns second preview info: `RecordPatternsSecondPreviewInfoDemo20`
- Virtual threads second preview info: `VirtualThreadsSecondPreviewInfoDemo20`
- Structured concurrency second incubator info: `StructuredConcurrencySecondIncubatorInfoDemo20`
- Scoped values incubator info: `ScopedValuesIncubatorInfoDemo20`
- Foreign function/memory second preview info: `ForeignFunctionMemorySecondPreviewInfoDemo20`
- Vector API fifth incubator info: `VectorApiFifthIncubatorInfoDemo20`
- Core runtime updates info: `CoreRuntimeUpdatesInfoDemo20`
- Runner: `Java20AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java20.demo.Java20AllFeaturesRunner
```

