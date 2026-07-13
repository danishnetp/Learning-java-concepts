# Java 12 Features

Java 12 was released in March 2019 (JDK 12). It is a feature release (not LTS).
It brings several language enhancements and preview features.

---

## 1) Switch Expressions (Preview)
- Switch can be used as an expression with a value, not just a statement.
- Introduces arrow syntax `->` for compact case labels.
- Supports pattern matching and multiple case labels.
- Must have a value for every possible input or use `default`.

```java
// Traditional switch statement
int numLetters = switch(day) {
    case MONDAY, FRIDAY, SUNDAY -> 6;
    case TUESDAY -> 7;
    case THURSDAY, SATURDAY -> 6;
    case WEDNESDAY -> 8;
};

// Yield for complex cases
String result = switch(day) {
    case MONDAY -> {
        // Complex logic
        yield "Start of week";
    }
    default -> "Other day";
};
```

## 2) String API: `String.indent(int)`
- Indents all lines of a string by a given number of spaces.
- Useful for code generation and formatted output.

```java
String text = "Line 1\nLine 2";
String indented = text.indent(4); // Add 4 spaces to each line
```

## 3) `String.transform(Function)`
- Terminal operation that applies a function to the entire string.
- Provides a convenient way to apply custom transformations.

```java
String result = "hello".transform(s -> s.toUpperCase() + "!");
// result: "HELLO!"
```

## 4) Teeing Collector
- `Collectors.teeing()` allows processing a stream into two different collectors
  and combining their results.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
var result = numbers.stream()
    .collect(Collectors.teeing(
        Collectors.summingInt(Integer::intValue),
        Collectors.counting(),
        (sum, count) -> "Sum: " + sum + ", Count: " + count
    ));
```

## 5) `Files.mismatch(Path, Path)`
- Finds the first position where two files differ.
- Returns -1L if files are identical.
- Useful for file comparison and verification.

```java
long mismatchPos = Files.mismatch(file1, file2);
if (mismatchPos == -1L) {
    // Files are identical
}
```

## 6) Microbenchmark Suite (JMH)
- Java Microbenchmark Harness becomes more integrated.
- Helps measure and tune JVM performance.

## 7) Shenandoah GC
- Low-latency garbage collector with pause times < 10ms.
- Available as experimental/preview feature.

## 8) Raw String Literals (Removed)
- Was planned as a preview feature but removed before Java 12 release.
- Text blocks are the long-term solution (Java 13+).

## 9) G1 GC Improvements
- G1 becomes more efficient with better parallelization.
- Full GC improvements continue from Java 11.

## 10) Abortable Mixed Collections
- G1 GC improvement for better heap management during mixed collection.

## 11) Deprecations and API Changes
- Some internal APIs deprecated.
- Module system refinements.

## 12) Compact Number Formatting
- `java.text.NumberFormat` supports compact number formats.
- Shows numbers like 1.2M instead of 1200000.

```java
var fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
System.out.println(fmt.format(1200000)); // "1.2M"
```

## 13) Generics, Arrays, and Lambda Improvements
- Improved type inference in nested contexts.
- Better handling of variance in generics.

---

## Sample classes in this project

- Switch expressions (preview): `SwitchExpressionDemo`
- String.indent(): `StringIndentDemo`
- String.transform(): `StringTransformDemo`
- Collectors.teeing(): `CollectorsTeeingDemo`
- Files.mismatch(): `FilesMismatchDemo`
- NumberFormat compact: `NumberFormatCompactDemo`
- GC improvements info: `GarbageCollectorImprovementsDemo`
- Runner: `Java12AllFeaturesRunner`

## Quick run

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java12.Java12AllFeaturesRunner
```

