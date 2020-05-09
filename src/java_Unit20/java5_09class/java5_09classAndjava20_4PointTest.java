package java_Unit20.java5_09class;

import java.util.Arrays;

/**
 * (对面板上的点进行排序)编写一个程序,满足下面的要求:
 * 定义一个名为 Point的类,它的两个数据域x和y分别表示点的x坐标和y坐标。实现
 * Comparable接口用于比较点的x坐标。如果两个点的x坐标一样,则比较它们的y坐标
 * 义一个名为 CompareR的类实现 Comparator<Point>。实现 compare方法来通过y坐标值
 * 比较两个点。如果y坐标值一样,则比较它们的x坐标值
 * 随机创建100个点,然后使用 Arrays,sort方法分别以它们x坐标的升序和y坐标的升序显
 * 示这些点
 */

public class java5_09classAndjava20_4PointTest {
    public static void main(String[] args) {

        // 创建一个点
//        double x = Math.random() * 100;
//        double y = Math.random() * 200;
//        java5_09classAndjava20_4PointClass m = new java5_09classAndjava20_4PointClass(x, y);

//        java5_09classAndjava20_4PointClass[] x =

        // 随机生成 100 个点
        java5_09classAndjava20_4PointClass[] m = new java5_09classAndjava20_4PointClass[100];

        for (int i = 0; i < 100; i++) {
            double x = Math.random() * 100;
            double y = Math.random() * 200;
            m[i] = new java5_09classAndjava20_4PointClass(x, y);

            System.out.println( "m[" + i + "]=" + m[i]);
        }

        // 对数组 m 由 x 从小到大排序
        Arrays.sort(m);
        for (int i = 0; i < 100; i++) {
            System.out.println( "m[" + i + "]=" + m[i]);
        }

        // 对数组 m 由 y 从小到大排序
        ComparatorY c = new ComparatorY();
        Arrays.sort(m, c);
        for (int i = 0; i < 100; i++) {
            System.out.println( "m[" + i + "]=" + m[i]);
        }
    }
}
