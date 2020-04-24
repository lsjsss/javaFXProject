package java_Unit20;

import java.util.ArrayList;
import java.util.Collection;

public class java20_3_TestForEach {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("New York");
        collection.add("Atlanta");
        collection.add("Dallas");
        collection.add("Madison");
        collection.forEach(e -> System.out.print(e.toUpperCase() + " "));
    }
}
