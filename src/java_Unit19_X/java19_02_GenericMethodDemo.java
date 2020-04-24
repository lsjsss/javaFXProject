package java_Unit19_X;

public class java19_02_GenericMethodDemo {
    public static void main(String[] args ) {
        Integer[] integers = {1, 2, 3, 4, 5};
        String[] strings = {"London", "Paris", "New York", "Austin"};
        java19_02_GenericMethodDemo.<Integer>print(integers);
        java19_02_GenericMethodDemo.<String>print(strings);
    }
    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
