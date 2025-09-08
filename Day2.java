import java.lang.reflect.Method;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Strings in Java
        String s1 = "java"; //String literal
        // String s2 = "java"; //String literal

        // System.out.println(s1 == s2); //true even though we have not used new keyword because both s1 and s2 are pointing to same object in string pool

        // String s3 = new String("java"); //creating string using new keyword
        // String s4 = new String("java"); //creating string using new keyword
        // System.out.println(s3 == s4); //false because both s3 and s4 are pointing to different objects in heap memory
        // System.out.println(s3.equals(s4)); //true because both s3 and s4

        // Strings are array of characters. They are immutable (cannot be changed) because they are stored in string pool. If we try to change a string, a new object is created in heap memory that is not in string pool.
        // String methods
        // System.out.println(s1.length()); //4
        // System.out.println(s1.charAt(1)); //a
        // System.out.println(s1.concat(" is a programming language")); //java is a programming language
        // System.out.println(s1.contains("ava")); //true
        // System.out.println(s1.equals("Java")); //false
        // System.out.println(s1.equalsIgnoreCase("Java")); //true brcause it ignores case sensitivity
        // System.out.println(s1.indexOf('a')); //1
        // System.out.println(s1.lastIndexOf('a')); //3
        // System.out.println(s1.replace('a', 'o')); //jovo
        // System.out.println(s1.substring(1, 3)); //av
        // System.out.println(s1.toUpperCase()); //JAVA
        // System.out.println(s1.toLowerCase()); //java
        // System.out.println(s1.trim()); //java (removes leading and trailing spaces)
        // System.out.println(s1.startsWith("ja")); //true
        // System.out.println(s1.endsWith("va")); //true
        // System.out.println(s1.isEmpty()); //false
        // System.out.println(s1.split("a")); //[j, v, ] (splits the string at each occurrence of the specified character and returns an array of substrings)
       
        //traversing a string
        // for (int i = 0; i < s1.length(); i++) {
        //     System.out.println(s1.charAt(i));
        // }

        // for(String s : s1.split("")){
        //     System.out.println(s);
        // }


        // StringBuilder
        // StringBuilder sb = new StringBuilder("java");
        // System.out.println(sb); //java
        // System.out.println(sb.append(" is a programming language")); //java is a programming language
        // System.out.println(sb.insert(4, " is a programming language")); //java is a programming language
        // System.out.println(sb.delete(4, 15)); //java
        // System.out.println(sb.reverse()); //avaj
        // System.out.println(sb.replace(4, 15, "is a programming language")); //java is a programming language
        // System.out.println(sb.length()); //4

        // StringBuffer
        // StringBuffer sbf = new StringBuffer("java");
        // System.out.println(sbf); //java
        // System.out.println(sbf.append(" is a programming language")); //java is a programming language
        // System.out.println(sbf.insert(4, " is a programming language")); //java is a programming language
        // System.out.println(sbf.delete(4, 15)); //java
        // System.out.println(sbf.reverse()); //avaj
        // System.out.println(sbf.replace(4, 15, "is a programming language")); //java is a programming language
        // System.out.println(sbf.length()); //4


        // // **Difference between StringBuffer and StringBuilder:**

        // | Feature         | StringBuffer         | StringBuilder        |
        // |-----------------|---------------------|---------------------|
        // | Thread Safety   | Yes (synchronized)  | No                  |
        // | Performance     | Slower              | Faster              |
        // | Introduced in   | Java 1.0            | Java 5              |
        // | Use Case        | Multi-threaded      | Single-threaded     |
        // | Methods         | Same as StringBuilder | Same as StringBuffer |

        // Use `StringBuilder` for most cases unless thread safety is required.



        // OOPS in Java
        // Class - blueprint of an object. It is a user-defined data type that contains variables and methods to represent the properties and behaviors of an object.
        // Object - instance of a class. It is created using the `new` keyword.
        // Constructor - special method that is called when an object is created. It is used to initialize the properties of an object. It has the same name as the class and does not have a return type.
        // Types of Constructors:
        // 1. Default Constructor - constructor that does not take any parameters. It is provided by the compiler if no constructor is defined in the class.
        // 2. Parameterized Constructor - constructor that takes parameters. It is used to initialize the properties of an object with specific values.
        // 3. Copy Constructor - constructor that takes an object of the same class as a parameter. It is used to create a new object as a copy of an existing object.
        // 4. Constructor Chaining - calling one constructor from another constructor using `this()` keyword. It is used to avoid code duplication and to initialize the properties of an object in a single place.
        // 5. Private Constructor - constructor that is declared as private. It is used to restrict the instantiation of a class from outside the class. It is used in Singleton Design Pattern.
        // 6. Abstract class Constructor - constructor that is declared in an abstract class. It is used to initialize the properties of an object of a subclass. It is used in Factory Design Pattern.
        // 7. Record class Constructor - constructor that is declared in a record class. It is used to initialize the properties of an object of a record class. It is used to create immutable data classes.

        /*
         * 📝 Q1. Student Class Basics

            👉 Create a Student class with:

            Attributes: name, age, marks

            A constructor to initialize values

            A method displayDetails() to print the student’s details

            Extra Twist: Create 3 different students and print their details.

        *  📝 Q2. Average Marks (Method Overloading)

            👉 Extend your Student class:

            Add two methods named calculateAverage (method overloading):

            calculateAverage(int m1, int m2) → returns average of 2 subjects

            calculateAverage(int m1, int m2, int m3) → returns average of 3 subjects

            Extra Twist: Create a student and call both methods.

       * 📝 Q3. Compare Students (OOP Practice)

            👉 Write a program:

            Create two students.

            Write a method compareMarks(Student s1, Student s2) → prints who scored more marks.

            Use constructor to initialize students.
         */


        // Ques 1 : Solution
        Student std1  = new Student("John", 10, 85);
        Student std2 = new Student("Keshav", 21 , 95);
        Student std3 = new Student("Annu", 20, 75);

        std1.displayDetails();
        std2.displayDetails();
        std3.displayDetails();
        sc.close();
    }
}

class Student {
    String name;
    int age;
    int marks;

    // Constructor to initialize values
    public Student(String name, int age, int marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public void displayDetails(){
        System.out.println("Name: " + name + " his age is " + age + " and he obtained " + marks);
    }

    public float calculateAverage(int m1, int m2){
        return (m1 + m2)/2;
    }

    public float calculateAverage(int m1, int m2, int m3){
        return (m1 + m2 + m3)/3;
    }
} 
