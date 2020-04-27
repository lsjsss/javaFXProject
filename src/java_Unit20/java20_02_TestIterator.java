package java_Unit20;

import java.util.*;

public class java20_02_TestIterator {
    public static void main(String[] args) {
        //���Ա�
        ArrayList<String> collection = new ArrayList<>();
        //�򼯺������Ԫ��
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");

        //���� Collection �ĸ��ӿ� Iterable �еķ���
        Iterator<String> iterator = collection.iterator();

        //ȡ��Ԫ�أ�ת��Ϊ��д��ĸ
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();

        //�ڶ��α���ʱ���������β������������ı�
        //ȡ��Ԫ�أ�ת��Ϊ��д��ĸ,�������
        ListIterator<String> iterator2 = collection.listIterator();
        while (iterator2.hasPrevious()) {
            System.out.print(iterator.next().toUpperCase() + " ");
        }
        System.out.println();
    }
}

