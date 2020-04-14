package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java14_16_ShowRectangle extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        //矩形坐标及宽高
        Rectangle r1 = new Rectangle(25, 10, 60, 30);
        //线条颜色
        r1.setStroke(Color.BLACK);
        //背景颜色
        r1.setFill(Color.WHITE);
        pane.getChildren().add(new Text(10, 27, "r1"));
        pane.getChildren().add(r1);

        //默认边框颜色和填充颜色为黑色
        Rectangle r2 = new Rectangle(25, 50, 60, 30);
        pane.getChildren().add(new Text(10, 67, "r2"));
        pane.getChildren().add(r2);

        Rectangle r3 = new Rectangle(25, 90, 60, 30);
        r3.setArcWidth(15);
        r3.setArcHeight(25);
        pane.getChildren().add(new Text(10, 107, "r3"));
        pane.getChildren().add(r3);

        for (int i = 0; i < 4; i++){
            Rectangle r = new Rectangle(100, 50, 100, 30);
            r.setRotate(i * 360 / 8);
            //红绿蓝参数随机生成
            r.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            r.setFill(Color.WHITE);
            pane.getChildren().add(r);
        }

        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("ShowRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
