package Finder;

import java.util.Scanner;

public class NineThirtheen {

  public static void main(String[] args) {
    double[][] array = newArray();
    initArray(array);
    Location.locateLargerst(array).print();
  }

  public static double[][] newArray() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of rows and column in array: ");
    int row = input.nextInt();
    int column = input.nextInt();
    return new double[row][column];
  }

  public static void initArray(double[][] array) {
    System.out.println("Enter the array: ");
    Scanner input = new Scanner(System.in);
    for (int i = 0; i < array.length; ++i) {
      for (int j = 0; j < array[i].length; ++j) {
        array[i][j] = input.nextDouble();
      }
    }
  }
}

class Location {

  public int row = 0;
  public int column = 0;
  public double maxValue = 0;

  private Location() {}

  public Location(int row, int column, double maxValue) {
    this.row = row;
    this.column = column;
    this.maxValue = maxValue;
  }

  public static Location locateLargerst(double[][] a) {
    int row = 0;
    int column = 0;
    double maxValue = a[row][column];
    for (int i = 0; i < a.length; ++i) {
      for (int j = 1; j < a[i].length; ++j) {
        if (a[i][j] <= maxValue) continue;
        row = i;
        column = j;
        maxValue = a[row][column];
      }
    }
    return new Location(row, column, maxValue);
  }

  public void print() {
    System.out.printf(
      "The location of the largest element is %f at (%d, %d)\n",
      this.maxValue,
      this.row,
      this.column
    );
  }
}
