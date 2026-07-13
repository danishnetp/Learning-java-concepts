# Java 20 Feature Samples

Each Java 20 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java20.demo`.

## Feature demos

- `PatternMatchingSwitchFourthPreviewInfoDemo20`
  - Summarizes pattern matching for `switch` (fourth preview).

- `RecordPatternsSecondPreviewInfoDemo20`
  - Summarizes record patterns (second preview).

- `VirtualThreadsSecondPreviewInfoDemo20`
  - Summarizes virtual threads (second preview).

- `StructuredConcurrencySecondIncubatorInfoDemo20`
  - Summarizes structured concurrency (second incubator).

- `ScopedValuesIncubatorInfoDemo20`
  - Summarizes scoped values (incubator).

- `ForeignFunctionMemorySecondPreviewInfoDemo20`
  - Summarizes Foreign Function & Memory API (second preview).

- `VectorApiFifthIncubatorInfoDemo20`
  - Summarizes Vector API fifth incubator update.

- `CoreRuntimeUpdatesInfoDemo20`
  - Summarizes core runtime/library/tooling updates.

- `Java20AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 20 is a feature release (not LTS).
- Several Java 20 features are preview/incubator and may change.
- Examples are concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java20.demo.Java20AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java20.demo.VirtualThreadsSecondPreviewInfoDemo20
```

