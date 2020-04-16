package javaAdvanceHomework;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 问题描述：
 * 设计并实现一款计算器。
 * 你的任务：
 * 1.设计并实现计算器的UI架构及界面。
 * 2.用事件驱动实现计算功能。
 */

public class Exercise16 extends Application {
    TextField type1;
    TextField type2 = new TextField();
    TextArea log = new TextArea("计算结果记录:\n");

    /** 数值显示 */
    VBox vBox = new VBox();
    /** 记录显示 */
    VBox vBox2 = new VBox();
    /** 按钮显示 */
    GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        /** 数值显示 */
        showType();

        /** 记录显示 */
        log.setMinSize(200,160);
        log.setMaxSize(200,160);
        log.setEditable(false);

        /** 添加数字按钮 */
        numButton();

        /** 添加符号按钮 */
        symbalButton();

        //放置面板及面板元素
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox);
        borderPane.setCenter(vBox2);
        borderPane.setLeft(gridPane);

        //放置场景
        Scene scene = new Scene(borderPane, 430, 220);
        primaryStage.setTitle("Exercise16");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        /** 键盘动作事件 */
        scene.setOnKeyReleased(e -> {
            keyEvent(e);
        });
    }

    /** 数值显示 */
    public void showType() {
        //添加数值显示框
        type1 = new TextField("");
        type2 = new TextField("实时计算结果");
        type1.setMinSize(200, 20);
        type2.setMaxSize(230, 20);
        type1.setLayoutX(10);
        type1.setLayoutY(15);
        //设置结果显示区域为只读
        type2.setEditable(false);
        //文字内容右对齐
        type1.setAlignment(Pos.CENTER_RIGHT);
        //设置字体
        type1.setFont(new Font("Consolas", 20));
    }

    /** 添加数字按钮 */
    private void numButton() {
        //数字按钮
        Button bt[] = new Button[10];
        int x = 0, y = 2;
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new Button("" + i);
            bt[i].setMinSize(50,40);
            String num = i + "";
            int zero = i;
            bt[i].setOnMouseClicked(e -> {
                String news = type1.getText() + num;
                type1.setText(news);

                //判断首个数字是否为 0
                String olds = type1.getText();
                if(olds.charAt(0) == '0') {
                    String news2 = "";
                    for (int j = 1; j < olds.length(); j++) {
                        news2 = news2 + olds.charAt(j);
                    }
                    type1.setText(news2);
                }

                String s;
                s = type1.getText();
                try {
                    type2.setText("" + calculate(s));
                } catch (Exception e1) {
                    type2.setText("输入错误");
                }
                type1.requestFocus();
            });
        }

        //将按钮 0 添加到面板上
        gridPane.add(bt[0], 1, 3);

        /** 面板添加 */
        //添加文本框
        vBox.getChildren().addAll(type1, type2);
        vBox2.getChildren().add(log);

        //将按钮 1-9 添加到面板上
        for (int i = 1; i < bt.length; i++) {
            gridPane.add(bt[i], x, y);
            x++;
            if (x == 3) {
                x = 0;
            }

            if (i == 3) {
                y--;
            } else if (i == 6) {
                y--;
            }
        }
    }

    /** 添加符号按钮 */
    public void symbalButton() {
        //放置计算按钮 + - * /，并给按钮添加事件监听器
        Button bt_add = new Button("+");
        bt_add.setMinSize(40,40);
        bt_add.setMaxSize(40,40);
        bt_add.setOnMouseClicked(e -> {
            calculateEvent("+");
        });
        gridPane.add(bt_add, 3, 0);

        Button bt_sub = new Button("-");
        bt_sub.setMinSize(40,40);
        bt_sub.setMaxSize(40,40);
        bt_sub.setOnMouseClicked(e -> {
            calculateEvent("-");
        });
        gridPane.add(bt_sub, 3, 1);

        Button bt_mul = new Button("*");
        bt_mul.setMinSize(40,40);
        bt_mul.setMinSize(40,40);
        bt_mul.setOnMouseClicked(e -> {
            calculateEvent("*");
        });
        gridPane.add(bt_mul, 3, 2);

        Button bt_div = new Button("/");
        bt_div.setMinSize(40,40);
        bt_div.setMinSize(40,40);
        bt_div.setOnMouseClicked(e -> {
            calculateEvent("/");
        });
        gridPane.add(bt_div, 3, 3);


        //运算符的按钮 =
        Button bt_eq = new Button("=");
        bt_eq.setMinSize(50,40);
        bt_eq.setMaxSize(50,40);
        bt_eq.setOnMouseClicked(e -> {
            //把结果显示回显示框
            System.out.println("计算结果");

            String oldls = log.getText();
            log.setText(oldls + type1.getText() + "=" + calculate(type1.getText()) + "\n");
        });
        gridPane.add(bt_eq, 2, 3);

        //添加清空数字按钮 C
        Button bt_C = new Button("C");
        bt_C.setMinSize(50,40);
        bt_C.setMinSize(50,40);
        bt_C.setOnMouseClicked(e -> {
            type1.setText("0");
            type2.setText("");
            System.out.println("清零");
        });
        gridPane.add(bt_C, 0, 3);


        //添加倒数按钮
        Button bt_re = new Button("1/x");
        bt_re.setMinSize(40,40);
        bt_re.setMaxSize(40,40);
        bt_re.setOnMouseClicked(e -> {
            try {
                String s = type1.getText();
                type2.setText("" + 1/calculate(s));
                System.out.println("倒数运算");
            } catch(Exception e1) {
                System.out.println("算式格式有误，无法进行倒数计算");
            }
        });
        gridPane.add(bt_re, 4, 0);

        //添加开平方按钮
        Button bt_ex = new Button("√");
        bt_ex.setMinSize(40,40);
        bt_ex.setMaxSize(40,40);
        bt_ex.setOnMouseClicked(e -> {
            try {
                String s = type1.getText();
                type2.setText("" + Math.sqrt(calculate(s)));
                System.out.println("开平方");
            } catch(Exception e1) {
                System.out.println("算式格式有误，无法进行倒数计算");
            }
        });
        gridPane.add(bt_ex, 4, 1);

        //添加平方按钮
        Button bt_sq = new Button("x^2");
        bt_sq.setMinSize(40,40);
        bt_sq.setMaxSize(40,40);
        bt_sq.setOnMouseClicked(e -> {
            try {
                String s = type1.getText();
                type2.setText("" + Math.pow(calculate(s), 2));
                System.out.println("计算平方值");
            } catch(Exception e1) {
                System.out.println("算式格式有误，无法进行倒数计算");
            }
        });
        gridPane.add(bt_sq, 4, 2);

        //添加小数点按钮
        Button bt_po = new Button(".");
        bt_po.setMinSize(40,40);
        bt_po.setOnMouseClicked(e -> {
            calculateEvent(".");
        });
        gridPane.add(bt_po, 4, 3);
    }


    /** 按钮 + - * / 事件 */
    private void calculateEvent(String ch) {
        String news = type1.getText() + ch;
        type1.setText(news);

        String s;
        s = type1.getText();
        try {
            type2.setText("" + calculate(s));
        } catch (Exception e1) {
            type2.setText("输入错误");
        }
    }

    public void keyEvent(KeyEvent e) {
        String s;
        switch (e.getCode()) {
            //按下enter键
            case ENTER:
                System.out.println("计算结果");

                String oldls = log.getText();
                log.setText(oldls + type1.getText() + "=" + calculate(type1.getText()) + "\n");
                break;
            //如果按下的不是enter键
            default:
                s = type1.getText();
                try {
                    type2.setText("" + calculate(s));
                } catch (Exception e1) {
                    type2.setText("输入错误");
                }
        }
    }


    /** 核心计算 */
    public double calculate(String s) {
        double sum = 0;
        String sn = s;
        //判断是否包含"-"号
        if (sn.contains("-")) {
            sn = sn.replace("-", "+-");
        }
        //排除连"++"号的影响，如5-3++-3
        String[] ss = sn.split("\\+");
        for (int k = 0; k < ss.length; k++) {
            if (ss[k].equals("")) {
                ss[k] = "0";
            }
        }
        //剥离符号，进行运算
        for (int i = 0; i < ss.length; i++) {
            //判断是否同时具有"*"和"/"
            if (ss[i].contains("*") && ss[i].contains("/")) {
                double sum1 = 1;
                String[] sss = ss[i].split("\\*");
                for (int l = 0; l < sss.length; l++) {
                    //判断是否有"/",如果有继续剥离
                    if (sss[l].contains("/")) {
                        String[] ssss = sss[l].split("\\/");
                        double sum2 = Double.parseDouble(ssss[0]);
                        for (int h = 1; h < ssss.length; h++) {
                            sum2 = sum2 / Double.parseDouble(ssss[h]);
                        }
                        sum1 = sum1 * sum2;
                    } else {
                        sum1 = sum1 * Double.parseDouble(sss[l]);
                    }
                }
                sum += sum1;
            }
            //判断是否只有"*"
            else if (ss[i].contains("*") && !ss[i].contains("/")) {
                String[] sss = ss[i].split("\\*");
                double sum1 = 1;
                for (int l = 0; l < sss.length; l++) {
                    sum1 = sum1 * Double.parseDouble(sss[l]);
                }
                sum += sum1;
            }
            //判断是否只有"/"
            else if (ss[i].contains("/") && !ss[i].contains("*")) {
                String[] sss = ss[i].split("\\/");
                double sum1 = Double.parseDouble(sss[0]);
                for (int l = 1; l < sss.length; l++) {
                    sum1 = sum1 / Double.parseDouble(sss[l]);
                }
                sum += sum1;
            }
            //只包含数字
            else {
                sum += Double.parseDouble(ss[i]);
            }
        }
        //控制台即时输出计算日志
        System.out.println(s + "=" + sum);
        return sum;
    }
}
