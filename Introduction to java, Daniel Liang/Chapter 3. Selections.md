## 3.1 Introduction
Selection statements are statements that use boolean evaluation to pick the course of execution in a program

## 3.2 Boolean Data Types, Values and Expressions
The Java operator used to perform boolean operations are the same with those in C/C++. every boolean expression returns a boolean (obviously).

Boolean variable can only hold either `true` or `false`values.
### Note
Boolean cannot be converted to integers and vice versa

## 3.3 If Statements
An if statement is a construct that enables a program to specify alternative paths of execution.

Java has several selection statements:
1. one way if statements. (syntax same as C)
2. two way if-else statements.
3. nested if statements
4. multi-way if-else statements
5. switch statements and
6. conditional operators.

```java
if (conditional) {
	execute;
}
// behaves the same as C/C++
```
## 3.4 Two way If-else statements
Not writing a note in this—Basically the same with C/C++

## 3.5 Nested if and Multi-way if-else Statements
nested if statements have one or multiple if statements nested into the initial if statement that contains them all (the nests that is). it is basically the same in syntax and execution as the Nested if statements in C/C++.

### Multi way if else statements.
they are if else statements with multiple conditions leading to multiple path of execution.
```java
if (condition_1) 
	execute_1;
else
	if (condition_2)
		execute_2;
	else
		execute_2
```
the above statement is analogous to the below syntax which is even more preferable.
```java
if (condition_1)
	execute_1;
else if (condition_2)
	execute_2;
else
	execute_3;
```
the `else if`’s can be as multiple as needed to convey the logic that is required

## 3.6 Common Errors and Pitfalls
1. Forgetting necessary braces.
2. Wrong semicolon at the `if`Line
3. Redundant testing of boolean values
4. Dangling `else` ambiguity
5. Equality test of 2 floating-Point values: calculations involving floating point numbers can lead to round of errors due to their limitations in storage precision. Therefor equally testing floats are not reliable. in the next subsection we will discuss more elaborately.
### 3.6.1 Equality test of two floating numbers
Due to the unreliability in testing floating point numbers equality due to the reason i explained above, there are alternatives used to mitigate this issue.

we can do this by comparing whether the 2 float values are close enough by some threshold; an epsilon. That is:
$$
if \;\;\; |x - y| < e, \;\;\;   x\; and \; y \;should\; be\: equal.
$$
$e$ is the epsilon, and if the absolute difference between the float numbers are less than it, the floats are considered equal. Epsilon is set to $10^{-14}$ if variable being tested is of type `double`, for `floats` $e$ should be $10^{-7}$.

an example:
```java
final double EPSILON = 10e-14;
double x = 1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1;
if (Math.abs(x - 0.5) < EPSILON) {
	System.out.println(x + " is approximately equal to 0.5");
}
```
Some other pitfall, worth mentioning, is not Simplifying variable assignments.
I mention this because sometimes i often forget that boolean expressions return boolean without the need of an if statement. So instead of this code:
```java
if (number % 2 == 0)
	even = true;
else
	even = true;
```
although the above is accurate, it’s unnecessary, somewhat redundant and unclean. A better version to assign a boolean to a variable should be:
```java
boolean even = number % 2 == 0;
```
here the conditional expression is written at the RHS, evaluated there and its result is returned to be stored in the bool variable.

## 3. 7 Generating Random Numbers
`Math.random()` returns a random double value between 0.0 and 1.0 excluding 1.0
an example of this program:
```java
public class rand {
	public static void main(String[] args) {
		int rando =  (int) Math.random() * 10;
	}
}
```

## 3.10 Logical operators
Logical operators, also known as boolean operators operate on boolean values to create new boolean values.

### 3.10.1 Table of Boolean Operators

| Operator | Name         | Description         |
| -------- | ------------ | ------------------- |
| !        | not          | Logical Negation    |
| &&       | and          | Logical Conjuction  |
| \|\|     | or           | Logical disjunction |
| ^        | exclusive or | Logical exclusion   |
### 3.10.2 Truth Table for Operator ^

| P1    | P2    | P1 ^ P2 | Example (assume age=24, weight=140)                                                         |
| ----- | ----- | ------- | ------------------------------------------------------------------------------------------- |
| false | false | false   | (age > 34) ^ (weight > 140) is false, because (age > 34) and (weight > 140) are both false. |
| false | true  | false   | (age > 34) ^(weight ≥ 140) is true, because (age > 34) but (weight ≥ 140) is true.          |
| true  | false | true    |                                                                                             |
| true  | true  | false   |                                                                                             |

The trick i’ve seen to or exclusive here is that ONLY one of the boolean expression/element being operated on by the ^operator should be true, for the whole expression to be true, any other case results to false.

I guess that’s why its called exclusive or, because the expressions being operated are, logically, mutually exclusive so the operation can only be truthy if one of the elements are absent (in truth—falsey).

## 3.11 Case Study: Determining leap year
A leap year has 366 days, the February of a leap year has 29 days.

Leap year Logic: a leap is year is divisible by 4 but not by 100, or its divisible by 400
The code:
```java
import jave.util.scanner;

public class LeapYear {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a year: ");
		Int year = input.nextInt();

		boolean isLeap = (year % 4 == 0 && year % 100 != 0) || year % 400
		== 0;
		System.out.print("Is the year " + year + " leap? " + isLeap);
		
	}
}
```

## 3.13 switch Statements
syntax:
```java
switch (status) {
	case 0:
		// execute 1
		break;
	case 1:
		// execute 2
		break;
	default:
		// default execution
		break;
}
```
according to what I've just read, switch expressions must yield a value of `char`, `byte`, `short`, `int` or `String` type and must always be enclosed in parenthesis, and the case value type must also be the same with the switch expressions.

## 3.14 Conditional Operators
```java
(boolean_expression) ? expression_1 : expression_2;
```
the symbol ? and : appearing together is called a conditional operator also known as a ternary operator, because it uses three operands.  it is the only ternary operator in Java. It is a conditional operation with no explicit `if` in the statement.

## 3.15 Operator Precedence and Associativity
[Operator Precedence](operator_precedence.png)

## 3.16 Debugging
Learn how to use jdb—java debugger.