public class TestMatrix {
  public static void main(String[] args) {
    Integer[][] mat1 = new Integer[][] {{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
    Integer[][] mat2 = {{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

    IntegerMatrix intMatrix = new IntegerMatrix();
    IntegerMatrix.printResult(mat1, mat2, intMatrix.addMatrix(mat1, mat2), '+');
    System.out.println();
    IntegerMatrix.printResult(mat1, mat2, intMatrix.multiplyMatrix(mat1, mat2), '*');
  }
}
