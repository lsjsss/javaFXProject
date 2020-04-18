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
 * ����������
 * ��Ʋ�ʵ��һ���������
 * �������
 * 1.��Ʋ�ʵ�ּ�������UI�ܹ������档
 * 2.���¼�����ʵ�ּ��㹦�ܡ�
 */

public class java4_13_Homework_Exercise16 extends Application {
    TextField type1;
    TextField type2 = new TextField();
    TextArea log = new TextArea("��������¼:\n");

    /** ��ֵ��ʾ */
    VBox vBox = new VBox();
    /** ��¼��ʾ */
    VBox vBox2 = new VBox();
    /** ��ť��ʾ */
    GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        /** ��ֵ��ʾ */
        showType();

        /** ��¼��ʾ */
        log.setMinSize(200,160);
        log.setMaxSize(200,160);
        log.setEditable(false);

        /** ������ְ�ť */
        numButton();

        /** ��ӷ��Ű�ť */
        symbalButton();

        //������弰���Ԫ��
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(vBox);
        borderPane.setCenter(vBox2);
        borderPane.setLeft(gridPane);

        //���ó���
        Scene scene = new Scene(borderPane, 430, 220);
        primaryStage.setTitle("Exercise16");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();

        /** ���̶����¼� */
        scene.setOnKeyReleased(e -> {
            keyEvent(e);
        });
    }

    /** ��ֵ��ʾ */
    public void showType() {
        //�����ֵ��ʾ��
        type1 = new TextField("");
        type2 = new TextField("ʵʱ������");
        type1.setMinSize(200, 20);
        type2.setMaxSize(230, 20);
        type1.setLayoutX(10);
        type1.setLayoutY(15);
        //���ý����ʾ����Ϊֻ��
        type2.setEditable(false);
        //���������Ҷ���
        type1.setAlignment(Pos.CENTER_RIGHT);
        //��������
        type1.setFont(new Font("Consolas", 20));
    }

    /** ������ְ�ť */
    private void numButton() {
        //���ְ�ť
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

                //�ж��׸������Ƿ�Ϊ 0
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
                    type2.setText("�������");
                }
                type1.requestFocus();
            });
        }

        //����ť 0 ��ӵ������
        gridPane.add(bt[0], 1, 3);

        /** ������ */
        //����ı���
        vBox.getChildren().addAll(type1, type2);
        vBox2.getChildren().add(log);

        //����ť 1-9 ��ӵ������
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

    /** ��ӷ��Ű�ť */
    public void symbalButton() {
        //���ü��㰴ť + - * /��������ť����¼�������
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


        //������İ�ť =
        Button bt_eq = new Button("=");
        bt_eq.setMinSize(50,40);
        bt_eq.setMaxSize(50,40);
        bt_eq.setOnMouseClicked(e -> {
            //�ѽ����ʾ����ʾ��
            System.out.println("������");

            String oldls = log.getText();
            log.setText(oldls + type1.getText() + "=" + calculate(type1.getText()) + "\n");
        });
        gridPane.add(bt_eq, 2, 3);

        //���������ְ�ť C
        Button bt_C = new Button("C");
        bt_C.setMinSize(50,40);
        bt_C.setMinSize(50,40);
        bt_C.setOnMouseClicked(e -> {
            type1.setText("0");
            type2.setText("");
            System.out.println("����");
        });
        gridPane.add(bt_C, 0, 3);


        //��ӵ�����ť
        Button bt_re = new Button("1/x");
        bt_re.setMinSize(40,40);
        bt_re.setMaxSize(40,40);
        bt_re.setOnMouseClicked(e -> {
            try {
                String s = type1.getText();
                type2.setText("" + 1/calculate(s));
                System.out.println("��������");
            } catch(Exception e1) {
                System.out.println("��ʽ��ʽ�����޷����е�������");
            }
        });
        gridPane.add(bt_re, 4, 0);

        //��ӿ�ƽ����ť
        Button bt_ex = new Button("��");
        bt_ex.setMinSize(40,40);
        bt_ex.setMaxSize(40,40);
        bt_ex.setOnMouseClicked(e -> {
            try {
                String s = type1.getText();
                type2.setText("" + Math.sqrt(calculate(s)));
                System.out.println("��ƽ��");
            } catch(Exception e1) {
                System.out.println("��ʽ��ʽ�����޷����е�������");
            }
        });
        gridPane.add(bt_ex, 4, 1);

        //���ƽ����ť
        Button bt_sq = new Button("x^2");
        bt_sq.setMinSize(40,40);
        bt_sq.setMaxSize(40,40);
        bt_sq.setOnMouseClicked(e -> {
            try {
                String s = type1.getText();
                type2.setText("" + Math.pow(calculate(s), 2));
                System.out.println("����ƽ��ֵ");
            } catch(Exception e1) {
                System.out.println("��ʽ��ʽ�����޷����е�������");
            }
        });
        gridPane.add(bt_sq, 4, 2);

        //���С���㰴ť
        Button bt_po = new Button(".");
        bt_po.setMinSize(40,40);
        bt_po.setOnMouseClicked(e -> {
            calculateEvent(".");
        });
        gridPane.add(bt_po, 4, 3);
    }


    /** ��ť + - * / �¼� */
    private void calculateEvent(String ch) {
        String news = type1.getText() + ch;
        type1.setText(news);

        String s;
        s = type1.getText();
        try {
            type2.setText("" + calculate(s));
        } catch (Exception e1) {
            type2.setText("�������");
        }
    }

    public void keyEvent(KeyEvent e) {
        String s;
        switch (e.getCode()) {
            //����enter��
            case ENTER:
                System.out.println("������");

                String oldls = log.getText();
                log.setText(oldls + type1.getText() + "=" + calculate(type1.getText()) + "\n");
                break;
            //������µĲ���enter��
            default:
                s = type1.getText();
                try {
                    type2.setText("" + calculate(s));
                } catch (Exception e1) {
                    type2.setText("�������");
                }
        }
    }


    /** ���ļ��� */
    public double calculate(String s) {
        double sum = 0;
        String sn = s;
        //�ж��Ƿ����"-"��
        if (sn.contains("-")) {
            sn = sn.replace("-", "+-");
        }
        //�ų���"++"�ŵ�Ӱ�죬��5-3++-3
        String[] ss = sn.split("\\+");
        for (int k = 0; k < ss.length; k++) {
            if (ss[k].equals("")) {
                ss[k] = "0";
            }
        }
        //������ţ���������
        for (int i = 0; i < ss.length; i++) {
            //�ж��Ƿ�ͬʱ����"*"��"/"
            if (ss[i].contains("*") && ss[i].contains("/")) {
                double sum1 = 1;
                String[] sss = ss[i].split("\\*");
                for (int l = 0; l < sss.length; l++) {
                    //�ж��Ƿ���"/",����м�������
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
            //�ж��Ƿ�ֻ��"*"
            else if (ss[i].contains("*") && !ss[i].contains("/")) {
                String[] sss = ss[i].split("\\*");
                double sum1 = 1;
                for (int l = 0; l < sss.length; l++) {
                    sum1 = sum1 * Double.parseDouble(sss[l]);
                }
                sum += sum1;
            }
            //�ж��Ƿ�ֻ��"/"
            else if (ss[i].contains("/") && !ss[i].contains("*")) {
                String[] sss = ss[i].split("\\/");
                double sum1 = Double.parseDouble(sss[0]);
                for (int l = 1; l < sss.length; l++) {
                    sum1 = sum1 / Double.parseDouble(sss[l]);
                }
                sum += sum1;
            }
            //ֻ��������
            else {
                sum += Double.parseDouble(ss[i]);
            }
        }
        //����̨��ʱ���������־
        System.out.println(s + "=" + sum);
        return sum;
    }
}
