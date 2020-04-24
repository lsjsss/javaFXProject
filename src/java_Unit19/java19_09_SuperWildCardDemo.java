package java_Unit19;

/** 下限通配 */
public class java19_09_SuperWildCardDemo {
    public static void main(String[] args) {
        java19_01_GenericStack<String> stack1 = new java19_01_GenericStack<String>();
        java19_01_GenericStack<Object> stack2 = new java19_01_GenericStack<Object>();
        stack2.push("Java");
        stack2.push(2);
        stack1.push("Sun");
        add(stack1, stack2);
        java19_08_AnyWildCardDemo.print(stack2);
    }

    /** 下限通配   java19_1_GenericStack<T> <=> String , java19_1_GenericStack<? super T> <=> Object */
    public static <T> void add(java19_01_GenericStack<T> stack1, java19_01_GenericStack<? super T> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    /** 受限通配 */
//    public static <T> void add(java19_1_GenericStack<T> stack1, java19_1_GenericStack<? super T> stack2) {
//        while (!stack1.isEmpty()) {
//            stack2.push(stack1.pop());
//        }
//    }
}

