package java_Unit19;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/** ���޵ķ������ͣ� ���͸�խ*/
public class java19_3_BoundedTypeDemo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2, 2);
        Circle circle = new Circle(2);

//        System.out.println("Same area? " + equalArea(rectangle, circle));
    }

    /** ͼ�ζ��� */
//    public static <E extends GeometricObject> boolean equalArea(E object1, E object2) {
//        return object1.getArea() == object2.getArea();
//    }
}
//E�����޵ģ� <E>��ʵ�ȼ���<W extends Object>