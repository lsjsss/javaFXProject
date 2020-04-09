package javaclass;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class java16_14_MediaDemo extends Application {
    private static final String MEDIA_URL =
            "http://47.95.255.91/jiongma.mp4";
//                    "cs.armstrong.edu/liang/common/sample.mp4";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        //mediaPlayer做参数，MediaView做对象
        MediaView mediaView = new MediaView(mediaPlayer);

        //播放按钮
        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                //单击播放按钮变为暂停状态
                playButton.setText("||");
            } else {
                mediaPlayer.play();
                //单击暂停按钮变为播放状态
                playButton.setText(">");
            }
        });

        Button rewindButton = new Button("<<");
        //按快退键转到视频开头
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        //滑杆，调节音量
        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_COMPUTED_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        //值属性除100，与视频音量属性相同
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton,
                new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 650, 500);
        primaryStage.setTitle("MediaDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
