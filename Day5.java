import java.util.Scanner;

public class Day5 {
    public static int factorial(int n){
        if(n == 0 || n== 1){
            return 1;
        }

        return n*factorial(n-1);
    }

    public static int fibonnacci(int n){
        if (n == 0) {
            return 0;
        } else if(n == 1){
            return 1;
        }else{
            return fibonnacci(n-1) + fibonnacci(n-2);
        }
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Ques: 1: Write a program of factorial of a number using recursion.
        int n = sc.nextInt();
        int factorialResult = factorial(n);
        // Ques:2 : using Recursion, write a program to print fibonacci series.
        int fibonacciResult = fibonnacci(n);
        // Ques: 3 : Write a program to find GCD of two numbers using recursion.
        int gcdResult = gcd(56, 98);
        System.out.println("Factorial of " + n + " is: " + factorialResult);
        System.out.println("Fibonacci of " + n + " is: " + fibonacciResult);
        System.out.println("GCD of 56 and 98 is: " + gcdResult);
        sc.close();
        
    }
}
