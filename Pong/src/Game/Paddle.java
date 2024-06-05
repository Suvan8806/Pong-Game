package Game;

//(c) A+ Computer Science

//www.apluscompsci.com

//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {

 //instance variables
 private int speed;
 private int score;

 public Paddle() {
	 super(10,10,10,10);
	 speed =5;
	 score = 0;
 }
public Paddle(int x, int y) {
	super(x,y,10,10);
  	speed = 5;
  	score = 0;
}
public Paddle(int x, int y, int spd) {
	super(x,y,10,10);
	speed = spd;
	score = 0;
}
public Paddle(int x, int y, int w, int h) {
	  super(x,y,w,h);
	  speed = 5;
	  score = 0;
	}
public Paddle(int x, int y, int w, int h, int spd) {
	  super(x,y,w,h);
	  speed = spd;
	  score = 0;
	}
public Paddle(int x, int y, int w, int h, Color col) {
  super(x,y,w,h,col);
  speed = 5;
  score = 0;
}
public Paddle(int x, int y, int w, int h, Color col, int spd) {
  super(x,y,w,h,col);
  speed = spd;
  score = 0;
}

 //add the other Paddle constructors

 public void moveUpAndDraw(Graphics window) {
	 
		//draw(window,Color.WHITE);
	    if(getY()<=10) {
	    	//setY(getY());
	    } else { 
	    	Paddle w = new Paddle(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
			w.draw(window);
	    	setY(getY()-speed);
	    }
	    draw(window);
 }
 
 public void moveDownAndDraw(Graphics window) {
	 	
	 	//draw(window,Color.WHITE);
		if(getY()>=390) {
	    	//setY(getY());
	    } else { 
	    	Paddle w = new Paddle(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
			w.draw(window);
	    	setY(getY()+speed);
	    }
	    draw(window);
 }

 //add get methods
 public int getSpeed() { return speed; }
 public void setSpeed(int spd) { speed = spd; }
 public int getScore() { return score; }
 public void addScore() { score = score + 1; }
 public void resetScore() {score = 0;}
 
 //add a toString() method
 @Override
 public String toString(){
	   return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed(); 
  }
}