// checks if a Point is in a circle with midspoint at origin

import java.util.Scanner;
public class ThreeTwentyTwo {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a point with 2 cordinates: ");
    double x = input.nextDouble();
    double y = input.nextDouble();

    final double RADIUS = 10.0;
    final double EPSILON = 10e-14;

    double distance = Math.sqrt( x*x + y*y );
    if (distance < RADIUS || Math.abs(distance - RADIUS) < EPSILON)
      System.out.println("Point ("+x+", "+y+") is in the circle");
    else
      System.out.println("Point ("+x+", "+y+") is not in the circle");
  }
}
