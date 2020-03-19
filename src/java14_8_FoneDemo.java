import com.sun.deploy.xml.XMLable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class java14_8_FoneDemo extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new StackPane();

        Circle circle = new Circle();  //创建一个圆
        circle.setRadius(50);  //将圆的半径设置为50
        circle.setStroke(Color.BLACK);  //将圆边框的颜色，设置为常量(BLACK),(只有主要颜色)
        //设置填充 r:0.5, g:0.5, b:0.5; 不透明度:10%
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
        pane.getChildren().add(circle);

        Label label = new Label("JavaFX");
        label.setFont(Font.font("Timees New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));

        Scene scene = new Scene(pane);
        primaryStage.setTitle("FontDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
