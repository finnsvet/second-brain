## 7.1 Introduction
 a single array variable can reference a large collection of data
## 7.2 Array Basics
Once an array is created, its size is fixed. and array reference variable is used to access the elements in an array using an index. Arrays are usually collections of variables of the same type.
### 7.2.1 Declaring Arrays
to declare an array in a program, you must declare a variable to reference the array and specify the arrays element type. Below is the syntax:
```java
elementType[] arrayRefVar;
```
or
```java
elementType arrayRefVar[]; // allowed but not preferred
```
the above style was adopted from C/C++.
### 7.2.2 Creating Arrays
Unlike declarations for primitive types, the declaration of an array variable does not allocate any space in memory for the array. it creates only a storage location for the reference to an array. if the variable does not contain a reference to an array, the value of the variable is `null`.

You cannot assign elements to an array unless it has already been created. After an array variable has been declared, you can create an array using the `new` operator and assign its reference to the variable. This is done via the following syntax:
```java
arrayRefVar = new elementType[arraySize];
```
the above statement does 2 things:
1) creates an array using `new elementType[arraySize]`
2) assigns the reference of the newly created array to the variable `arrayRefVar`

therefore, declaring the array, creating it and assigning its reference to the declared array variable can be done, via the syntax:
```java
elementType[] arrayRefVar = new elementType[arraySize];
// an example
double[] myList = new double[10];
```
values are assigned to arrays the way they are traditionally done in most languages (C/C++):
```java
arrayRefVar[index] = value;
```

### Note:
* an array variable that appears to hold an array actually contains a reference to that array, meaning an array variable and an array are different, but most of this time for simplicity this distinction can be ignored.
### 7.2.3 Array size and Default Values:
An array’s size must be given when allocating space for the array—specifying the number of elements that can be stored in it. Its size is immutable after the array is created.
Size can be obtained using `arrayRefVar.length`. 
#### 7.2.3.1 Default values for array elements depending on type
* numeric primitive types → `0`
* char types                       → `\u0000`
* boolean types                 → `false`
### 7.2.4 Accessing Array Elements
array elements are accessed through the index. Array indices are `0` based (common logic)
```java
arrayRefVar[index];
```
### 7.2.5 Array Initializers
java has a shorthand notation which combines the declaration, creation and initialization of an array in one statement. This notation is known as the _array initializer_. Its syntax is thus:
```java
elementType[] arrayRefVar = {value0, value1, ..., valuek};
```
an example:
```java
int[] numbers = {1, 2, 3, 4, 5, 7};
```
#### Caution:
* The new operator is not used with the array initializer syntax. using an array initializer, you would have to declare, create and initialize the array all in one statement, splitting it would yield errors, an example:
```java
double[] myList;
myList = {2.0, 4.5, 6.6, 3.9};
// This will yield syntax errors; WRONG
```
### 7.2.6 Processing Arrays
when processing arrays one will usually use for loops for one of these two reasons:
* all the elements in an array are of the same type , so they are evenly processed in the same fashion using a loop.
* since the size of an array is usually known, its natural to use a for loop
assuming that an array is created as follows:
```java
double[] list = new double[10];
```
the above array can be processed as follows:
* **initializing arrays with input values**:
```java
java.util.Scanner input = new java.util.Scanner(System.in);
System.out.println("input "+ list.length + " numbers: ")
for (int index = 0; index < list.length; ++i)
	list[i] = input.nextDouble();
```
* **initializing arrays with random values**: this can be done like the example above but, instead,  asking for input is never declared and then each array element is initialized with: `Math.random() * scaler` where `scaler` is the number each generated random number should not exceed.
* **Displaying arrays**: the print function is used
* **Summing all element**: summing all individual elements of the array.
* **Finding the largest element**: This can be achieved with the following code:
```java
int[] list = {2, 1, 3, 10, 7}:
int indexOfMax = 0;
for (int i = 1; i < list.length; ++i){
	if (list[indexOfMax] < list[i])
		indexOfMax = i;
}
int max = list[indexOfMax];
```
* **Finding the smallest index of the largest element**: this is achieved similar to the code snippet above.
* **Random shuffling of elements**: This can be achieved via the snippet
```java
for (int i = 0; i < list.length-1; ++i) {
	int j = (int) (Math.random() * list.length);
	temp = list[i];
	list[i] = list[j];
	list[j] = temp;
}
```
* **Shifting elements**: this is done thus:
```java
double temp = list[0]
for (int i = i; i < list.length; ++i)
	list[i - 1] = list[i];
list[list.length - 1] = temp;
```
* **Simplifying Coding**: arrays help to simplify coding, especially in cases where traversing some sort of data collection is needed

### 7.2.7 For-each Loops
java support for each loop which enables traversing the elements in an array sequentially, without the use of indices (index variables). its syntax is thus:
```java
for (double item : list) [
	System.out.println(item);
]
```
The item variable must be of the same type as the elements in the array
```java
for (elementType element : arrayRefVar) {
	// process element
}
```

## 7.5 Copying Arrays
To copy the contents of an array into another; its individual contents will have to be copied into the target array. This is not done using the assignment operator.

Using the assignment operator `=` to copy an array into another like below:
```java
array1 = array2;
```
does not copy the contents, rather, it merely copies the reference value of array2 to the array reference variable: array1. After this statement both array1 and array2 reference the same array as shown in the below image:
![array reference assignment](source-files/imgs/arrayrefcopy.png)

the array previously referenced by array1 is no longer referenced and becomes garbage memory, which will be automatically collected by the Java Virtual Machine; This process is known as _garbage collection_.

in Java you can use assignment to copy primitive data types but not arrays, assignment on arrays will only copy the reference of the array you wish to copy to the array reference variable you are assigning to; making both variables point to the same array in memory, there will be no copy.

there are three ways to copy arrays:
 1) Use a loop to copy individual elements to the target array
 2) Use the static `arraycopy` method in the System class.
 3) Use the `clone` method to copy arrays; This will be discussed later in chapter 13.
 
 ### 7.5.1 Using `arraycopy`to copy an array
 the `arraycopy` method can be found in the `java.lang.System`class, its syntax is thus:
 ```java
 arraycopy(sourceArray, srcPos, targetArray, tarPos, length)
 ```
 where: 
 * `srcPos` is the starting index of `sourceArray` to start the copy
 * `tarPos` is the starting index of `targetArray` to start the pasting
 * `length` is determines the number of elements to be copied.
 for example to **completely** copy an array contents into another, this is done thus:
 ```java
 System.arraycopy(array1, 0, array2, 0, array1.length);
 ```
 `arraycopy` those not allocate memory for the target array, this must be done , before hand, by the programmer.

## 7.6 Passing Arrays to Methods
when passing an array to a method, the reference of the array is passed into the method. 

if you want to pass an **anonymous array** without explicitly declaring an array reference variable this can be done thusly:
```java
arrayMethod(new int[]{1, 2, 3, 5});
```
this argument declaration here creates an anonymous array and passes its reference to the `arraymethod` parameter (which should be an array reference variable).
### Anonymous array syntax:
```java
new elementType[] {value0, value1, ..., valuek};
```

Java uses _pass-by-value_ to pass arguments to a method:
* when passing primitive data types the value passed is the value of the type itself
* in arrays, as spoken of previously, this is not the case, here the value passed is not a duplicate of the array with its contents, rather, the reference of the array is the value passed. Therefore any changes made to the referenced passed array within the method, will persist and reflect itself outside the array. Semantically this is described as _pass-by-sharing_

![array pass into method mechanism](source-files/imgs/arraymethodpass.png)

### Note
* arrays are objects in java (introduced in chapter 9), the JVM stores objects in an area of memory called the heap, which is used for dynamic memory allocation.
## 7.7 Returning an array form a method
when a method returns an array, the reference of the array is returned.

## 7.9 Variable-Length Argument Lists
a variable number of arguments of the same type can be passed to a method and treated as an array.
Its syntax is thus:
```java
typeName... paramaterName
```
to achieve this in a method declaration, as declared above, you specify the type followed by an ellipsis, followed but the name of the list.

In java only one variable-length parameter may be specified in a method, and this parameter must be the last parameter, any regular parameters must precede it.

variable length parameters are treated as arrays in java. Below give a snippet of its possible usages:
```java
public static void main(String[] args) {
	arrayDoSomething(2, 5, 7, 9, 12, 1);
	arrayDoSomething(new int[] {1, 3, 2 ,9});	
}

public static void arrayDoSomething(int... numbers) {
	//
}
```
## 7.10 Searching arrays
This can be done via searching algorithms or the linear search approach (I have covered this in prior studies.

## 7.11 Sorting arrays
This is also achieved by some algorithm (which, thankfully i have previously studied, so fuck this)

## 7.12 The Array Class
The `java.util.Arrays` class contains useful methods for common array operations such as sorting and searching. This class contains various static methods for sorting, searching, comparing arrays, filling array elements and returning string representation of the array. These methods are overloaded for all primitive types.

| some Array class methods with example               | Explanation                                                                                                                                                            |
| --------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `java.util.Arrays.sort(array);`                     | Sorts an array                                                                                                                                                         |
| `java.util.Arrays.sort(array, start, end);`         | Sorts an array partially, starting from the `start` index and ends at but not including the `end`index                                                                 |
| `java.util.Arrays.parallelSort(array);`             | Similar to `sort` but more efficient if computer has multiple processors                                                                                               |
| `java.util.Arrays.parallelSort(array, start, end);` | Similar to `sort` but partially and more efficient if computer has multiple processors                                                                                 |
| `java.util.Arrays.binarySearch(array, 10);`         | Uses binary Search to search for a value, in this case the value is 10. Array must already be sorted in sequence of increasing magnitude for search to work accurately |
| `java.util.Arrays.equals(array1, array2);`          | Returns a boolean to signify if both arrays are equal or not. `true` if equal, `false` if not.                                                                         |
| `java.util.Arrays.fill(array, item);`               | Used to fill in all indices of an array with the value of `item`                                                                                                       |
| `java.util.Arrays.fill(array1, start, end, item);`  | Performs the same directives as above but only fills partially, starting from the `start` index and ending, but not including, at the `end` index.                     |
| `java.util.Arrays.toString(array);`                 | returns String that represent all the element in the array. Quick and simple way to display an array.                                                                  |
## 7.13 Command-Line Arguments
