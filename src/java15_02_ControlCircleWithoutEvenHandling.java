import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**没有实现事件驱动的圆*/
public class java15_02_ControlCircleWithoutEvenHandling extends Application {
    @Override
    public void start(Stage primaryStage) {
        //创建栈面板，后面的会覆盖前面的，自动居中
        StackPane pane = new StackPane();
        //创建一个圆，半径50像素(px)
        Circle circle = new Circle(50);
        //设置边框颜色
        circle.setStroke(Color.BLACK);
        //设置填充颜色
        circle.setFill(Color.WHITE);
        //将圆添加到面板上
        pane.getChildren().add(circle);

        //水平盒子，放置按钮
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        //居中对齐
        hBox.setAlignment(Pos.CENTER);
        //两个按钮，放大和缩小
        Button btEnlarge = new Button("Enable");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().addAll(btEnlarge,btShrink);
//        hBox.getChildren().add()

        //边界面板，划分为 东南西北中 五个部分
        BorderPane borderPane = new BorderPane();
        //圆  在中间位置
        borderPane.setCenter(pane);
        //水平  底部位置(南)
        borderPane.setBottom(hBox);
        //北，西，东，这三个被盖住了，因为它没有节点

        //设置边界对齐方式，使得水平盒子居中
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
