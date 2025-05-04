## 4.1 Introduction
This chapter teaches methods to perform common mathematical operations.  Supposedly, we will be taught how to estimate the area enclosed by 4 cities given their GPS locations via their longitude and latitude. This chapter also gives a brief introduction to string objects.

## 4.2 Common Mathematical Functions
A method is a group of statements that perfrom a specific task.
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
