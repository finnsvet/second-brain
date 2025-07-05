public abstract class GenericMatrix<T extends Number> {

  protected abstract T add(T element1, T element2);
  protected abstract T multiply(T element1, T element2);
  protected abstract T zero();

  public T[][] addMatrix(T[][] matrix1, T[][] matrix2) {

    if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length)
      throw new RuntimeException("Matrices are not of the same size");

    T[][] result = (T[][]) new Number[matrix1.length][matrix2[0].length];

    for (int i = 0; i < result.length; ++i) {
      for (int j = 0; j < result[i].length; ++j)
        result[i][j] = add(matrix1[i][j], matrix2[i][j]);
    }

    return result;
  }

  public T[][] multiplyMatrix(T[][] matrix1, T[][] matrix2) {

    if (matrix1[0].length != matrix2.length)
      throw new RuntimeException("Matrice not compatible for multiplication");

    T[][] result = (T[][]) new Number[matrix1.length][matrix2[0].length];

    for (int i = 0; i < result.length; ++i) {
      for (int j = 0; j < result[0].length; ++j) {
        result[i][j] = zero();
        for (int k = 0; k < matrix1[0].length; ++k)
          result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
      }
    }

    return result;
  }

  public static void printResult(Number[][] m1, Number[][] m2, Number[][] m3, char op) {

    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m1[0].length; j++)
        System.out.print(" " + m1[i][j]);

      if (i == m1.length / 2)
        System.out.print("  " + op + " ");
      else
        System.out.print("    ");

      for (int j = 0; j < m2.length; j++)
        System.out.print(" " + m2[i][j]);

      if (i == m1.length / 2)
        System.out.print("  =  ");
      else
        System.out.print("     ");

      for (int j = 0; j < m3.length; j++)
        System.out.printf("%3d", m3[i][j]);

      System.out.println();
    }
  }
}
