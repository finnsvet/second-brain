/** This is a code that solves a 2 by 2 Linear equation
 * ax + by = e
 * cx + dy = f
 * using crammers rule
 * */

public class OneThirteen {
  public static void main(String [] args) {
    double a = 3.4, b = 50.2, c = 2.1, d = 0.55, e = 44.5, f = 5.9;
    double divisor = a*d - b*c;

    if ( divisor == 0 ) {
      System.out.println("ad -bc is 0");
      return;
    }

    double x = getX(b, d, e, f)/divisor;
    double y = getY(a, c, e, f)/divisor;

    System.out.println("The solution to the equation:");
    System.out.printf("%.2fx + %.2fy = %.2f%n", a, b, e);
    System.out.printf("%.2fx + %.2fy = %.2f%n", c, d, f);
    System.out.println("is x = " + x + " y = " + y);
  }

  public static double getX (double b, double d, double e, double f) {
    return (e*d - b*f);
  }
  public static double getY (double a, double c, double e, double f) {
    return (a*f - e*c);
  }
}
