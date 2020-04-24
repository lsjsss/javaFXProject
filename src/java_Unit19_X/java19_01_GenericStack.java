package java_Unit19_X;

/**
 * 1.�����ĺ����һ��<E>
 * 2.�õ�ArrayList<E>
 * 3.peek()����ֵ����E
 * 4.pop()...
 * 5.push()�Ĳ���ֵ���� E
 */

/**
 * 1.�����ĺ����һ�� <E> �� <T>
 * 2.�����У���Ҫ�� E ��Ҫ����
 * 3.�����У���Ҫ E ��Ҫ����
 */

/** ��������� <E> */
public class java19_01_GenericStack<E> {
    /** Լ�����Ա����� */
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public int getSize() {
        return list.size();
    }

    /** ���巵������ */
    public E peek() {
        return list.get(getSize() - 1);
    }

    /** ����������� */
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
