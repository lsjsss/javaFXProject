package java_Unit19;
//6�� - 19.4 ʵ�ֶԷ������͵���������
import java.util.Scanner;

public class java4_28_Exercise19_4 {
    public static void main(String[] args) {
        // �������Ա�
        Integer[] list = new Integer[10];
        Scanner input = new Scanner(System.in);

        // �������ݣ���ӵ����Ա�
        System.out.print("����10������Ԫ�أ�");
        for (int i = 0; i < 10; i++) {
            list[i] = input.nextInt();
        }

        // �������Ա��е���
        System.out.print("������Ҫ���ҵ�����");
        Integer key = input.nextInt();
        System.out.println(key + " ���б������Ա��е�������λ���ǣ�" + (linearSearch(list, key) + 1));

    }

    /** ���Բ���Ԫ��  ���ͷ���  ʵ�� */
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        int length = list.length;
        for (int i = 0; i < length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }
}
