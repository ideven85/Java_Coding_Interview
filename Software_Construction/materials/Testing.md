# Phases of Testing

- A **module** is a part of a software system that can be designed, implemented, tested, and reasoned about separately from the rest of the system. In this reading, we’ll focus on modules that are functions, represented by Java methods. In future readings we’ll broaden our view to think about larger modules, like a class with multiple interacting methods.

- A **specification (or spec)** describes the behavior of a module. For a function, the specification gives the types of the parameters and any additional constraints on them (e.g. sqrt’s parameter must be nonnegative). It also gives the type of the return value and how the return value relates to the inputs. In Java code, the specification consists of the method signature and the comment above it that describes what it does.

- A module has an **implementation** that provides its behavior, and clients that use the module. For a function, the implementation is the body of the method, and the clients are other code that calls the method. The specification of the module constrains both the client and the implementation. We’ll have much more to say about specifications, implementations, and clients a few classes from now.

- A **test case** is a particular choice of inputs, along with the expected output behavior required by the specification.

- A **test suite** is a set of test cases for a module.

# Test First Programming


1) Spec: Write a specification for the function.
2) Test: Write tests that exercise the specification.
3) Implement: Write the implementation.
 

# Systematic testing
Rather than exhaustive, haphazard, or randomized testing, we want to test systematically. Systematic testing means that we are choosing test cases in a principled way, with the goal of designing a test suite with three desirable properties:

- **Correct**. A correct test suite is a legal client of the specification, and it accepts all legal implementations of the spec without complaint. This gives us the freedom to change how the module is implemented internally without necessarily having to change the test suite.

- **Thorough**. A thorough test suite finds actual bugs in the implementation, caused by mistakes that programmers are likely to make.

- **Small**. A small test suite, with few test cases, is faster to write in the first place, and easier to update if the specification evolves. Small test suites are also faster to run. You will be able to run your tests more frequently if your test suites are small and fast.