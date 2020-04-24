package java_Unit19;

public class java19_11_IntegerMatrix extends java19_10_GenericMatrix<Integer> {
    @Override /** 加两个整数 Add two integers */
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }
    @Override /** 将两个整数相乘 Multiply two integers */
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }
    @Override /** 为整数指定零 Specify zero for an integer */
    protected Integer zero() {
        return 0;
    }
}
