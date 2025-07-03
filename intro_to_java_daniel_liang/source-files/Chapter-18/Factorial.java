import java.util.Scanner;
import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		BigInteger nfac = factorial(n);
		System.out.printf("n: %d, factorial: %d\n", n, nfac);
	}

	private static BigInteger factorial(int n) {
		if (n == 0) // base case
			return new BigInteger("1");
		else
			return new BigInteger(n + "").multiply(factorial(n - 1));
	}
}
