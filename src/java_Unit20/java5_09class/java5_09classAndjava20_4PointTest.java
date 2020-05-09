package java_Unit20.java5_09class;

import java.util.Arrays;

/**
 * (������ϵĵ��������)��дһ������,���������Ҫ��:
 * ����һ����Ϊ Point����,��������������x��y�ֱ��ʾ���x�����y���ꡣʵ��
 * Comparable�ӿ����ڱȽϵ��x���ꡣ����������x����һ��,��Ƚ����ǵ�y����
 * ��һ����Ϊ CompareR����ʵ�� Comparator<Point>��ʵ�� compare������ͨ��y����ֵ
 * �Ƚ������㡣���y����ֵһ��,��Ƚ����ǵ�x����ֵ
 * �������100����,Ȼ��ʹ�� Arrays,sort�����ֱ�������x����������y�����������
 * ʾ��Щ��
 */

public class java5_09classAndjava20_4PointTest {
    public static void main(String[] args) {

        // ����һ����
//        double x = Math.random() * 100;
//        double y = Math.random() * 200;
//        java5_09classAndjava20_4PointClass m = new java5_09classAndjava20_4PointClass(x, y);

//        java5_09classAndjava20_4PointClass[] x =

        // ������� 100 ����
        java5_09classAndjava20_4PointClass[] m = new java5_09classAndjava20_4PointClass[100];

        for (int i = 0; i < 100; i++) {
            double x = Math.random() * 100;
            double y = Math.random() * 200;
            m[i] = new java5_09classAndjava20_4PointClass(x, y);

            System.out.println( "m[" + i + "]=" + m[i]);
        }

        // ������ m �� x ��С��������
        Arrays.sort(m);
        for (int i = 0; i < 100; i++) {
            System.out.println( "m[" + i + "]=" + m[i]);
        }

        // ������ m �� y ��С��������
        ComparatorY c = new ComparatorY();
        Arrays.sort(m, c);
        for (int i = 0; i < 100; i++) {
            System.out.println( "m[" + i + "]=" + m[i]);
        }
    }
}
