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

### 4.2.6 Case Study: Computing angles of a triangle
