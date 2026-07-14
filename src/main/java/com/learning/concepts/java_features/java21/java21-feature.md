# Java 21 Features

Java 21 was released in September 2023 (JDK 21). It is a Long-Term
Support (LTS) release and includes finalized language/platform features,
plus preview and incubator updates.

---

## 1) Virtual Threads (Standard)
- Virtual threads became a standard feature in Java 21 (JEP 444).
- Lightweight threads improve scalability for concurrent applications.
- Simplifies high-throughput server style programming.

```java
Thread.startVirtualThread(() -> System.out.println("virtual thread"));
```

## 2) Pattern Matching for `switch` (Standard)
- Finalized in Java 21 (JEP 441).
- Enables clearer type-based branching in switch expressions/statements.

```java
String result = switch (obj) {
    case String s -> "String: " + s;
    case Integer i -> "Integer: " + i;
    default -> "Unknown";
};
```

## 3) Record Patterns (Standard)
- Finalized in Java 21 (JEP 440).
- Supports concise deconstruction of record values in patterns.

```java
record Point(int x, int y) {}
if (obj instanceof Point(int x, int y)) {
    System.out.println(x + ", " + y);
}
```

## 4) Sequenced Collections (Standard)
- New Sequenced Collection APIs in Java 21 (JEP 431).
- Adds first/last element operations and reversed views.
- Covers `List`, ordered `Set`, and ordered `Map` types.

## 5) Generational ZGC (Standard)
- ZGC gains generational mode in Java 21 (JEP 439).
- Improves throughput and memory behavior for many workloads.

## 6) Key Encapsulation Mechanism (KEM) API (Standard)
- New cryptographic KEM API in Java 21 (JEP 452).
- Supports modern key encapsulation use cases in security protocols.

## 7) String Templates (Preview)
- Preview feature in Java 21 (JEP 430).
- Improves safe and readable string composition with embedded expressions.
- Requires preview flags when compiling/running on JDK 21.

## 8) Unnamed Patterns and Variables (Preview)
- Preview feature in Java 21 (JEP 443).
- Uses `_` for intentionally unused pattern variables.
- Helps reduce boilerplate and improve readability.

## 9) Unnamed Classes and Instance Main Methods (Preview)
- Preview feature in Java 21 (JEP 445).
- Simplifies beginner programs by reducing ceremony.

## 10) Scoped Values (Preview)
- Preview feature in Java 21 (JEP 446).
- Safer immutable context sharing alternative for some ThreadLocal usage.

## 11) Foreign Function & Memory API (Third Preview)
- Third preview in Java 21 (JEP 442).
- Continues safer native interop and off-heap memory access evolution.

## 12) Vector API (Sixth Incubator)
- Sixth incubator update in Java 21 (JEP 448).
- Continues SIMD-friendly vector computation improvements.

## 13) Prepare to Disallow Dynamic Agent Loading
- Java 21 introduces warnings to prepare stricter future behavior (JEP 451).
- Targets better integrity by default for JVM execution.

## 14) Deprecate Windows 32-bit x86 Port for Removal
- Java 21 deprecates the Windows 32-bit x86 port for removal (JEP 449).

---

## Sample classes in this project

- Virtual threads standard info: `VirtualThreadsStandardInfoDemo21`
- Pattern matching switch standard info: `PatternMatchingSwitchStandardInfoDemo21`
- Record patterns standard info: `RecordPatternsStandardInfoDemo21`
- Sequenced collections standard info: `SequencedCollectionsStandardInfoDemo21`
- Generational ZGC standard info: `GenerationalZgcStandardInfoDemo21`
- KEM API standard info: `KemApiStandardInfoDemo21`
- String templates preview info: `StringTemplatesPreviewInfoDemo21`
- Unnamed patterns/variables preview info: `UnnamedPatternsVariablesPreviewInfoDemo21`
- Unnamed classes/instance main preview info: `UnnamedClassesInstanceMainPreviewInfoDemo21`
- Scoped values preview info: `ScopedValuesPreviewInfoDemo21`
- Foreign function/memory third preview info: `ForeignFunctionMemoryThirdPreviewInfoDemo21`
- Vector API sixth incubator info: `VectorApiSixthIncubatorInfoDemo21`
- Dynamic agent loading warnings info: `DynamicAgentLoadingWarningInfoDemo21`
- Windows 32-bit x86 deprecation info: `Windows32BitX86DeprecationInfoDemo21`
- Runner: `Java21AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java21.demo.Java21AllFeaturesRunner
```

