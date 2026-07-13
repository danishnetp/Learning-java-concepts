# Java 12 Feature Samples

Each Java 12 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java12`.

## Feature demos

- `SwitchExpressionDemo`
  - Shows switch expressions with arrow syntax and yield for complex cases.

- `StringIndentDemo`
  - Demonstrates `String.indent()` for adding indentation to multi-line strings.

- `StringTransformDemo`
  - Shows `String.transform()` method for applying functions to strings.

- `CollectorsTeeingDemo`
  - Demonstrates `Collectors.teeing()` for dual-stream collection.

- `FilesMismatchDemo`
  - Shows `Files.mismatch()` for finding first byte difference between files.

- `NumberFormatCompactDemo`
  - Demonstrates compact number formatting (1.2M vs 1200000).

- `GarbageCollectorImprovementsDemo`
  - Summarizes G1 improvements and Shenandoah GC introduction.

- `Java12AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 12 is a feature release (not LTS).
- Switch expressions are a preview feature in Java 12.
- Most examples use standard Java 12 APIs.
- All examples are intentionally small and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java12.Java12AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java12.SwitchExpressionDemo
```

