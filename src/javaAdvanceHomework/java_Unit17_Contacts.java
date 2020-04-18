package javaAdvanceHomework;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class java_Unit17_Contacts extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        BorderPane borderPane = new BorderPane();
        GridPane gridpane = new GridPane();
        HBox hBox = new HBox(5);

        //添加文本框
        Text Nametext = new Text(20, 20, "Name");
        TextField Name = new TextField();
        Name.setMinSize(300, 20);
        Text Streettext = new Text(20, 20, "Street");
        TextField Street = new TextField();
        Text Citytext = new Text(20, 20, "City");


        HBox hBox1 = new HBox();
        TextField City = new TextField();
        City.setMaxSize(160, 20);

        Text Statetext = new Text(20, 20, "State");
        TextField State = new TextField();
        State.setMaxSize(40, 20);

        Text Ziptext = new Text(20, 20, "Zip");
        TextField Zip = new TextField();
        Zip.setMaxSize(60, 20);

        //添加底部按钮
        Button bt_add = new Button("Add");
        Button bt_first = new Button("First");
        Button bt_next = new Button("Next");
        Button bt_previous = new Button("Previous");
        Button bt_last = new Button("Last");
        Button bt_update = new Button("Update");

        //鼠标按钮事件
//        ObjectOutputStream output;
        bt_add.setOnMouseClicked(e -> {
            try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_08.dat"));
                ) {
                // Write a string, double value, and object to the file
                //写入对象数据，写字符串，写基本类型
                output.writeUTF(Name.getText());
                output.writeUTF(Street.getText());
                output.writeUTF(City.getText());
                output.writeUTF(State.getText());
                output.writeInt(Integer.parseInt(Zip.getText()));
                //写入日期类对象 java.util.Date()
                //DataOutputStream
                //writeUTF()  writeDouble() 这些方法是在 DataInput 接口中
                //ObjetOutputStream 类实现了 ObjectInput 这个接口,而ObjectInput 这个接口是DataInput接口的子接口
                output.writeObject(new java.util.Date());

                System.out.println("输出到文件完成");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        bt_first.setOnMouseClicked(e -> {

        });
        bt_last.setOnMouseClicked(e -> {

        });
        bt_last.setOnMouseClicked(e -> {

        });
        bt_next.setOnMouseClicked(e -> {

        });
        bt_next.setOnMouseClicked(e -> {

        });
        bt_previous.setOnMouseClicked(e -> {

        });
        bt_update.setOnMouseClicked(e -> {

        });


        gridpane.add(Nametext, 0, 0);
        gridpane.add(Name, 1, 0);
        gridpane.add(Streettext, 0, 1);
        gridpane.add(Street, 1, 1);
        gridpane.add(Citytext, 0, 2);

        hBox1.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(City, Statetext, State, Ziptext, Zip);
        gridpane.add(hBox1, 1, 2);

        gridpane.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);

        Insets size = new Insets(3, 3, 3, 3);
        gridpane.setPadding(size);
        hBox.getChildren().addAll(bt_add, bt_first, bt_last, bt_next, bt_previous, bt_update);
        borderPane.setTop(gridpane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 370, 100);
        primaryStage.setTitle("Exercise17_09");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
