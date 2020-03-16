import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class java14_5_ShowCircleCentered extends Application{
    @Override
    public void start(Stage promaryStage){
        Pane pane = new Pane();

        Circle circle = new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.GREEN);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        Scene scene = new Scene(pane, 200, 200);
        promaryStage.setTitle("ShowCirleCentered");
        promaryStage.setScene(scene);
        promaryStage.show();
    }
}
