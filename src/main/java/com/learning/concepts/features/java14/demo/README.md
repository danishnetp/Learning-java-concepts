# Java 14 Feature Samples

Each Java 14 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java14`.

## Feature demos

- `SwitchExpressionsDemo14`
  - Demonstrates switch expressions (standardized in Java 14).

- `HelpfulNpeDemo14`
  - Demonstrates improved NullPointerException diagnostics.

- `PatternMatchingInstanceofDemo14`
  - Explains pattern matching for `instanceof` (preview in Java 14).

- `TextBlocksPreviewInfoDemo14`
  - Demonstrates text blocks (second preview in Java 14).

- `RecordsPreviewInfoDemo14`
  - Provides record feature overview (preview in Java 14).

- `JpackageToolInfoDemo14`
  - Shows packaging tool usage examples.

- `G1NumaInfoDemo14`
  - Summarizes G1 NUMA-aware memory allocation improvements.

- `JfrEventStreamingInfoDemo14`
  - Describes JFR event streaming support.

- `RemovedFeaturesInfoDemo14`
  - Summarizes removed CMS and Pack200 components.

- `Java14AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 14 is a feature release (not LTS).
- Several language/runtime features were preview in Java 14.
- Examples are intentionally concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java14.Java14AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java14.SwitchExpressionsDemo14
```

