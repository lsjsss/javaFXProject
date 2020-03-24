import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**使用匿名内部类来编写事件驱动程序*/
public class java15_04_AnonymousHandlerDemo extends Application {
    @Override
    public void start(Stage PrimaryStage){
        //图形构造
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btNew = new Button("New");
        Button btOpen = new Button("Open");
        Button btSave = new Button("Save");
        Button btPrint = new Button("Print");
        hBox.getChildren().addAll(btNew, btOpen, btSave, btPrint);

        //给 new 按钮设置监听
        btNew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //匿名内部类
            public void handle(ActionEvent event) {
                System.out.println("Process New");
            }
        });
        //btNew.setOnAction(.....）;
        //new  的后面是一个 EventHandler 接口，监听器必须实现的接口 泛型<ActionEvent>
        //()  无参的
        //{}里 实际上是原来内部类的类体

        btOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Process Open");
            }
        });

        btSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Process Save");
            }
        });

        btPrint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Process Print");
            }
        });

        Scene scene = new Scene(hBox, 300, 50);
        PrimaryStage.setTitle("AnonymousHandlerDemo");
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
}
