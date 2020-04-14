package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**继承 Application 类*/
public class java14_04_ShowCircle extends Application {
    @Override
    public void start(Stage primaryStage){
        //创建一个圆，类名：Circle
        Circle circle = new Circle();
        //圆心的 x 坐标 100
        circle.setCenterX(100);
        //圆心的 y 坐标 100
        circle.setCenterY(100);
        circle.setRadius(50);
        //黑色线条
        circle.setStroke(Color.BLACK);
        //白色填充，null为空白
        circle.setFill(Color.WHITE);

        Pane pane = new Pane();
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("ShowCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
