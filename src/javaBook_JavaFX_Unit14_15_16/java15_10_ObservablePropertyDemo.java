package javaBook_JavaFX_Unit14_15_16;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class java15_10_ObservablePropertyDemo {
    public static void main(String[] args) {
        //这一行的对象，是属性对象，DoubleProperty(双精度属性)是一个抽象类
        DoubleProperty balance = new SimpleDoubleProperty();
        //balance是一个对象，有值
        //setON****-->addListener(监听属性值)
        //匿名内部类
        balance.addListener(new InvalidationListener() {
            @Override
            //只要值发生更改，就对语句进行输出
            public void invalidated(Observable observable) {
                System.out.println("The new value is " + balance.doubleValue());
            }
        });

        //对值变化能够监听，也能够编写事件处理方法
        //只有可观察对象能这样监听和处理
        balance.set(4.5);
        balance.set(10.9);
    }
}

/**
 * 运行结果：
 * The new value is 4.5
 * The new value is 10.9
 */
