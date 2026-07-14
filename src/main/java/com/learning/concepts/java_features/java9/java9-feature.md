# Java 9 Features

This document lists the major Java 9 features across language, APIs,
platform, tools, and JVM/runtime improvements.

## 1) Java Platform Module System (JPMS)
- Introduced modules (`module-info.java`) to improve encapsulation and
  reliable dependency management.
- Key directives: `requires`, `exports`, `opens`, `uses`, `provides`.
- Supports strong encapsulation and smaller runtime images.

```java
module com.example.app {
    requires java.sql;
    exports com.example.api;
}
```

## 2) Interface private methods
- Interfaces can now declare `private` and `private static` methods.
- Useful for sharing logic between default methods.

## 3) Collection factory methods
- Convenient immutable collection creation methods:
  `List.of(...)`, `Set.of(...)`, `Map.of(...)`, `Map.ofEntries(...)`.

```java
List<String> names = List.of("A", "B", "C");
Map<Integer, String> map = Map.of(1, "one", 2, "two");
```

## 4) Stream API enhancements
- `takeWhile`, `dropWhile`, and new `iterate` overload with predicate.
- `Stream.ofNullable(...)` to safely create stream from nullable value.

## 5) Optional API enhancements
- Added `ifPresentOrElse`, `or`, and `stream` methods.

## 6) Try-with-resources improvement
- Can use effectively-final variables in try-with-resources without
  redeclaring them in `try (...)`.

```java
BufferedReader br = Files.newBufferedReader(path);
try (br) {
    System.out.println(br.readLine());
}
```

## 7) Diamond operator with anonymous classes
- Java 9 allows `<>` with anonymous inner classes in more cases.

## 8) Enhanced `@Deprecated`
- `@Deprecated` now supports `since` and `forRemoval`.

```java
@Deprecated(since = "9", forRemoval = true)
public void oldApi() {}
```

## 9) JShell (REPL)
- Interactive read-eval-print loop for quickly trying Java code.
- Tool command: `jshell`.

## 10) HTTP/2 client (incubator)
- New HTTP client API introduced as incubator in Java 9
  (`jdk.incubator.httpclient`).
- Supports HTTP/2 and WebSocket.

## 11) Process API improvements
- Better process management via `ProcessHandle`.
- Access process id, children, descendants, and lifecycle hooks.

## 12) Reactive Streams API
- Introduced `java.util.concurrent.Flow` interfaces:
  `Publisher`, `Subscriber`, `Subscription`, `Processor`.

## 13) Stack-Walking API
- Added `StackWalker` for efficient and flexible stack traversal.

## 14) Variable Handles
- Added `java.lang.invoke.VarHandle` as a modern alternative to some
  `sun.misc.Unsafe` use cases for atomic/ordered variable access.

## 15) Platform logging and JVM changes
- Unified JVM logging (`-Xlog`), replacing many old logging flags.
- G1 became the default garbage collector.
- Compact Strings to reduce memory usage for Latin-1 strings.
- Segmented code cache improvements.

## 16) Multi-Release JAR files
- Allows shipping version-specific class implementations in one JAR
  (`META-INF/versions/<version>`).

## 17) JDK/JRE image and tooling changes
- `jlink`: create custom runtime images.
- `jmod`: new packaging format for JDK modules.
- Modular runtime images replaced old monolithic rt.jar/tools.jar layout.

## 18) AOT compilation (experimental)
- Introduced `jaotc` (Ahead-Of-Time compiler) as an experimental feature.

## 19) JavaDoc updates
- JavaDoc output moved to HTML5 by default and added better search.

## 20) Security and protocol updates
- Updated TLS handling and stronger default security posture in JDK 9.

---

## Quick summary
Java 9's most important change is JPMS (modules). Other high-impact
updates include JShell, collection factory methods, stream/optional
enhancements, process API improvements, and tooling like `jlink`.

## Sample classes in this project

Each feature has its own class with a separate `main` method under
package `com.learning.concepts.features.java9`.

- JPMS overview: `ModuleSystemInfoDemo`
- Interface private methods: `InterfacePrivateMethodDemo`
- Collection factory methods: `CollectionFactoryMethodsDemo`
- Stream enhancements: `StreamEnhancementsDemo`
- Optional enhancements: `OptionalEnhancementsDemo`
- Try-with-resources enhancement: `TryWithResourcesEnhancementDemo`
- Diamond with anonymous classes: `DiamondWithAnonymousClassDemo`
- Enhanced `@Deprecated`: `EnhancedDeprecatedDemo`
- JShell overview: `JShellInfoDemo`
- HTTP client feature note: `HttpClientFeatureDemo`
- Process API: `ProcessApiEnhancementsDemo`
- Reactive Streams (`Flow`): `ReactiveStreamsFlowDemo`
- StackWalker: `StackWalkerDemo`
- VarHandle: `VarHandleDemo`
- JVM/GC changes note: `JvmAndGcInfoDemo`
- Multi-release JAR note: `MultiReleaseJarInfoDemo`
- jlink/jmod note: `JlinkJmodInfoDemo`
- AOT note: `AotCompilationInfoDemo`
- JavaDoc update note: `JavadocHtml5InfoDemo`
- Security/TLS note: `SecurityTlsInfoDemo`

Run all:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java9.Java9AllFeaturesRunner
```

