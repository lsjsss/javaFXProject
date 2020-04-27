package java_Unit20;

import java.util.ArrayList;
import java.util.Collection;

public class java20_01_TestCollection {
    public static void main(String[] args) {
        //����һ�����Ա�
        ArrayList collection1 = new ArrayList<>();

        //��ų������ƣ���ӵ����Ա�(����)
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.println("A���ϳ����б�1  list of cities in collection1:");
        //������� collection1 �е�Ԫ��
        System.out.println(collection1);

        //true
        System.out.println("\n����˹�ղ����� Is Dallas in collection1? "
                + collection1.contains("Dallas"));

        //ɾ�������е�Ԫ�� Dallas�������»�ȡ���ϵĳ���
        collection1.remove("Dallas");
        System.out.println("\n" + collection1.size() +
                " �������ռ�����1 cities are in collection1 now");

        //����ڶ�������
        Collection collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");
        collection2.add("Los Angeles");
        collection2.add("Atlanta");

        System.out.println("\n�����еĳ����б�2 A list of cities in collection2:");
        System.out.println(collection2);

        //�������Ա�c1��������new�������ģ�����clone������������
        ArrayList c1 = (ArrayList)(collection1.clone());
        //7������
        c1.addAll(collection2);
        System.out.println("\n����1�򼯺�2�еĳ��� Cities in collection1 or collection2: ");
        System.out.println(c1);

        c1 = (ArrayList)(collection1.clone());
        //����1
        c1.retainAll(collection2);
        System.out.print("\n����1�ͼ���2�еĳ��� Cities in collection1 and collection2: ");
        System.out.println(c1);
        c1 = (ArrayList)(collection1.clone());
        c1.removeAll(collection2);
        System.out.print("\n����1�еĳ��У�������2�� Cities in collection1, but not in 2: ");
        System.out.println(c1);
    }
}

