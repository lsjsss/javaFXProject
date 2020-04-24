package java_Unit19;

public class java19_13_TestIntegerMatrix {
    public static void main(String[] args) {
        // Create Integer arrays m1, m2
        Integer[][] m1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {1, 1, 1}};
        Integer[][] m2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

        // Create an instance of IntegerMatrix
        java19_11_IntegerMatrix integerMatrix = new java19_11_IntegerMatrix();
        System.out.println("\nm1 + m2 is ");
        java19_10_GenericMatrix.printResult(
                m1, m2, integerMatrix.addMatrix(m1, m2), '+');
        System.out.println("\nm1 * m2 is ");
        java19_10_GenericMatrix.printResult(
                m1, m2, integerMatrix.multiplyMatrix(m1, m2), '*');
    }
}
