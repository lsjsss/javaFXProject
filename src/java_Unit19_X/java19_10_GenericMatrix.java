package java_Unit19_X;

public abstract class java19_10_GenericMatrix<E extends Number> {
    /**
     * Abstract method for adding two elements of the matrices
     * 矩阵两个元素相加的抽象方法
     */
    protected abstract E add(E o1, E o2);

    /**
     * Abstract method for multiplying two elements of the matrices
     * 矩阵两个元素相乘的抽象方法
     */
    protected abstract E multiply(E o1, E o2);

    /**
     * Abstract method for defining zero for the matrix element
     * 为矩阵元素定义零的抽象方法
     */
    protected abstract E zero();

    /**
     * Add two matrices
     * 加两个矩阵
     */
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        // 两个数组相加返回一个数值
        // Check bounds of the two matrices 检查两个矩阵的界限
        if ((matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length)) {
            //矩阵的大小不同
            throw new RuntimeException(
                    "The matrices do not have the same size");
        }

        E[][] result =
                (E[][]) new Number[matrix1.length][matrix1[0].length];
        // Perform addition 执行加法
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    /**
     * Multiply two matrices
     * 将两个矩阵相乘
     */
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        // Check bounds 检查界限
        if (matrix1[0].length != matrix2.length) {
            // 矩阵的大小不兼容
            throw new RuntimeException(
                    "The matrices do not have compatible size");
        }
        // Create result matrix 创建结果矩阵
        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];
        // Perform multiplication of two matrices 执行两个矩阵的乘法
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j],
                            multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }
        return result;
    }

    /**
     * Print matrices, the operator, and their operation result
     * 打印矩阵，运算符及其运算结果
     */
    public static void printResult(
            // op: +  *
            Number[][] m1, Number[][] m2, Number[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                System.out.print(" " + m1[i][j]);
            }
            if (i == m1.length / 2) {
                System.out.print(" " + op + " ");
            } else {
                System.out.print("   ");
            }
            for (int j = 0; j < m2.length; j++) {
                System.out.print(" " + m2[i][j]);
            }
            if (i == m1.length / 2) {
                System.out.print(" = ");
            } else {
                System.out.print("   ");
            }
            for (int j = 0; j < m3.length; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
