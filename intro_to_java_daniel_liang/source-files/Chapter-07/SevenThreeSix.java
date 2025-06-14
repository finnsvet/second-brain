// My algroithm to implement the Eight Queens Puzzle.
// No 2 Queens must be ine the same row, colomn or diagonal
// Although this could be achieved with more sophistsicated object types
// to allieviate suffering; i hava chosen to suffer and limit myself to only
// what was taught in this chapter.

// NOTE: Algorithm now works, Problem noe is that i need to generate this
// multiple times until queen places have no empty positions

public class SevenThreeSix {

  public static void main(String[] args) {
    int[] queenPlaces = { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] solvedByOrder = new int[8];
    boolean unsolved = true;
    while (unsolved) {
      // check if queen has no empty position
      // if it does find another configuration
      solvedByOrder = placeQueens(queenPlaces);
      unsolved = checkIfSolved(solvedByOrder);
    }
    displaySolvedPuzzle(solvedByOrder);
  }

  public static int[] placeQueens(int[] queenPlaces) {
    // get firstqueen
    int firstQueenIndex = (int) (Math.random() * 8);
    queenPlaces[firstQueenIndex] = firstQueenIndex + 1;

    int level = 1;
    int[] levelOrder = { 0, 0, 0, 0, 0, 0, 0, 0 };
    levelOrder[level - 1] = queenPlaces[firstQueenIndex];
    ++level;

    for (; level <= queenPlaces.length; ++level) {
      int[] availableSpots = getAvailableSpots(
        getTakenSpots(queenPlaces, levelOrder, level)
      );
      if (availableSpots.length == 0) break;
      // find random spot in available spot then update queenPlaces with loop
      int randIndex = (int) (Math.random() * availableSpots.length);
      int queenRandPosition = availableSpots[randIndex];
      // fill that spot in queenPlaces
      queenPlaces[queenRandPosition - 1] = queenRandPosition;
      levelOrder[level - 1] = queenRandPosition;
    }
    // System.out.println(java.util.Arrays.toString(queenPlaces) + " done");
    return levelOrder;
  }

  // return taken spots in current level
  public static int[] getTakenSpots(
    int[] queenPlaces,
    int[] levelOrder,
    int currentLevel
  ) {
    int[] filled = new int[8];

    // eleminate collsion in same coloumn
    // cuurentLevel is the same as the filled spots in filled array
    for (int i = 0; i < levelOrder.length; i++) if (levelOrder[i] != 0) {
      filled[i] = levelOrder[i];
    }

    // System.out.println(java.util.Arrays.toString(filled) + " tksp");
    // System.out.println("current level " + currentLevel);

    int[] diagonalHit = new int[8];
    int hitIndex = 0;

    // elminate collsion digonally
    for (int level = 1; level <= currentLevel; ++level) {
      int levelDiff = currentLevel - level;
      int leftDiHit = (filled[level - 1] - levelDiff) < 1
        ? 0
        : filled[level - 1] - levelDiff;
      int rightDiHit = (filled[level - 1] + levelDiff) > 8
        ? 0
        : filled[level - 1] + levelDiff;

      if (leftDiHit != 0) {
        boolean isUnique = true;
        for (int item : diagonalHit) if (item == leftDiHit) isUnique = false;
        if (isUnique) {
          diagonalHit[hitIndex] = leftDiHit;
          ++hitIndex;
        }
      }

      if (rightDiHit != 0) {
        boolean isUnique = true;
        for (int item : diagonalHit) if (item == rightDiHit) isUnique = false;
        if (isUnique) {
          diagonalHit[hitIndex] = rightDiHit;
          ++hitIndex;
        }
      }
    }

    // Problem: diagonalhit and filled may contain similar elements
    // delete the elements in diagonalHit that conatins such
    for (int i = 0; i < diagonalHit.length; ++i) {
      for (int item : filled) {
        if (diagonalHit[i] == item) diagonalHit[i] = 0;
      }
    }

    // now array filled and diagonalHit, contain terminated positions
    // get its size while elimnating 0 valued elements so we can create an new array; terminated
    int terminatedOptionsCount = 0;
    for (int i = 0; i < filled.length; ++i) {
      if (filled[i] != 0) ++terminatedOptionsCount;
    }
    for (int i = 0; i < diagonalHit.length; ++i) {
      if (diagonalHit[i] != 0) ++terminatedOptionsCount;
    }

    // create new array and fill it with terminated option
    int[] terminated = new int[terminatedOptionsCount];
    int index = 0;
    for (int item : filled) if (item != 0) terminated[index++] = item;
    for (int item : diagonalHit) if (item != 0) terminated[index++] = item;

    return terminated;
  }

  public static int[] getAvailableSpots(int[] terminated) {
    int size = 8 - terminated.length;
    int[] available = new int[size];
    int counter = 0;

    if (size == 0) return available;

    for (int i = 1; i <= 8; ++i) {
      boolean in = false;
      for (int item : terminated) if (i == item) in = true;

      if (in == false) available[counter++] = i;
    }
    return available;
  }

  public static boolean checkIfSolved(int[] queens) {
    boolean unsolved = false;
    for (int item : queens) {
      if (item == 0) {
        unsolved = true;
        break;
      }
    }
    return unsolved;
  }

  public static void displaySolvedPuzzle(int[] queenOrder) {
    for (int i = 0; i < queenOrder.length; ++i) {
      int position = queenOrder[i];
      for (int j = 0; j < 8; ++j) {
        if (j == position - 1) System.out.print("|Q");
        else System.out.print("| ");
      }
      System.out.println("|");
    }
  }
}
// fucking solved! all it took was my soul
