import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class java14_11_ShowGridPane extends Application {
    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);  //中间对齐
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); //外边距 上 右 下 左
        pane.setHgap(5.5);  //水平间距
        pane.setVgap(5.5);  //垂直间距

        pane.add(new Label("First Name:"), 0, 0);// 1 列 1 行
        pane.add(new TextField(), 1, 0);// 1 列 0 行
        pane.add(new Label("MI"), 0, 1);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(new TextField(), 1, 2);
        Button btAdd = new Button("Add Name");
        pane.add(btAdd, 1, 3);// 2 列 4 行
        GridPane.setHalignment(btAdd, HPos.RIGHT);//右对齐

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowGridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
