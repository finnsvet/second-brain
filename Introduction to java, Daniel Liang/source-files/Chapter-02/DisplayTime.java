/**
 * This program convertes seconds to its minute and seconds format
 * using the modulo operator %
 */

import java.util.Scanner;

public class DisplayTime {
  public static void main( String[] args ) {

    Scanner input = new Scanner(System.in);
    System.out.println("input seconds");
    int seconds = input.nextInt();

    int minutes = seconds / 60;
    int r_seconds = seconds % 60;

    System.out.printf("minutes in %ds: %d minutes, %d seconds.\n", seconds, minutes, r_seconds);
  }
}
