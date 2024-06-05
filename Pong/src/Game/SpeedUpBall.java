package Game;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball {

 //instance variables
	 private int xSpeed;
     private int ySpeed;
     private int tempxSpeed;
     private int tempySpeed;

    public SpeedUpBall() {
        super(200,200);
        xSpeed = 3;
        ySpeed = 1;
        tempxSpeed = xSpeed;
        tempySpeed = ySpeed;
 }
 public SpeedUpBall(int x, int y) {
     super(x,y);
     xSpeed = 3;
     ySpeed = 1;
     tempxSpeed = xSpeed;
     tempySpeed = ySpeed;
 }
 public SpeedUpBall(int x, int y, int w, int h) {
     super(x,y,w,h);
     xSpeed = 3;
     ySpeed = 1;
     tempxSpeed = xSpeed;
     tempySpeed = ySpeed;
 }
 public SpeedUpBall(int x, int y, int w, int h, Color col) {
     super(x,y,w,h,col);
     xSpeed = 3;
     ySpeed = 1;
     tempxSpeed = xSpeed;
     tempySpeed = ySpeed;
 }
 public SpeedUpBall(int x, int y, int w, int h, Color col, int xSpd, int ySpd) {
     super(x,y,w,h,col);
     xSpeed = xSpd;
     ySpeed = ySpd;
     tempxSpeed = xSpeed;
     tempySpeed = ySpeed;
 }
 @Override
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
 
@Override
 public void setXSpeed(int xSpd) { xSpeed = xSpd; }
@Override
 public void setYSpeed(int ySpd) { ySpeed = ySpd; }
@Override
 public int getXSpeed() { return xSpeed; }
@Override
 public int getYSpeed() { return ySpeed; }
 
 public void speedUp() {
	 if(xSpeed>0) {
		 xSpeed = xSpeed+1;
	 } else {
		 xSpeed = xSpeed-1;
	 }
	 if(ySpeed>0) {
		 ySpeed = ySpeed+1;x
	 } else {
		 ySpeed = ySpeed-1;
	 }
 };
 
 public void resetSpeed() {
	 xSpeed = tempxSpeed;
	 ySpeed = tempySpeed;
 }
 
 public void resetSpeedLeft() {
	 xSpeed = -tempxSpeed;
	 ySpeed = tempySpeed;
 }

 
}

