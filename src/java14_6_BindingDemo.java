import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class java14_6_BindingDemo {
    public static void main(String[] args) {
        DoubleProperty d1 = new SimpleDoubleProperty(1); //双精度属性类型
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        d1.bind(d2);  //单向绑定
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());

        d2.setValue(70.2);  // d2 的值改为 70.2
        System.out.println("d1 is " + d1.getValue() + " and d2 is " + d2.getValue());
    }
}
