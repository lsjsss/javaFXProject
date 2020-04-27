package java_Unit20;

import java.util.ArrayList;
import java.util.Collection;

public class java20_01_TestCollection {
    public static void main(String[] args) {
        //创建一个线性表
        ArrayList collection1 = new ArrayList<>();

        //存放城市名称，添加到线性表(有序)
        collection1.add("New York");
        collection1.add("Atlanta");
        collection1.add("Dallas");
        collection1.add("Madison");

        System.out.println("A集合城市列表1  list of cities in collection1:");
        //输出集合 collection1 中的元素
        System.out.println(collection1);

        //true
        System.out.println("\n达拉斯收藏了吗？ Is Dallas in collection1? "
                + collection1.contains("Dallas"));

        //删除集合中的元素 Dallas，并重新获取集合的长度
        collection1.remove("Dallas");
        System.out.println("\n" + collection1.size() +
                " 现在已收集城市1 cities are in collection1 now");

        //定义第二个集合
        Collection collection2 = new ArrayList<>();
        collection2.add("Seattle");
        collection2.add("Portland");
        collection2.add("Los Angeles");
        collection2.add("Atlanta");

        System.out.println("\n集合中的城市列表2 A list of cities in collection2:");
        System.out.println(collection2);

        //创建线性表c1，不是用new来创建的，是用clone方法来创建的
        ArrayList c1 = (ArrayList)(collection1.clone());
        //7个城市
        c1.addAll(collection2);
        System.out.println("\n集合1或集合2中的城市 Cities in collection1 or collection2: ");
        System.out.println(c1);

        c1 = (ArrayList)(collection1.clone());
        //交集1
        c1.retainAll(collection2);
        System.out.print("\n集合1和集合2中的城市 Cities in collection1 and collection2: ");
        System.out.println(c1);
        c1 = (ArrayList)(collection1.clone());
        c1.removeAll(collection2);
        System.out.print("\n集合1中的城市，但不在2中 Cities in collection1, but not in 2: ");
        System.out.println(c1);
    }
}

