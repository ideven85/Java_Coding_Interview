

- A module is a part of a software system that can be designed, implemented, tested, and reasoned about separately from the rest of the system. In this reading, we’ll focus on modules that are functions, represented by Java methods. In future readings we’ll broaden our view to think about larger modules, like a class with multiple interacting methods.

- A specification (or spec) describes the behavior of a module. For a function, the specification gives the types of the parameters and any additional constraints on them (e.g. sqrt’s parameter must be nonnegative). It also gives the type of the return value and how the return value relates to the inputs. In Java code, the specification consists of the method signature and the comment above it that describes what it does.

- A module has an implementation that provides its behavior, and clients that use the module. For a function, the implementation is the body of the method, and the clients are other code that calls the method. The specification of the module constrains both the client and the implementation. We’ll have much more to say about specifications, implementations, and clients a few classes from now.

- A test case is a particular choice of inputs, along with the expected output behavior required by the specification.

- A test suite is a set of test cases for a module.

