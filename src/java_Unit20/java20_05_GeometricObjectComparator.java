package java_Unit20;

import java_Unit13.java13_01_GeometricObject;
import java.util.Comparator;

public class java20_05_GeometricObjectComparator
        implements Comparator<java13_01_GeometricObject>, java.io.Serializable {
    /** 重写 Serializable 中的 compare 方法 */
    @Override
    public int compare(java13_01_GeometricObject o1, java13_01_GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        if (area1 < area2) {
            return -1;
        } else if (area1 == area2) {
            return 0;
        } else {
            return 1;
        }
    }
}
