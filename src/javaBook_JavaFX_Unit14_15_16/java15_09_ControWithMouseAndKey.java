package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**把面板当作一个属性，可以直接使用这个面板，方便直接使用*/
public class java15_09_ControWithMouseAndKey extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage) {
        //放置两个按钮到水平盒子中
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        //注册监听器，lambda表达式，没有new，也是创建监听器对象
        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());
        //编写事件驱动程序并不复杂，但是可以做的更细致，细致到有3种方法可以放缩圆，
        //1单击按钮，    2单击鼠标(面板上单击)，    3按键(使面板处于焦点状态，其他的都没有焦点状态)

        //注册了另外一个监听器，事件源是圆面板circlePane
        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                circlePane.enlarge();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                circlePane.shrink();
            }
        });//一对代码

        //为键盘注册监听器
        circlePane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.U) {//按下键盘上U键，放大圆
                circlePane.enlarge();
            } else if (e.getCode() == KeyCode.D) {//按下圆上D键，缩小圆
                circlePane.shrink();
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();

        circlePane.requestFocus();//获取焦点
    }
}