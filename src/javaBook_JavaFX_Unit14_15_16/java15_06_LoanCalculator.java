package javaBook_JavaFX_Unit14_15_16;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class java15_06_LoanCalculator extends Application {
    /**属性设置在方法前好，还是方法里面好?
    * 多个方法公用的属性，放在方法前面*/
    // 6 个属性, 公用属性
    //文本域
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalulate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) throws Exception {
        //网格面板
        GridPane gridPane = new GridPane();
        //水平
        gridPane.setHgap(5);
        //垂直
        gridPane.setVgap(5);
        //列，行排列
        gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        gridPane.add(tfAnnualInterestRate, 1, 0);
        gridPane.add(new Label("Number Of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);
        gridPane.add(new Label("Monthly Payment"), 0, 3);
        gridPane.add(tfMonthlyPayment, 1, 3);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 4);
        gridPane.add(tfTotalPayment, 1, 4);
        gridPane.add(btCalulate, 1, 5);

        gridPane.setAlignment(Pos.CENTER);
        //文本域中文字是右对齐，下边对齐
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);

        //将文本的可编辑属性设置为 假
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        //设置网格面板的 水平h，垂直v 的对齐方式
        GridPane.setHalignment(btCalulate, HPos.RIGHT);

        btCalulate.setOnAction(e -> calculateLoanPayment());

        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("LoanCaculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateLoanPayment() {
        //因为 TextFiled.getText() 的返回值类型是字符串，所以使用 double 强制类型转换
        double interest = Double.parseDouble(tfAnnualInterestRate.getText());
        int year = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());

        //产生一个贷款对象 Loan
//        Loan loan = new Loan(interest, year, loanAmount);

//        tfMonthlyPayment.setText(String.format("$%.2f",loan.getMonthlyPayment));
//        tfTotalPayment.setText(String.format("$%。2f", loan.getTotalPayment));
    }

}
