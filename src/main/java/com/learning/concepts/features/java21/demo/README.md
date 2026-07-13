# Java 21 Feature Samples

Each Java 21 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java21.demo`.

## Feature demos

- `VirtualThreadsStandardInfoDemo21`
  - Summarizes virtual threads (standard).

- `PatternMatchingSwitchStandardInfoDemo21`
  - Summarizes pattern matching for `switch` (standard).

- `RecordPatternsStandardInfoDemo21`
  - Summarizes record patterns (standard).

- `SequencedCollectionsStandardInfoDemo21`
  - Summarizes sequenced collections APIs (standard).

- `GenerationalZgcStandardInfoDemo21`
  - Summarizes generational ZGC support (standard).

- `KemApiStandardInfoDemo21`
  - Summarizes KEM API (standard).

- `StringTemplatesPreviewInfoDemo21`
  - Summarizes string templates (preview).

- `UnnamedPatternsVariablesPreviewInfoDemo21`
  - Summarizes unnamed patterns and variables (preview).

- `UnnamedClassesInstanceMainPreviewInfoDemo21`
  - Summarizes unnamed classes and instance main methods (preview).

- `ScopedValuesPreviewInfoDemo21`
  - Summarizes scoped values (preview).

- `ForeignFunctionMemoryThirdPreviewInfoDemo21`
  - Summarizes Foreign Function & Memory API (third preview).

- `VectorApiSixthIncubatorInfoDemo21`
  - Summarizes Vector API sixth incubator update.

- `DynamicAgentLoadingWarningInfoDemo21`
  - Summarizes dynamic agent loading warnings.

- `Windows32BitX86DeprecationInfoDemo21`
  - Summarizes Windows 32-bit x86 port deprecation.

- `Java21AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 21 is an LTS release.
- Some Java 21 features are preview/incubator and may change.
- Examples are concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java21.demo.Java21AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java21.demo.VirtualThreadsStandardInfoDemo21
```

