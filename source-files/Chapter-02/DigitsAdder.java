/**
 * This program takes in an integer between 0 - 1000
 * and adds its individual digits.
 */
import java.util.Scanner;

public class DigitsAdder {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number between 0 and 1000:");
    int integer = input.nextInt();
    
    if ( !(integer > 0 && integer < 1000) ) {
      System.out.println("Number does not obey above criteria.");
      return;
    }

    int tenth       = integer % 10;
    int hundredth   = ( (integer % 100) - tenth ) / 10;
    int thousandth  = ( (integer % 1000) - hundredth - tenth ) / 100;
    
    int sumOfDigits = tenth + hundredth + thousandth;
    System.out.println("The sum of the digits is " + sumOfDigits);
  }
}
