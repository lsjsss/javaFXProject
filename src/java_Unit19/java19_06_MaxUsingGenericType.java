package java_Unit19;

public class java19_06_MaxUsingGenericType {
    /** 返回两个对象的最大值  Return the maximum of two objects */
    public static <E extends Comparable<E>> E max(E o1, E o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        }
        else {
            return o2;
        }
    }
}

