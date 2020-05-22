package java_Unit21;

import java.util.*;

/**
 * 统计单词出现的次数：
 * 使用散列映射表 HashMap 来存储一对由单词及其计数组成的单词
 */
public class java21_09_CountOccurrenceOfWords {
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // 创建一个TreeMap以将单词作为键并计算为值  Create a TreeMap to hold words as key and count as value
        // 可以先用 HashMap 统计， 输出时再封装成 TreeMap，提高效率
        Map<String, Integer> map = new TreeMap<>();

        // 把文本分为字符串数组
        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    // value 不可直接修改
                    map.put(key, value);
                }
            }
        }

        // 显示每个条目的键和值  Display key and value for each entry
        map.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
