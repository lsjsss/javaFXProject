package java_Unit21;

import java.util.*;

public class java21_03_TestLinkedHashSet {
  public static void main(String[] args) {
    // 创建一个哈希集 Create a hash set
    Set<String> set = new LinkedHashSet<>();
    
    // 将字符串添加到集合中 Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    System.out.println(set);

    // 显示哈希集中的元素 Display the elements in the hash set
    // 不是构造方法
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
} 
