Recursion is a technique that leads to elegant solutions to problems that are difficult.

## Listing 18.1 Computing Factorial
```java
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long nfac = factorial(n);
		System.out.printf("n: %d, factorial: %l", 
		n, nfac);
	}
	private static long factorial(int n) {
		if (n == 0) // base case
			return 1;
		else
			return n * factorial(n -1 );
	}
}
```

More elaborate implementation of factorial: [here](source-files/Chapter-18/Factorial.java)

Things to Note:
1) Its simpler and more efficient to implement factorial via a loop
2) Recursion without a base case leads to infinite recursion

There are 2 forms of recursion:
* direct: as seen above
* indirect: when method A invokes method B, which indirectly invokes method A again.

## 18.4 Problem Solving Using Recursion

All recursive methods possess the following characteristics