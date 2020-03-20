import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class java14_05_ShowCircleCentered extends Application{  //Application 图形程序的使用
    @Override
    public void start(Stage promaryStage){
        //创建面板
        Pane pane = new Pane();

        //创建圆
        Circle circle = new Circle();

        //属性绑定：x坐标
        // 圆 . 圆心的 x 坐标                面板宽度属性
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        //黑色线条
        circle.setStroke(Color.BLACK);
        //白色填充
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        //场景大小： 200*200
        Scene scene = new Scene(pane, 200, 200);
        //设置舞台
        promaryStage.setTitle("ShowCirleCentered");
        promaryStage.setScene(scene);
        promaryStage.show();
    }
}
