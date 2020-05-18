package java_Unit21;

import java.util.*;

public class java21_04_TestTreeSet {
    public static void main(String[] args) {
        // 创建一个哈希集  Create a hash set
        Set<String> set = new HashSet<>();

        // 将字符串添加到集合中  Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        TreeSet<String> treeSet = new TreeSet<>(set);
        // 升序排序
        System.out.println("排序树集  Sorted tree set: " + treeSet);

        // 使用SortedSet界面中的方法  Use the methods in SortedSet interface
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());

        // 纽约  前面的元素
        System.out.println("headSet(\"New York\"): " +
                treeSet.headSet("New York"));

        // 纽约  后面的元素
        System.out.println("tailSet(\"New York\"): " +
                treeSet.tailSet("New York"));

        // 使用NavigableSet界面中的方法  Use the methods in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet.lower("P"));
        System.out.println("higher(\"P\"): " + treeSet.higher("P"));
        System.out.println("floor(\"P\"): " + treeSet.floor("P"));
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));

        // 找到第一个元素并从集合中删除
        System.out.println("pollFirst(): " + treeSet.pollFirst());
        System.out.println("pollLast(): " + treeSet.pollLast());
        System.out.println("New tree set: " + treeSet);
    }
}
