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

## 4) Sealed Classes (Second Preview)
- Continued as a preview feature with refinements.
- Restricts inheritance to explicitly permitted classes.

```java
public sealed class Shape permits Circle, Rectangle {}
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
- Runner: `Java16AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java16.demo.Java16AllFeaturesRunner
```

