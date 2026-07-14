# Java 18 Features

Java 18 was released in March 2022 (JDK 18). It is a feature release (not LTS)
and includes several preview language features, JVM improvements, and API enhancements.

---

## 1) Pattern Matching for `switch` (Preview)
- Continues as second preview in Java 18 with enhancements.
- Extends pattern matching to switch expressions and statements.
- Reduces boilerplate in type-checking hierarchies.

```java
String result = switch (obj) {
    case String s -> "String: " + s;
    case Integer i -> "Integer: " + i;
    default -> "Unknown";
};
```

## 2) Record Patterns (Preview)
- First preview of record patterns in Java 18.
- Enables destructuring of records in pattern matching.
- Simplifies extraction of component values from nested records.

```java
record Point(int x, int y) {}
if (obj instanceof Point(int x, int y)) {
    System.out.println("Point: " + x + ", " + y);
}
```

## 3) Text Blocks (Standard)
- Text blocks are now a standard language feature.
- Finalized after preview in Java 13-17.
- Simplifies multi-line string handling.

```java
String json = """
    {
        "name": "John",
        "age": 30
    }
    """;
```

## 4) Virtual Threads (Preview)
- First preview of virtual threads via Project Loom.
- Lightweight, user-mode threads for highly concurrent applications.
- Simplifies async/concurrent programming compared to platform threads.

```java
Thread vt = Thread.ofVirtual().start(() -> System.out.println("Virtual!"));
```

## 5) Structured Concurrency (Incubator)
- First incubating API (part of Project Loom).
- Improves reliability of concurrent code through structured scopes.
- Simplifies cancellation and resource management.

## 6) Foreign Function & Memory API (Preview)
- Continues as second preview with refinements.
- Safer and more efficient alternative to JNI.
- Enables interop with native code without unsafe operations.

## 7) Deprecations and Removals

### @Deprecated Enhancements
- `@Deprecated` annotation now supports `since` and `forRemoval` parameters.
- Better control over deprecation messaging and timeline.

```java
@Deprecated(since = "18", forRemoval = true)
public void oldMethod() {}
```

### Removed: Finalization
- Finalization mechanism deprecated for removal.
- Encourages use of try-with-resources or other patterns.

## 8) UTF-8 by Default
- UTF-8 is now the default charset on all platforms.
- Simplifies cross-platform development.
- Removes platform-dependent character encoding behavior.

## 9) Simple Web Server (Incubator)
- Incubating single-file HTTP server in `jdk.httpserver` module.
- Useful for testing and static content serving.

```bash
jwebserver [-p 8000] [-d /path] [-b 127.0.0.1]
```

## 10) Code Reflection (Incubator)
- First incubating API for code reflection.
- Provides compile-time accessible reflection for classes.

## 11) Vectorization Improvements
- Continued evolution of Vector API (now in third incubator iteration).
- Performance improvements and API refinements.

## 12) JVM and Performance Improvements
- Automatic Generation of Heap Dumps on OutOfMemoryError
- Improved performance in various subsystems.

---

## Sample classes in this project

- Pattern matching switch: `PatternMatchingSwitchPreviewDemo18`
- Record patterns: `RecordPatternsPreviewDemo18`
- Text blocks standard: `TextBlocksStandardDemo18`
- Virtual threads preview: `VirtualThreadsPreviewDemo18`
- Structured concurrency info: `StructuredConcurrencyInfoDemo18`
- Foreign function/memory info: `ForeignFunctionMemoryInfoDemo18`
- Deprecated enhancements: `DeprecatedEnhancementsDemo18`
- UTF-8 charset: `Utf8CharsetDemo18`
- Simple web server info: `SimpleWebServerInfoDemo18`
- Code reflection info: `CodeReflectionInfoDemo18`
- Runner: `Java18AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java18.demo.Java18AllFeaturesRunner
```


