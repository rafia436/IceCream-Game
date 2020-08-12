package game;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;

import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.input.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.Thread;
import javafx.animation.KeyFrame;


public class Ice_Cream 

{
	static boolean stop1 = false;
	static boolean end1 = false;
	static boolean b = false;
    static 	Image image;//=new Image("resources/1.png");                
	static ImageView img = new ImageView(image);
	static int a=0;
	static int scores=0;
	static double Move=4.0;
	static Pane pane=new Pane();
	static int RandScoop = (int) (1+ Math.random()*11);
	static int startingX = (int) (20+Math.random()*450);
	static int counter = 0;
	static double h = 557.5600000000007;
	static double MainScore=0;
	static ImageView cat=new ImageView();
	static Timeline t;
	static Button btPlayAgain=new Button("Play Again");
	
	public Ice_Cream() 
	{
	
	}

	public static Scene setNewScene() 

	{

		Scene scene=new Scene(pane,500,700);
		
		Image BGImage=new Image("resources/BG.jpg",500,700,false,true);
		
		//Play play = new Play();
		
		//int scoops= (int) (1+ Math.random() * 12);
		
		int catNum;
		DropShadow dropShadow = new DropShadow();
		dropShadow.setRadius(5.0);
		dropShadow.setOffsetX(3.0);
		dropShadow.setOffsetY(3.0);
		dropShadow.setColor(Color.color(0.6,0.08, 0.8));
		
		DropShadow dropShadow2= new DropShadow();
		dropShadow2.setRadius(10.0);
		dropShadow2.setOffsetX(5.0);
		dropShadow2.setOffsetY(5.0);
		dropShadow2.setColor(Color.color(0.0,0.0, 0.0));
		
		
		BackgroundImage BG= new BackgroundImage(BGImage,BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
		
		Image score=new Image("resources/score.gif");
		ImageView ivScore= new ImageView(score);
		ImageView ivScore2=new ImageView(score);
		ImageView ivScore3=new ImageView(score);
		
		ivScore.setX(435);
		ivScore.setY(20);
		ivScore2.setX(380);
		ivScore2.setY(20);
		ivScore3.setX(325);
		ivScore3.setY(20);
		ivScore.setFitHeight(50);
		ivScore.setFitWidth(50);
		ivScore2.setFitHeight(50);
		ivScore2.setFitWidth(50);
		ivScore3.setFitHeight(50);
		ivScore3.setFitWidth(50);
		
		
		Image cone=new Image("resources/Cone.png");
		ImageView ivCone=new ImageView(cone);
		ivCone.setFitHeight(125);
		ivCone.setFitWidth(150);
		ivCone.setY(575);
		ivCone.setX(50);

		pane.setOnKeyPressed( e ->
		{
		if((e.getCode() == KeyCode.RIGHT) )
		{
				ivCone.setX(ivCone.getX()+10);
		    }
		
		    else if(ivCone.getX() >= 405 || ivCone.getX() <= -43 )
		    {
		    	ivCone.setX(ivCone.getX()+10);
		    }
		
			if((e.getCode() == KeyCode.LEFT))
		
			{
				ivCone.setX(ivCone.getX()-10);
		    }
		
		    else if(ivCone.getX() >= 405 || ivCone.getX() <= -43)
		    {
		    	ivCone.setX(ivCone.getX()-10);
		    } 
		});
		
		catNum = Play.pic;
		cat = Play.sendIv;
		if(catNum == 1)
		{
			cat.setFitHeight(80);
			cat.setFitWidth(80);
			cat.setX(370);
			cat.setY(80);
		}
		else if(catNum == 2)
		{
			cat.setFitHeight(105);
			cat.setFitWidth(130);
			cat.setX(360);
			cat.setY(70);
		}

		else if(catNum == 3)
		{
			cat.setFitHeight(110);
			cat.setFitWidth(110);
			cat.setX(380);
			cat.setY(60);
		}
		Image gameOver=new Image("resources/gameover.png");
		ImageView over=new ImageView(gameOver);
		
		Text text = new Text(5,45, "Score ="  +MainScore); 
		text.setFont(Font.font("FLAMENCO", FontWeight.BOLD, FontPosture.ITALIC, 20));
		text.setFill(Color.WHITE);
		text.setEffect(dropShadow);
		pane.getChildren().addAll(text);
		
	
		// the loop of the game
		 while( stop1 != true && end1 != true && counter < 3)
		{ 
			 EventHandler<ActionEvent> eventHandler  = e ->
	 		{
	 			Move = 4;
	 			moving_icecream();
		  		 if ( (img.getY() >= 557.5600000000007) && ((img.getX()<=(ivCone.getX()+100))&&(img.getX()>=(ivCone.getX()-100))) )
				{	
		  			img.setY(h);
		  			pane.getChildren().removeAll(img);
		  			show_icecream();
		  			MainScore++;
		  			text.setText("Score = " + MainScore);
		  		
		  			if(MainScore == 10.0) {  // if score reaches maximum score
					    t.stop();
					    pane.getChildren().removeAll(img);
					    pane.getChildren().remove(BG);
					    pane.getChildren().remove(ivCone);
					    pane.getChildren().removeAll(ivScore,ivScore2,ivScore3);
					    pane.getChildren().remove(cat);
					    pane.getChildren().remove(text);
					    Text txt= new Text("YOU MADE IT!");
					    txt.setLayoutY(30);
					    txt.setLayoutX(170);
					    txt.setEffect(dropShadow);
					    txt.setFont(Font.font(20));
					    txt.setFont(Font.font("FLAMENCO", FontWeight.BOLD, FontPosture.ITALIC, 20));
					    txt.setFill(Color.WHITE);
					    pane.getChildren().add(txt);
					    
					    if(catNum==1) {
					    Image cat= new Image("resources/win1.png");
					    ImageView iv= new ImageView(cat);
					    iv.setX(35);
					    iv.setY(180);
					    pane.getChildren().add(iv);
					    }

					    if(catNum==2) {
					    Image cat= new Image("resources/win2.png");
					    ImageView iv= new ImageView(cat);
					    iv.setScaleX(2);
					    iv.setScaleY(2);
					    iv.setX(100);
					    iv.setY(200);
					    pane.getChildren().add(iv);
					    }
					    if(catNum==3) {
					    Image cat= new Image("resources/win3.png");
					    ImageView iv= new ImageView(cat);
					    iv.setX(40);
					    iv.setY(130);
					    pane.getChildren().add(iv);
					    }
					    
		  			}
					    
				}
		  		
		  		if (img.getY() >= 700.0 ) // in case scoops dont go in the cone
		  		{
		  			counter = counter + 1 ;
		  			switch(counter)
		  			{
		  			case 1 : pane.getChildren().removeAll(ivScore3); break;
		  			case 2 : pane.getChildren().removeAll(ivScore2); break;
		  			case 3 : 
		  				 pane.getChildren().removeAll(img);
		  				pane.getChildren().removeAll(ivScore); 
		  				pane.getChildren().add(over);
		  				pane.getChildren().remove(ivCone);
		  				pane.getChildren().remove(text);
		  			    t.stop();
		  			   
		  				cat.setY(300);
		  				cat.setX(200);
		  				over.setX(50);
		  				break;
		  			}
		  			if ( counter == 3 )
		  				end1 = true;
		  			
		  			pane.getChildren().removeAll(img);
		  
		  			stop1 = true;
		  			
		  		}
		  		
		  		// adding another scope
		  		if(stop1 == true && counter <= 3)
		  		{	
		  			show_icecream();
		  			moving_icecream();
					stop1 = false;
		  		}
		  		else
		  		{
		  		   
		  			end1 = true;
		  		}
		  		
	 		};//end of the animation event handler
	 		
	 		t = new Timeline( new KeyFrame( Duration.millis(15), eventHandler));
			t.setCycleCount(Timeline.INDEFINITE);
			t.play();
			stop1 = true;
			
			
	} //end of the while loop  
		 
		 
	
			 
pane.getChildren().addAll(cat,ivScore,ivScore2,ivScore3,ivCone);
pane.setBackground(new Background(BG));
pane.requestFocus();

return scene;

}
	
	public static void show_icecream()
	{
		int RandScoop = (int) (1+ Math.random()*11);
    	int startingX = (int) (20+Math.random()*450);
    	img = new ImageView("resources/"+RandScoop+".png");	
    	img.setX(startingX);
    	pane.getChildren().add(img);
	}
	
	public static void moving_icecream()
	{
		Move = Move + 0.04;	
	    img.setY(img.getY() + Move);
	    img.setFitHeight(50);
	    img.setFitWidth(50);
	}
}




