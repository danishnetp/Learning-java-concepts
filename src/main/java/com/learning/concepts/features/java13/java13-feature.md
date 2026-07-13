# Java 13 Features

Java 13 was released in September 2019 (JDK 13). It is a feature release
(not LTS) focused on preview language features, runtime improvements,
and tooling updates.

---

## 1) Text Blocks (Preview)
- Multi-line string literals were introduced as a preview feature.
- Improves readability for JSON, SQL, XML, and formatted text.
- Java 13 uses triple quotes and supports cleaner indentation handling.

```java
String json = """
        {
          "name": "Ravi",
          "version": 13
        }
        """;
```

## 2) Switch Expressions (Second Preview)
- Switch expressions continued as a preview in Java 13.
- Added `yield` for returning values from complex switch blocks.

```java
String message = switch (day) {
    case MONDAY -> "Start";
    default -> {
        yield "Other";
    }
};
```

## 3) `yield` Keyword in Switch Expressions
- Introduced to produce a value from a block case in switch expressions.
- Replaces older `break value` style from earlier preview iterations.

## 4) Dynamic CDS Archives
- Java 13 improves Class Data Sharing by supporting dynamic archive creation
  at application exit.
- Helps startup performance and memory sharing across JVM processes.

```bash
java -XX:ArchiveClassesAtExit=app.jsa -cp app.jar com.example.Main
java -XX:SharedArchiveFile=app.jsa -cp app.jar com.example.Main
```

## 5) ZGC: Uncommit Unused Memory
- ZGC can return unused heap memory to the operating system.
- Reduces memory footprint for applications with fluctuating workload.

## 6) Reimplement Legacy Socket API
- Legacy `java.net.Socket` / `ServerSocket` implementation was reworked.
- Maintains compatibility while modernizing internals and maintainability.

## 7) `FileSystems.newFileSystem(Path)` Convenience Method
- Simplifies creating file systems from paths (for example ZIP/JAR files).
- Reduces boilerplate when working with archive-based file systems.

## 8) `jpackage` Tool (Incubator)
- Adds a packaging tool for creating native installers/packages.
- Generates platform-specific artifacts such as `.msi`, `.pkg`, or `.deb`.

## 9) Unicode 12.1 Support
- Java 13 updated Unicode data support to version 12.1.

## 10) Garbage Collector and Runtime Refinements
- Additional G1 and ZGC tuning and reliability improvements.

## 11) Deprecations/Removals Context
- Continued cleanup of legacy and internal APIs across JDK releases.

---

## Sample classes in this project

- Text blocks: `TextBlocksDemo`
- Switch expressions + `yield`: `SwitchExpressionYieldDemo`
- `FileSystems.newFileSystem(Path)`: `FileSystemsPathDemo`
- Dynamic CDS info: `DynamicCdsInfoDemo`
- ZGC uncommit memory info: `ZgcUncommitInfoDemo`
- Legacy socket reimplementation info: `LegacySocketReimplementationInfoDemo`
- `jpackage` info: `JpackageInfoDemo`
- Unicode support info: `UnicodeSupportInfoDemo`
- Runner: `Java13AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java13.demo.Java13AllFeaturesRunner
```

