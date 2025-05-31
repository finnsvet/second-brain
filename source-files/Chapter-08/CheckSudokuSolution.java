import java.util.Scanner;

public class CheckSudokuSolution {

  public static void main(String[] args) {
    int[][] grid = readSolution();
    System.out.println("The solution is " + isValid(grid));
  }

  public static int[][] readSolution() {
    int[][] grid = new int[9][9];
    Scanner input = new Scanner(System.in);
    for (int row = 0; row < grid.length; ++row) {
      for (int col = 0; col < grid[row].length; ++col) {
        grid[row][col] = input.nextInt();
      }
    }
    return grid;
  }

  public static boolean isValid(int[][] grid) {
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        if (
          grid[i][j] < 1 || grid[i][j] > 9 || !isValid(i, j, grid)
        ) return false;
      }
    }
    return true;
  }

  public static boolean isValid(int i, int j, int[][] grid) {
    //check rows:
    for (int column = 0; column < grid[i].length; ++column) {
      if (column != j && grid[i][column] == grid[i][j]) return false;
    }
    // check columns
    for (int row = 0; row < grid.length; row++) {
      if (row != i && grid[row][j] == grid[i][j]) return false;
    }
    // check small 3*3 boxes
    for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; ++row) {
      for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; ++col) {
        if (
          !(row == i && col == j) && grid[row][col] == grid[i][j]
        ) return false;
      }
    }
    return true;
  }
}
