import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class java14_2_MultipeStageDemo extends Application {  //类名，全部继承

    @Override
    public void start(Stage primaryStage) throws Exception {  //重写 Application 中的 start 方法
        Scene scene = new Scene(new Button("OK"), 200, 250);  //创建场景和按钮
        primaryStage.setTitle("MyJavaFX");  //设置标题文字
        primaryStage.setScene(scene);  //放置场景到舞台：舞台自动创建
        primaryStage.show();  //显示舞台

        Stage stage = new Stage();  //创建了一个新的舞台
        stage.setTitle("Second Stage");  //添加标题栏文字

        stage.setScene(new Scene(new Button("new Stage"), 100, 100));  //添加按钮
        stage.show();  //显示舞台
    }
}
