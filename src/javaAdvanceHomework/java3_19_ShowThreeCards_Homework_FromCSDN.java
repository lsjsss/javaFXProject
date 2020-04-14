package javaAdvanceHomework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.geometry.Insets;
//import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class java3_19_ShowThreeCards_Homework_FromCSDN extends Application {
//    public static ImageView readImageFromJar(String jarname, String picname) {
//        ImageView imageView = null;
//        try {
//            JarFile jarFile = new JarFile(jarname);
//            JarEntry entry = jarFile.getJarEntry(picname);
//            InputStream in = jarFile.getInputStream(entry);
//            imageView = new ImageView(new Image(in));
//            in.close();
//            jarFile.close();
//        }
//        catch (IOException e) {
//            System.err.println("read file error.");
//        }
//        return imageView;
//    }
    @Override
    public void start(Stage primaryStage) {
        int r1=(int)((Math.random()*100)%54);
        int r2=(int)((Math.random()*100)%54);
        int r3=(int)((Math.random()*100)%54);
        int r4=(int)((Math.random()*100)%54);
        Pane pane=new HBox();
        pane.setPadding(new Insets(5,5,5,5));
        String card1=new String("javaBook_JavaFX_Unit14_15_16/image/card/" +String.valueOf(r1)+".png");
        String card2=new String("javaBook_JavaFX_Unit14_15_16/image/card/" +String.valueOf(r2)+".png");
        String card3=new String("javaBook_JavaFX_Unit14_15_16/image/card/" +String.valueOf(r3)+".png");
        String card4=new String("javaBook_JavaFX_Unit14_15_16/image/card/" +String.valueOf(r4)+".png");
//        ImageView imageView1 = new ImageView(card1);
//        ImageView imageView2 = new ImageView(card2);
//        ImageView imageView3 = new ImageView(card3);
//        ImageView imageView4 = new ImageView(card4);
        String name1="     ", name2="     ", name3="     ", name4="     ";
//        name1=getName(name1,r1);
//        name2=getName(name2,r2);
//        name3=getName(name3,r3);
//        name4=getName(name4,r4);
        Text t1=new Text(name1);
        Text t2=new Text(name2);
        Text t3=new Text(name3);
        Text t4=new Text(name4);
        pane.getChildren().add(new ImageView(card1));
        pane.getChildren().add(t1);
        pane.getChildren().add(new ImageView(card2));
        pane.getChildren().add(t2);
        pane.getChildren().add(new ImageView(card3));
        pane.getChildren().add(t3);
        pane.getChildren().add(new ImageView(card4));
        pane.getChildren().add(t4);

        Scene scene=new Scene(pane);
        primaryStage.setTitle("第三题");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    public String getName(String name,int r){
//        if(r>=1 && r<=13) {
//            name+="黑桃";
//        } else if(r>=14 && r<=26) {
//            name+="红桃";
//        } else if(r>=27 && r<=39) {
//            name+="方块";
//        } else if(r>=40 && r<=52) {
//            name+="梅花";
//        } else if(r==53 || r==54) {
//            name+="大王";
//        }
//        if(r!=53 && r!=54){
//            if(r==11 || r==24 || r==37 || r==50) {
//                name+="J";
//            } else if(r==12 || r==25 || r==38 || r==51) {
//                name+="Q";
//            } else if(r==13 || r==26 || r==39 || r==52) {
//                name+="K";
//            } else if(r==1 || r==14 || r==27 || r==40) {
//                name+="A";
//            } else {
//                name+=String.valueOf(r%13);
//            }
//        }
//        return name;
//    }
    public static void main(String[] args) {
        launch(args);
    }
}
