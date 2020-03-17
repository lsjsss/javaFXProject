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
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
//        Text t1 = new Text(centerX-5, centerY-clockRadius, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY +5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY - 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        //表盘美化
        double msLength = clockRadius * 0.1;//分钟刻度长度
        double msbX = centerX + msLength * Math.sin((1 % 12 + 0 / 60.0) * (2 * Math.PI / 12)) + 10;//分钟刻度起点横坐标
        double msbY = centerY - msLength * Math.cos((1 % 12 + 0 / 60.0) * (2 * Math.PI / 12)) - 10;//分钟刻度起点纵坐标
        double mseX = centerX + msLength * Math.sin((1 % 12 + 0 / 60.0) * (2 * Math.PI / 12));//分钟刻度终点横坐标
        double mseY = centerY - msLength * Math.cos((1 % 12 + 0 / 60.0) * (2 * Math.PI / 12));//分钟刻度终点纵坐标
        Line msLine = new Line(centerX, centerY, mseX, mseY);//绘制时针线
        msLine.setStroke(Color.PINK);
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
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine, msLine);
    }
}