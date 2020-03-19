import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class java14_4_ShowCircle extends Application {  //继承 Application 类
    @Override
    public void start(Stage primaryStage){
        Circle circle = new Circle();  //创建一个圆，类名：Circle
        circle.setCenterX(100);  //圆心的 x 坐标 100
        circle.setCenterY(100);  //圆心的 y 坐标 100
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);  //黑色线条
        circle.setFill(Color.WHITE);  //白色填充，null为空白

        Pane pane = new Pane();
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("ShowCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
