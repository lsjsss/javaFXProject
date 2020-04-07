package javaclass;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class java16_9_ListViewDemo extends Application {
    /** 字符串数组(串)用于组合框、列表视图 */
    private String[] flagTitles = {
            "Canada", "China", "Denmark", "France",
            "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    /** 创建 ImageView 数组，用于显示图像 */
    private ImageView[] ImageViews = {
            new ImageView("javaclass/image/ca.gif"),
            new ImageView("javaclass/image/china.gif"),
            new ImageView("javaclass/image/denmark.gif"),
            new ImageView("javaclass/image/fr.gif"),
            new ImageView("javaclass/image/germany.gif"),
            new ImageView("javaclass/image/india.gif"),
            new ImageView("javaclass/image/norway.gif"),
            new ImageView("javaclass/image/uk.gif"),
            new ImageView("javaclass/image/us.gif")
    };
    // String 数组与 ImageView 数组 具备 对应关系

    @Override
    public void start(Stage primaryStage) throws Exception {
        //创建一个列表视图(ListView) ，实现多选功能
        //泛型(<String>), 列表里的项目只能是字符串(String[] flagTitles)
        ListView<String> lv = new ListView<>
                //参数，生成可视化列表视图： observableList
                (FXCollections.observableArrayList(flagTitles));
        //列表视图尺寸
        lv.setPrefSize(400, 400);
        //设置为多选模式(MULTIPLE), 单选模式(SINGLE)
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //流式面板
        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        //把列表视图放到滚动面板中
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);

        //    获取选择模式          被选项目的属性
        lv.getSelectionModel().selectedItemProperty().addListener(
            ov -> {
                //清空面板，lambda 表达式
                imagePane.getChildren().clear();
                //增强型 for 循环   i = 选中的列表数量
                for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
                    //把图像添加到图像面板上
                    imagePane.getChildren().add(ImageViews[i]);
                }
            }
        );

        Scene scene = new Scene(pane, 800, 170);
        primaryStage.setTitle("ListViewDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
