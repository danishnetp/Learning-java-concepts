# Java 18 Feature Samples

Each Java 18 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java18.demo`.

## Feature demos

- `PatternMatchingSwitchPreviewDemo18`
  - Demonstrates pattern matching for switch (second preview in Java 18).

- `RecordPatternsPreviewDemo18`
  - Demonstrates record patterns with destructuring (first preview in Java 18).

- `TextBlocksStandardDemo18`
  - Demonstrates multi-line text blocks as a standard feature.

- `VirtualThreadsPreviewDemo18`
  - Demonstrates lightweight virtual threads (preview via Project Loom).

- `StructuredConcurrencyInfoDemo18`
  - Explains structured concurrency API (incubator).

- `ForeignFunctionMemoryInfoDemo18`
  - Summarizes Foreign Function & Memory API (second preview).

- `DeprecatedEnhancementsDemo18`
  - Demonstrates enhanced @Deprecated annotation with since and forRemoval.

- `Utf8CharsetDemo18`
  - Demonstrates UTF-8 as default charset on all platforms.

- `SimpleWebServerInfoDemo18`
  - Summarizes simple web server tool (incubator).

- `CodeReflectionInfoDemo18`
  - Summarizes code reflection API (incubator).

- `Java18AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 18 is a feature release (not LTS).
- Several features are preview/incubator and may change in future versions.
- Examples are intentionally concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java18.demo.Java18AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java18.demo.TextBlocksStandardDemo18
```


