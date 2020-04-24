package java_Unit19;

public class java19_08_AnyWildCardDemo {
    public static void main(String[] args) {
        java19_01_GenericStack<Integer> intStack = new java19_01_GenericStack<Integer>();
        // 1 is autoboxed into new Integer(1)
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);

        print(intStack);
    }
    /** Prints objects and empties the stack */
    // java19_1_GenericStack<Integer> 是 java19_1_GenericStack<?> 的子类
    /** 非受限通配 <?>   ? 代表为任意类型 */
    public static void print(java19_01_GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
//在使用中， 我们用 Integer 代替 ?
