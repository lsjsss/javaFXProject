import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class java3_27_ClassCode_ButtonEvent extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //创建一个垂直盒子
        VBox vBox = new VBox();

        //设置四个按钮的对齐方式为 （水平，垂直方向）居中
        vBox.setAlignment(Pos.CENTER);

        //设置按钮之间的间距, 同时创建 Insets 对象做参数
        vBox.setPadding(new Insets(20, 20, 20, 20));

        //新建按钮
        Button button1 = new Button("New");
        Button button2 = new Button("Open");
        Button button3 = new Button("Save");
        Button button4 = new Button("Print");

        //创建事件驱动
        button1.setOnAction( e -> System.out.println("New a file"));
        button2.setOnAction( e -> System.out.println("Open a file"));
        button3.setOnAction( e -> System.out.println("Save a file"));
        button4.setOnAction( e -> System.out.println("Print a file"));

        //将四个按钮(所有)同时放入水平盒子中
        vBox.getChildren().addAll(button1, button2, button3, button4);

        //设置场景,场景大小， 将垂直盒子放入场景中
        Scene scene = new Scene(vBox, 200, 200);
        //把场景放到主舞台上
        primaryStage.setScene(scene);

        //主舞台
        primaryStage.show();
        primaryStage.setTitle("Homework");
    }

    /**入口方法编写 */
    public static void main(String[] args) {
        launch(args);
    }
}
