## 1.2 A First Look at Input/Output
the `iostream` comprises of the `istream` and `ostream`, which represents input and output streams, respectively. A stream is a sequence of characters read from or written to and IO device.

## Standard Input and Output Objects
The library defines four IO objects: 
1) object of type `istream`; `cin`: standard input
2) object of type `ostream`; `cout`: standard output
3) object of type `ostream`; `cerr`: standard error
4) object of type `ostream`; `clog`: holds general information about execution of the program
```cpp
#include <iostream>
int main() {
	std::cout << "INPUT 2 numbers :" << std::endl;
	int v1 = 0, v2 = 0;
	std::cin >> v1 >> v2;
	std::cout << "The sum of " << v1 << " and " << v2 << " is " <<
	v1 + v2 << std::endl;
	return 0;
}
```
Every program that uses a library facility must include its associated header.

### Writing to a stream and `std::cout` the `<<opertor` and `std::endl`
This is done using the output operator `<<operator`to print a message to the standard output `cout`.

The `<<operator` takes in two operands; the left operand is an object of the `ostream` type and the right operand is a value to be printed. An operation using this operand returns the `ostream` object on the left. so the below statement:
```cpp
std::cout << "Input 2 numbers: " << std::endl;
```
can be chained as:
```cpp
(std::cout << "Input 2 numbers: ") << std::endl;
```
this is chain is possible because the first bracket expression returns `std::cout`.

Remember the `std::endl` is manipulator that adds and newline character to the buffer of contents to be printed and flushes the buffer, flushing the buffer ensures that all output generated so far has been written to the output stream rather than sitting in memory waiting to be written.

### Using Names from the standard library
Identifiers of objects, data and functions are all encapsulated in the `std` namespace, namespaces prevent identification collisions. Contents of a namespace are accessed via that `::operator`

### Reading from Stream, the `>>operator` , `std::cin`
the `>>operator`, or input operator,  behaves analogously to the `std::cin` output operator, it takes an `istream` object as its left operand and stores what was read in the given object which is declared as the right operand, this operand also returns its left operand.

## 1.4.3 Reading and Unknown Number of inputs
```cpp
#include <iostream>
int main() {
	std::cout << "input numbers to sum: " << std::endl;
	int sum = 0, value = 0;
	while (std::cin >> value)
		sum += value;
	std::cout << "The sum is " << sum << std::endl;
	return 0
}
```
in the while loop expression here due to the operand returns its left operand, wich in this case is `std::cin` after each execution of the continuation statement in the loop the `std::cin` object is returned and evaluated. When we use `istream` as a condition, our goal is to test its state. 

A valid state means the stream hasn’t occurred and error, so the loop continues.
An invalid state means the stream as encountered an invalid input or hit `EOF.

## 1.5 Introducing Classes
data structures in c++ are defined using classes, According to the book a Book store class will be built and this chapter introduces details about it, The class name `Sales_item`it will be defined in a header named `Sales_item.h`

### 1.5.1 The `Sales_item` class
Its purpose is to represent the total revenue, number of copies sold and average sales price of a book.
Every class defines a type, the type name is that same as the class’s name.