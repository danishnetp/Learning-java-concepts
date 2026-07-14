# Java 10 Features

Java 10 was released in March 2018 (JDK 10). It is a feature release
(not LTS). The most user-visible change is `var` for local variables.

---

## 1) Local Variable Type Inference (`var`)
- New reserved type name `var` lets the compiler infer the type of a
  local variable from its initializer.
- Reduces boilerplate without losing static typing.
- Only valid for local variables; not for fields, parameters, or
  return types.

```java
var names = new ArrayList<String>();
var count = 10;
var map = Map.of("a", 1);
```

## 2) Unmodifiable Collection copies (`List.copyOf`, `Set.copyOf`, `Map.copyOf`)
- Factory methods to create unmodifiable copies of existing collections.
- Changes to the original collection are not reflected in the copy.

```java
List<String> original = new ArrayList<>(List.of("a", "b"));
List<String> copy = List.copyOf(original);
```

## 3) `Collectors.toUnmodifiableList/Set/Map`
- Stream collectors that gather results into unmodifiable collections.

```java
List<Integer> result = stream.collect(Collectors.toUnmodifiableList());
```

## 4) `Optional.orElseThrow()`
- Zero-argument overload of `orElseThrow` that throws
  `NoSuchElementException` if no value is present.

```java
String value = Optional.of("Java10").orElseThrow();
```

## 5) `String` performance improvements (Compact Strings - internals)
- `String.chars()`, improved internal representation; mostly transparent.

## 6) Parallel Full GC for G1
- G1 garbage collector got parallel full GC, reducing worst-case pause
  times.

## 7) Application Class-Data Sharing (AppCDS)
- Extends CDS to allow application classes to be stored in the shared
  archive, reducing startup time and memory footprint.

```
java -Xshare:dump -XX:SharedClassListFile=classlist -XX:SharedArchiveFile=app.jsa -cp app.jar
java -Xshare:on -XX:SharedArchiveFile=app.jsa -jar app.jar
```

## 8) Thread-Local Handshakes
- JVM can stop individual threads for operations without doing a full
  stop-the-world pause.

## 9) Heap Allocation on Alternative Memory Devices
- JVM can allocate Java heap on user-specified alternative memory devices
  via `-XX:AllocateHeapAt`.

## 10) Root Certificates in OpenJDK
- OpenJDK now ships with a default set of root CA certificates (CA certs
  from Oracle's Java SE program), removing an earlier empty keystore.

## 11) Time-Based Release Versioning
- Java moved to a strict 6-month release cadence starting from Java 9/10.
- Version format: `$FEATURE.$INTERIM.$UPDATE.$PATCH` (e.g. `10.0.2`).

## 12) Removed and Deprecated APIs
- Removed deprecated methods in `Runtime`: `runFinalizersOnExit`.
- Various internal APIs cleaned up.

---

## Sample classes in this project

- `var` (local type inference): `LocalVariableTypeInferenceDemo`
- Unmodifiable copy factory methods: `UnmodifiableCollectionCopyDemo`
- Collectors toUnmodifiable: `CollectorsToUnmodifiableDemo`
- `Optional.orElseThrow()`: `OptionalOrElseThrowDemo`
- AppCDS and JVM flags info: `AppCdsInfoDemo`
- Thread-local handshakes info: `ThreadLocalHandshakeInfoDemo`
- Time-based versioning info: `TimeBasedVersioningInfoDemo`
- Root certificates info: `RootCertificatesInfoDemo`
- Runner: `Java10AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java10.Java10AllFeaturesRunner
```

