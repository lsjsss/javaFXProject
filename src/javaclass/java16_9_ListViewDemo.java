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
    private String[] flagTitles = {
            "Canada", "China", "Denmark", "France",
            "Germany", "India", "Norway", "United Kingdom",
            "United States of America"};

    private ImageView[] ImageViews = {
            new ImageView("javaclass/image/ca.gif"),
            new ImageView("javaclass/image/china.gif"),
            new ImageView("javaclass/image/denmark.gif"),
            new ImageView("javaclass/image/fr.gif"),
            new ImageView("javaclass/image/germany.gif"),
            new ImageView("javaclass/image/india.gif"),
            new ImageView("javaclass/image/norway.gif"),
            new ImageView("javaclass/image/uk.gif"),
            new ImageView("javaclass/image/us.gif")};

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<String> lv = new ListView<>
                (FXCollections.observableArrayList(flagTitles));
        lv.setPrefSize(400, 400);
        lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        FlowPane imagePane = new FlowPane(10, 10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(lv));
        pane.setCenter(imagePane);

        lv.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                    imagePane.getChildren().clear();
                    for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
                        imagePane.getChildren().add(ImageViews[i]);
                    }
                }
        );

        Scene scene = new Scene(pane, 450, 170);
        primaryStage.setTitle("ListViewDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
