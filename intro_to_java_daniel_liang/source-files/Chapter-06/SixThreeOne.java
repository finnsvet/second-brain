// Luhn check or Mod 10 check algorithm for
// validating or invalidating credit card numbers

import java.util.Scanner;

public class SixThreeOne {
  public static void main(String[] args) {
    System.out.println("input credit card number: ");
    Scanner input = new Scanner(System.in);
    Long card = input.nextLong();

    System.out.printf("card %d is %s\n", card, isValid(card) ? "valid" : "invalid");
  }
  public static boolean isValid(long number) {
    if ( ( (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number) ) % 10) == 0)
      return true;
    return false;
  }
  public static int sumOfDoubleEvenPlace(long number) {
    String card = number + "";
    int sum = 0; int cardLen = getSize(number);

    for (int index = cardLen - 2; index >=0; index = index - 2)
      sum += getDigit( 2 * charToInt(card.charAt(index)) );
    return sum;
  }
  public static int getDigit(int number) {
    if ( (number % 10) != number ) {
      int num1 = number % 10;
      number -= num1;
      int num2 = number / 10;
      return num1 + num2;
    }
    return number;
  }
  public static int sumOfOddPlace(long number) {
    String card = number + "";
    int sum = 0; int cardLen = getSize(number);

    for (int index = cardLen - 1; index >= 0; index = index -2)
      sum += charToInt(card.charAt(index));
    return sum;
  }
  public static boolean prefixMatched(long number, int d) {
    return true;
  }
  public static int getSize(long d) {
    return (d + "").length();
  }
  public static long getPrefix(long number, int k) {
    return 0;
  }
  public static int charToInt(char c) {
    return c - '0';
  }
}
