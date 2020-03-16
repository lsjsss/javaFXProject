import javafx.application.Application;
import javafx.stage.Stage;

public class java14_2_4_Test extends Application {
    public java14_2_4_Test() {
        System.out.println("Test constructor is invoked");
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start methood is invoked");
    }

    public static void main(String[] args) {
        System.out.println("launch application");
        Application.launch(args);
    }
}
