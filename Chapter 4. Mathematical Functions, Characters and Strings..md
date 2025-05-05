## 4.1 Introduction
This chapter teaches methods to perform common mathematical operations.  Supposedly, we will be taught how to estimate the area enclosed by 4 cities given their GPS locations via their longitude and latitude. This chapter also gives a brief introduction to string objects.

## 4.2 Common Mathematical Functions
A method is a group of statements that perform a specific task.
The methods this chapter discusses (which belong to the Math class) are:
1. trigonometric methods
2. exponent methods
3. service methods
Service methods include rounding, min,  max, absolute and random methods. In addiction to methods the Math class provides 2 useful double constants, `PI` and `E`, the base of natural logarithms.
```java
//usage
Math.PI;
Math.E;
```

### 4.2.1 Trigonometric Methods in Math class

| Method            | Description                                             |
| ----------------- | ------------------------------------------------------- |
| sin(radians)      | returns the trigonometric sine of an angle in radians   |
| cos(radians)      | returns the trigonometric cos of an angle in radians    |
| tan(radians)      | returns the trigonometric tan of an angle in radians    |
| toRadians(degree) | returns the angle in radians for the angles in degrees  |
| toDegree(radians) | returns the angle in degrees for the angle in radians   |
| asin(s)           | returns the angle in radians for the inverse of sine    |
| acos(a)           | returns the angle in radians for the inverse of cosine  |
| atan(a)           | returns the angle in radians for the inverse of tangent |

### 4.2.2 Exponent Methods in Math class

| Method    | Description                                             |
| --------- | ------------------------------------------------------- |
| exp(x)    | returns e raised to power of x, $e^{x}$                 |
| log(x)    | returns the natural logarithm of x, $ln(x)= log_{e}(x)$ |
| log10(x)  | returns the base 10 logarithm of x, $log_{10}(x)$       |
| pow(a, b) | returns a raised to the power of b, $a^{b}$             |
| sqrt(x)   | returns the square root of x, $\sqrt{x}$  for $x>=0$    |
### 4.2.3 The Rounding Methods
The math class contains 4 rounding methods

| Method   | Description                                                                                                                |
| -------- | -------------------------------------------------------------------------------------------------------------------------- |
| ceil(x)  | x is rounded up to its nearest integer. This integer is returned as a double value.                                        |
| floor(x) | x is rounded down to its nearest integer. This integer is returned as a double value                                       |
| rint(x)  | x is rounded to its nearest integer. if x is equally close to the two integers, the even one is returned as a double value |
| round(x) | returns `(int) Math.floor(x + 0.5)`if x is a float and returns `(long) Math.floor(x + 0.5)` if x is a double.              |

an example of rounding methods used
```java
Math.ceil(2.1) returns 3.0
Math.ceil(2.0) returns 2.0
Math.ceil(−2.0) returns −2.0
Math.ceil(−2.1) returns −2.0
Math.floor(2.1) returns 2.0
Math.floor(2.0) returns 2.0
Math.floor(−2.0) returns −2.0
Math.floor(−2.1) returns −3.0
Math.rint(2.1) returns 2.0
Math.rint(−2.0) returns −2.0
Math.rint(−2.1) returns −2.0
Math.rint(2.5) returns 2.0
Math.rint(3.5) returns 4.0
Math.rint(−2.5) returns −2.0
Math.round(2.6f) returns 3 // Returns int
Math.round(2.0) returns 2 // Returns long
Math.round(−2.0f) returns −2 // Returns int
Math.round(−2.6) returns −3 // Returns long
Math.round(−2.4) returns −2 // Returns long
```
### 4.2.4 The min, max and abs Methods
the `min` and `max` methods returns the minimum and maximum numbers of two numbers int, long, float or double. While `abs`returns the absolute value of a number (int, long, float or double).

### 4.2.5 The random Method
the `random()` method generates a random double greater than or equal to 0.0 and less than 1.0 (1.0 not included)

## 4.3 Character Data Type and Operations
A character data type represents a single character.
```java
char letter = 'A';
char numChar = '4';
```

### 4.3.1 Unicode and ASCII Code
Mapping a character to its binary representation is called _encoding._  Java supports Unicode, an encoding scheme established by the Unicode Consortium. Unicode was originally designed to be a 16-bit character encoding, but it seem that the 65,536 characters possible in a 16-bit encoding are not sufficient to hold all the characters in the world.

The unicode was therefore extended to hold 1,112,064 characters, the characters that go beyond the 16 bit limit are called _supplementary characters_. Java supports supplementary characters. 

for simplicity we will be considering only the characters within the 16-bit limit, they are stored in the `char` variable type.

A 16-bit unicode takes two bytes, preceded by `\u` expressed in 4 hexadecimal characters running from `\u0000` to `\uFFFF`.

Most computers use the ASCII, an 8-bit encoding scheme, Unicode includes ASCII code, with `\u0000` to `\u007F` corresponding to the 128 ASCII characters.

### 4.3.2 Escape Sequences for Special Characters.
for instances like: needing to include double characters to be printed via `System.out.println()`.

| Escape Sequence | Name            | Unicode Code | Decimal Value |
| --------------- | --------------- | ------------ | ------------- |
| \b              | backspace       | \u0008       | 8             |
| \t              | Tab             | \u0009       | 9             |
| \n              | Linefeed        | \u000A       | 10            |
| \f              | Formfeed        | \u000C       | 12            |
| \r              | Carriage Return | \u000D       | 13            |
| \ \             | Backslash       | \u005C       | 92            |
| \”              | Double Qoute    | \u0022       | 32            |
The backlash \ is called an escape character, its a special character used to display other characters, To display the character itself, you use the escape sequence `\\`.

### 4.3.3 Casting between char and Numeric Types
a char can be used to cast into any numeric type and vice-versa. when an integer is cast into a char, only its lower 16 bits of data are used, the other part is ignored.

and example:
```java
// Note a hex integer is written using prefix 0X
char ch = (char)0XAB0041; // The lower 16 bits hex code 0041 is
						  // assigned to ch
System.out.println(ch);
 // ch is character A
```

when a floating point value is cast into a char, its first cast into an int before its cast into a char.

an example:
```java
char ch = (char)65.25; // float is cast into an int thereby removing the decimal part, then the resulting int (65) is then cast into a char
System.out.prinltn(ch); // prints 'A'
```

when casting a char to a numeric type it can be done implicitly by java if the result of the casting fits into the casting variable, otherwise it must be cast explicitly.

any positive integer between the range 0 and FFFF in hexadecimal can be cast into a character implicitly. any number not in this range must be cast into a char explicitly.

All numeric operators can be applied to char operands.

### 4.3.4 Comparing and Testing Characters
Methods in Character class.

| Method              | Description                                                    |
| ------------------- | -------------------------------------------------------------- |
| isDigit(ch)         | Returns true if the specified character is a digit             |
| isLetter(ch)        | Returns true if the specified character is a letter            |
| isLetterOrDigit(ch) | Returns true is the specified character is a letter or digit   |
| isLowerCase(ch)     | Returns true if the specified character is a lowercase         |
| isUpperCase(ch)     | Returns true if the specified character is an uppercase letter |
| toLowerCase(ch)     | Returns the lowercase of the specified character               |
| toUpperCase(ch)     | Returns the uppercase of the specified character.              |
## 4.4 The String Type
A string is a sequence of characters.
```java
String message = "Welcome to Java";
```
String is a predefined class in the Java library, just like classes System and Scanner. it is not a primitive type, it is known as a _reference type_.

Any Java class can be used as a reference type for a variable, variables declared by a reference type are known as reference variables that references an object.

Here message is a reference variable that reference a string object with content—”Welcome to Java”.

### Simple methods for String objects

| Method        | Description                                                           |
| ------------- | --------------------------------------------------------------------- |
| length()      | Returns the number of characters in this string                       |
| charAt(index) | Returns the character at the specified index from the string          |
| concat(s1)    | Returns a new string that concatenates this string with string s1     |
| toUpperCase() | Returns a new string with all the letters in uppercase                |
| toLowerCase() | Returns a new string with all the letters in lowercase                |
| trim()        | Returns a new string with whitespace characters trimmed on both sides |

### 4.4.a Instance and static methods introduced
The above methods can only be invoked from a specific string instance thus why they are called `instance methods`.
A non instance method is called a static method.

A static method can be invoked without using an object, All methods in math class are static methods. They are not tied to a specific object instance.

The syntax to invoke an instance method is:
```java
referenceVariable.methodName(arguments;
```
Syntax to invoke static methods:
```java
ClassName.methodName(arguments);
```

### 4.4.1 Getting String Length
the `length()` instance method is used.
```java
String message = "Suck nuts!";
int messageLen = message.length();
```
### 4.4.2 Getting Characters from a String
the `charAt(index)` instance method is used.
```java
int index = message.charAt(2);
```
### 4.4.3 Concatenating Strings
the `concat()` instance method, or the `+operator` is used to concatenate 2 strings.
```java
String s3 = s1.concat(s2);
String s6 = s4 + s5;       // also concatenation
```
the `+=` operator is also used to concatenate a string to another:
```java
String one  = "This is a ";
String two += "message";
System.out.println(two); 
```
### 4.4.4 Converting Strings
```java
String lowercase = "Welcome".toLowerCase();
String UPPERCASE = "Welcome".toUpperCase();

String trimmed = "\t Good Night \n".trim() // returns a new string with no whitspace characters-> Good Night.
```
### 4.4.5 Reading a String from the Console `next()` and `nextLine()`

The `next()` method of the Scanner object reads a string from the console
```java
Scanner input = new Scanner(System.in);
String firstString = input.next();
String seconString = input.next();
```
the `next()` methods reads a sting that ends with a white-space character.

while the `nextLine()` reads an entire line of text and returns it as a string.
```java
Scanner input = new Scanner(System.in);
System.out.println("Enter a line ");
String line = input.nextLine();
```

### 4.4.6 Reading a character from the console