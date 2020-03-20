import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class java14_03_ButtonPane extends Application {
    @Override
    public void start(Stage primaryStage){
        //栈面板 StackPane
        StackPane pane = new StackPane();
        //添加到面板上一个 OK 按钮
        pane.getChildren().add(new Button("OK"));
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("Button in a pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
