package game;

import javafx.scene.*;

import javafx.scene.control.*;

import javafx.scene.effect.*;

import javafx.scene.image.*;

import javafx.scene.layout.*;

import javafx.scene.paint.*;

import javafx.scene.text.*;


public class Play

{

public Button btn = new Button("Next");

Image cat1= new Image("resources/Pusheen.png");

Image cat2= new Image("resources/Unicorn.png");

Image cat3= new Image("resources/Pinky.png");

ImageView iv= new ImageView(cat1);

ImageView iv2= new ImageView(cat2);

ImageView iv3= new ImageView(cat3);

static ImageView sendIv;

static int pic;


public Play()

{

}


public Scene setNewScene()

{

Pane pane=new Pane();

Scene scene = new Scene(pane,500,700);


Image backgroundimage= new Image("resources/BG.jpg",500,700,false,true);

BackgroundImage background= new BackgroundImage(backgroundimage

,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT

,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);


DropShadow dropShadow = new DropShadow();

DropShadow dropShadow2= new DropShadow();

dropShadow2.setRadius(10.0);

dropShadow2.setOffsetX(5.0);

dropShadow2.setOffsetY(5.0);

dropShadow.setRadius(5.0);

dropShadow.setOffsetX(3.0);

dropShadow.setOffsetY(3.0);

dropShadow2.setColor(Color.color(0.0,0.0, 0.0));

dropShadow.setColor(Color.color(0.6,0.08, 0.8));


Text txt= new Text("Choose your SUPER-CAT!!");


txt.setLayoutY(30);

txt.setLayoutX(140);

txt.setEffect(dropShadow);

txt.setFont(Font.font(20));

txt.setFont(Font.font("FLAMENCO", FontWeight.BOLD, FontPosture.ITALIC, 20));

txt.setFill(Color.WHITE);


iv.setOnMousePressed(e-> 

{

iv.setEffect(dropShadow);

iv2.setEffect(null);

iv3.setEffect(null);

});


iv2.setOnMousePressed(e-> 

{

iv2.setEffect(dropShadow);

iv.setEffect(null);

iv3.setEffect(null);

});


iv3.setOnMousePressed(e-> 

{

iv3.setEffect(dropShadow);

iv.setEffect(null);

iv2.setEffect(null);

});


iv.setX(160);

iv.setY(100);

iv2.setX(130);

iv2.setY(300);

iv3.setX(180);

iv3.setY(450);


btn.setLayoutX(400);

btn.setLayoutY(650);

btn.setScaleY(2);

btn.setScaleX(2);

btn.setStyle("-fx-background-color:pink;-fx-text-fill: white");

btn.setEffect(dropShadow2);


btn.setOnMousePressed(e-> 

{

btn.setEffect(null);

});


btn.setOnMouseReleased(e-> 

{

btn.setEffect(dropShadow2);

});


iv.setOnMouseClicked(e ->

{

pic = 1;

sendIv = iv;

});


iv2.setOnMouseClicked(e ->

{

pic =2;

sendIv = iv2;

});


iv3.setOnMouseClicked(e ->

{

pic = 3;

sendIv = iv3;

});


pane.setBackground(new Background(background));

pane.getChildren().addAll(iv,iv2,iv3,btn,txt);


return scene;

}


}
