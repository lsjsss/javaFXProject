package java_Unit20;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class java5_08class {
    public static void main(String[] args) {
        // ����������a1 Ĭ�ϣ� a2 ָ�� 30
        ArrayList<Object> a1 = new ArrayList<>();
        // size() �������ص���ʵ��Ԫ�صĸ���
        System.out.println("a1 ��Ĭ��������С" + a1.size());

        ArrayList<Object> a2 = new ArrayList<>(30);
        System.out.println("a2 ��ָ��������С" + get(a2));


    }

    /** https://www.cnblogs.com/hs2018/p/10449970.html */
    public static int get(ArrayList a2) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //��ȡ elementData �ֶ�
            Field field = arrayListClass.getDeclaredField("elementData");
            //��ʼ����Ȩ��
            field.setAccessible(true);
            //��ʾ������get����ȡʵ���ֶ�elementData��ֵ
            Object[] objects = (Object[])field.get(a2);
            //���ص�ǰArrayListʵ��������ֵ
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
