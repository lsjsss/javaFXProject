package java_Unit19_X;

import java_Unit13.java13_01_GeometricObject;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/** 受限的泛型类型， 类型更窄*/
public class java19_03_BoundedTypeDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 2);
        Circle circle = new Circle(2);

//        System.out.println("Same area? " +
//                equalArea(rectangle, circle));
    }

    /** 图形对象 */
    public static <E extends java13_01_GeometricObject> boolean equalArea(
            E object1, E object2) {
        return object1.getArea() == object2.getArea();
    }
}
//E是受限的， <E>其实等价于<W extends Object>