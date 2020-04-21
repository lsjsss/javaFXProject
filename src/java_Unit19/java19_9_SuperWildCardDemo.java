package java_Unit19;

/** œ¬œﬁÕ®≈‰ */
public class java19_9_SuperWildCardDemo {
    public static void main(String[] args) {
        java19_1_GenericStack<String> stack1 = new java19_1_GenericStack<String>();
        java19_1_GenericStack<Object> stack2 = new java19_1_GenericStack<Object>();
        stack2.push("Java");
        stack2.push(2);
        stack1.push("Sun");
        add(stack1, stack2);
        java19_8_AnyWildCardDemo.print(stack2);
    }

    public static void add(java19_1_GenericStack stack1, java19_1_GenericStack stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

