import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class java14_21_ClockPane_Tests extends Pane {
    private int hour, minute, second;

    private double w = 250, h = 250;

    public java14_21_ClockPane_Tests() {
        setCurrentTime();
    }

    public java14_21_ClockPane_Tests(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
        paintClock();
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        this.hour = hour;
        this.minute = minute;
        this.second = second;

        paintClock();
    }

    protected void paintClock() {
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 22, "12");
        Text t2 = new Text(centerX - clockRadius + 13, centerY +5, "9");
        Text t3 = new Text(centerX + clockRadius - 20, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 13, "6");


        //表盘数字美化
        double tLength = clockRadius ;//时钟刻度长度
        double[] tsbX = new double[12];
        double[] tsbY = new double[12];
        Line[] tsLine = new Line[12];
        Text[] t = new Text[12];
        for (int i = 0; i < 12; i++){
            tsbX[i] = centerX - 5 + (tLength - 20) * Math.sin((i % 12 + 0 / 60.0) * (2 * Math.PI / 12));//时钟数字刻度起点横坐标
            tsbY[i] = centerY + 4 - (tLength - 20) * Math.cos((i % 12 + 0 / 60.0) * (2 * Math.PI / 12));//时钟数字刻度起点纵坐标
//            tsLine[i] = new Line(tsbX[i], tsbY[i], tseX[i], tseY[i]);//绘制时针线
            if (i == 0){
                t[i] = new Text(tsbX[i], tsbY[i], "12");
            }else {
                t[i] = new Text(tsbX[i], tsbY[i], ""+i);
            }

//            tsLine[i].setStroke(Color.BLACK);
        }

        //结束

        //表盘美化
        double hsLength = clockRadius ;//时钟刻度长度
        double[] hsbX = new double[12];
        double[] hsbY = new double[12];
        double[] hseX = new double[12];
        double[] hseY = new double[12];
        Line[] hsLine = new Line[12];
        for (int i = 0; i < 12; i++){
            hsbX[i] = centerX + (hsLength - 10) * Math.sin((i % 12 + 0 / 60.0) * (2 * Math.PI / 12));//时钟刻度起点横坐标
            hsbY[i] = centerY - (hsLength - 10) * Math.cos((i % 12 + 0 / 60.0) * (2 * Math.PI / 12));//时钟刻度起点纵坐标
            hseX[i] = centerX + hsLength * Math.sin((i % 12 + 0 / 60.0) * (2 * Math.PI / 12));//时钟刻度终点横坐标
            hseY[i] = centerY - hsLength * Math.cos((i % 12 + 0 / 60.0) * (2 * Math.PI / 12));//时钟刻度终点纵坐标
            hsLine[i] = new Line(hsbX[i], hsbY[i], hseX[i], hseY[i]);//绘制时针线
            hsLine[i].setStroke(Color.BLACK);
        }

        double msLength = clockRadius ;//分钟刻度长度
        double[] msbX = new double[60];
        double[] msbY = new double[60];
        double[] mseX = new double[60];
        double[] mseY = new double[60];
        Line[] msLine = new Line[60];
        for (int i = 0; i < 60; i++){
            msbX[i] = centerX + (msLength - 5) * Math.sin((i % 60 + 0 / 60.0) * (2 * Math.PI / 60));//分钟刻度起点横坐标
            msbY[i] = centerY - (msLength - 5) * Math.cos((i % 60 + 0 / 60.0) * (2 * Math.PI / 60));//分钟刻度起点纵坐标
            mseX[i] = centerX + msLength * Math.sin((i % 60 + 0 / 60.0) * (2 * Math.PI / 60));//分钟刻度终点横坐标
            mseY[i] = centerY - msLength * Math.cos((i % 60 + 0 / 60.0) * (2 * Math.PI / 60));//分钟刻度终点纵坐标
            msLine[i] = new Line(msbX[i], msbY[i], mseX[i], mseY[i]);//绘制分针线
            msLine[i].setStroke(Color.BLACK);
        }
        //结束

        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60 ));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60 ));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);

        double hLength = clockRadius * 0.5;//时针长度
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));//时针终点横坐标
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));//时针终点纵坐标
        Line hLine = new Line(centerX, centerY, hourX, hourY);//绘制时针线
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
//        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        getChildren().addAll(circle, sLine, mLine, hLine);
        for (int i=0; i<12; i++){
            getChildren().addAll(hsLine[i]);
            getChildren().addAll(t[i]);
        }
        for (int i=0; i<60; i++){
            getChildren().addAll(msLine[i]);
        }
    }
}
