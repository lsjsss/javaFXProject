package javaAdvanceHomework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static java.lang.Math.*;

/**
 * 显示包含三个图像视图的面板。每个图像视图显示一张扑克牌，如下图所示。
 * 扑克牌图像文件名为1.png、2.png、…、54.png，
 * 并存储在image/card目录中。这三张牌都是不同的，随机选择。
 * 项目所需的扑克牌图像（javaClass.image.rar）可以从课程平台的资料/课程资料中获得。
 * 1.创建三个ImageView，并使扑克牌显示其中。
 * 2.随机显示54张牌中的3张牌。
 */

public class java3_19_ShowThreeCards_Homewoke extends Application {
    @Override
    public void start(Stage primaryStage) {
        //创建一个面板，水平盒子
        Pane pane = new HBox(5);
        //定义生成牌的数量
        int num = 3;
        //创建生成牌文件名的数字
        int[] number = new int[num];
        //创建三个
        String[] imageurl = new String[num];
        //创建三个ImageView
        ImageView[] image = new ImageView[num];

        //循环使三张牌显示
        for (int i = 0; i < number.length; i++ ) {
            //随机生成图像数字名称
            number[i] = (int) ((random() * 54) / 100.0 * 100);
            //产生随机图像路径
            imageurl[i] = "javaBook_JavaFX_Unit14_15_16/image/card/" + number[i] + ".png";
            //导入图像路径
            image[i] = new ImageView(imageurl[i]);
            //显示扑克牌
            pane.getChildren().add(new ImageView(imageurl[i]));
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
