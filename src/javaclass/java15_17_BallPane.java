package javaclass;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 * @author lsjss
 */
public class java15_17_BallPane extends Pane {
    //小球属性
    public final double radius = 20;
    /**圆心*/
    private double x = radius, y = radius;
    /**增量*/
    private double dx = 1, dy = 1;
    /**绘制圆形， 将圆定义为面板的属性*/
    private Circle circle = new Circle(x, y, radius);
    /**时间线， 用于控制动画的对象*/
    private Timeline animation;

    /**时间线的对象作为面板的一个属性*/
    public java15_17_BallPane() {
        //添加圆到面板上
        circle.setFill(Color.GREEN);
        getChildren().add(circle);

        //时间线， 球的运动时间为50ms
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    /**动画播放*/
    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    /**增加速度  每次增加 0.1*/
    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    /**减少速度*/
    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    /**返回动画的速度*/
    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        if (x < radius || x > getWidth() - radius) {
            dx *= -1;
        } if (y < radius || y > getHeight() - radius) {
            dy *= -1;
        }

        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}
