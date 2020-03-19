import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class java14_9_ShowImage extends Application {
    @Override
    public void start(Stage primaryStage){
        Pane pane = new HBox(10);//创建一个面板，水平盒子
        pane.setPadding(new Insets(5, 5, 5, 5));//边界  上5右5下5左5
        Image image = new Image("image/china.gif");//创建一个Image对象
        //图像文件 -> Image对象 -> ImageView对象 -> pane对象 -> 场景 -> 舞台
        pane.getChildren().add(new ImageView(image));

        //第二个ImageView对象
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(100); //宽
        imageView2.setFitWidth(100);  //高
        pane.getChildren().add(imageView2);

        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);
        //创建了 3 个ImageView，依次放入 HBox,这三个 ImageView 用的是同一个 Image 对象

        Scene scene = new Scene(pane);
        primaryStage.setTitle("ShowImage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
