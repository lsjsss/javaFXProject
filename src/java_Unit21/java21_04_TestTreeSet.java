package java_Unit21;

import java.util.*;

public class java21_04_TestTreeSet {
    public static void main(String[] args) {
        // ����һ����ϣ��  Create a hash set
        Set<String> set = new HashSet<>();

        // ���ַ�����ӵ�������  Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        TreeSet<String> treeSet = new TreeSet<>(set);
        // ��������
        System.out.println("��������  Sorted tree set: " + treeSet);

        // ʹ��SortedSet�����еķ���  Use the methods in SortedSet interface
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());

        // ŦԼ  ǰ���Ԫ��
        System.out.println("headSet(\"New York\"): " +
                treeSet.headSet("New York"));

        // ŦԼ  �����Ԫ��
        System.out.println("tailSet(\"New York\"): " +
                treeSet.tailSet("New York"));

        // ʹ��NavigableSet�����еķ���  Use the methods in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet.lower("P"));
        System.out.println("higher(\"P\"): " + treeSet.higher("P"));
        System.out.println("floor(\"P\"): " + treeSet.floor("P"));
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));

        // �ҵ���һ��Ԫ�ز��Ӽ�����ɾ��
        System.out.println("pollFirst(): " + treeSet.pollFirst());
        System.out.println("pollLast(): " + treeSet.pollLast());
        System.out.println("New tree set: " + treeSet);
    }
}
