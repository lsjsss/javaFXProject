package java_Unit20;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class java5_08_09class {
    public static void main(String[] args) {
        // 数组长度测量:使用 length 属性
        int[] x = new int[10];
        System.out.println(x.length);

        // 字符串长度:使用 length() 方法
        String s = "abcdefg";
        System.out.println(s.length());

        // 集合大小:使用 size() 方法
        ArrayList<Object> ar = new ArrayList<>();

        // 集合的容量:使用反射

        // 测试容量，a1 默认， a2 指定 30
        ArrayList<Object> a1 = new ArrayList<>();
        // size() 方法返回的是实际元素的个数
        System.out.println("a1 的默认容量大小" + get(a1));

        ArrayList<Object> a2 = new ArrayList<>(30);
        System.out.println("a2 的指定容量大小" + get(a2));
        // 初始默认大小为 10
        // 容量自增，扩大为原来的 1.5 倍
        // 默认加载因子 1.0
        // size() 返回是基本元素的个数

        //添加一个元素
        a2.add(5);
        a2.trimToSize();//容量缩小到与实际元素个数适应。
        System.out.println(get(a2));


    }


    /** https://www.cnblogs.com/hs2018/p/10449970.html */
    public static int get(ArrayList a) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[])field.get(a);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void getCapacity(ArrayList<Object> l) {

    }
}
