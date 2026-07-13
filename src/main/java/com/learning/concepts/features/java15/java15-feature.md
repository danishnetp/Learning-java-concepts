# Java 15 Features

Java 15 was released in September 2020 (JDK 15). It is a feature release
(not LTS). Java 15 finalized some preview features and introduced new
preview/runtime capabilities.

---

## 1) Text Blocks (Standard)
- Text blocks became a standard feature in Java 15 (preview in Java 13/14).
- Multi-line strings are easier to read and maintain.
- This is the main String-related feature introduced/finalized in Java 15.

```java
String json = """
        {
          "name": "Ravi",
          "jdk": 15
        }
        """;
```

## 2) String utility methods in Java 15
- Java 15 did **not** introduce brand-new `String` methods such as
  `isBlank()`, `strip()`, `lines()`, `repeat()`, `indent()`, or
  `transform()`.
- Those methods were introduced in earlier releases:
  - Java 11: `isBlank`, `strip`, `stripLeading`, `stripTrailing`,
    `lines`, `repeat`
  - Java 12: `indent`, `transform`
- In Java 15, the major String improvement is that **Text Blocks became
  standard**, making multi-line string handling much easier.

## 3) Sealed Classes (Preview)
- Restrict which classes/interfaces can extend or implement a type.
- Useful for modeling controlled hierarchies.

```java
// Preview style
public sealed class Shape permits Circle, Rectangle {}
```

## 4) Hidden Classes
- New JVM feature for frameworks and dynamic language runtimes.
- Supports short-lived classes not discoverable as normal classes.

## 5) Records (Second Preview)
- Records continued in preview with refinements after Java 14 preview.

## 6) Pattern Matching for `instanceof` (Second Preview)
- Continued refinement of pattern matching syntax and flow analysis.

## 7) ZGC: Production Ready
- Z Garbage Collector moved from experimental to production-ready status.

## 8) Shenandoah GC Improvements
- Ongoing low-pause garbage collector improvements.

## 9) Remove Nashorn JavaScript Engine
- Nashorn and related `jjs` tool removed from JDK.

## 10) Remove RMI Activation
- Deprecated RMI Activation mechanism removed.

## 11) DatagramSocket / MulticastSocket Reimplementation
- Legacy networking internals modernized (JEP 373).

## 12) Edwards-Curve Digital Signature Algorithm (EdDSA)
- Added support for Ed25519/Ed448 signatures.

## 13) TLS and Crypto Enhancements
- Continued improvements in security providers and protocols.

## 14) Foreign-Memory Access API (Second Incubator)
- Continued evolution of safer off-heap/native memory APIs.

## 15) Helpful NullPointerException Enhancements (continued)
- Improvements and adoption of richer NPE diagnostics.

---

## Sample classes in this project

- Text blocks: `TextBlocksStandardDemo15`
- Sealed classes preview info: `SealedClassesPreviewInfoDemo15`
- Hidden classes info: `HiddenClassesInfoDemo15`
- Records preview info: `RecordsSecondPreviewInfoDemo15`
- Pattern matching preview info: `PatternMatchingSecondPreviewInfoDemo15`
- ZGC production-ready info: `ZgcProductionInfoDemo15`
- Nashorn removal info: `NashornRemovalInfoDemo15`
- RMI activation removal info: `RmiActivationRemovalInfoDemo15`
- DatagramSocket reimplementation info: `DatagramSocketReimplementationInfoDemo15`
- EdDSA info: `EdDSAInfoDemo15`
- Runner: `Java15AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java15.Java15AllFeaturesRunner
```

