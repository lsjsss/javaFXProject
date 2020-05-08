package java_Unit20;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class java5_08class {
    public static void main(String[] args) {
        // 测试容量，a1 默认， a2 指定 30
        ArrayList<Object> a1 = new ArrayList<>();
        // size() 方法返回的是实际元素的个数
        System.out.println("a1 的默认容量大小" + a1.size());

        ArrayList<Object> a2 = new ArrayList<>(30);
        System.out.println("a2 的指定容量大小" + get(a2));


    }

    /** https://www.cnblogs.com/hs2018/p/10449970.html */
    public static int get(ArrayList a2) {
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[])field.get(a2);
            //返回当前ArrayList实例的容量值
            return objects.length;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
