package javaclass;

import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class java16_6_DescriptionPane extends BorderPane {
    private Label lblImageTitle = new Label();

    private TextArea taDescription = new TextArea();

    public java16_6_DescriptionPane() {
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

    /** 设置图 */
    public void setImageView(ImageView icon) {
        lblImageTitle.setGraphic(icon);
    }

    /** 设置文本 */
    public void setDescription(String text) {
        taDescription.setText(text);
    }
}
