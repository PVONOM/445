# CS 0445 – Algorithms and Data Structures 1 – Assignment#1 [^1]

**Due: Friday, June 14th @ 11:59pm**

You should submit `ArrayDS.java` to GradeScope (the link is on
Canvas). You must also submit an Assignment Information Sheet `InfoSheet.md` as described in the Submission
Requirements section below.

**Late submission deadline: Sunday June 16th @11:59pm with 10% penalty per late day**

## TABLE OF CONTENTS

- [Overview](#overview)
- [ArrayDS](#ArrayDS)
- [Extra Credit](#Extra-Credit)
- [Submission Requirements](#submission-requirements)
- [Rubrics](#rubrics)

## OVERVIEW

**Purpose:** To refresh your Java programming skills, to emphasize the object-oriented programming
approach used in Java, and to practice working with Java arrays and generics. Specifically, you will work with control
structures, class-building, interfaces and generics to **create** an array-based
data structure that implements an Abstract Data Type (ADT).

- **Task:** To design and implement a generic class `ArrayDS<T>` that will act as a data structure for maintaining
sequences of Java Objects. Your `ArrayDS<T>` class will primarily implement **three** interfaces –
`SequenceInterface<T>`, `ReorderInterface`, and the Java standard `Comparable<ArrayDS<T>>`. The details of the first two interfaces are explained in the files `SequenceInterface.java` and `ReorderInterface.java`. **Read these files carefully before implementing
your `ArrayDS<T>` class.**


[^1]: Assignment adapted from Dr. John Ramirez’s CS 0445 class.


## ArrayDS

For the details on the functionality of your `ArrayDS<T>` class, carefully read the files
`SequenceInterface.java`, `ReorderInterface.java`, and `Assig1Test.java`. You must use the interface files as specified and **cannot remove/alter any of
the code that is already written in them**. There are different ways of implementing the
`SequenceInterface<T>` and `ReorderInterface` interface methods, some of which are more efficient than
others. Try to think of the best way of implementing these methods in this assignment, but the most
important thing at this point is getting them to work correctly. A lot of pencil and paper work is
recommended before actually starting to write your code. Later we will discuss the relative merits of
different implementations. Your `ArrayDS<T>` class header should be:

`public class ArrayDS<T extends Comparable<? super T>> implements SequenceInterface<T>, ReorderInterface, Comparable<ArrayDS<T>> {`

**Important Note: The primary data within your `ArrayDS<T>` class *must be* a **resizable** Java array, not an `ArrayList`. You may not use any predefined Java collection class (e.g., `ArrayList`) for your `ArrayDS<T>` data
fields.**

You must add instance variables and named constants inside the `ArrayDS<T>` class to keep the state of the ArrayDS<T> and to follow the secure programming practices we
mentioned in class.

To illustrate the semantics of the interface, let's have an example.

Let's take the sequence `9875732732` as an example. This is a sequence of `Integer` objects, which can be defined as follows:

```java
SequenceInterface<Integer> number = new ArrayDS<>();
```

Here are some properties of the sequence in the example above. Please match these with the methods
in `SequenceInterface.java` and `ReorderInterface.java`.

```java
size() == 10
isEmpty() == false
first() == 9
last() == 2
predecessor(7) == 8, 5, or 2
getFrequencyOf(3) == 2
itemAt(3) == 5
lastOccurrenceOf(7) == 7
number.append(0)
number.toString() == "98757327320"
number.prefix(1)
number.toString() == "198757327320"
number.insert(0, 2)
number.toString() == "1908757327320"
number.deleteHead()
number.toString() == "908757327320"
number.deleteTail()
number.toString() == "90875732732"
number.trim(5)
number.toString() == "908757"
number.cut(2, 3)
number.toString() == "907"
```

To implement the `Comparable` interface, your `ArrayDS` class must implement the following method.

```java
public int compareTo(ArrayDS<T> other){ ... }
```

Comparing two `ArrayDS` objects is done using a lexicographical comparison between the items contained in the objects. That is why we require the type parameter `T` to be `Comparable` to itself. For an example, take a look at the `ArrayDS` objects defined below and their comparisons.


```java
first.toString() == "abcabcd"
second.toString() == "abcabcd"
first.compareTo(second) == 0 //first equals second
second.deleteHead()
second.toString() == "bcabcd"
first.compareTo(second) < 0 //first < second because the first letter in second is 'b' whereas the corresponding letter in first is 'a'
```

Besides the methods of `SequenceInterface<T>`, `ReorderInterface`, and `Comparable`, you will also need to write the following constructors:

```java
public ArrayDS()
public ArrayDS(ArrayDS<T> other)
```

The first constructor initializes the underlying array to an array of a default size of your choice. The second constructor (copy constructor) initializes the `ArrayDS` object as a deep copy of the argument `other`.

Finally, you will need to override the following method:

`public String toString();`

This method will return a `String` that is the concatenation of all of the items in the Sequence without spaces. For example, if an `ArrayDS` object contains the numbers `1, 2, 3, 4, 5, 6`, toString() should output: `"123456"`.


After you have finished your coding of `ArrayDS<T>`, the `Assig1Test.java` file provided for you should compile and run correctly and should give output identical to the output shown in the file `A1Out.txt`. Please note that this statement doesn't suggest that you delay testing until you are done with all the methods of `ArrayDS`. Instead, you should use stubs and incrementally test your code using `Assig1Test.java` as you code up each of the methods. Think carefully about the order of implementing the methods of `ArrayDS` as _some methods can make other methods easier to implement_.


## Coding Style and Documentation

Please check [this guide](https://introcs.cs.princeton.edu/java/11style/) for directions regarding the expected coding style and documentation. For Javadoc comments, please refer to Appendix A of the textbook.

## EXTRA CREDIT

There are three methods denoted as EXTRA CREDIT in the interface files. Each method is worth 2 extra points.

## SUBMISSION REQUIREMENTS

The only source file that will be graded is:

1. `ArrayDS.java`

You must submit the above file together with an edited version of `InfoSheet.md`.

The idea from your submission is that the autograder can compile and run your code **from the command line** WITHOUT ANY additional files or changes, so be
sure to test them thoroughly before submitting it.

**Note: If you use an IDE such as NetBeans, Eclipse, or IntelliJ, to develop your programs, make sure
they will compile and run on the command line before submitting – this may require some
modifications to your program (such as removing some package information).**


## RUBRICS

Please note that if an autograder is available, its score will be used as a guidance for the TA, not as an official final score. Please also note that the autograder rubrics are the definitive rubrics for the assignment. The rubrics below will be used by the TA to assign partial credit in case your code scored less than 60% of the autograder score. If your code is manually graded for partial credit, the maximum you can get for the autograded part is 60%.

| Item | Grade |
|------|-------|
|Autograder Score| 93|
|Assignment Information Sheet and correct submission | 2 |
| Javadoc comments and coding style  | 5 |
| Extra credit  | 6 |