// Zellers congruence: algorithm that tells the day of the week

import java.util.Scanner;

public class ThreeTwentyOne {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter year: (e.g 2012):");
    int year = input.nextInt();

    System.out.println("Enter Month: 1-12:");
    int m = input.nextInt();
    if (m == 1) { m = 13; year -= 1; }
    if (m == 2) { m = 14; year -= 1; }

    System.out.println("Enter the day of the month: 1-31 ");
    int q = input.nextInt();

    int k = year % 100;
    int j = year / 100;    

    int h = ( q + (26*(m+1)/10) + k + (k/4) + (j/4) + 5*j ) % 7;

    String dotwi = "Day of the week is ";
    switch (h) {
      case 0:
        System.out.println(dotwi + "Saturday");
        break;
      case 1:
        System.out.println(dotwi + "Sunday");
        break;
      case 2:
        System.out.println(dotwi + "Monday");
        break;
      case 3:
        System.out.println(dotwi + "Tuesday");
        break;
      case 4:
        System.out.println(dotwi + "Wednesday");
        break;
      case 5:
        System.out.println(dotwi + "Thursday");
        break;
      case 6:
        System.out.println(dotwi + "Friday");
        break;
    }
  }
}
