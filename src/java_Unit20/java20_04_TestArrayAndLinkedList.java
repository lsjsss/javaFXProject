package java_Unit20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class java20_04_TestArrayAndLinkedList {
    public static void main(String[] args) {
        // ������һ�� ArrayList ���� --> ������ĩβ֮�������ط�����ɾ��Ԫ��
        // ���� ���ϣ� �����ֵ� ֻ�ܴ�Ű�װ������
        // List ��Ϊ��ߵĶ�������ܳ��ã��ӿ�������������Լ�������͵Ķ�̬��List���� �ȿ��Է� ArrayList ���� Ҳ���Է� LinkedList ����
        // Arraylist �ɿ��� List ������
        List arrayList = new ArrayList<>();

        // 1�Զ�װ�䵽�µ�Integer��1��  1 is autoboxed to new Integer(1)
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        //��ĩβ��������Ԫ��  ˳��[1,2,3,1,4]

        //[10,1,2,3,1,4]
        arrayList.add(0, 10);

        //[10,1,2,30,3,1,4]
        arrayList.add(3, 30);

        // ���
        System.out.println("�����б��е������б� A list of integers in the array list:");
        System.out.println(arrayList);

        // LinkedList ��ʹ��
        // ����ĩβ֮�������ط������ɾ��Ԫ��
        // �����Ѿ��߱��� 7 ��Ԫ��
        LinkedList<Object> linkedList = new LinkedList<Object>(arrayList);

        ////
        // �������
        System.out.println("��ǰ��ʾ�����б� Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////


        linkedList.add(1, "red");

        ////
        // �������
        System.out.println("��ǰ��ʾ�����б�(��� add) Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////

        // ɾ����һ��Ԫ��
        linkedList.removeLast();

        ////
        // �������
        System.out.println("��ǰ��ʾ�����б�(ɾ�� removeLast) Display the linked list forward:");
        for(int i = 0; i <= linkedList.size() - 1; i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
        ////

        // ��� green Ԫ�ص����
        linkedList.addFirst("green");
        System.out.println("��ǰ��ʾ�����б� Display the linked list forward:");

        ////
        // �������
        System.out.println("��ǰ��ʾ�����б�(��� addfirst) Display the linked list forward:");
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
        System.out.println("�����ʾ�����б� Display the linked list backward:");
        listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }
}
