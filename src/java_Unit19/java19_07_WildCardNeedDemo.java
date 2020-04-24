package java_Unit19;

public class java19_07_WildCardNeedDemo {
    public static void main(String[] args ) {
        java19_01_GenericStack<Integer> intStack = new java19_01_GenericStack<Integer>();
        // 1 is autoboxed into new Integer(1)
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
//        System.out.print("The max number is " + max(intStack));
    }

    //泛型是它的子类，泛型栈不是它(java19_1_GenericStack<Integer>)的子类
    /** Find the maximum in a stack of numbers */
    public static double max(java19_01_GenericStack<Number> stack) {
        // Initialize max
        double max = stack.pop().doubleValue();
        while (!stack.isEmpty()) {
            double value = stack.pop().doubleValue();
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
