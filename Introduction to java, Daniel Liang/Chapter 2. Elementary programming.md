## 2.3 Inputing—The Scanner class
The scanner class is used for console input, Java uses System.out to refer to the standard output devices, and java uses System.in to refer to input devices. By default output device is the monitor and input device is the keyboard.
```java
Scanner input = new Scanner(System.in);
```
the scanner class is imported via:
```java
import java.util.Scanner;
```

### Types of import in java
There are two types of import in java
1. specific import: This specifies a single class in the import statement.
2. wildcard import: This imports all the classes in the package using the asterisk wildcard
an example of both types of imports in java:
```java
// specific import
import java.util.Scanner;
// wildcard import
import java.util.*;
```
there is no specific performance between the wildcard import and the specific import.

## 2.4 Identifiers
Identifiers are the names that identify elements in a java, such as variables, classes and methods.

identifiers follow the following rules:
1. Identifiers are sequences of characters that contain letters, numbers, underscores and the dollar sign ($)
2. an Identifier must start with a letter, underscore or a dollar sign, it cannot start with a number
3. an identifier cannot be a reserved word
4. an identifier can be of any length.

## 2.4 Variables
variable represent values that might be changed in the course of the program.
if variable are of the same type they can be declared together, an example below:
```java
int x, y, z;
String names, animals, places;
double length, breadth, witdth;
```

## 2.7 Named Constants
a named constant is an identifier that represents a permanent value.
it is simple a constant that represents a value that never changes, in java its also known as a final variable.

this is the syntax for declaring a final variable or a constant:
```java
final datatype CONSTANTNAME = value;
```
a constant must be declared and initialized in the same statement, the reserved keyword `final` is used to declare a constant in java, also by convention, the identifier of a constant in java are written in all uppercase.

## 2.8 Naming conventions in Java
* use lowercase or camelCase for variables and methods
* capitalize the first letter of class names
* capitalize every letter in constant names and use underscores in-between words
## 2.9 Numeric data types and operations
in java there are six variable types for storing numeric values:
* For integers
	1. byte
	2. short
	3. int
	4. long
* For floating point numbers
	1. double
	2. float
for floating point numbers the double is twice the size of the float type, the float is known as single precision while the double is known as double precision. normally the double should be used normally instead of the float because its more accurate than than the float type.

### 2.9.1 Reading numbers from the keyboard
this method are used via the Scanner class to get numerical input from users via keyboard, each type has a special method to handle its input

| method       | Description                                |
| ------------ | ------------------------------------------ |
| nextByte()   | read integer of byte type                  |
| nextShort()  | reads integer of short type                |
| nextInt()    | reads integer of int type                  |
| nextLong     | reads integer of long type                 |
| nextFloat()  | reads floating point number of float type  |
| nextDouble() | reads floating point number of double type |

### 2.9.3 Exponent operations
the `Math.pow(a, b)` can be used to compute a raised to the power b. It is defined in the math class in the java API.

## 2.10 Numeric Literals
numeric literals are to be assigned to variable typed that can handle or store them, if not a compile error will be thrown.

below are the suffix to be appended to different numeric literals to declare their types

| type            | suffix                      | note                                                                                                                                  | example |
| --------------- | --------------------------- | ------------------------------------------------------------------------------------------------------------------------------------- | ------- |
| integers        | None                        | integer literals can be assigned to integer variable as long as it can fit into the variable—Cannot store `int` literals into `short` |         |
| Long            | L                           | the suffix L is preferred to the l(lowercase) due to l being easily mistaken as 1                                                     |         |
| Floating points | F for floats, D for doubles | by default all floating point literals are declared as doubles, but can be made floats by appending F                                 |         |
|                 |                             |                                                                                                                                       |         |
### 2.10.3 Scientific Notation
floating point literals can be written in scientific notation in the form `aEb` to represent:
$$
a \times 10^{b}
$$
There was this vigor, this virility i once had for life and its incumbent obstacles. 
I have lost it, Nothing remains to give anymore.

In Java mathematical operations do not follow BODMAS, its more of BMDAS, multiplication has higher precedence than division, which is weird.

## Type casting in Java
in java er can type casting just like in C/C++, casting from a type with a smaller storage range to that with a larger storage range is known as widening.
While casting from a larger storage range type to that of a shorter storage range is known as narrowing.

an example below
```java
int one = (int) 1.0;
```
