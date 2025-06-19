## 15.1 Introduction
You can write code to process events. such as button click, mouse movement and keystrokes. This is *event driven programming*

When a button it fires an *action event*, An object to handle the action is an *event handler*. The button in which the event originates from is called a *event source object*.

![event handling](source-files/imgs/eventhandleprocess.png)

Not all objects can be handlers for an action event. To be a handler of an action event, two requirements must be met:
1) The object must be an instance of the `EventHandler<T extends Event>` interface.
```java
EventHandler<T extends Event>
```
2) `EventHandler` object must be registered with the event source object (so it can listen for events) using
```java
source.setOnAction(handler);
```

The `EventHandler<ActionEvent>` interface contains the `handle(ActionEvent)` method from processing action events. Your handler must override this method.

Listing 15.1 implementation; [here](source-files/Chapter-15/HandleEvent.java).

## 15.2 Events and Event Sources
an event is an object created from an event source. Firing an event means to create an event and delegate the handler to handle the event.

An event is an instance of the event class. The root class of the Java event classes is `java.util.EventObject`. The root class  of the JavaFx event class is `javafx.event.Event`.

 ![javafx event](source-files/imgs/javafxevent.png)

You can identify the source object of an event using the `getSource()` instance methods in the `EventObject` class.
The subclasses of `EventObject` deal with specific types of events, such as window events, mouse events and key events.

If a component can fire an event any subclass of that event can fire the same event.

![eventhanlders](source-files/imgs/eventhanlders.png)

## 15.3 Registering Handler and Handling Events
A handler is an a object that must be registered with an event source object and its must be an instance of an appropriate event-handling interface.

Java uses a delegation based model for event handling: an object fires an event and the object interested in the event handles it.

For an object to be the handler of an event of a source object; 2 things are required:
1) The handler must be an instance of the corresponding event-handler interface.
2) The handler object must be registered by the source object.

for example; since the `Button` fires an `ActionEvent` its handler must be of type `EventHandler<ActionEvent>` so it can handle the action using its instance method `void handle(ActionEvent e)`

![Event Listening](source-files/imgs/eventlistening.png)

The event object contains information pertinent to the event.

An Implementation [here](source-files/Chapter-15/ControlCircle.java)

## 15.4 Inner Classes
an Inner class, or nested class,  is a class defined within the scope of another class. Inner classes are useful fro defining handler classes.

An inner class may be used just like a regular class. Normally its defined only for the use of the outer class.

An inner class has the following features:
1) An inner class is compiled into a class named `OuterClassName$InnerClassName.class`
2) An inner class can reference the data and methods defined in the outer class in which it nests, so there is **no need** of passing objects by reference to the inner class via its constructor for access.
3) An inner class can be defined with a visibility modifier subject to the same visibility rules applied to a member of the class.
4) An inner class can be defined as `static`. A `static` inner class can be accessed using the outer class name
5) A `static` inner class cannot access non-static members of the outer class.
6) Objects of an inner class are usually created in the outer class. However, its possible to create an instance of an inner class from another class.
7) ==To create and instance of a ***non static*** inner class. ***An instance of the outer class needs to created first*** then the inner class is created via this syntax:==
```java
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```
8) ==If the inner class is static, an instance can be created as so:==
```java
OuterClass.InnerClass innerObject = new OuterClass.InnerClass()
```

When Inner class should be used:
* To combine dependent classes into a primary class, This reduces the number of source files. An makes them easier to organize due to their naming convention `OuterClass_$InnerClass_.class`
* Another practical use is avoiding class-naming conflicts
* A handler class is designed specifically to create a handler object for a GUI component (e.g a button). The handler class will not be shared by other applications and therefore appropriate to be defined inside the main class as an inner class.

## 15.5 Anonymous Inner-Class Handlers
An anonymous inner class is an inner class without a name. It combines defining an inner class and creating an instance of the class into one step.

![inner anonymous](source-files/imgs/inneranon.png)

The syntax for an anonymous inner class is:
```java
new SuperClassName/InterfaceName() {
	// implement, override methods in superclass or interface
	
	// Other methods if necassary
}
```

Since an anonymous inner class is a special kind of inner class, it is treated like an inner class with the following features:
* An anonymous inner class ***must always*** extend a superclass or implement an interface, but it cannot have an explicit `extends` or `implements` clause.
* An anonymous inner class must implement all the abstract methods in the superclass or in the interface.
* An anonymous inner class always uses the no-org constructor from its superclass to create an instance. If an anon inner class implements an interface, its constructor is `Object()`
* An anonymous inner class is compiled into a class named `OuterClassName$n.class` where `n` is order number, starting from 1, of the anonymous classes created in the Outer class.

## Listing 15.4
