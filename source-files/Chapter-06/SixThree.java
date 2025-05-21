import java.util.Scanner;

public class SixThree {
  public static void main(String[] args) {
    System.out.println("input number: ");
    Scanner input = new Scanner(System.in);
    int num = input.nextInt();
    System.out.printf("The number %d is %s palindrome; its reverse: %d\n", num, (isPalindrome(num) ? "a" : "not a"), reverse(num));
  }

  public static int reverse(int number) {
    int reversed = 0;
    int level = (number + "").length() - 1;

    boolean complete = true;
    while (complete) {
      int remainder = number % 10;
      if (remainder != number) {
        reversed += remainder * Math.pow(10, level);
        number = ( number - remainder ) / 10;
        --level;
      } else {
        reversed += number;
        complete = false;
      }
    }
    return reversed;
  }

  public static boolean isPalindrome(int number) {
    String first = number + "";
    String second = reverse(number) + "";
    
    for (int firstIndex = 0; firstIndex < first.length(); firstIndex++)
      if ( first.charAt(firstIndex) != second.charAt(firstIndex) )
        return false;
    return true;
  }
}
