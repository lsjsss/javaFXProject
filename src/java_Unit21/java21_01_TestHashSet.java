package java_Unit21;

import java.util.*;

public class java21_01_TestHashSet {
    public static void main(String[] args) {
        /** 创建一个哈希集 Create a hash set */
        Set<String> set = new HashSet<>();
        /** 此类定义不具备通用性 */
        HashSet<String> hSet = new HashSet<>();

        // 将字符串添加到集合中 Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        // 第二次重复添加，Set 中不允许存在重复元素
        set.add("New York");
        // remove()    clear()

        // HahSet AbstractSet AbstractCollection    Set Collection
        System.out.println(set);

        // 显示哈希集中的元素 display the elements in the hash set
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }

        // 使用forEach方法处理元素 Process the elements using a forEach method
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));
    }
}
