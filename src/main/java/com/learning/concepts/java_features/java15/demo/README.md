# Java 15 Feature Samples

Each Java 15 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java15`.

## Feature demos

- `TextBlocksStandardDemo15`
  - Demonstrates text blocks (standardized in Java 15).

- `SealedClassesPreviewInfoDemo15`
  - Explains sealed classes preview syntax and intent.

- `HiddenClassesInfoDemo15`
  - Summarizes hidden classes for framework/runtime generation scenarios.

- `RecordsSecondPreviewInfoDemo15`
  - Covers records in second preview state.

- `PatternMatchingSecondPreviewInfoDemo15`
  - Explains second preview of pattern matching for `instanceof`.

- `ZgcProductionInfoDemo15`
  - Notes that ZGC is production-ready in Java 15.

- `NashornRemovalInfoDemo15`
  - Summarizes Nashorn engine/tool removal.

- `RmiActivationRemovalInfoDemo15`
  - Summarizes RMI Activation removal.

- `DatagramSocketReimplementationInfoDemo15`
  - Describes networking internals modernization (JEP 373).

- `EdDSAInfoDemo15`
  - Demonstrates EdDSA algorithm availability check.

- `Java15AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 15 is a feature release (not LTS).
- Several features in Java 15 were preview at that time.
- Examples are concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java15.Java15AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java15.TextBlocksStandardDemo15
```

