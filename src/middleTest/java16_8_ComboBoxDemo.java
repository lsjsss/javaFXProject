package middleTest;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/** 组合框(下拉菜单) */
public class java16_8_ComboBoxDemo extends Application {
    /** 组合框文字(标题)：字符串数组 */
    private String[] flagTitles = {"China", "Russia"};

    private String[] flagDescription = new String[2];

    /** 描述文字的面板 */
    private DescriptionPane descriptionPane = new DescriptionPane();

    /** 创建一个组合框 (使用泛型)*/
    private ComboBox<String> cbo = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        //文本域文字
        flagDescription[0] = "Description for China ...";
        flagDescription[1] = "Description for Russia ...";

        //初始默认显示选项
        setDisplay(0);

        BorderPane pane = new BorderPane();

        //将选项与面板组合
        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("China");

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
        descriptionPane.setDescription(flagDescription[index]);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


class DescriptionPane extends BorderPane {
    private Label lblImageTitle = new Label();

    private TextArea taDescription = new TextArea();

    public DescriptionPane() {
        lblImageTitle.setContentDisplay(ContentDisplay.TOP);
        lblImageTitle.setPrefSize(200, 100);

        //标签信息
        lblImageTitle.setFont(new Font("SansSerif", 16));
        taDescription.setFont(new Font("Serif", 14));

        taDescription.setWrapText(true);
        taDescription.setEditable(false);

        //创建滚动面板(含有滚动条)
        ScrollPane scrollPane = new ScrollPane(taDescription);

        //将标签设置到滚动面板左边
        setLeft(lblImageTitle);
        setCenter(scrollPane);
        setPadding(new Insets(5, 5, 5, 5));
    }

    /** 设置标题 */
    public void setTitle(String title) {
        lblImageTitle.setText(title);
    }

    /** 设置文本 */
    public void setDescription(String text) {
        taDescription.setText(text);
    }
}

