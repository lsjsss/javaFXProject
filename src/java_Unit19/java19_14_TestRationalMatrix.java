package java_Unit19;

import java_Unit13.Rational;

public class java19_14_TestRationalMatrix {
    public static void main(String[] args) {
        // 创建两个Rational数组m1和m2  Create two Rational arrays m1 and m2
        Rational[][] m1 = new Rational[3][3];
        Rational[][] m2 = new Rational[3][3];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m1[i][j] = new Rational(i + 1, j + 5);
                m2[i][j] = new Rational(i + 1, j + 6);
            }
        }
        // 创建一个RationalMatrix实例  Create an instance of RationalMatrix
        java19_12_RationalMatrix rationalMatrix = new java19_12_RationalMatrix();
        System.out.println("\nm1 + m2 is ");
        java19_10_GenericMatrix.printResult(
                m1, m2, rationalMatrix.addMatrix(m1, m2), '+');
        System.out.println("\nm1 * m2 is ");
        java19_10_GenericMatrix.printResult(
                m1, m2, rationalMatrix.multiplyMatrix(m1, m2), '*');
    }
}
