package java_Unit20;

import java.util.ArrayList;

public class java4_26_27class {
    public static void main(String[] args) {
        //����һ�����ϣ���ӽ�����Ԫ��  ������
        ArrayList<String> al = new ArrayList<>();
        //�򼯺�������ַ������� Collection �ӿڼ̳е�
        al.add("name1");
        //ʹ��ָ��λ�õ���ӷ�ʽ���Ǵ� List �ӿڼ̳е�
        al.add(1,"name2");
        //�����õ���������ӷ�����List Ϊ Collection ���ӽӿ�
        //List �ӿ����м���add�����������Ԫ��

        //�鿴 addAll �����е�Ԫ��, �鿴���ϳߴ�
        System.out.println(al.size());
        //��������(ʹ�� for ѭ��)
        for (int i = 0; i < al.size(); i++) {
            //ָ��Ҫ��ȡԪ�ص��±�
            System.out.println(al.get(i));
        }

        //�����һ�����ϵ�Ԫ�أ�ʹ�� addAll,0��ʾ���λ��
        ArrayList<String> al2 = new ArrayList<>();
        al2.addAll(0,al);
        for (int i = 0; i < al2.size(); i++) {
            //ָ��Ҫ��ȡԪ�ص��±�
            System.out.println(al2.get(i));
        }

        //clear ��������ռ���
        al2.clear();
        for (int i = 0; i < al2.size(); i++) {
            //ָ��Ҫ��ȡԪ�ص��±�
            System.out.println(al2.get(i));
        }

        //�жϼ����а������󣬼����а�������
        //����Ƿ��ڼ�����
        System.out.println(al.contains("name1"));

        //��鼯�������Ƿ���ͬ
        ArrayList<String> al3 = new ArrayList<>();
        al3.addAll(0,al);
        System.out.println(al.containsAll(al3));

        //����
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));

//        //ɾ���������Ӽ�
//        al.add(2,"name3");
//        //Collection
//        al.remove("name4");
//        //List
//        al.remove(2);
//        al.removeAll(al2);
//        //false
//        System.out.println("" + al.isEmpty());

        //�ж�һ�������Ƿ�����һ�����ϵ��Ӽ�
        // true ˵�� al2 �� al ���Ӽ�
        System.out.println(al.retainAll(al2));
        System.out.println(al2.retainAll(al));

        Object[] s = (al.toArray());
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        //println�ܹ���������������͡����ϣ��������������
        String[] a = {"����","�Ϻ�","���ͺ���"};

        ArrayList<String> al5 = new ArrayList<>();
        al5.add("name1");
        al5.add("name2");
        al5.add("name3");
        al5.add("name4");
        al5.add("name5");
        al5.add("name1");
        System.out.println(al5);

        System.out.println("indexOf ˳����Ҷ�����±�" + al5.indexOf("name1"));
        System.out.println("lastIndexOf ������Ҷ�����±�" + al5.lastIndexOf("name1"));

        //�޸�Ԫ��
        al5.set(5, "name6");
        System.out.println(al5);

        //ɾ�� ĳ���±�λ�� ��Ԫ��
        al5.remove(3);
        System.out.println(al5);

        System.out.println(al5.subList(1, 4));


    }
}
