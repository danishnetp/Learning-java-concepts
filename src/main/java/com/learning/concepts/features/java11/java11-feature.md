# Java 11 Features

Java 11 was released in September 2018 (JDK 11). It is a Long-Term Support (LTS) release.
It brings several language and library enhancements, plus important deprecations.

---

## 1) Local Variable Syntax for Lambda Parameters
- Lambda parameters can use `var`, introduced in Java 10, making them more consistent with
  local variables and allowing modifiers like `final`.

```java
// Java 11
(var x, var y) -> x + y

// With final
(final var x, final var y) -> x + y
```

## 2) String API Enhancements
- `String.isBlank()` - checks if string is empty or contains only whitespace
- `String.lines()` - returns a stream of lines from a multi-line string
- `String.strip()` - removes leading and trailing whitespace (Unicode-aware)
- `String.stripLeading()` - removes leading whitespace only
- `String.stripTrailing()` - removes trailing whitespace only
- `String.repeat(int)` - repeats the string n times

```java
String text = "  Hello  ";
text.isBlank();      // false
text.strip();        // "Hello"
"Java".repeat(3);    // "JavaJavaJava"
```

## 3) `java.nio.file.Files` API Enhancements
- `Files.readString(Path)` - reads a file into a String
- `Files.writeString(Path, String)` - writes a String to a file
- `Files.isSameFile()` - compares files for identity

```java
String content = Files.readString(Path.of("file.txt"));
Files.writeString(Path.of("out.txt"), "content");
```

## 4) Collection.toArray(IntFunction)
- Allows collection conversion to typed arrays with a function reference.

```java
List<String> list = List.of("a", "b", "c");
String[] array = list.toArray(String[]::new);
```

## 5) `Predicate.not()` static method
- Convenient way to negate predicates.

```java
List<String> items = List.of("a", "b", "c");
items.stream().filter(Predicate.not(String::isEmpty)).toList();
```

## 6) HttpClient (finalized from incubator)
- The HTTP client introduced as incubator in Java 9, 10 is now standard API in Java 11.
- Part of `java.net.http` module.

```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://example.com")).build();
```

## 7) Single File Source Code Execution
- Can run Java source files directly without compiling first with `java` command.
- Useful for scripts and quick prototyping.

```bash
java MyScript.java
```

## 8) Epsilon GC (Experimental)
- A garbage collector that does no actual collection — all memory is allocated and never freed.
- Useful for performance testing and extremely short-lived applications.

```bash
java -XX:+UseEpsilonGC MyApp
```

## 9) Z Garbage Collector (ZGC - Experimental)
- Low-latency garbage collector with pauses typically < 10ms.
- Supports heaps from 8MB to 16TB (experimental in Java 11).

## 10) Nest-Based Access Control
- Allows nested classes (inner classes) to access each other's private members more naturally.
- JVM feature; no direct syntax changes.

## 11) Dynamic Class-File Constants (`condy`)
- Lazy evaluation of constants in bytecode.

## 12) Deprecations and Removals
- Removed `java.xml.ws` (SOAP web services); moved to separate module.
- Removed `java.xml.bind` (JAXB); moved to separate module.
- Removed `java.corba` (CORBA).
- Deprecated `Thread.destroy()` and `Thread.stop()` variants.

## 13) Flight Recorder (JFR)
- Performance monitoring and diagnostics tool.
- Records JVM events with minimal overhead.

```bash
java -XX:+UnlockCommercialFeatures -XX:+FlightRecorder MyApp
```

## 14) ChaCha20 and Poly1305 Algorithms
- Support for modern stream cipher and MAC algorithms in Java security.

## 15) TLS 1.3 Support
- Full support for TLS 1.3 protocol in JSSE.

---

## Sample classes in this project

- Lambda var syntax: `LambdaVarSyntaxDemo`
- String enhancements: `StringEnhancementsDemo`
- Files API: `FilesApiEnhancementsDemo`
- Collection.toArray: `CollectionToArrayDemo`
- Predicate.not: `PredicateNotDemo`
- HttpClient: `HttpClientFinalizedDemo`
- Single-file source code info: `SingleFileSourceCodeInfoDemo`
- GC options info: `GarbageCollectorInfoDemo`
- Nest-based access info: `NestBasedAccessControlInfoDemo`
- Runner: `Java11AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java11.Java11AllFeaturesRunner
```

