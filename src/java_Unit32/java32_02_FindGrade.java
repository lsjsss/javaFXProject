package java_Unit32;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class java32_02_FindGrade extends Application {
    // Statement for executing queries
    private Statement stmt;
    private TextField tfSSN = new TextField();
    private TextField tfCourseId = new TextField();
    private Label lblStatus = new Label();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // ��ʼ�����ݿ����Ӳ�����һ�� Statement ����
        initializeDB();

        Button btShowGrade = new Button("Show Grade");
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("SSN"), tfSSN,
                new Label("Course ID"), tfCourseId, (btShowGrade));

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, lblStatus);

        // �����п� 6 ��
        tfSSN.setPrefColumnCount(6);
        tfCourseId.setPrefColumnCount(6);
        // ��ť��Ӽ���  ��ʾ�ɼ���ִ��statement��� SQL��� resout
        btShowGrade.setOnAction(e -> showGrade());

        // Create a scene and place it in the stage
        Scene scene = new Scene(vBox, 420, 80);
        // Set the stage title
        primaryStage.setTitle("java32_02_FindGrade");
        // Place the scene in the stage
        primaryStage.setScene(scene);
        // Display the stage
        primaryStage.show();
    }

    /** ��ʼ��DB */
    private void initializeDB() {
        try {
            // ����JDBC��������
            Class.forName("com.mysql.jdbc.Driver");
//      Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver loaded");

            // ��������   ���ط����������ݿ�  �û���  ����
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/javabook", "scott", "tiger");
//    ("jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl",
//     "scott", "tiger");
            System.out.println("Database connected");

            // ����һ�� statement ����
            stmt = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void showGrade() {
        String ssn = tfSSN.getText();
        String courseId = tfCourseId.getText();
        try {
            // ��ѯ�ֶ�
            String queryString = "select firstName, mi, " +
                    "lastName, title, grade from Student, Enrollment, Course " +
                    "where Student.ssn = '" + ssn + "' and Enrollment.courseId "
                    + "= '" + courseId +
                    // ���������
                    "' and Enrollment.courseId = Course.courseId " +
                    " and Enrollment.ssn = Student.ssn";

            ResultSet rset = stmt.executeQuery(queryString);

            // �ȹ����ò�ѯ�����ٹ����ַ���
            if (rset.next()) {
                String lastName = rset.getString(1);
                String mi = rset.getString(2);
                String firstName = rset.getString(3);
                String title = rset.getString(4);
                String grade = rset.getString(5);

                // �ڱ�ǩ����ʾ���
                lblStatus.setText(firstName + " " + mi +
                        " " + lastName + "'s grade on course " + title + " is " +
                        grade);
            } else {
                lblStatus.setText("Not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
