package java_Unit30;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class java30_02_FlashText extends Application {
    private String text = "";

    /**
     * ����Application���е�start����
     * Override the start method in the Application class
     */
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Label lblText = new Label("Programming is fun");
        pane.getChildren().add(lblText);

        // �����ڲ��࣬�������һ��ʵ���� Runnable �ӿڵ���
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (lblText.getText().trim().length() == 0) {
                            text = "Welcome";
                        } else {
                            text = "";
                        }

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblText.setText(text);
                            }
                        });

                        // ��˸���ʱ��
                        Thread.sleep(200);
                    }
                } catch (InterruptedException ex) {
                }
            }
        }).start();

        // ����һ�������������������̨��  Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        // Set the stage title
        primaryStage.setTitle("java30_02_FlashText");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();
    }

    /**
     * main�����������޵�IDE�в���Ҫ
     * JavaFX֧�֡������������в���Ҫ��
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
