import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class java15_10_ObservablePropertyDemo {
    public static void main(String[] args) {
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("The new value is " + balance.doubleValue());
            }
        });

        balance.set(4.5);
    }
}

/**
 * 运行结果：
 * The new value is 4.5
 */
