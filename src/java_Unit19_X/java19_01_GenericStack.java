package java_Unit19_X;

/**
 * 1.类名的后面加一个<E>
 * 2.用的ArrayList<E>
 * 3.peek()返回值类型E
 * 4.pop()...
 * 5.push()的参数值类型 E
 */

/**
 * 1.类名的后面加一个 <E> 或 <T>
 * 2.属性中，需要加 E 的要加上
 * 3.方法中，需要 E 的要加上
 */

/** 类名后添加 <E> */
public class java19_01_GenericStack<E> {
    /** 约定线性表类型 */
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public int getSize() {
        return list.size();
    }

    /** 定义返回类型 */
    public E peek() {
        return list.get(getSize() - 1);
    }

    /** 定义参数类型 */
    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }
}
