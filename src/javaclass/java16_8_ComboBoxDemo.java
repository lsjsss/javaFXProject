package javaclass;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class java16_8_ComboBoxDemo extends Application {
    private String[] flagTitles = {
            "Canada", "China", "Denmark", "France",
            "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    private ImageView[] flagImage = {
            new ImageView("javaclass/image/ca.gif"),
            new ImageView("javaclass/image/china.gif"),
            new ImageView("javaclass/image/denmark.gif"),
            new ImageView("javaclass/image/fr.gif"),
            new ImageView("javaclass/image/germany.gif"),
            new ImageView("javaclass/image/india.gif"),
            new ImageView("javaclass/image/norway.gif"),
            new ImageView("javaclass/image/uk.gif"),
            new ImageView("javaclass/image/us.gif")};

    private String[] flagDescription = new String[9];

    private java16_6_DescriptionPane descriptionPane = new java16_6_DescriptionPane();

    private ComboBox<String> cbo = new ComboBox<>();

    @Override
    public void start(Stage primaryStage) {
        flagDescription[0] = "The Canadian national flag ...";
        flagDescription[1] = "Description for China ...";
        flagDescription[2] = "Description for Denmark ...";
        flagDescription[3] = "Description for France ... ";
        flagDescription[4] = "Description for Germany...";
        flagDescription[5] = "Description for India ...";
        flagDescription[6] = "Description for Norway ...";
        flagDescription[7] = "Description for UK ...";
        flagDescription[8] = "Description for US ...";

        setDisplay(0);

        BorderPane pane = new BorderPane();

        BorderPane paneForComboBox = new BorderPane();
        paneForComboBox.setLeft(new Label("Select a country: "));
        paneForComboBox.setCenter(cbo);
        pane.setTop(paneForComboBox);
        cbo.setPrefWidth(400);
        cbo.setValue("Canada");

        ObservableList<String> items = FXCollections.observableArrayList(flagTitles);
        cbo.getItems().addAll(items);
        pane.setCenter(descriptionPane);

        cbo.setOnAction(e -> setDisplay(items.indexOf(cbo. getValue())));

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ComboBoxDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setDisplay(int index) {
        descriptionPane.setTitle(flagTitles[index]);
        descriptionPane.setImageView(flagImage[index]);
        descriptionPane.setDescription(flagDescription[index]);
    }
}
