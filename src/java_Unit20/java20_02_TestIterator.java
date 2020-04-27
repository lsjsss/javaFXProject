package java_Unit20;

import java.util.*;

public class java20_02_TestIterator {
    public static void main(String[] args) {
        //线性表
        ArrayList<String> collection = new ArrayList<>();
        //向集合中添加元素
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");

        //是在 Collection 的父接口 Iterable 中的方法
        Iterator<String> iterator = collection.iterator();

        //取出元素，转换为大写字母
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();

        //第二次遍历时输出到集合尾部，不再输出文本
        //取出元素，转换为大写字母,倒序输出
        ListIterator<String> iterator2 = collection.listIterator();
        while (iterator2.hasPrevious()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();
    }
}

