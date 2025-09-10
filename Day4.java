
/*
1. Abstract Classes & Methods

💡 Concept Covered: Abstract class + abstract methods + inheritance

👉 Question (Detailed):

Create an abstract class called Shape.

The class should have:

an abstract method calculateArea() (no body, only declaration).

a non-abstract method displayShapeName() that prints the type of shape.

Now, create two subclasses:

Circle (with a radius property).

Rectangle (with length and breadth properties).

Each subclass should provide its own implementation of calculateArea().

Finally, write a main method where you:

Create objects of Circle and Rectangle.

Call their calculateArea() methods.

Call displayShapeName() to show how an abstract class can have both abstract and concrete methods.

🎯 Learning outcome: You’ll see how abstract classes allow you to define common structure while forcing subclasses to implement specific behavior.


2. Interfaces & Multiple Inheritance

💡 Concept Covered: Interfaces + multiple inheritance through interfaces

👉 Question (Detailed):

Create an interface Flyable with one method fly().

Create another interface Swimmable with one method swim().

Now create a class Duck that implements both interfaces (this shows multiple inheritance because a class can implement many interfaces).

Inside the Duck class:

Implement the fly() method to print something like "Duck is flying low in the sky."

Implement the swim() method to print something like "Duck is swimming in the pond."

In the main method, create a Duck object and call both fly() and swim().

🎯 Learning outcome: You’ll see how Java avoids the diamond problem of multiple inheritance by using interfaces.


3. Enumerations

💡 Concept Covered: Enum in Java + switch/case usage

👉 Question (Detailed):

Create an enum called Day with values: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY.

Write a program where you:

Take a day as input (for example, Day.SATURDAY).

Use a switch statement (or if-else) to check:

If the day is SATURDAY or SUNDAY, print "Weekend - Relax!".

Otherwise, print "Weekday - Work hard!".

Also, demonstrate how enums can be used in a loop to print all days of the week.

🎯 Learning outcome: You’ll see how enums can be used to represent constants in a program.
*/

public class Day4 {
    public static void main(String[] args) {
        Circle circle = new Circle(7.5);
        Rectangle rectangle = new Rectangle(6.5, 10.8);

        System.out.println(circle.calculateArea());
        circle.displayShapeName();

        System.out.println(rectangle.calculateArea());
        rectangle.displayShapeName();
    }
}

abstract class Shape {

    abstract double calculateArea();

    public void displayShapeName(){
        System.out.println("Shape: " + this.getClass().getSimpleName());
    }
    
}


class Circle extends Shape{

    private double radius;

    public Circle (double radius){
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return radius*radius;
    }



}

 class Rectangle  extends Shape{
    private double length ;
    private double breadth ;

    public Rectangle(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double calculateArea() {
        return length*breadth;
    }
    
}