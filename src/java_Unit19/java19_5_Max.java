package java_Unit19;

public class java19_5_Max {
    /**
     * Return the maximum of two objects
     */
    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        }
        else {
            return o2;
        }
    }
}
