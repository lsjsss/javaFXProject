package java_Unit21;

import java.util.*;

public class java21_08_TestMap {
  public static void main(String[] args) {
    // ����һ��HashMap  Create a HashMap
    Map<String, Integer> hashMap = new HashMap<>();
    // ����� Key �����ͣ��ұ��� Value ������
    hashMap.put("Smith", 30);
    hashMap.put("Anderson", 31);
    hashMap.put("Lewis", 29);
    hashMap.put("Cook", 29);

    System.out.println("Display entries in HashMap");
    System.out.println(hashMap + "\n");

    // ��ǰ���HashMap����һ��TreeMap  Create a TreeMap from the preceding HashMap
    TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
    System.out.println("Display entries in ascending order of key");
    // ���� Key ����������
    System.out.println(treeMap);

    System.out.println(treeMap.firstKey());
    System.out.println(treeMap.headMap("Lewis"));
    treeMap.pollFirstEntry().setValue(88);
    System.out.println(treeMap.pollFirstEntry());

    // ����һ��LinkedHashMap  Create a LinkedHashMap
    // �����ﵽ 75% ʱ�Զ���������
    Map<String, Integer> linkedHashMap =
      new LinkedHashMap<>(16, 0.75f, true);
    linkedHashMap.put("Smith", 30);
    linkedHashMap.put("Anderson", 31);
    linkedHashMap.put("Lewis", 29);
    linkedHashMap.put("Cook", 29);

    // ��ʾ����˹������  Display the age for Lewis
    System.out.println("\nThe age for " + "Lewis is " +
      linkedHashMap.get("Lewis"));

    System.out.println("Display entries in LinkedHashMap");
    System.out.println(linkedHashMap);
    
    // ��ʾÿ����Ŀ�����ƺ�����  Display each entry with name and age
    System.out.print("\nNames and ages are ");
    treeMap.forEach(
      (name, age) -> System.out.print(name + ": " + age + " "));
  }
}
