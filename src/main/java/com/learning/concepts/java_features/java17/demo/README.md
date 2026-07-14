# Java 17 Feature Samples

Each Java 17 feature is demonstrated in a separate class with its own
`main` method under package `com.learning.concepts.features.java17`.

## Feature demos

- `SealedClassesStandardDemo17`
  - Demonstrates sealed classes and sealed interfaces with working examples.

- `PatternMatchingSwitchPreviewInfoDemo17`
  - Explains pattern matching for switch (preview in Java 17).

- `RandomGeneratorApiDemo17`
  - Demonstrates the modern `java.util.random.RandomGenerator` API.

- `ForeignFunctionMemoryInfoDemo17`
  - Summarizes incubating foreign function/memory interop API.

- `StrongEncapsulationInfoDemo17`
  - Summarizes stronger encapsulation of JDK internals (JEP 403).

- `StrictFloatingPointInfoDemo17`
  - Summarizes restored always-strict floating-point semantics (JEP 306).

- `DeserializationFilterInfoDemo17`
  - Explains context-specific deserialization filter support (JEP 415).

- `AppletDeprecationInfoDemo17`
  - Summarizes Applet deprecation-for-removal context.

- `RmiActivationRemovalInfoDemo17`
  - Summarizes RMI Activation removal.

- `MetalPipelineInfoDemo17`
  - Summarizes Java2D Metal pipeline context on macOS.

- `Java17AllFeaturesRunner`
  - Runs all demos in sequence from one main method.

## Notes

- Java 17 is an LTS release.
- Some Java 17 features are preview/incubator and are documented via info demos.
- Examples are intentionally concise and learning-focused.

## Run all demos

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java17.Java17AllFeaturesRunner
```

## Run one demo

```powershell
java -cp build\classes\java\main com.learning.concepts.features.java17.RandomGeneratorApiDemo17
```

