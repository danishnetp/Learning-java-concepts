# Java 14 Features

Java 14 was released in March 2020 (JDK 14). It is a feature release
(not LTS). Java 14 includes one finalized language feature and several
important preview, runtime, and tooling enhancements.

---

## 1) Switch Expressions (Standard)
- Switch expressions became a standard feature in Java 14
  (preview in Java 12/13).
- Supports `->` labels and `yield` for block cases.

```java
int letters = switch (day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY -> 7;
    default -> {
        int value = 8;
        yield value;
    }
};
```

## 2) Helpful NullPointerExceptions
- JVM can show which variable/field in a null chain caused the NPE.
- Greatly improves debugging of null dereference issues.

## 3) Records (Preview)
- Records introduced as preview for concise immutable data carriers.
- Auto-generates constructor, accessors, `equals`, `hashCode`, `toString`.

```java
// Java 14 preview syntax
record User(String name, int age) {}
```

## 4) Pattern Matching for `instanceof` (Preview)
- Preview support to combine type check and cast in one step.

```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

## 5) Text Blocks (Second Preview)
- Multi-line string literals continued in second preview state.
- Standardized later in Java 15.

## 6) Packaging Tool (`jpackage`) Incubator
- `jpackage` added to create native app images/installers.
- Supports platform-specific packaging flows.

## 7) G1 GC: NUMA-Aware Memory Allocation
- G1 improved by considering NUMA memory locality on large systems.
- Better throughput/latency in some multi-socket environments.

## 8) JFR Event Streaming
- Java Flight Recorder gains event streaming support.
- Enables near-real-time monitoring pipelines.

## 9) ZGC on macOS and Windows
- ZGC support expanded beyond Linux.

## 10) Removal of CMS Garbage Collector
- Concurrent Mark Sweep (CMS) GC removed.
- G1, ZGC, Shenandoah are modern alternatives.

## 11) Removal of Pack200 Tools/API
- `pack200` and `unpack200` tools and related API removed.

## 12) Foreign-Memory Access API (Incubator)
- New incubating API for safer access to off-heap/native memory.

---

## Sample classes in this project

- Switch expressions: `SwitchExpressionsDemo14`
- Helpful NPE: `HelpfulNpeDemo14`
- Pattern matching (`instanceof`): `PatternMatchingInstanceofDemo14`
- Text blocks info: `TextBlocksPreviewInfoDemo14`
- Records preview info: `RecordsPreviewInfoDemo14`
- `jpackage` info: `JpackageToolInfoDemo14`
- G1 NUMA info: `G1NumaInfoDemo14`
- JFR streaming info: `JfrEventStreamingInfoDemo14`
- Removals (CMS/Pack200): `RemovedFeaturesInfoDemo14`
- Runner: `Java14AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java14.Java14AllFeaturesRunner
```

