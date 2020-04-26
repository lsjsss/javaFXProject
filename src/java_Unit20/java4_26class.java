package java_Unit20;

import java.util.ArrayList;

public class java4_26class {
    public static void main(String[] args) {
        //创建一个集合，添加进几个元素  泛型类
        ArrayList<String> al = new ArrayList<>();
        //向集合中添加字符串，从 Collection 接口继承的
        al.add("name1");
        //使用指定位置的添加方式，是从 List 接口继承的
        al.add(1,"name2");
        //上面用到了两个添加方法，List 为 Collection 的子接口
        //List 接口中有几个add方法可以添加元素

        //查看 addAll 集合中的元素, 查看集合尺寸
        System.out.println(al.size());
        //遍历集合(使用 for 循环)
        for (int i = 0; i < al.size(); i++) {
            //指定要获取元素的下标
            System.out.println(al.get(i));
        }

        //添加另一个集合的元素，使用 addAll,0表示添加位置
        ArrayList<String> al2 = new ArrayList<>();
        al2.addAll(0,al);
        for (int i = 0; i < al2.size(); i++) {
            //指定要获取元素的下标
            System.out.println(al2.get(i));
        }

        //clear 方法：清空集合
        al2.clear();
        for (int i = 0; i < al2.size(); i++) {
            //指定要获取元素的下标
            System.out.println(al2.get(i));
        }

        //判断集合中包含对象，集合中包含集合
        //检查是否在集合中
        System.out.println(al.contains("name1"));

        //检查集合内容是否相同
        ArrayList<String> al3 = new ArrayList<>();
        al3.addAll(0,al);
        System.out.println(al.containsAll(al3));

        //等于
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));
        System.out.println(al.equals(al2));

//        //删除，对象，子集
//        al.add(2,"name3");
//        //Collection
//        al.remove("name4");
//        //List
//        al.remove(2);
//        al.removeAll(al2);
//        //false
//        System.out.println("" + al.isEmpty());

        //判断一个集合是否是另一个集合的子集
        // true 说明 al2 是 al 的子集
        System.out.println(al.retainAll(al2));
        System.out.println(al2.retainAll(al));

        Object[] s = (al.toArray());
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
