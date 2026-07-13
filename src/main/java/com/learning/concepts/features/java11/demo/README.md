# Java 11 Feature Samples

Each Java 11 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java11`.

## Feature demos

- `LambdaVarSyntaxDemo`
  - Uses `var` in lambda parameter declarations (Java 11 enhancement).

- `StringEnhancementsDemo`
  - Demonstrates `isBlank()`, `strip()`, `lines()`, and `repeat()`.

- `FilesApiEnhancementsDemo`
  - Shows `Files.readString()` and `Files.writeString()` convenience methods.

- `CollectionToArrayDemo`
  - Uses the new `Collection.toArray(IntFunction)` method.

- `PredicateNotDemo`
  - Demonstrates `Predicate.not()` for predicate negation.

- `HttpClientFinalizedDemo`
  - Shows the finalized HttpClient API (moved from incubator in Java 9/10).

- `SingleFileSourceCodeInfoDemo`
  - Explains direct Java source file execution with `java MyScript.java`.

- `GarbageCollectorInfoDemo`
  - Summarizes Epsilon GC and ZGC (experimental in Java 11).

- `NestBasedAccessControlInfoDemo`
  - Demonstrates nest-based access for inner classes.

- `Java11AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 11 is an LTS (Long-Term Support) release.
- Some features are API additions; others are JVM-level optimizations.
- All examples are intentionally small and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java11.Java11AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java11.StringEnhancementsDemo
```

