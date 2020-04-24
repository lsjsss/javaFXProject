package java_Unit19;

public class java19_04_GenericSort {
    public static void main(String[] args) {
        // Create an Integer array
        //创建一个 Integer 类型数组
        Integer[] intArray = {new Integer(2), new Integer(4),
                new Integer(3)};

        // Create a Double array
        //创建一个Double类型数组
        Double[] doubleArray = {new Double(3.4), new Double(1.3),
                new Double(-22.1)};

        // Create a Character array
        //创建一个字符类型的数组
        Character[] charArray = {new Character('a'),
                new Character('J'), new Character('r')};

        // Create a String array
        //创建一个字符串数组
        String[] stringArray = {"Tom", "Susan", "Kim"};

        // Sort the arrays
        //编一段程序，对以上四种类型排序
        //排序这四个数组(使用泛型)
        sort(intArray);
        sort(doubleArray);
        sort(charArray);
        sort(stringArray);

        // Display the sorted arrays
        //输出四种类型数组，使用同一种方法输出(使用泛型)
        System.out.print("Sorted Integer objects: ");
        printList(intArray);
        System.out.print("Sorted Double objects: ");
        printList(doubleArray);
        System.out.print("Sorted Character objects: ");
        printList(charArray);
        System.out.print("Sorted String objects: ");
        printList(stringArray);
    }

    /**
     * Sort an array of comparable objects
     * 两个 E 类型对象进行比较(同一类型进行比较)，
     * E 是 Comparable 的子类型，
     * 指定进行比较的元素是 E 类型，
     * 可比较对象的数组排序
     */
    public static <E extends Comparable<E>> void sort(E[] list) {//泛型方法，受限的泛型
        //声明 E 的一个变量(最小值)
        E currentMin;

        //声明整型的最小值的下标
        int currentMinIndex;

        //双重循环，解决排序问题
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i+1..list.length?2]
            currentMin = list[i];
            currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            // Swap list[i] with list[currentMinIndex] if necessary;
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    /**
     * Print an array of objects
     */
    public static void printList(Object[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
