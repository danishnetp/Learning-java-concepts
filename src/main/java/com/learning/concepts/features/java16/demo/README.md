# Java 16 Feature Samples

Each Java 16 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java16.demo`.

## Feature demos

- `RecordsStandardDemo16`
  - Demonstrates records (standard in Java 16).

- `PatternMatchingInstanceofStandardDemo16`
  - Demonstrates pattern matching for `instanceof` (standard in Java 16).

- `SealedClassesPreviewInfoDemo16`
  - Explains sealed classes in second preview state.

- `VectorApiInfoDemo16`
  - Summarizes Vector API incubator purpose.

- `ForeignLinkerApiInfoDemo16`
  - Summarizes Foreign Linker API incubator direction.

- `UnixDomainSocketInfoDemo16`
  - Highlights Unix-domain socket channel support.

- `ElasticMetaspaceInfoDemo16`
  - Explains metaspace elasticity improvements.

- `StrongEncapsulationInfoDemo16`
  - Summarizes strong encapsulation of JDK internals (JEP 396).

- `JpackageStandardInfoDemo16`
  - Shows jpackage usage (standard tool status).

- `RemovedAotGraalInfoDemo16`
  - Summarizes AOT and old Graal JIT experimental removal.

- `Java16AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 16 is a feature release (not LTS).
- Some features in Java 16 were still preview/incubator.
- Examples are concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java16.demo.Java16AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java16.demo.RecordsStandardDemo16
```

