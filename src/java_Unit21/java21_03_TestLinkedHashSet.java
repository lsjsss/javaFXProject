package java_Unit21;

import java.util.*;

public class java21_03_TestLinkedHashSet {
  public static void main(String[] args) {
    // ����һ����ϣ�� Create a hash set
    Set<String> set = new LinkedHashSet<>();
    
    // ���ַ�����ӵ������� Add strings to the set
    set.add("London");
    set.add("Paris");
    set.add("New York");
    set.add("San Francisco");
    set.add("Beijing");
    set.add("New York");

    System.out.println(set);

    // ��ʾ��ϣ���е�Ԫ�� Display the elements in the hash set
    // ���ǹ��췽��
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
} 
