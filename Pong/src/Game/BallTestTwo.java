package Game;

//(c) A+ Computer Science

//www.apluscompsci.com

//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import static java.lang.System.out;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable {

     private Ball ball;
     
     public BallTestTwo() {

            setBackground(Color.WHITE);
            setVisible(true);

            //instantiate a new Ball
            ball = new Ball(100,100,50,50,Color.RED);
            
            //test the Ball thoroughly
            
            //test all constructors

            new Thread(this).start();

     }

     public void update(Graphics window) {

            paint(window);

     }
     
     public void paint(Graphics window) {
    	 	
            ball.moveAndDraw(window);
            
            if(!(ball.getX()>=10 && ball.getX()<=550)) {

                   ball.setXSpeed(ball.getYSpeed() * -1);

            }
            
            if(!(ball.getY()>=10 && ball.getY()<=450)) {

                   ball.setYSpeed(ball.getYSpeed() * -1);

            }
            

     }

	 public void run() {
		 
	     try {
	
	    	 while(true) {
	    		 
	    		 Thread.currentThread().sleep(19);
	    		 repaint();
	
	    	 }
	
	    } catch(Exception e) {
	
	    }
	
	 }     

}