package java_Unit21;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class java05_22_class {
    public static void main(String[] args) {
        Set<String> ss =  Collections.singleton("abc");
        ss.add("xyz");

        List l = Collections.unmodifiableList(Arrays.asList("abc", "xyz"));
        System.out.println(l);

        // 移除将会导致 Unsupper  出错
        l.remove("abc");
    }
}
