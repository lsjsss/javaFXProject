package java_Unit20.java5_09class;

/**
 * (对面板上的点进行排序)编写一个程序,满足下面的要求:
 * 定义一个名为 Point的类,它的两个数据域x和y分别表示点的x坐标和y坐标。实现
 * Comparable接口用于比较点的x坐标。如果两个点的x坐标一样,则比较它们的y坐标
 * 义一个名为 CompareR的类实现 Comparator<Point>。实现 compare方法来通过y坐标值
 * 比较两个点。如果y坐标值一样,则比较它们的x坐标值
 * 随机创建100个点,然后使用 Arrays,sort方法分别以它们x坐标的升序和y坐标的升序显
 * 示这些点
 */

public class java5_09classAndjava20_4PointClass implements Comparable<java5_09classAndjava20_4PointClass> {
    double x = 0.0;
    double y = 0.0;

    /** 方法：构造、set get、输出 */
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

    /** 重写 CompareTo() 比较方法 */
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
