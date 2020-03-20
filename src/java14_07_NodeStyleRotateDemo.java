import javafx.application.Application;  //导包
import javafx.scene.Scene;  //场景导包
import javafx.scene.control.Button;  //按钮 Button 导包，控件，UI 组件
import javafx.scene.layout.StackPane;  //场景，布局导包
import javafx.stage.Stage;  //舞台导包

public class java14_07_NodeStyleRotateDemo extends Application {
    @Override  //重写 start 方法(@ 注解)一个提醒作用
    /**start 方法不需要返回值，方法参数是一个系统自动生成的主舞台(Java虚拟机生成)*/
    public void start(Stage primaryStage){
        //创建一个栈面板对象，用于放置控件(按钮)，它放入场景之中
        StackPane pane = new StackPane();
        //创建一个按钮，(另一种方法：创建时不指定文字，之后去设置)
        Button btOK = new Button("OK");
        //按钮边框，设置样式：在参数中用样式串指定，用 -fx- 开头，
        // 用 属性(border) - 属性颜色(color) ，相当于css ，属性值写在冒号后，用分号结束样式串。
        btOK.setStyle("-fx-border-color:blue;");
        //添加按钮到面板
        pane.getChildren().add(btOK);

        //面板旋转 45 度，数值为负时逆时针旋转
        pane.setRotate(45);
        //设置面板样式       边框颜色                 背景颜色
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

        //把面板放到场景中
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("NodeStyleRotatDemo");
        primaryStage.setScene(scene);
        primaryStage.show();  //使用主舞台
    }
}