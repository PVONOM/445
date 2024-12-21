
public interface WordSearchInterface {


    /**
     * Check is there exists a path on a word search puzzle grid with strictly increasing adjacent alphabet letters from a start cell to an end cell.
     * A Word Search Puzzle is an n-by-n grid of lower-case English letters. Each cell in the grid can be represented by its row 
     * number and column number. Row numbers and column numbers are in the range 0 to n-1 inclusive, where n is the grid size.  
     * A cell is adjacent to another if it is next to it along any of the eight directions: N, NE, E, SE, S, SW, W, and NW.
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
