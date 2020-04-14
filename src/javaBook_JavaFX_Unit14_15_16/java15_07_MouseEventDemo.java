package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java15_07_MouseEventDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        //文本初始位置(坐标)，内容
        Text text = new Text(20, 20, "Programming is fun");
        pane.getChildren().addAll(text);
        //监听不是动作事件(ActionEvent) 是监听鼠标事件(MouseEvent)
        //事件源是 text， 监听鼠标拖动事件
        text.setOnMouseDragged(e -> {
            //将文本框的x， y坐标设置为鼠标拖动的坐标
            text.setX(e.getX());
            text.setY(e.getY());
            //画线程序
            //text->ImageView
            //绘制线条 Panit 类，画点(多个点)
        });

        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("MouseEveneDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
