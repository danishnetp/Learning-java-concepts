# Java 17 Features

Java 17 was released in September 2021 (JDK 17). It is a Long-Term
Support (LTS) release and a major milestone with finalized language
features, stronger security defaults, and JVM/API improvements.

---

## 1) Sealed Classes and Interfaces (Standard)
- Sealed classes and interfaces are now a standard language feature in Java 17.
- Finalized after being a preview in Java 15/16.
- Lets you explicitly control which classes can extend or which interfaces can implement a type.
- Uses the `permits` clause to list allowed subclasses or implementers.
- Permitted types must be declared as `final`, `sealed`, or `non-sealed`.
- Works for both **sealed classes** and **sealed interfaces**.

```java
// Sealed Class
public sealed class Animal permits Dog, Cat {}

// Sealed Interface
public sealed interface Shape permits Circle, Rectangle {}
```

## 2) Pattern Matching for `switch` (Preview)
- Introduced as a preview feature in Java 17.
- Extends pattern matching ideas to `switch` expressions/statements.

## 3) Enhanced Pseudo-Random Number Generators
- New `RandomGenerator` API (`java.util.random`) for modern PRNG usage.
- Includes multiple algorithm families and cleaner abstraction.

```java
RandomGenerator generator = RandomGenerator.of("L128X256MixRandom");
int value = generator.nextInt(100);
```

## 4) Foreign Function & Memory API (Incubator)
- Continued incubator evolution for safe native interop and off-heap access.
- Goal: reduce JNI complexity with safer alternatives.

## 5) Strong Encapsulation of JDK Internals (JEP 403)
- Deep reflection access to JDK internals is strongly restricted by default.
- Encourages migration away from unsupported internal APIs.

## 6) Restore Always-Strict Floating-Point Semantics (JEP 306)
- Restores consistently strict IEEE 754 behavior.
- Simplifies mental model by removing old platform-dependent behavior.

## 7) Context-Specific Deserialization Filters (JEP 415)
- Adds better control over deserialization filtering policy composition.
- Improves security posture against unsafe deserialization.

## 8) Deprecate Applet API for Removal (JEP 398)
- Applet API deprecated for removal due to obsolescence and security concerns.

## 9) Remove RMI Activation (JEP 407)
- RMI Activation mechanism removed from Java 17.

## 10) macOS Metal Rendering Pipeline
- Java 2D pipeline on macOS can use Metal (modern graphics API).

## 11) New macOS/AArch64 Port
- Official support for Apple Silicon (AArch64) platform.

## 12) Security / TLS / Crypto Updates
- Continued updates across cryptographic providers and protocols.

---

## Sample classes in this project

- Sealed classes standard: `SealedClassesStandardDemo17`
- Pattern matching switch preview info: `PatternMatchingSwitchPreviewInfoDemo17`
- RandomGenerator API: `RandomGeneratorApiDemo17`
- Foreign function/memory info: `ForeignFunctionMemoryInfoDemo17`
- Strong encapsulation info: `StrongEncapsulationInfoDemo17`
- Strict floating-point semantics: `StrictFloatingPointInfoDemo17`
- Deserialization filter info: `DeserializationFilterInfoDemo17`
- Applet deprecation info: `AppletDeprecationInfoDemo17`
- RMI activation removal info: `RmiActivationRemovalInfoDemo17`
- Metal pipeline info: `MetalPipelineInfoDemo17`
- Runner: `Java17AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java17.Java17AllFeaturesRunner
```
