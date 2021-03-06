package java_Unit31;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
/** 学生客户端 */
public class java31_06_StudentClient extends Application {
    private TextField tfName = new TextField();
    private TextField tfStreet = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfZip = new TextField();

    /** Button for sending a student to the server */
    /** 注册按钮 */
    private Button btRegister = new Button("Register to the java31_01_Server");

    /** Host name or ip */
    String host = "localhost";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.add(new Label("Name"), 0, 0);
        pane.add(tfName, 1, 0);
        pane.add(new Label("Street"), 0, 1);
        pane.add(tfStreet, 1, 1);
        pane.add(new Label("City"), 0, 2);

        HBox hBox = new HBox(2);
        pane.add(hBox, 1, 2);
        hBox.getChildren().addAll(tfCity, new Label("State"), tfState,
                new Label("Zip"), tfZip);
        pane.add(btRegister, 1, 3);
        GridPane.setHalignment(btRegister, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);
        tfName.setPrefColumnCount(15);
        tfStreet.setPrefColumnCount(15);
        tfCity.setPrefColumnCount(10);
        tfState.setPrefColumnCount(2);
        tfZip.setPrefColumnCount(3);

        // 设置监听
        btRegister.setOnAction(new ButtonListener());

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 450, 200);
        // Set the stage title
        primaryStage.setTitle("java31_06_StudentClient");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();
    }

    /**
     * Handle button action
     * 单击按钮触发事件，将学生对象传送到服务器
     */
    private class ButtonListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            try {
                // Establish connection with the server
                Socket socket = new Socket(host, 8000);

                // Create an output stream to the server
                ObjectOutputStream toServer =
                        new ObjectOutputStream(socket.getOutputStream());

                // Get text field
                // 为变量赋值
                String name = tfName.getText().trim();
                String street = tfStreet.getText().trim();
                String city = tfCity.getText().trim();
                String state = tfState.getText().trim();
                String zip = tfZip.getText().trim();

                // Create a Student object and send to the server
                // 通过变量生成学生对象
                java31_05_StudentAddress s =
                        new java31_05_StudentAddress(name, street, city, state, zip);
                toServer.writeObject(s);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
