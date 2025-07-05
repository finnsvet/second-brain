Generics enable us detect errors at compile time rather than at runtime. Generics enable us parameterize types.

The key benefit of generics is to enable errors to be detected at Compile time rather than at runtime. A generic class or method permits you to specify allowable types of objects that the class or method can work with. If an incompatible object is uses the compiler throws an error.

```java
package java.lang;

public interface Comparable<T> {
	public int compareTo(T o)
}
```

in the above snippet, `<T>` represents a *formal generic type*, which can be replaced later with an actual *concrete type*. Replacing a generic type is called *generic instantiation*.

```java
Comparable<Date> o = new Date();
o.compareTo("blue"); // Compiler Error!
```

if an object implementing this interface was instantiated; calling the `compareTo()` method with an argument not of the same type as the objects *generic instantiation* will yield a compile error; this is a some-what hand-wavy explanation of how generic types prevents runtime errors, because a compiler error will occur instead.

Things to Note:
1) Generic type must be reference types. You cannot replace a generic type with a primitive type.

## 19.3 Defining Generic Classes and Interfaces
A generic type can be defined for a class or interface. Now, when instantiating an object of such class, or using the class or interface to declare a reference variable—a concrete type must be specified.

An example: Generic Stack:
```java
public class GenericStack<T>{

	private java.util.ArrayList<T> stack = new java.util.ArrayList<>();

	public int getSize() {
		return stack.size();
	}
	
	public T peek() {
		return stack.get(stack.size() - 1);
	}

	public void push (T o){
		stack.add(o);
	}

	public T pop() {
		T popped = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1)
		return popped;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public String toString(){
		return "Stack: " + stack.toString();
	}
}
```

Things to Note:
1) Generic classes define their constructors the same way non-generic classes define theirs: no need for declaring the generic type syntax `(<T>)`
```java
public GenericClass() {
	// this is a constructor
}
```
2) Occasionally, generic classes may have more than one generic parameters, they can be declared as so:
```java
public class GenericClass<T1, T2, T3> {
}
```
3) One can declare a generic class or interface as a subtype of a generic class or interface.
```java
public class String implements Comparable<String>
```

## 19.4 Generic Methods
A generic type can be defined for a static method. To declare this: we place the generic type `<T>` immediately after the static keyword.
```java
public class GenericMethodClass {
	public static <T> void print(T[] list) {
		for (int i = 0; i != list.length; ++i)
			System.out.print(list[i]);
	}
}
```

To invoke a generic method, prefix the methods name with the actual concrete type  in angled brackets.
```java
GenericMethodClass.<String>print(strings);
GenericMethodClass.<Integer>print(integers);
```
In a case where the concrete type was not specified; the compiler automatically discovers the actual type.

## 19.5 Bounded Generic Type
A Generic Type (`<T>`) can be specified as a subtype of another type. Such type can be declared with such syntax:
```java
<T extends SuperType> // This is a bounded genric type.
```
Bounded generic types allows us to create more specific limits of what type of objects can be passed into a generic method, or used to allow successful *generic instantiation* in a generic class
```java
class Circle extends GeometricObject {}
class Rectangle extends GeometricObject {}
// the above classes have overriden the getArea() method to
// suite thier individual logic

public class BoundedTypeDemo {
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(2, 2);
		Circle circ = new Circle(3);
		
		System.out.println("Same area? " + equalArea(rect, circ));
	}
	
	private static <T extends GeometricObject> boolean equalArea(
		T object1, T object2) {
		return object1.getArea() == object2.getArea();
	}
}
```
Thing to note:
1) an unbounded generic type `<T>` is that same as `<T extends Object>`

## 19.5 Case Study: Sorting an Array of Objects
```java
public class GenericSort {

	public static void main(String[] args) {
	
		Integer[] integers = { Integer.valueOf(2), Integer.valueOf(4),
		Integer.valueOf(1) };
		
		Double[] doubles = { Double.valueOf(3.2),  Double.valueOf(1.3),
		Double.valueOf(-22.3)};
		
		Character[] chars = {Character.valueOf('a'), 
		Character.valueOf('j'), Character.valueOf('r')};
		
		String[] strings = {"Tom", "Susana", "Ivy"};

		sort(integers); sort(doubles);
		sort(chars); sort(strings);
		
		printList(integers); printList(doubles);
		printList(chars); printList(strings);
	}
	
	public static <T extends Comparable<T>> void sort(T[] array) {
		T minValue;
		int minIndex; 
		
		for (int i = 0; i != array.length; ++i) {
			minValue = array[i];
			minIndex = i;
			for (int j = i + 1; j != array.length; ++j) {
				if (minValue.compareTo(array[j]) > 0) {
					minValue = array[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				array[minIndex] = array[i];
				array[i] = minValue;
			}
		}
	}
	
	public static void printList(Object[] array) {
		for (Object o: array)
			System.out.print(o + " ");
		System.out.println();
	}
}
```

## 19.6 Raw Types and Backward Compatibility
A generic class or interface used without specifying a concrete type, called a raw type enables backward compatibility with earlier versions of Java.

A generic class can be used without specifying a concrete type like so:
```java
GenericStack stack = new GenericStack();
```
the above declaration is roughly equivalent to:
```java
GenericStack<Object> stack = new GenericStack<Object>();
```

## Type Safety concerns while using Raw Types
Generic computations with raw types are *unsafe*; because it can lead to objects of incompatible types trying to perform some computations in a situation where they should be compatible, which can lead to runtime error.

## 19.7 Wildcard Generic Types
*You can use unbounded wildcards, bounded wildcards, or lower bound wildcards to specify a range for a generic type.*

Wildcard generic types has three forms:
* `<?>` → **unbounded wildcard** : same as `<? extends Object>`
* `<? extends T>` → **bounded wildcard** : represents T or a subtype of T
* `<? super T>` → **lower bound wildcard** : denotes T or a supertype of T

An example when this can be used:
```java
public static void main(String[] args) {
	
	GenericStack<Integer> stack = new GenericStack<>();
	stack.push(2); stack.push(1); stack.push(-1):
	
	System.out.println(max(stack));
}

public static double max(GenericStack<Number> stack) {

	double max = stack.pop().doubleValue();
	
	while(!stack.isEmpty()) {
		double current = stack.pop().doubleValue();
		if (current > max)
			max = current;
	}
	
	return max;
}
```

> Note → The max function here is **Not** a generic function; its a function that accepts an argument with a type that is of a specified concreted type, generically designed class (or simply a generic class type that has undergone generic Instantiation). 

In the above function the `Integer` class is a subtype of the `Number` class, But `GenericStack<Integer>` is not a subtype of `GenericStack<Number>`; They are both different types which means the line `System.out.println(max(Stack))` will cause a compile error. How can we prevent this? this can be circumvented using wildcard generic types.

The compiler error can be prevented by changing the type of of the `stack` parameter in the `max` function from a `Number` concreted generic class type to a bounded wildcard type that allows a broader range of concreted generic class types in which the concreted type is either a subtype of the `Number` class or the `Number` class itself, the changing can be achieved as so:
```java
public static double max(GenericStack<? extends Number>) stack) {
}
```

Things to note (opinionated):
1) a method or class that requires some generic functionality and is declared with a generic type placeholder like `<T>`, `<E>` or whatever **is** a ***generic class or method***
2) But a declaration that uses an already concreted type generic type related to a method or class, does not necessarily make said class or method a generic one, unless it uses a certain generic Type placeholder, like `<T>` 

## 19.8 Erasure and Restrictions on Generics
The information on generics is used by the compiler but it is not available a runtime.
This is called type erasure.

The generics are present at compile time. Once the compiler confirms that a generic type is used safely, it converts the generic type to a raw type. This enables backward compatibility with legacy code.

Things to Note:
1) Once the compiler uses the generic type information to compile a code the generic type information is erased
2) a Generic class is shared by all its instances regardless of its actual concrete type. an example: `List<Integer>` and `List<String>`  instances all share a single generic class as their type which is `List`
3) Only the actual (concrete-less) generic class (e.g `List` not `List<String>`) is loaded into the JVM for runtime computations; so something like this is illogical to the JVM while in runtime execution:

This is wrong
```java
System.out.println(list1 instanceof ArrayList<String>); // ERRORORNEOUS
```
but the snippet below is valid:
```java
System.out.println(list1 instanceof ArrayList);
```


Due to generic type erasure there are some restrictions on how generic **types** can be declared:
1) **Restriction 1**: Cannot use `new E()`
	```java
	E object = new E(); // ILLEGAL
	```
	this is illegal because construction (`new E()`) is executed at runtime.
2) **Restriction 2**: Cannot use `new E[]`
	```java
	E object = new E[capacity]; // ILLEGAL
	```
	this can be circumvented by creating an array of the Object type; then casting it `E[]`. This will yield an ==unchecked compiler warning== because the array type might mismatch the concreted generic type after compilation during runtime.
	```java
	E object = (E[]) new Object[capacity];
	```
3) **Restriction 2.1**: Generic type array creation using a generic class is not allowed:
	```java
	ArrayList<String>[] list = new ArrayList<String>[10]; // ILLEGAL
	```
	This can be circumvented as so:
	```java
	ArrayList<String>[] list = (ArrayList<String>) new ArrayList[10];
	```
	Though a compile warning will still be alerted.
4) **Restriction 3**: A Generic type parameter of a **CLASS** is not allowed in a static context:
	```java
	public class Test<T> {
		public static void m(E o1) { // ILLEGAL
		}
		
		public static E o1; // ILLEGAL
		
		static {
			E o2; // ILLEGAL
		}
	}
	```
5) **Restriction 4**: Exception classes cannot be generic
	A generic class may not extend ```java.lang.Throwable```, below statements is illegal:
	```java
	public class MyException<T> extends Exception {  // ILLEGAL
	}
	```

## 19.9 Case Study: Generic Matrix Class
[GenericMatrix.java](source-files/Chapter-19/GenericMatrix.java)→[IntegerMatrix.java](source-files/Chapter-19/IntegerMatrix.java)→[TestMatrix.java](source-files/Chapter-19/TestMatrix.java)

