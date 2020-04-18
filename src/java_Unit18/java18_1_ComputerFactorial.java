package java_Unit18;

import java.util.Scanner;

public class java18_1_ComputerFactorial {
    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        int n = input.nextInt();
        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }

    /**
     * Return the factorial for the specified number
     */
    public static long factorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        } else {
            // Recursive call
            return n * factorial(n - 1);
        }
    }
}
