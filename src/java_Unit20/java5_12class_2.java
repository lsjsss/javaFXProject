package java_Unit20;

import java.util.Stack;

public class java5_12class_2 {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        System.out.println(s.empty());;
        s.push("White");
        System.out.println(s.empty());
        s.push("Black");
        s.push("Blue");

        System.out.println(s.peek());
        System.out.println(s.peek());

        System.out.println(s.pop());
        System.out.println(s.pop());

        // ²é¿´Õ»ÈÝÁ¿
        System.out.println(s.capacity());
    }
}
