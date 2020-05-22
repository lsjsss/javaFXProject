package java_Unit21;

import java.util.*;

/**
 * ͳ�Ƶ��ʳ��ֵĴ�����
 * ʹ��ɢ��ӳ��� HashMap ���洢һ���ɵ��ʼ��������ɵĵ���
 */
public class java21_09_CountOccurrenceOfWords {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // ����һ��TreeMap�Խ�������Ϊ��������Ϊֵ  Create a TreeMap to hold words as key and count as value
        // �������� HashMap ͳ�ƣ� ���ʱ�ٷ�װ�� TreeMap�����Ч��
        Map<String, Integer> map = new TreeMap<>();

        // ���ı���Ϊ�ַ�������
        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    // value ����ֱ���޸�
                    map.put(key, value);
                }
            }
        }

        // ��ʾÿ����Ŀ�ļ���ֵ  Display key and value for each entry
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
