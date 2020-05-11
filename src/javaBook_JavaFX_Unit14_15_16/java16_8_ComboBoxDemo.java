package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/** 组合框(下拉菜单) */
public class java16_8_ComboBoxDemo extends Application {
    /** 组合框文字(标题)：字符串数组 */
    private String[] flagTitles = {
            "Canada", "China", "Denmark", "France",
            "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    /** 图片数组 */
    private ImageView[] flagImage = {
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/ca.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/china.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/denmark.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/fr.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/germany.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/india.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/norway.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/uk.gif"),
            new ImageView("javaBook_JavaFX_Unit14_15_16/image/us.gif")};

    private String[] flagDescription = new String[9];

    /** 描述文字的面板 */
    private java16_6_DescriptionPane descriptionPane = new java16_6_DescriptionPane();

    /** 创建一个组合框 (使用泛型)*/
    private ComboBox<String> cbo = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        //文本域文字
        flagDescription[0] = "The Canadian national flag ...";
        flagDescription[1] = "Description for China ...";
        flagDescription[2] = "Description for Denmark ...";
        flagDescription[3] = "Description for France ... ";
        flagDescription[4] = "Description for Germany...";
        flagDescription[5] = "Description for India ...";
        flagDescription[6] = "Description for Norway ...";
        flagDescription[7] = "Description for UK ...";
        flagDescription[8] = "Description for US ...";

        //初始默认显示选项
        setDisplay(0);

        BorderPane pane = new BorderPane();

        //将选项与面板组合
        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        //可视化列表，组合框文字 flagTitles
        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        //将items加到组合框cbo中
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        //设置监听(鼠标单击事件)，从组合框中获取鼠标的值
        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo. getValue())));

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ComboBoxDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** 设置显示 */
    private void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }
}
