java provides interfaces to implement while loops, do-while loops and for-loops.

## 5.2 The While Loop
The while loops executes statements repeatedly while the condition is true; syntax:
```java
while (loop-continuation-condition) {
	// execute
}
```
## 5.4 Loop design strategies
the key to designing a loop is to determine the code that need to be repeated and write a condition for terminating the loop.

## 5.5 Controlling a loop with user confirmation or sentinel value
what is a sentinel value dawg? i do not know.
Its a common practice to use a sentinel value to terminate the input. an example:
```java
char continueLoop = 'Y;
while (continueLoop == 'Y') {
	System.out.println("Enter Y to continue and N to quit: ");
	continueLoop = input.getLine().charAt(0);
}
```
a special value used to control the termination or  continuation of a loop is called—_sentinel_ value. A loop that uses a sentinel value to control its execution is called a sentinel controlled loop

### NOTE; CAUTION even
do not use floating point values for equality checking in loop control, they cannot be trusted due to their imprecise nature in date storing.

## Input and output redirection with java
```bash
java ClassName < input.txt
java ClassName > output.txt
```
don’t really know much of this shwiz.

## 5.6 do-while loop
The do while loop is the same as the while loop just that it executes the loop body first before checking the loop continuation condition.
```java
do {
	// executables
} while (condition);
```
in the do while loop the loop-body is executed at least once.

## 5.7 For loop
```java
for (initial-action; loop-continuation-condtition; action-after-each-iteration) {
	// loop body
	statement(s);
}
```
variable used to control number of iterations in a for loop is known as the _control variable_, the _initial-action_ often often initializes the control variable.

### Note
1) the `initial-action` in a for loop can be a list of zero or more coma-separated statements, for example:
```java
for (int i = 1, j = 0; i+j < 10; i++, j++) {
	// do something
}
```
2) the `action-after-each-iteration` in a for loop can be a list of zero or more comma-separated statements, for example:
```java
for (int i = 1; i < 100; System.out.println(i), i++) ;
```
3) if the `loop-continuation-condition` in a for loop is omitted, it is implicitly `true `
```java
for (;;) {
	// infinite loop
}
```

## 5.8 Which loop to use
Ask your mother

## 5.9 Nested Loops
A loop can be inside another loop, like me inside your moth-
i’m not explaining this crap its easy

## 5.10 Minimizing numeric errors
Numeric errors involving floating-point numbers are inevitable, because floating point numbers are represented in approximation in computers by nature. This section discusses how to minimize them. The fundamental problem of floating point numbers is that they are represented by approximation, to avoid this count loops using integer types or compare equality using an epsilon

## 5.12 Break and Continue
I’ll break your mum then continue plowing her.

* `break`s terminate a loop completely, while
* `continue`s stops the execution of the current iteration from where it was executed at then goes to the next iteration to resume execution

## 5.13 Case Study: Checking Palindromes
a string is a palindrome if it reads the same forwards and backwards, eg; “mum”.
```java
import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine()
		int low = 0;
		int high = line.length() - 1;
		boolean isPalindrom = true;

		while (isPalindrom) {
			if (line.charAt(low) != line.charAt(high))
				isPalindrom = false;
			++low;
			--high;
		}
		System.out.printf("%s is %s palindrome", line, isPalindrom ? "a" : "not a palindrome");
	}
}
```