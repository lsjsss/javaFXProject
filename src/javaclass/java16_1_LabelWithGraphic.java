package javaclass;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class java16_1_LabelWithGraphic extends Application {
    @Override
    public void start(Stage primaryStage) {
        ImageView us = new ImageView(new Image("javaclass/image/us.gif"));
        //标签： 文字 + 图片
        Label lb1 = new Label("\n50 States", us);

        //样式设置        边框颜色：绿色            边框宽度：2px
        lb1.setStyle("-fx-border-color: green; -fx-border-width: 2");
        //文字和图形的位置关系图片在底部      底部 Node
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        //文本填充颜色：红色
        lb1.setTextFill(Color.RED);

        Label lb2 = new Label("Circle", new Circle(50, 50, 25));
        lb2.setContentDisplay(ContentDisplay.TOP);
        lb2.setTextFill(Color.ORANGE);

        Label lb3 = new Label("Retangle", new Rectangle(10, 10, 50, 25));
        lb3.setContentDisplay(ContentDisplay.RIGHT);

        Label lb4 = new Label("Ellipse", new Ellipse(50, 50, 50, 25));
        lb4.setContentDisplay(ContentDisplay.LEFT);

        Ellipse ellipse = new Ellipse(50, 50, 50, 25);
        //椭圆边框颜色： 绿色
        ellipse.setStroke(Color.GREEN);
        ellipse.setFill(Color.WHITE);
        //创建面板
        StackPane stackPane = new StackPane();
        //标签上放置文字
        stackPane.getChildren().addAll(ellipse, new Label("JavaFx"));
        Label lb5 = new Label("A pane inside a label", stackPane);
        lb5.setContentDisplay(ContentDisplay.BOTTOM);

        //标签 --> 面板 --> 标签

        HBox pane = new HBox(20);
        pane.getChildren().addAll(lb1, lb2, lb3, lb4, lb5);

        Scene scene = new Scene(pane, 450, 150);
        primaryStage.setTitle("LabelWithGraphic");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
