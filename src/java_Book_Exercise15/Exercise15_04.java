package java_Book_Exercise15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * ¼òÒ×¼ÆËãÆ÷
 *
 * @author ASUS
 */
public class Exercise15_04 extends Application {
    private double d1, d2, d3;
    Double c1, c2, c3, c4;
    String str1, str2;

    @Override
    public void start(Stage stage) {
        HBox hbTop = new HBox();
        HBox hbBottom = new HBox();
        hbBottom.setAlignment(Pos.CENTER);
        hbBottom.setSpacing(60);
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        Text t1 = new Text("Number1:");
        t1.setFont(new Font(20));
        Text t2 = new Text("Number2:");
        t2.setFont(new Font(20));
        Text t3 = new Text("Result:");
        t3.setFont(new Font(20));
        TextField tf1 = new TextField();
        tf1.setEditable(true);
        TextField tf2 = new TextField();
        tf2.setEditable(true);
        TextField tf3 = new TextField();
        tf3.setEditable(true);

        hbTop.getChildren().addAll(t1, tf1, t2, tf2, t3, tf3);

        Button bt1 = new Button("Add");
        Button bt2 = new Button("Subtract");
        Button bt3 = new Button("Multiply");
        Button bt4 = new Button("Divide");
        hbBottom.getChildren().addAll(bt1, bt2, bt3, bt4);

        vbox.getChildren().addAll(hbTop, hbBottom);

        Scene scene = new Scene(vbox, 500, 80);
        stage.setTitle("Exercise15_04");
        stage.setScene(scene);
        stage.show();

        bt1.setOnAction((ActionEvent e) -> {
            str1 = tf1.getText();
            d1 = (double) Double.parseDouble(str1);
            str2 = tf2.getText();
            d2 = (double) Double.parseDouble(str2);
            d3 = d1 + d2;
            c1 = new Double(d3);
            tf3.setText(c1.toString());
        });
        bt2.setOnAction((ActionEvent e) -> {
            str1 = tf1.getText();
            d1 = (double) Double.parseDouble(str1);
            str2 = tf2.getText();
            d2 = (double) Double.parseDouble(str2);
            d3 = d1 - d2;
            c2 = new Double(d3);
            tf3.setText(c2.toString());
        });
        bt3.setOnAction((ActionEvent e) -> {
            str1 = tf1.getText();
            d1 = (double) Double.parseDouble(str1);
            str2 = tf2.getText();
            d2 = (double) Double.parseDouble(str2);
            d3 = d1 * d2;
            c3 = new Double(d3);
            tf3.setText(c3.toString());
        });
        bt4.setOnAction((ActionEvent e) -> {
            str1 = tf1.getText();
            d1 = (double) Double.parseDouble(str1);
            str2 = tf2.getText();
            d2 = (double) Double.parseDouble(str2);
            d3 = d1 / d2;
            c4 = new Double(d3);
            tf3.setText(c4.toString());
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}