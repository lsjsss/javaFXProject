package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class java16_2_ButtonDemo extends Application {
    /**Protected 子类  设置为属性，可直接使用  */
    protected Text text = new Text(50,50,"JavaFX Programming");

    /** 返回值类型： 边界面板，东南西北中 */
    protected BorderPane getPane() {
        /**三种布局
         * HBox paneForButtons
         */

        //创建一个水平盒子(放置按钮的面板) paneForButtons
        HBox paneForButtons = new HBox(20);
        //创建两个按钮
        Button btLeft = new Button("Left", new ImageView("javaBook_JavaFX_Unit14_15_16/image/left.gif"));
        Button btRight = new Button("Right", new ImageView("javaBook_JavaFX_Unit14_15_16/image/right.gif"));
        //( + ) 调整按钮箭头到文字右侧
        btRight.setContentDisplay(ContentDisplay.RIGHT);
        //把左按钮和右按钮放到盒子里
        paneForButtons.getChildren().addAll(btLeft, btRight);
        //设置(放置按钮)面板上的组件对齐方式为居中对齐
        paneForButtons.setAlignment(Pos.CENTER);
        //边框样式设置为绿色
        paneForButtons.setStyle("-fx-border-color: green");

        //用于放置按钮的面板
        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        //用于放置文本的面板 标签
        Pane paneForText = new Pane();
        paneForText. getChildren().add(text);
        pane.setCenter(paneForText);

        //设置 lamdba 表达式监听  左移 / 右移 10个像素
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text. getX() + 10));
        return pane;
    }

    @Override
    public void start(Stage primaryStage){
        // 场景中放置面板 getPane()， 在面板中调整组建
        Scene scene = new Scene(getPane(),450,200);
        primaryStage.setTitle("ButtonDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
