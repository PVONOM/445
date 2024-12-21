import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A5Test {
  private static Scanner scan;
  private WordSearchInterface ws;
  private char[][] puzzle;

  public static void main(String[] args) {

    A5Test a5 = new A5Test();
    scan = new Scanner(System.in);
    while (true) {
      switch (a5.menu()) {
        case 1:
          a5.readFromFile();
          break;
        case 2:
          a5.printPuzzle();
          break;
        case 3:
          a5.findPath();
          break;
        case 4:
          scan.close();
          System.exit(0);
          break;
        default:
          System.out.println("Incorrect option");
      }
      System.out.println("Press ENTER to continue ...");
      scan.nextLine();
    }
  }

  private void printPuzzle() {
    if (puzzle == null) {
      System.out.println("Please create a puzzle first.");
    } else {
      printPuzzle(puzzle);
    }
  }

  public A5Test() {
  }

  private void findPath() {
    if (ws == null) {
      System.out.println("Please create a puzzle first.");
    } else {
      printPuzzle(puzzle);
      System.out.println("Please enter row number of start cell:");
      int startRow = Integer.parseInt(scan.nextLine());
      System.out.println("Please enter col number of start cell:");
      int startCol = Integer.parseInt(scan.nextLine());
      System.out.println("Please enter row number of end cell:");
      int endRow = Integer.parseInt(scan.nextLine());
      System.out.println("Please col row number of end cell:");
      int endCol = Integer.parseInt(scan.nextLine());
      boolean solution = ws.isIncreasingSequencePossible(puzzle, startRow, startCol, endRow, endCol);
      if (solution) {
        System.out.println("A path with adjacent ordered letters can be found");
      } else {
        System.out.println("A path with adjacent ordered letters cannot be found");
      }
    }
  }

  private void printPuzzle(char[][] puzzle) {
    for (int i = 0; i < puzzle.length; i++) {
      for (int j = 0; j < puzzle.length; j++) {
        System.out.print(puzzle[i][j] + " ");
      }
      System.out.println();
    }
  }

  private void readFromFile() {
    System.out.println("Please enter filename:");
    String fileName = scan.nextLine();
    try (Scanner scan = new Scanner(new File(fileName))) {
      int size = scan.nextInt();
      scan.nextLine();
      puzzle = new char[size][size];
      for (int i = 0; i < size; i++) {
        String line = scan.nextLine();
        for (int j = 0; j < size; j++) {
          puzzle[i][j] = line.charAt(j);
        }
      }
      ws = new WordSearchPuzzle();
      System.out.println("Puzzle file loaded successfully!");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private int menu() {
    int choice = -1;
    System.out.println("*********************************");
    System.out.println("Welcome to Four Four Five Word Puzzle Program!");
    System.out.println("1. Read a puzzle from a file");
    System.out.println("2. Display the puzzle");
    System.out.println("3. Search for a path in the puzzle");
    System.out.println("4. Exit.");
    System.out.println("*********************************");

    while (true) {
      System.out.print("Please choose a menu option (1-4): ");
      try {
        choice = Integer.parseInt(scan.nextLine());
        break;
      } catch (Exception e) {
        System.out.println("Invalid input: " + e.getMessage());
      }
    }
    return choice;
  }
}