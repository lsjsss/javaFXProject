import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class java16_7_TextAreaDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        java16_6_DescriptionPane descriptionPane = new java16_6_DescriptionPane();

        descriptionPane.setTitle("Canada");
        String description = "The Canadian national flag ...";
        descriptionPane.setImageView(new ImageView("image/ca.gif"));
        descriptionPane.setdescription(description);

        Scene scene = new Scene(descriptionPane, 450, 200);
        primaryStage.setTitle("TextAreaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
