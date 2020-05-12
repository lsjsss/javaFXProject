package java_Unit20;

import java.util.Vector;

public class java5_12class {
    public static void main(String[] args) {
        //创建一个向量对象
        Vector<String> vl = new Vector<>(20,8);

        // 向这个向量增加 5 个元素 (字符串)
        vl.add("中国");
        vl.add("德国");
        vl.add("美国");
        vl.add("日本");
        vl.add("越南");

        System.out.println(vl);
        System.out.println(vl.capacity());

        System.out.println(vl.elementAt(2));

        // 删除元素
        vl.remove(2);
        System.out.println(vl);
    }
}
