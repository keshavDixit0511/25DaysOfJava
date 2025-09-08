public class Day3 {
    public static void main(String[] args) {
        /*
            ❓ Question 1

            Create a Person class with name and age. Extend it into a Student class with marks.

            Use a constructor in Student that calls the parent constructor using super().

            Write a method displayDetails() in both classes, and override it in Student to also show marks.
            👉 Print both versions using an object of Student.

            ❓ Question 2

            Add another subclass Teacher extending Person with a field subject.

            Show constructor chaining with super() in Teacher.

            Override displayDetails() in Teacher as well.
            👉 Create objects of both Student and Teacher and call displayDetails(). Observe polymorphism.

            ❓ Question 3

            Modify Student class:

            Add a method calculateGrade() which returns grade based on marks.

            Call this method inside the overridden displayDetails().
            👉 Test with multiple students (different marks) and show how overriding + extra methods work together.
        */
        Person p1 = new Person("Alice", 30);
        p1.displayDetails();
        Student s1 = new Student("Keshav",24 ,96);
        s1.displayDetails();
        Teacher t1 = new Teacher("Annu", 20, "Math");
        t1.displayDetails();
        
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void displayDetails(){
        System.out.println("Name: " + name + " age: " + (age));
    }
}
class Student extends Person {
    int marks;

    public Student(String name, int age, int marks){
        super(name, age);
        this.marks = marks;
    }

    @Override
    public void displayDetails(){
        System.out.println("Name: " + name + " age: " + age + " marks: " + marks + " grade: " + calculateGrade());
    }

    public char calculateGrade(){
        if(marks >= 90) return 'A';
        else if(marks >= 80) return 'B';
        else if(marks >= 70) return 'C';
        else if(marks >= 60) return 'D';
        else return 'F';
    }
}

class Teacher extends Person{
    String subject;

    public Teacher(String Name, int age, String subject){
        super(Name, age);
        this.subject = subject;
    }
    @Override
    public void displayDetails(){
        System.out.println("Name: "+ name + " age: " + age + " Subject: " + subject);
    }
}