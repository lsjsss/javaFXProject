package java_Unit20;

import java.util.Vector;

public class java5_12class {
    public static void main(String[] args) {
        //����һ����������
        Vector<String> vl = new Vector<>(20,8);

        // ������������� 5 ��Ԫ�� (�ַ���)
        vl.add("�й�");
        vl.add("�¹�");
        vl.add("����");
        vl.add("�ձ�");
        vl.add("Խ��");

        System.out.println(vl);
        System.out.println(vl.capacity());

        System.out.println(vl.elementAt(2));

        // ɾ��Ԫ��
        vl.remove(2);
        System.out.println(vl);
    }
}
