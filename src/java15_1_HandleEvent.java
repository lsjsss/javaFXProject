import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class java15_1_HandleEvent extends Application {
    @Override
    public void start(Stage primaryStage) {
        //面板水平盒子
        HBox pane = new HBox(10);
        //水平垂直 居中对齐
        pane.setAlignment(Pos.CENTER);
        /*可以获取帮助信息
         * 指向要获取信息的地方， 稍停
         * 提示信息窗口可以滚动
         * 还可以打开JavaDoc
         */

        Button btOK = new Button("OK");
        Button btCancel = new Button("Cancel");
        OKHandlerClass handler1 = new OKHandlerClass();
        btOK.setOnAction(handler1);
        CancelHandlerClass handler2 = new CancelHandlerClass();
        btCancel.setOnAction(handler2);
        pane.getChildren().addAll(btOK,btCancel);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("HandleEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class OKHandlerClass implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        System.out.println("OK button clicked");
    }
}

class CancelHandlerClass implements  EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        System.out.println("Cancel button clicked");
    }
}
