package javaAdvanceHomework;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 问题描述：
 * 设计并实现一款计算器。
 * 你的任务：
 * 1.设计并实现计算器的UI架构及界面。
 * 2.用事件驱动实现计算功能。
 */

public class java4_13_Homework_3 extends Application {
    //存开始数字 0
    private int number1;
    //存结束数字 0
    private int number2;
    //存运算符的变量 null
    private String logic;

    TextField view;
    //记录第一次点击运算符之后的拼接操作
    private boolean flag;
    //记录是否按了等号
    private boolean eq;

    @Override
    public void start(Stage primaryStage) {
        HBox hBox1 = new HBox();

        //添加数值显示框
        view = new TextField("0");
        view.setMinSize(200, 40);
        view.setLayoutX(10);
        view.setLayoutY(15);
        //设置只读
        view.setEditable(false);
        //内容右对齐
        view.setAlignment(Pos.CENTER_RIGHT);
        //设置字体
        view.setFont(new Font("Consolas", 20));
        hBox1.getChildren().add(view);


//        //创建布局对象
        Pane root = new Pane();
        root.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
//        //创建场景对象
////        Scene scene = new Scene(hBox1);
////        primaryStage.setScene(scene);
//        //设置窗口宽高
//        primaryStage.setWidth(228);
//        primaryStage.setHeight(260);
//        //设置不能改变大小
//        primaryStage.setResizable(false);


        //添加一个表格布局
        GridPane gridPane = new GridPane();

        //设置布局中元素组件横向间距
//        gridPane.setHgap(20);
        //设置布局中元素组件纵向间距
//        gridPane.setVgap(10);
//        gridPane.setLayoutY(65);
//        gridPane.setPrefWidth(200);
//        gridPane.setPrefHeight(200);
//		gridPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
//        gridPane.setPadding(new Insets(10));
        //列容器
        root.getChildren().add(gridPane);


        //创建数字监听器对象
        NumberEvent numberEvent = new NumberEvent();


        //添加按钮
        Button bt[] = new Button[10];
        int x = 0, y = 2;
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new Button("" + i);
            bt[i].setMinWidth(50);
            bt[i].setMinHeight(40);
            bt[i].setOnMouseClicked(numberEvent);
//            bt[i].setOnKeyTyped(e -> {
//                String text1 = view.getText();
//                //先获取当前按钮的内容
//                String btnNumber = e.getCharacter();
//                //将显示框原本的数字拼接当前按钮的数字
//                if (flag) {
//                    text1 = "0";
//                    flag = false;
//                }
//                text1 += btnNumber;
//                //将字符串转换为int类型
//                int num = Integer.parseInt(text1);
//                //没有点击运算符按钮
//                if (logic == null) {
//                    number1 = num;
//                    //把结果显示回显示框
//                    view.setText(number1 + "");
//                    //点击了运算符按钮
//                } else {
//                    number2 = num;
//                    //把结果显示回显示框
//                    view.setText(number2 + "");
//                }
//            });
        }

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


//        gridPane.add(bt[7], 0, 0);
//        gridPane.add(bt[8], 1, 0);
//        gridPane.add(bt[9], 2, 0);
//        gridPane.add(bt[4], 0, 1);
//        gridPane.add(bt[5], 1, 1);
//        gridPane.add(bt[6], 2, 1);
//        gridPane.add(bt[1], 0, 2);
//        gridPane.add(bt[2], 1, 2);
//        gridPane.add(bt[3], 2, 2);


        //将按钮 0 添加到面板上
        gridPane.add(bt[0], 1, 3);


        //添加按钮 C
        Button bt_C = new Button("C");
        bt_C.setMinWidth(50);
        bt_C.setMinHeight(40);
        bt_C.setOnMouseClicked(e -> {
            clean();
        });
        gridPane.add(bt_C, 0, 3);


        //添加按钮 =
        Button bt_eq = new Button("=");
        bt_eq.setMinWidth(50);
        bt_eq.setMinHeight(40);
        bt_eq.setOnMouseClicked(e -> {
            //记录运算结构
            switch (logic) {
                case "+":
                    number1 = number1 + number2;
                    break;
                case "-":
                    number1 = number1 - number2;
                    break;
                case "*":
                    number1 = number1 * number2;
                    break;
                case "/":
                    number1 = number1 / number2;
                    break;
                default:
                    break;
            }
            //把结果显示回显示框
            view.setText(number1 + "");
            //按了等号
            eq = true;
        });

        gridPane.setOnKeyTyped(e -> {
            switch (e.getCode()) {
                case ADD:
                    number1 = number1 + number2;
                    logic = "+";
                    break;
                case SUBTRACT:
                    number1 = number1 - number2;
                    logic = "-";
                    break;
                case MULTIPLY:
                    number1 = number1 * number2;
                    logic = "*";
                    break;
                case DIVIDE:
                    number1 = number1 / number2;
                    logic = "/";
                    break;
                default:
                    break;
            }
            flag = true;
            //把结果显示回显示框
            view.setText(number1 + "");
            //按了等号
            eq = true;
//
//
//            String text1 = view.getText();
//            //先获取当前按钮的内容
//            String btnNumber = e.getCharacter();
//            //将显示框原本的数字拼接当前按钮的数字
//            if (flag) {
//                text1 = "0";
//                flag = false;
//            }
//            text1 += btnNumber;
//            //将字符串转换为int类型
//            int num = Integer.parseInt(text1);
//            //没有点击运算符按钮
//            if (logic == null) {
//                number1 = num;
//                //把结果显示回显示框
//                view.setText(number1 + "");
//                //点击了运算符按钮
//            } else {
//                number2 = num;
//                //把结果显示回显示框
//                view.setText(number2 + "");
//            }
        });

//        bt_eq.setOnKeyPressed(e -> {
//            switch (e.getCode()) {
//                case ADD:
//                    number1 = number1 + number2;
//                    break;
//                case SUBTRACT:
//                    number1 = number1 - number2;
//                    break;
//                case MULTIPLY:
//                    number1 = number1 * number2;
//                    break;
//                case DIVIDE:
//                    number1 = number1 / number2;
//                    break;
//            }
//            //把结果显示回显示框
//            view.setText(number1 + "");
//            //按了等号
//            eq = true;
//        });


        //运算符的按钮 =
        gridPane.add(bt_eq, 2, 3);

        //创建监听器对象
        LogicEvent logicEvent = new LogicEvent();

        //放置计算按钮，并给按钮添加事件监听器
        Button bt_add = new Button("+");
        bt_add.setMinWidth(50);
        bt_add.setMinHeight(40);
        bt_add.setOnMouseClicked(logicEvent);
        gridPane.add(bt_add, 3, 0);

        Button bt_sub = new Button("-");
        bt_sub.setMinWidth(50);
        bt_sub.setMinHeight(40);
        bt_sub.setOnMouseClicked(logicEvent);
        gridPane.add(bt_sub, 3, 1);

        Button bt_mul = new Button("*");
        bt_mul.setMinWidth(50);
        bt_mul.setMinHeight(40);
        bt_mul.setOnMouseClicked(logicEvent);
        gridPane.add(bt_mul, 3, 2);

        Button bt_div = new Button("/");
        bt_div.setMinWidth(50);
        bt_div.setMinHeight(40);
        bt_div.setOnMouseClicked(logicEvent);
        gridPane.add(bt_div, 3, 3);


//        //创建布局对象
//        Pane root = new Pane();
//			root.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
//        //创建场景对象
////        Scene scene = new Scene(hBox1);
////        primaryStage.setScene(scene);
//        //设置窗口宽高
//        primaryStage.setWidth(228);
//        primaryStage.setHeight(260);
//        //设置不能改变大小
//        primaryStage.setResizable(false);

        //调用方法添加组件
//        addComp(root);

//        primaryStage.show();


        //放置面板及面板元素
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox1);
        borderPane.setCenter(gridPane);
//        borderPane.setBottom(hBox);

        BorderPane.setAlignment(hBox1, Pos.CENTER);

        //放置场景
        Scene scene = new Scene(borderPane, 400, 200);
        primaryStage.setTitle("Exercise15_04");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 该方法是添加组件
     *
     * @param root
     */
//    private void addComp(Pane root) {
    //添加显示框
//        view = new TextField("0");
//        view.setMinSize(200, 50);
//        view.setLayoutX(10);
//        view.setLayoutY(15);
//        //设置只读
//        view.setEditable(false);
//        //内容右对齐
//        view.setAlignment(Pos.CENTER_RIGHT);
//        //设置字体
//        view.setFont(new Font("Consolas", 20));
//        root.getChildren().add(view);

//        //添加一个表格布局
//        GridPane gridPane = new GridPane();
//        //设置布局中元素组件横向间距
//        gridPane.setHgap(20);
//        //设置布局中元素组件纵向间距
//        gridPane.setVgap(10);
//        gridPane.setLayoutY(65);
//        gridPane.setPrefWidth(228);
//        gridPane.setPrefHeight(185);
////		gridPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
//        gridPane.setPadding(new Insets(10));
//        //列容器
//        root.getChildren().add(gridPane);
//
//
//        //创建数字监听器对象
//        NumberEvent numberEvent = new NumberEvent();
//        //添加按钮
//        Button btn_7 = new Button("7");
//        btn_7.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_7, 0, 0);
//
//        Button btn_8 = new Button("8");
//        btn_8.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_8, 1, 0);
//
//        Button btn_9 = new Button("9");
//        btn_9.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_9, 2, 0);
//
//
//        Button btn_4 = new Button("4");
//        btn_4.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_4, 0, 1);
//
//        Button btn_5 = new Button("5");
//        btn_5.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_5, 1, 1);
//
//        Button btn_6 = new Button("6");
//        btn_6.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_6, 2, 1);
//
//
//        Button btn_1 = new Button("1");
//        btn_1.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_1, 0, 2);
//
//        Button btn_2 = new Button("2");
//        btn_2.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_2, 1, 2);
//
//        Button btn_3 = new Button("3");
//        btn_3.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_3, 2, 2);
//
//        Button btn_0 = new Button("0");
//        btn_0.setOnMouseClicked(numberEvent);
//        gridPane.add(btn_0, 1, 3);
//
//
//        Button btn_C = new Button("C");
//        btn_C.setOnMouseClicked(new EventHandler<Event>() {
//            @Override
//            public void handle(Event event) {
//                clean();
//            }
//        });
//        gridPane.add(btn_C, 0, 3);
//
//        Button btn_eq = new Button("=");
//        btn_eq.setOnMouseClicked(new EventHandler<Event>() {
//            @Override
//            public void handle(Event event) {
//                //记录运算结构
//                switch (logic) {
//                    case "+":
//                        number1 = number1 + number2;
//                        break;
//                    case "-":
//                        number1 = number1 - number2;
//                        break;
//                    case "*":
//                        number1 = number1 * number2;
//                        break;
//                    case "/":
//                        number1 = number1 / number2;
//                        break;
//
//                    default:
//                        break;
//                }
//                //把结果显示回显示框
//                view.setText(number1 + "");
//                //按了等号
//                eq = true;
//            }
//        });
//        gridPane.add(btn_eq, 2, 3);
//        //运算符的按钮
//
//        //创建监听器对象
//        LogicEvent logicEvent = new LogicEvent();
//        Button btn_add = new Button("+");
//        //给按钮添加事件监听器
//        btn_add.setOnMouseClicked(logicEvent);
//        gridPane.add(btn_add, 3, 0);
//        Button btn_sub = new Button("-");
//        btn_sub.setOnMouseClicked(logicEvent);
//        gridPane.add(btn_sub, 3, 1);
//        Button btn_mul = new Button("*");
//        btn_mul.setOnMouseClicked(logicEvent);
//        gridPane.add(btn_mul, 3, 2);
//        Button btn_div = new Button("/");
//        btn_div.setOnMouseClicked(logicEvent);
//        gridPane.add(btn_div, 3, 3);
//    }

//    public static void main(String[] args) {
//        launch(args);
//    }

    /**
     * 数字监听器
     */
    class NumberEvent implements EventHandler<Event> {
        @Override
        public void handle(Event event) {
            //如果上一次是等号，得先清除一次
            if (eq) {
                clean();
            }

            /**
             *  ①判断运算符变量是否有值
             ②如果有值，将按钮的内容保存到2中的变量
             ③如果没有值，将按钮的内容保存到1中的变量
             */
            //获取当前显示框内容
            String text = view.getText();
            //获取事件源  (获取触发事件的按钮)
            Button btn = (Button) event.getSource();
            //先获取当前按钮的内容
            String btnNumber = btn.getText();
            //将显示框原本的数字拼接当前按钮的数字
            if (flag) {
                text = "0";
                flag = false;
            }
            text += btnNumber;
            //将字符串转换为int类型
            int num = Integer.parseInt(text);
            //没有点击运算符按钮
            if (logic == null) {
                number1 = num;
                view.setText(number1 + "");
                //点击了运算符按钮
            } else {
                number2 = num;
                view.setText(number2 + "");
            }
        }
    }

    /**
     * 运算符的事件监听器
     */
    class LogicEvent implements EventHandler<Event> {
        @Override
        public void handle(Event event) {
            //得到按钮
            Button logicBtn = (Button) event.getSource();
            //获取按钮内容
            logic = logicBtn.getText();
            flag = true;
//            eq = false;
        }
    }

    /**
     * 清除计算器参与逻辑的变量
     */
    private void clean() {
        number1 = 0;
        number2 = 0;
        logic = null;
        flag = false;
        eq = false;
        //显示0
        view.setText("0");
    }
}
