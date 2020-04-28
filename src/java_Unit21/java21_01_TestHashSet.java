package java_Unit21;

import java.util.*;

public class java21_01_TestHashSet {
  public static void main(String[] args) {
    // 创建一个哈希集 Create a hash set
    Set<String> set = new HashSet<>();

    // Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    System.out.println(set);

    // 显示哈希集中的元素 display the elements in the hash set
    for (String s: set) {
      System.out.print(s.toUpperCase() + " ");
    }
    
    // 使用forEach方法处理元素 Process the elements using a forEach method
    System.out.println();
    set.forEach(e -> System.out.print(e.toLowerCase() + " "));
  }
}
