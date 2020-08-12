package game;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.*;
import javafx.stage.*;
import game.Play;

public class Icecream extends Application {
public void start(Stage primaryStage) {
Pane pane=new Pane();
String MEDIA_URL="https://freesound.org/people/plagasul/sounds/1280/download/1280__plagasul__arpeggio5lop.wav";
Media media=new Media(MEDIA_URL);
MediaPlayer mp=new MediaPlayer(media);
mp.play();



Scene scene = new Scene(pane,500,500);
Image image= new Image("resources/Untitled-1.gif");
ImageView iv= new ImageView(image);
iv.setFitHeight(500);
iv.setFitWidth(500);
Button bt=new Button("Start Game");
Play play = new Play();

DropShadow dropShadow = new DropShadow();
dropShadow.setRadius(10.0);
dropShadow.setOffsetX(5.0);
dropShadow.setOffsetY(5.0);
dropShadow.setColor(Color.color(0.0,0.0,0.0));
pane.getChildren().add(iv);
pane.getChildren().add(bt);
bt.setLayoutX(60);
bt.setLayoutY(190);
bt.setScaleY(2);
bt.setScaleX(2);
bt.setStyle("-fx-background-color:pink;-fx-text-fill: white");
bt.setEffect(dropShadow);
bt.setOnMousePressed(e-> {
bt.setEffect(null);
});
bt.setOnMouseReleased(e-> {
bt.setEffect(dropShadow);
});
bt.setOnMouseClicked(e->{
primaryStage.setScene(play.setNewScene());
});
 
Ice_Cream icecream=new Ice_Cream(); 
Button nextBt = new Button();
nextBt = play.btn;
 
nextBt.setOnMouseClicked(e->{
primaryStage.setScene(Ice_Cream.setNewScene());
});

pane.requestFocus();
primaryStage.setScene(scene);
primaryStage.show();

}

public static void main(String[] args){
Application.launch(args);
}
}