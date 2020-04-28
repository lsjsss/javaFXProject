package java_Unit19;
//6组 - 19.4 实现对泛型类型的线性搜索
import java.util.Scanner;

public class java4_28_Exercise19_4 {
    public static void main(String[] args) {
        // 定义线性表
        Integer[] list = new Integer[10];
        Scanner input = new Scanner(System.in);

        // 接收数据，添加到线性表
        System.out.print("输入10个整型元素：");
        for (int i = 0; i < 10; i++) {
            list[i] = input.nextInt();
        }

        // 查找线性表中的数
        System.out.print("输入需要查找的数：");
        Integer key = input.nextInt();
        System.out.println(key + " 在列表中线性表中的所处的位置是：" + (linearSearch(list, key) + 1));

    }

    /** 线性查找元素  泛型方法  实现 */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        int length = list.length;
        for (int i = 0; i < length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
}
