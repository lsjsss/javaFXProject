package java_Unit21;

import java.util.*;

public class java21_08_TestMap {
  public static void main(String[] args) {
    // 创建一个HashMap  Create a HashMap
    Map<String, Integer> hashMap = new HashMap<>();
    // 左边是 Key 的类型，右边是 Value 的类型
    hashMap.put("Smith", 30);
    hashMap.put("Anderson", 31);
    hashMap.put("Lewis", 29);
    hashMap.put("Cook", 29);

    System.out.println("Display entries in HashMap");
    System.out.println(hashMap + "\n");

    // 从前面的HashMap创建一个TreeMap  Create a TreeMap from the preceding HashMap
    TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
    System.out.println("Display entries in ascending order of key");
    // 按照 Key 的升序排列
    System.out.println(treeMap);

    System.out.println(treeMap.firstKey());
    System.out.println(treeMap.headMap("Lewis"));
    treeMap.pollFirstEntry().setValue(88);
    System.out.println(treeMap.pollFirstEntry());

    // 创建一个LinkedHashMap  Create a LinkedHashMap
    // 容量达到 75% 时自动加载扩容
    Map<String, Integer> linkedHashMap =
      new LinkedHashMap<>(16, 0.75f, true);
    linkedHashMap.put("Smith", 30);
    linkedHashMap.put("Anderson", 31);
    linkedHashMap.put("Lewis", 29);
    linkedHashMap.put("Cook", 29);

    // 显示刘易斯的年龄  Display the age for Lewis
    System.out.println("\nThe age for " + "Lewis is " +
      linkedHashMap.get("Lewis"));

    System.out.println("Display entries in LinkedHashMap");
    System.out.println(linkedHashMap);
    
    // 显示每个条目的名称和年龄  Display each entry with name and age
    System.out.print("\nNames and ages are ");
    treeMap.forEach(
      (name, age) -> System.out.print(name + ": " + age + " "));
  }
}
