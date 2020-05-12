package java_Unit20;

import java.util.Collections;
import java.util.PriorityQueue;

/** 优先队列 */
public class java20_11_PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue queue1 = new PriorityQueue<>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");
        System.out.println("使用可比性的优先队列  Priority queue using Comparable:");
        // 判断队列长度是否大于 0， 移除所有元素， 从队首开始移除， 按比较器优先的顺序删除
        while (queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }

        // 反序
        PriorityQueue queue2 = new PriorityQueue<>(
                4, Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");
        System.out.println("\n使用比较器的优先队列  Priority queue using Comparator:");
        while (queue2.size() > 0) {
            System.out.print(queue2.remove() + " ");
        }
    }
}
