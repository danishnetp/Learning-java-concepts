# Java 8 Interface vs Abstract Class Examples

This folder contains Java 8 focused examples showing practical differences
between interfaces and abstract classes.

## Included examples

- `InterfaceFieldsExample`
  - Demonstrates that interface fields are always constants (`public static final`).
  - Shows abstract class fields as instance state with normal access control.
  - Output compares interface constant access and abstract class object state.

- `AbstractConstructorExample`
  - Demonstrates constructor support in abstract classes for shared initialization.
  - Highlights that interfaces define contracts, not constructor logic.
  - Uses a concrete task to show constructor-initialized values in action.

- `StaticMethodBehaviorExample`
  - Shows that both interfaces and abstract classes can have static methods.
  - Clarifies usage differences: interface static methods are not inherited,
	class static methods can be hidden by subclasses.
  - Output prints three variants to make call-site rules obvious.

- `DefaultMethodVsConcreteMethodExample`
  - Compares interface default methods and concrete methods inside abstract classes.
  - Shows how implementers/subclasses inherit reusable behavior in each model.
  - Output makes side-by-side behavior easy to read.

- `InitializerBlockExample`
  - Demonstrates static and instance initializer blocks in abstract classes.
  - Notes that interfaces cannot declare these blocks.
  - Output shows initialization counters after object creation.

- `FunctionalInterfaceLambdaExample`
  - Demonstrates lambda usage with a functional interface in Java 8.
  - Contrasts with abstract class instantiation via anonymous class.
  - Also shows a default method inside the functional interface.

- `ObjectMethodOverrideExample`
  - Shows interface limitation for `java.lang.Object` methods (`toString`, `equals`, `hashCode`).
  - Demonstrates abstract class override of `toString`.
  - Output combines a valid interface default method with class override behavior.

- `Java8InterfaceVsAbstractClassDemo`
  - Single entry point that executes all examples in sequence.
  - Useful for quick validation and learning-by-output.

## Design notes

- Examples are intentionally small and independent.
- Only Java 8-compatible language features are used in the example code.
- Each class includes a `demonstrate()` method to keep the runner simple.

## Quick run

From project root:

```powershell
.\gradlew.bat classes
java -cp build\classes\java\main com.learning.concepts.features.java8.Java8InterfaceVsAbstractClassDemo
```

