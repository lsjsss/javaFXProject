import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class java14_10_ShowFlowPane extends Application {//网格面板
    @Override
    public void start(Stage primaryStage){
        FlowPane pane = new FlowPane();//流式面板
        pane.setPadding(new Insets(11, 12, 13, 14));//边距，上11，右12，下13，左14
        pane.setHgap(5);//设置水平间距（节点之间的距离）
        pane.setVgap(5);//设置垂直间距

        //TextFiled：标签     Lable：文本框
        pane.getChildren().addAll(new Label("First name:"),new TextField(), new Label("MI:"));//addAll方法可以同时增加多个node
        TextField tfMi = new TextField();//默认列宽为10（文本域）
        tfMi.setPrefColumnCount(1);//文本域，将默认列宽修改为1
        pane.getChildren().addAll(tfMi, new Label("Last Name:"), new TextField());

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("ShowFlowPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
