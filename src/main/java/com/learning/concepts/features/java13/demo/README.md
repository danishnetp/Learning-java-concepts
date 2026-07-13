# Java 13 Feature Samples

Each Java 13 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java13.demo`.

## Feature demos

- `TextBlocksDemo`
  - Demonstrates text blocks (preview in Java 13).

- `SwitchExpressionYieldDemo`
  - Demonstrates switch expressions and `yield`.

- `FileSystemsPathDemo`
  - Demonstrates archive file system handling via NIO APIs.

- `DynamicCdsInfoDemo`
  - Explains dynamic CDS archive creation and reuse.

- `ZgcUncommitInfoDemo`
  - Summarizes ZGC uncommit behavior.

- `LegacySocketReimplementationInfoDemo`
  - Explains Java 13 legacy socket implementation rewrite.

- `JpackageInfoDemo`
  - Provides jpackage command examples (incubator context).

- `UnicodeSupportInfoDemo`
  - Highlights Unicode support updates.

- `Java13AllFeaturesRunner`
  - Runs all demos in sequence.

## Notes

- Java 13 is a feature release (not LTS).
- Some language/runtime features were preview or incubator in Java 13.
- This project demonstrates concepts with runnable code and info samples.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java13.demo.Java13AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java13.demo.TextBlocksDemo
```

