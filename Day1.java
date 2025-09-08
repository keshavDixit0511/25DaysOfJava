import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Ques: 1 : Write a program that takes farenheit as input and converts it to celsius.
        // System.out.println("Enter your temprature in F");
        // int farenheit = sc.nextInt();
        // double celsius = (farenheit - 32)/ 1.8;
        // System.out.printf("Temperature in Celsius: %.2f", celsius);
        //Ques: 2 : write a program to print prime numbers between 1 to n.
        System.out.println("Enter a number till there you want to check prime numbers");
        int n = sc.nextInt();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        //Ques: 3 : Write a program to print factorial of a number using loop.
        //Ques: 4 : write a program to reverse a number.
        //Ques: 5 : Write a program to check palindrom string.
        //Ques: 6 : Write a program to print this two pattern.
        /*
             *
             * *
             * * *
             * * * *
             * * * * *
            
            
                *
               * *
              * * *
             * * * *
            * * * * *
        */

        /*Ques: 7 : The Life insaurance is Based on age and smoking status.
        example :
        Age Range | For non-smoker($) | For smoker($)
        25 to 35   |  33              |  92
        36 to 45   |  50              |  179
        46 to 55   |  318              |  1007
        Using the data Provided , develop a java program where user can input his age and smoking status
        and the program will display the life insaurance premium.
        
        */
        sc.close();
    }

    private static boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }

        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
