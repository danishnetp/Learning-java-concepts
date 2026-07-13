# Java 19 Feature Samples

Each Java 19 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java19.demo`.

## Feature demos

- `PatternMatchingSwitchPreviewInfoDemo19`
  - Summarizes pattern matching for `switch` (third preview).

- `RecordPatternsPreviewInfoDemo19`
  - Summarizes record patterns (preview).

- `VirtualThreadsPreviewInfoDemo19`
  - Summarizes virtual threads (preview).

- `StructuredConcurrencyIncubatorInfoDemo19`
  - Summarizes structured concurrency (incubator).

- `ScopedValuesIncubatorInfoDemo19`
  - Summarizes scoped values (incubator).

- `ForeignFunctionMemoryPreviewInfoDemo19`
  - Summarizes Foreign Function & Memory API (preview).

- `VectorApiFourthIncubatorInfoDemo19`
  - Summarizes Vector API fourth incubator update.

- `LinuxRiscVPortInfoDemo19`
  - Summarizes Linux/RISC-V port support.

- `Java19AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 19 is a feature release (not LTS).
- Several Java 19 features are preview/incubator and may change.
- Examples are concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java19.demo.Java19AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java19.demo.VirtualThreadsPreviewInfoDemo19
```

