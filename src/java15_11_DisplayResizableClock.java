import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class java15_11_DisplayResizableClock extends Application {
    @Override
    public void start(Stage primaryStage) {
        java14_21_ClockPane clock = new java14_21_ClockPane();
        String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock");
        primaryStage.setScene(scene);
        primaryStage.show();

        //设置监听
        //监听面板宽度属性，使得钟表的大小随着面板的宽和高进行缩放
        pane.widthProperty().addListener(ov -> clock.setW(pane.getWidth()));
        pane.heightProperty().addListener(ov -> clock.setH(pane.getHeight()));

        //Question
        //可观察对象： 面板 pane
        //可观察对象什么样的值可以被监听： 宽度widthProperty 和高度heightProperty 属性
        //用什么方法监听: addListener()
        //监听器要实现哪个接口: InvalidationListener()
        //重写接口中的哪个方法: invalidated()
        //用内部类，还是用匿名内部类，还是用lamdba表达式: 都可以
    }
}
