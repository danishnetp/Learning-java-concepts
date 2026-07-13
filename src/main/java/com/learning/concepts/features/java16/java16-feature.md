# Java 16 Features

Java 16 was released in March 2021 (JDK 16). It is a feature release
(not LTS) and includes several finalized language features and JVM/API
enhancements.

---

## 1) Records (Standard)
- Records became a standard language feature in Java 16.
- Designed for immutable data carriers with concise syntax.
- Compiler auto-generates constructor, accessors, `equals`, `hashCode`,
  and `toString`.

```java
record User(String name, int age) {}
```

## 2) String utility methods in Java 16
- Java 16 did **not** introduce brand-new `String` utility methods.
- Recent related methods were added in earlier versions:
  - Java 15: `formatted()`, `stripIndent()`, `translateEscapes()`
  - Java 12: `indent()`, `transform()`
  - Java 11: `isBlank()`, `strip()`, `lines()`, `repeat()`

## 3) Pattern Matching for `instanceof` (Standard)
- Finalized in Java 16 after preview in Java 14/15.
- Combines type check and cast into one operation.

```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

## 4) Sealed Classes and Interfaces (Second Preview)
- Continued as a preview feature with refinements.
- Restricts inheritance for both **classes** and **interfaces**.
- Uses `permits` clause to list allowed subclasses or implementers.
- Permitted classes/interfaces must be `final`, `sealed`, or `non-sealed`.

```java
// Sealed Class
public sealed class Shape permits Circle, Rectangle {}

// Sealed Interface
public sealed interface Vehicle permits Car, Bike {}
```

## 5) Vector API (Incubator)
- Introduced incubating API for explicit vector computations.
- Enables predictable SIMD-style operations for high-performance math.

## 6) Foreign Linker API (Incubator)
- First incubator for safer and more efficient native interop.
- Complements foreign memory access work.

## 7) Unix-Domain Socket Channels
- `java.nio.channels` support for Unix-domain sockets added.
- Enables local IPC with filesystem socket paths.

## 8) Elastic Metaspace
- JVM metaspace can return unused memory more aggressively.
- Reduces memory footprint in dynamic/classloading-heavy apps.

## 9) Strong Encapsulation of JDK Internals
- Strongly encapsulates JDK internals by default (JEP 396).
- Reflective access to internal APIs requires explicit opens/exports.

## 10) Packaging Tool (`jpackage`) (Standard)
- `jpackage` graduated from incubator and became standard.
- Creates native installers/app images for target platforms.

## 11) Value-Based Classes Warning Enhancements
- Additional warnings and guidance for identity-sensitive operations on
  value-based classes.

## 12) Remove Ahead-of-Time and Graal JIT Experimental Tools
- Removed experimental AOT and old Graal JIT integration from JDK builds.

## 13) Security and TLS Updates
- Ongoing security provider, TLS, and crypto algorithm updates.

## 14) Date/Time Formatting Enhancement: Day Period Pattern `B`
- Java 16 improved `DateTimeFormatter` support for localized day periods.
- Pattern letter `B` can produce values like morning, afternoon, evening,
  or night (locale-dependent), beyond basic AM/PM.

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B", Locale.ENGLISH);
String text = formatter.format(LocalTime.of(21, 0));
```

## 15) Stream API Enhancement: `Stream.toList()`
- Java 16 added `Stream.toList()` as a convenient terminal operation.
- It returns an unmodifiable `List` and removes the need for
  `collect(Collectors.toUnmodifiableList())` in common cases.

```java
List<String> names = Stream.of("A", "B", "C")
        .map(String::toLowerCase)
        .toList();
```

---

## Sample classes in this project

- Records standard: `RecordsStandardDemo16`
- Pattern matching standard: `PatternMatchingInstanceofStandardDemo16`
- Sealed classes preview info: `SealedClassesPreviewInfoDemo16`
- Vector API info: `VectorApiInfoDemo16`
- Foreign Linker info: `ForeignLinkerApiInfoDemo16`
- Unix-domain socket info: `UnixDomainSocketInfoDemo16`
- Elastic Metaspace info: `ElasticMetaspaceInfoDemo16`
- Strong encapsulation info: `StrongEncapsulationInfoDemo16`
- `jpackage` standard info: `JpackageStandardInfoDemo16`
- Removed AOT/Graal info: `RemovedAotGraalInfoDemo16`
- Date/Time formatter day-period enhancement: `DateTimeFormatterDayPeriodDemo16`
- Stream API enhancement: `StreamApiEnhancementsDemo16`
- Runner: `Java16AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java16.demo.Java16AllFeaturesRunner
```

