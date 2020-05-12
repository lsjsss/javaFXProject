package java_Unit20;

import java.util.Collections;
import java.util.PriorityQueue;

/** ���ȶ��� */
public class java20_11_PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue queue1 = new PriorityQueue<>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");
        System.out.println("ʹ�ÿɱ��Ե����ȶ���  Priority queue using Comparable:");
        // �ж϶��г����Ƿ���� 0�� �Ƴ�����Ԫ�أ� �Ӷ��׿�ʼ�Ƴ��� ���Ƚ������ȵ�˳��ɾ��
        while (queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }

        // ����
        PriorityQueue queue2 = new PriorityQueue<>(
                4, Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");
        System.out.println("\nʹ�ñȽ��������ȶ���  Priority queue using Comparator:");
        while (queue2.size() > 0) {
            System.out.print(queue2.remove() + " ");
        }
    }
}
