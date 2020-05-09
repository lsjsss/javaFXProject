package java_Unit20;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class java5_08_09class {
    public static void main(String[] args) {
        // ���鳤�Ȳ���:ʹ�� length ����
        int[] x = new int[10];
        System.out.println(x.length);

        // �ַ�������:ʹ�� length() ����
        String s = "abcdefg";
        System.out.println(s.length());

        // ���ϴ�С:ʹ�� size() ����
        ArrayList<Object> ar = new ArrayList<>();

        // ���ϵ�����:ʹ�÷���

        // ����������a1 Ĭ�ϣ� a2 ָ�� 30
        ArrayList<Object> a1 = new ArrayList<>();
        // size() �������ص���ʵ��Ԫ�صĸ���
        System.out.println("a1 ��Ĭ��������С" + get(a1));

        ArrayList<Object> a2 = new ArrayList<>(30);
        System.out.println("a2 ��ָ��������С" + get(a2));
        // ��ʼĬ�ϴ�СΪ 10
        // ��������������Ϊԭ���� 1.5 ��
        // Ĭ�ϼ������� 1.0
        // size() �����ǻ���Ԫ�صĸ���

        //���һ��Ԫ��
        a2.add(5);
        a2.trimToSize();//������С����ʵ��Ԫ�ظ�����Ӧ��
        System.out.println(get(a2));


    }


    /** https://www.cnblogs.com/hs2018/p/10449970.html */
    public static int get(ArrayList a) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //��ȡ elementData �ֶ�
            Field field = arrayListClass.getDeclaredField("elementData");
            //��ʼ����Ȩ��
            field.setAccessible(true);
            //��ʾ������get����ȡʵ���ֶ�elementData��ֵ
            Object[] objects = (Object[])field.get(a);
            //���ص�ǰArrayListʵ��������ֵ
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void getCapacity(ArrayList<Object> l) {

    }
}
