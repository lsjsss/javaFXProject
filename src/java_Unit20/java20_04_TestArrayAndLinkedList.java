package java_Unit20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class java20_04_TestArrayAndLinkedList {
    public static void main(String[] args) {
        // 创建了一个 ArrayList 对象 --> 不能在末尾之外其他地方插入删除元素
        // 泛型 集合， 孪生兄弟 只能存放包装类整数
        // List 作为左边的对象情况很常用，接口名做对象类型约束，典型的多态（List）， 既可以放 ArrayList 对象， 也可以放 LinkedList 对象
        // Arraylist 可看作 List 的子类
        List arrayList = new ArrayList<>();

        // 1自动装箱到新的Integer（1）  1 is autoboxed to new Integer(1)
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        //向末尾添加了五个元素  顺序：[1,2,3,1,4]

        //[10,1,2,3,1,4]
        arrayList.add(0, 10);

        //[10,1,2,30,3,1,4]
        arrayList.add(3, 30);

        // 输出
        System.out.println("数组列表中的整数列表 A list of integers in the array list:");
        System.out.println(arrayList);

        // LinkedList 的使用
        // 可在末尾之外其他地方插入和删除元素
        // 现在已经具备了 7 个元素
        LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);

        ////
        // 正向输出
        System.out.println("向前显示链接列表 Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////


        linkedList.add(1, "red");

        ////
        // 正向输出
        System.out.println("向前显示链接列表(添加 add) Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////

        // 删除第一个元素
        linkedList.removeLast();

        ////
        // 正向输出
        System.out.println("向前显示链接列表(删除 removeLast) Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////

        // 添加 green 元素到最后
        linkedList.addFirst("green");
        System.out.println("向前显示链接列表 Display the linked list forward:");

        ////
        // 正向输出
        System.out.println("向前显示链接列表(添加 addfirst) Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////



        ListIterator<Object> listIterator = linkedList.listIterator();

        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        System.out.println("向后显示链接列表 Display the linked list backward:");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}
