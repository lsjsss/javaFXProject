import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class java14_5_ShowCircleCentered extends Application{  //Application 图形程序的使用
    @Override
    public void start(Stage promaryStage){
        Pane pane = new Pane();  //创建面板

        Circle circle = new Circle();  //创建圆

        //属性绑定：x坐标
        // 圆 . 圆心的 x 坐标                面板宽度属性
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);  //黑色线条
        circle.setFill(Color.WHITE);  //白色填充
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 200, 200);  //场景大小： 200*200
        promaryStage.setTitle("ShowCirleCentered");  //设置舞台
        promaryStage.setScene(scene);
        promaryStage.show();
    }
}
