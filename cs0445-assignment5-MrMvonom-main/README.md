# CS 0445 – Algorithms and Data Structures 1 – Assignment #5

You should submit the Java file `WordSearchPuzzle.java` to GradeScope (the link is on Canvas).
## Table of Contents

- [Overview](#overview)
- [Background](#background)
- [Find a path in the puzzle](#Find-a-path-in-the-puzzle)
- [Test Program](#test-program)
- [Submission Requirements](#submission-requirements)
- [Rubrics](#rubrics)

## Overview
 
* __Purpose__:  To understand and build a backtracking algorithm that checks for a path with **strictly increasing** letters inside a grid of lower-case letters, as detailed below.

You will implement the class `WordSearchPuzzle`, which implements the `WordSearchInterface` defined in `WordSearchInterface.java`. The interface has a single method, as specified below.

```java 
public interface WordSearchInterface {
    /**
     * Check if a path exists on a word search puzzle grid with strictly increasing adjacent alphabet letters from a start cell to an end cell.
     * A Word Search Puzzle is an n-by-n grid of lower-case English letters. Each cell in the grid can be represented by its row 
     * number and column number. Row and column numbers are 0 to n-1 inclusive, where n is the grid size.  
     * A cell is adjacent to another if it is next to it along any of the eight directions.
     * 
     * @param grid the 2-d array of letters representing a grid of letters. The grid should not be modified by the method.
     * @param startRow the int row number of the start cell (starting from 0)
     * @param startCol the int column number of the start cell (starting from 0)
     * @param endRow the int row number of the end cell
     * @param endCol the int column number of the end cell
     * @return true if a path with strictly increasing ordered alphabet letters can be found and false otherwise
     * @throws IndexOutOfBoundsException if either cell is outside the grid
     */
    public boolean isIncreasingSequencePossible(char[][] grid, int startRow, int startCol, int endRow, int endCol);
}

```

The class header is as follows.

```java
public class WordSearchPuzzle implements WordSearchInterface {
```


## Find a path in the puzzle
A Word Search puzzle is a 2-dimensional grid of lower-case English letters, such as the one below.

```
blnksreoomhs
eaocytsileot
stgarertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```

Each cell in the grid can be represented by its row and column numbers. Row and column numbers are in the range 0 to n-1 inclusive, where n is the grid size, 12 in the given example. For example, the up-left cell of the grid can be represented as `(0, 0)` because it is on the first row and the first column. The down-right cell is `(11, 11)`.

Your goal in this assignment is to check if we can move from one cell to another using adjacent letters without violating the alphabetic order of letters. For example, it is possible to move from `(0, 0)` to `(2, 1)` using adjacent cells and without violating the order of the alphabet as follows.

1. Start at `b` at `(0, 0)`
```
*B*lnksreoomhs
eaocytsileot
stgarertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```

2. Move to `l` at `(0, 1)`
```
B*L*nksreoomhs
eaocytsileot
stgarertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```

3. Move to `n` at `(0, 2)`
```
BL*N*ksreoomhs
eaocytsileot
stgarertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```

4. Move to `o` at `(1, 2)`
```
BLNksreoomhs
ea*O*cytsileot
stgarertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```

5. Move to `t` at `(2, 1)`
```
BLNksreoomhs
eaOcytsileot
s*T*garertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```
The sequence of the letters we visited on that path is `'b', 'l,' 'n,' 'o', 't'`, which represents a **strictly increasing** sequence of letters; that is, it doesn't violate the order of the alphabet.

```
BLNksreoomhs
eaOcytsileot
sTgarertrrgt
drltaswesgit
eoasnnogoebt
zsttiitnfser
inrjbioaholo
toquicksorts
risqueuertcl
otxdrchoeuel
mciaacuscrre
aelreprnnish
```

Note that the letters on the path are shown in upper-case for illustration only. Your code shouldn't change the grid. Also, note that each pair of consecutive letters is adjacent along one of the eight directions. The eight directions in clockwise order are right, down-right, down, down-left, left, up-left, up, and up-right.

**You must implement this search using backtracking.** 

Hint: define a private recursive helper method to perform backtracking and call it from your implementation of the `isIncreasingSequencePossible` method. An example helper method is:

```java
    private boolean solve(char[][] grid, int currentRow, int currentCol, int endRow, int endCol){
```

Please check the backtracking framework in the lecture notes and its explanation in the lecture videos.

## Test Program

You can use the test program `A5Test.java` to test your implementation. You can run the test program as follows:

```
> java A5Test 
```

You can find the output of an example run in the file `sample-output.txt`.

## Submission Requirements

You must submit your Github repository to GradeScope. We will only grade the following file:
1)	`WordSearchPuzzle.java`

_The idea from your submission is that your TA (and the autograder, if available) can compile and run your programs from the command line WITHOUT ANY additional files or changes, so be sure to test it thoroughly before submitting it. If the TA (and the autograder, if available) cannot compile or run your submitted code, it will be graded as if the program does not work.
If you cannot get the programs working as given, clearly indicate any changes you made and why on your Assignment Information Sheet.  You will lose some credit for not getting it to work properly, but getting the main programs to work with modifications is better than not getting them to work.  A template for the Assignment Information Sheet can be found in this repository. You do not have to use this template, but your sheet should contain the same information._

_Note: If you use an IDE, such as NetBeans, Eclipse, or IntelliJ, to develop your programs, make sure the programs will compile and run on the command line before submitting – this may require some modifications to your program (e.g., removing package information)._

## Rubrics 

Please note that if an autograder is available, its score will be used as guidance for the TA, not as an official final score. Please also note that the autograder rubrics are the definitive rubrics for the assignment. **This assignment has no manual grading except to detect code similarity or take points off if your code doesn't use backtracking**.
