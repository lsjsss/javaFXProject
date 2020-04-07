package javaclass;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java16_10_ScrollBarDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text(20, 20, "JavaFX Programming");

        //水平滚动条
        ScrollBar sbHorizontal = new ScrollBar();
        //垂直滚动条(默认为水平)
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);

        //双精度属性型
        System.out.println("Min" + sbHorizontal.getMin());
        System.out.println("Max" + sbHorizontal.getMax());

        System.out.println("UnitIcrem"+ sbHorizontal.getUnitIncrement());
        System.out.println("");

        Pane paneForText = new Pane();
        //将文本放到面板上
        paneForText.getChildren().add(text);

        //边界面板
        BorderPane pane = new BorderPane();
        pane.setCenter(paneForText);
        pane.setBottom(sbHorizontal);
        pane.setRight(sbVertical);

        //为水平滚动条添加监听 值属性      监听
        sbHorizontal.valueProperty().addListener(ov ->
                //修改文本的 x 坐标与滚动条相同（依照面板比例）
                text.setX(sbHorizontal.getValue() * paneForText.getWidth() / sbHorizontal.getMax()));

        sbVertical.valueProperty().addListener(ov ->
                text.setY(sbVertical.getValue() * paneForText.getHeight() / sbVertical.getMax()));

        //场景
        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ScrollBarDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
//水平滚动条的最小值和最大值，单击按钮时移动的距离，单极滑块的轨道空白处移动的距离