package Game;

//(c) A+ Computer Science

//www.apluscompsci.com

//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block {

     private int xSpeed;
     private int ySpeed;

     public Ball() {
            super(200,200);
            xSpeed = 3;
            ySpeed = 1;
     }
     public Ball(int x, int y) {
         super(x,y);
         xSpeed = 3;
         ySpeed = 1;
     }
     public Ball(int x, int y, int w, int h) {
         super(x,y,w,h);
         xSpeed = 3;
         ySpeed = 1;
     }
     public Ball(int x, int y, int w, int h, Color col) {
         super(x,y,w,h,col);
         xSpeed = 3;
         ySpeed = 1;
     }
     public Ball(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
         super(x,y,w,h,col);
         xSpeed = xSpd;
         ySpeed = ySpd;
     }

    
 //add the set methods 
	   public void setXSpeed(int xSpd) { xSpeed = xSpd; }
	   public void setYSpeed(int ySpd) { ySpeed = ySpd; }

	 public void moveAndDraw(Graphics window) {
	
	     //draw a white ball at old ball location
		 
		 //CHECK THIS !!!
		//draw(window,Color.WHITE);
		 
		Ball w = new Ball(getX(), getY(), getWidth(), getHeight(), Color.WHITE);
		w.draw(window);
		
		//set new x and y
	    setX(getX()+xSpeed);
	    setY(getY()+ySpeed);
	    
	    //draw the ball at its new location
	    draw(window);
	
	 }

     public boolean equals(Object obj) {
    	 if(this==obj) {
    		 return true;
    	 }
            return false;
     }  

 //add the get methods
	   public int getXSpeed() { return xSpeed; }
	   public int getYSpeed() { return ySpeed; }
	   
 //add a toString() method
	   @Override
	   public String toString(){
 		   return getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getXSpeed() + " " + getYSpeed(); 
 	   }

}