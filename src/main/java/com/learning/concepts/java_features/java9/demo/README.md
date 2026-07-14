# Java 9 Feature Samples

Each Java 9 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java9`.

## Feature demos

- `ModuleSystemInfoDemo`
  - Explains Java 9 modules (JPMS) and prints runtime module information.

- `InterfacePrivateMethodDemo`
  - Shows private helper methods inside interfaces for reuse by default methods.

- `CollectionFactoryMethodsDemo`
  - Demonstrates immutable collection factory methods such as `List.of` and `Map.of`.

- `StreamEnhancementsDemo`
  - Covers `takeWhile`, `dropWhile`, `Stream.ofNullable`, and the new `iterate` overload.

- `OptionalEnhancementsDemo`
  - Demonstrates `ifPresentOrElse`, `or`, and `Optional.stream()`.

- `TryWithResourcesEnhancementDemo`
  - Shows using an effectively-final resource variable directly inside `try (...)`.

- `DiamondWithAnonymousClassDemo`
  - Demonstrates the diamond operator with an anonymous class.

- `EnhancedDeprecatedDemo`
  - Shows `@Deprecated(since = ..., forRemoval = ...)` metadata.

- `JShellInfoDemo`
  - Provides a quick overview of JShell and example commands.

- `HttpClientFeatureDemo`
  - Describes the newer HTTP client model associated with Java 9 evolution.

- `ProcessApiEnhancementsDemo`
  - Uses `ProcessHandle` to inspect current process information.

- `ReactiveStreamsFlowDemo`
  - Demonstrates the `Flow` API using `SubmissionPublisher` and a subscriber.

- `StackWalkerDemo`
  - Shows efficient stack-frame traversal with `StackWalker`.

- `VarHandleDemo`
  - Demonstrates typed variable access and atomic-style update operations.

- `JvmAndGcInfoDemo`
  - Summarizes JVM and GC changes such as `-Xlog` and G1 default GC.

- `MultiReleaseJarInfoDemo`
  - Explains version-specific classes inside one JAR.

- `JlinkJmodInfoDemo`
  - Introduces modular runtime image creation and module packaging tools.

- `AotCompilationInfoDemo`
  - Documents the experimental `jaotc` tool concept.

- `JavadocHtml5InfoDemo`
  - Summarizes JavaDoc output improvements in Java 9.

- `SecurityTlsInfoDemo`
  - Prints TLS-related environment details and security-oriented notes.

- `Java9AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Some Java 9 features are API features and are demonstrated with code.
- Some are tooling/runtime features, so the demos provide explanatory output
  instead of creating full production setups.
- All examples are intentionally small and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java9.Java9AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java9.StreamEnhancementsDemo
```

