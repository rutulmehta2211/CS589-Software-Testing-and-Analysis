# CS589-Software-Testing-and-Analysis

## Final Project

In this project, the goal is to test the provided implementation of the account class. To test the account class, we are using following testing techniques.

1. Model-based testing Use the provided EFSM model to test the account class. Design test cases for the account class so that all 2-transition sequences testing criterion (all transition-pairs) is satisfied based on the provided EFSM, i.e., all 2- transition sequences are exercised during testing.

2. Default (ghost) transition testing Design a set of additional test cases so each default (ghost) transition in the EFSM is tested.

3. Multi-condition testing Use multiple condition testing to design additional test cases to test predicates of conditional statements in operations/methods. Notice that if a predicate contains only a simple condition, the multiple-condition testing is equivalent to the branch testing for this predicate.

Then, to determine the correctness/incorrectness of the test results, we will execute all the test cases in the test suite (TS.txt). During the execution of the test cases, the results produced by the Account class will be recorded/documented. On the basis of that we will validate the results and determine whether the Account class produced the correct result or the test failed (produced incorrect result). It is assumed that the provided EFSM represents the expected/correct behavior of the Account Class
