import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**类名，全部继承*/
public class java14_2_MultipeStageDemo extends Application {
    @Override
    /**重写 Application 中的 start 方法*/
    public void start(Stage primaryStage) throws Exception {
        //创建场景和按钮
        Scene scene = new Scene(new Button("OK"), 200, 250);
        //设置标题文字
        primaryStage.setTitle("MyJavaFX");
        //放置场景到舞台：舞台自动创建
        primaryStage.setScene(scene);
        //显示舞台
        primaryStage.show();

        //创建了一个新的舞台
        Stage stage = new Stage();
        //添加标题栏文字
        stage.setTitle("Second Stage");

        //添加按钮
        stage.setScene(new Scene(new Button("new Stage"), 100, 100));
        //显示舞台
        stage.show();
    }
}
