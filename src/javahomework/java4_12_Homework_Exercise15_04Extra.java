package javahomework;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 编写一个显示正多边形的程序，并使用两个名为+1和-1的按钮来增大或减小多边形的大小，如下图所示
 */

public class java4_12_Homework_Exercise15_04Extra extends Application {
    private RegularPolygonPane regularPolygonPane = new RegularPolygonPane();
    int size = 6;

    @Override
    public void start(Stage primaryStage) {
        //设置水平盒子，放置按钮
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        //设置水平盒子居中对齐
        hBox.setAlignment(Pos.CENTER);
        //设置两个按钮，放大和缩小
        Button btEnlarge = new Button(" + ");
        Button btShrink = new Button(" - ");
        hBox.getChildren().addAll(btEnlarge,btShrink);

        //设置水平盒子，显示多边形边数， 默认初始值为6
        HBox hBox2 = new HBox();
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);
        showSize(hBox2, size);

        //处理按钮中的动作事件
        btEnlarge.setOnAction((ActionEvent e) -> {
            regularPolygonPane.add();
            hBox2.getChildren().clear();
            showSize(hBox2, ++size);
        });
        btShrink.setOnAction((ActionEvent e) -> {
            regularPolygonPane.reducing();
            hBox2.getChildren().clear();
            showSize(hBox2, size = size > 3 ? --size : size);
        });

        //放置面板
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox2);
        borderPane.setCenter(regularPolygonPane);
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(hBox, Pos.CENTER);

        //放置场景
        Scene scene = new Scene(borderPane, 230, 230);
        primaryStage.setTitle("Exercise15_04");
        primaryStage.setScene(scene);
        primaryStage.show();

        //监听面板宽度属性，使正多边形的大小随着面板的宽和高进行缩放
        borderPane.widthProperty().addListener(ov -> regularPolygonPane.setWIDTH(borderPane.getWidth()));
        borderPane.heightProperty().addListener(ov -> regularPolygonPane.setHEIGHT(borderPane.getHeight()));
    }

    /** 显示边数方法 */
    public void showSize(HBox hBox2, int size) {
        String showsize = size + "边形";
        Text text = new Text(showsize);
        hBox2.getChildren().add(text);
    }
}

class RegularPolygonPane extends StackPane {
    private Polygon polygon = new Polygon();
    private double WIDTH = 200, HEIGHT = 200;
    private int n = 6;

    ObservableList<Double> list = polygon.getPoints();

    /** 添加默认正六边形面板 */
    public RegularPolygonPane() {
        getChildren().add(polygon);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);
        paintSize();
    }

    /** 增加边数 */
    public void add() {
        n++;
        list.removeAll(list);
        paintSize();
    }

    /** 减少边数 */
    public void reducing() {
        n = n > 3 ? --n : n;
        list.removeAll(list);
        paintSize();
    }

    /** 设置默认边数以及触发按钮事件时更新边数 */
    public void paintSize() {
        for (int i = 0; i < n; i++){
            double centerX = WIDTH / 2, centerY = HEIGHT / 2;
            double radius = Math.min(WIDTH, HEIGHT) * 0.4;
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / n));
            list.add(centerY + radius * Math.sin(2 * i * Math.PI / n));
        }
    }

    public void setWIDTH(double WIDTH) {
        this.WIDTH = WIDTH;
        list.removeAll(list);
        paintSize();
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
        list.removeAll(list);
        paintSize();
    }
}
