package java_Unit21;

import java.util.*;

public class java21_01_TestHashSet {
    public static void main(String[] args) {
        /** ����һ����ϣ�� Create a hash set */
        Set<String> set = new HashSet<>();
        /** ���ඨ�岻�߱�ͨ���� */
        HashSet<String> hSet = new HashSet<>();

        // ���ַ�����ӵ������� Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        // �ڶ����ظ���ӣ�Set �в���������ظ�Ԫ��
        set.add("New York");
        // remove()    clear()

        // HahSet AbstractSet AbstractCollection    Set Collection
        System.out.println(set);

        // ��ʾ��ϣ���е�Ԫ�� display the elements in the hash set
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }

        // ʹ��forEach��������Ԫ�� Process the elements using a forEach method
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }
}
