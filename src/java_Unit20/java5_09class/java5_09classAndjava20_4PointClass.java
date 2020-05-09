package java_Unit20.java5_09class;

/**
 * (������ϵĵ��������)��дһ������,���������Ҫ��:
 * ����һ����Ϊ Point����,��������������x��y�ֱ��ʾ���x�����y���ꡣʵ��
 * Comparable�ӿ����ڱȽϵ��x���ꡣ����������x����һ��,��Ƚ����ǵ�y����
 * ��һ����Ϊ CompareR����ʵ�� Comparator<Point>��ʵ�� compare������ͨ��y����ֵ
 * �Ƚ������㡣���y����ֵһ��,��Ƚ����ǵ�x����ֵ
 * �������100����,Ȼ��ʹ�� Arrays,sort�����ֱ�������x����������y�����������
 * ʾ��Щ��
 */

public class java5_09classAndjava20_4PointClass implements Comparable<java5_09classAndjava20_4PointClass> {
    double x = 0.0;
    double y = 0.0;

    /** ���������졢set get����� */
    public java5_09classAndjava20_4PointClass(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "java5_09classAndjava20_4Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /** ��д CompareTo() �ȽϷ��� */
    @Override
    public int compareTo(java5_09classAndjava20_4PointClass mp) {
        int flag = -2;
        if (this.x > mp.x){
            flag = 1;
        } else if (this.x < mp.x){
            flag = -1;
        } else {
            if (this.y > mp.y) {
                flag = 1;
            } else if (this.y < mp.y) {
                flag = -1;
            } else {
               flag = 0;
            }
        }
        return flag;
    }
}
