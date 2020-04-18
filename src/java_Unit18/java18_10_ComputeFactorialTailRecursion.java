package java_Unit18;

public class java18_10_ComputeFactorialTailRecursion {
    /**
     * Return the factorial for a specified number
     */
    public static long factorial(int n) {
        // Call auxiliary method
        return factorial(n, 1);
    }

    /**
     * Auxiliary tail?recursive method for factorial
     */
    private static long factorial(int n, int result) {
        if (n == 0) {
            return result;
        } else {
            // Recursive call
            return factorial(n - 1, n * result);
        }
    }
}
