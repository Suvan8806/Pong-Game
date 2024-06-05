package Game;

//(c) A+ Computer Science

//www.apluscompsci.com

//Name -


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.Scanner;

public class Pong extends Canvas implements KeyListener, Runnable {

	private SpeedUpBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Scanner kb;
	boolean c = true;

	public Pong() {
		kb = new Scanner(System.in);
		ball = new SpeedUpBall(20,20,10,10,Color.RED,2,1);
        //instantiate a left Paddle
	     leftPaddle = new Paddle(50,150,20,100,Color.BLACK,7);
        //instantiate a right Paddle
	     rightPaddle = new Paddle(700,150,20,100,Color.BLACK,7);
		
		//set up all variables related to the game
		keys = new boolean[4];
		setBackground(Color.WHITE);
		setVisible(true);
		new Thread(this).start();
		addKeyListener(this); //starts the key thread to log key strokes
	}

	public void update(Graphics window){
		paint(window);
	}

	public void paint(Graphics window) {

                              //set up the double buffering to make the game animation nice and smooth
                              Graphics2D twoDGraph = (Graphics2D)window;
                              //take a snap shop of the current screen and same it as an image

                              //that is the exact same width and height as the current screen

                              if(back==null) {
                            	  back = (BufferedImage)(createImage(getWidth(),getHeight()));
                              }

                              //create a graphics reference to the back ground image

                              //we will draw all changes on the background image

                              Graphics graphToBack = back.createGraphics();
                              ball.moveAndDraw(graphToBack);
                              leftPaddle.draw(graphToBack);
                              rightPaddle.draw(graphToBack);

                              //see if ball hits left wall
                              if(ball.getX()<=0) {
                            	  Ball w = new Ball(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), Color.WHITE);
                          		  w.draw(graphToBack);
                          		  ball.setX(400);
                          		  ball.setY(300);
                                  rightPaddle.addScore();
                                  ball.resetSpeed();
                                  gameplay();
                                  
                              }
                            //see if ball hits right wall
                              if(ball.getX()>=800-ball.getWidth()) {
                                  ball.setX(400);
                                  ball.setY(300);
                                  Ball w = new Ball(800-ball.getWidth(), ball.getY(), ball.getWidth(), ball.getHeight(), Color.WHITE);
                          		  w.draw(graphToBack);
                                  leftPaddle.addScore();
                                  ball.resetSpeedLeft();
                                  gameplay();
                              }
                            //see if the ball hits the top or bottom wall
                            if(!(ball.getY()>=10 && ball.getY()<=450)) {
                            	ball.setYSpeed(-ball.getYSpeed());
                            }
                            
                            
                              //see if the ball hits the left paddle 
                            if( (ball.getX() <=  leftPaddle.getX() + leftPaddle.getWidth() + abs(ball.getXSpeed()) &&
                            (ball.getY() >= leftPaddle.getY() &&
                            ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight() ||
                            ball.getY() + ball.getHeight() >= leftPaddle.getY() &&
                            ball.getY() + ball.getHeight() < leftPaddle.getY() + leftPaddle.getHeight() )))   { 
                      if(ball.getX()   <=   leftPaddle.getX() + (leftPaddle.getWidth()) - (abs(ball.getXSpeed())) ) {
                    	  ball.setYSpeed(-ball.getYSpeed());
                    	  if( ball.getY() + (ball.getHeight()/2) < leftPaddle.getY() + (leftPaddle.getHeight()/2)  ) { //above
                    		  ball.setYSpeed(-abs(ball.getYSpeed()));
                    		  
                    	  } else if ( ball.getY() + (ball.getHeight()/2) > leftPaddle.getY() + (leftPaddle.getHeight()/2)  ){ //below
                    		  ball.setYSpeed(abs(ball.getYSpeed()));
                    	  }
                      }	  
                      else {
                    	  ball.setXSpeed(-ball.getXSpeed());
                    	  if( ball.getY() + (ball.getHeight()/2) < leftPaddle.getY() + (leftPaddle.getHeight()/2)  ) {
                    		  ball.setYSpeed(-abs(ball.getYSpeed()));
                    	  } else if ( ball.getY() + (ball.getHeight()/2) > leftPaddle.getY() + (leftPaddle.getHeight()/2)  ){
                    		  ball.setYSpeed(abs(ball.getYSpeed()));
                    		  
                    	  }
                      } 
                      ball.speedUp();
                   }
                            
                              //see if the ball hits the right paddle rightPaddle
                            
                            if( (ball.getX() + ball.getWidth() >=  rightPaddle.getX()  &&
                                    (ball.getY() >= rightPaddle.getY() &&
                                    ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight() ||
                                    ball.getY() + ball.getHeight() >= rightPaddle.getY() &&
                                    ball.getY() + ball.getHeight() < rightPaddle.getY() + rightPaddle.getHeight() )))   { 
                              if(ball.getX() + ball.getWidth()   >=   rightPaddle.getX() + (abs(ball.getXSpeed()) )) {
                            	  ball.setXSpeed(-ball.getXSpeed());
                            	  if( ball.getY() + (ball.getHeight()/2) < rightPaddle.getY() + (rightPaddle.getHeight()/2)  ) { //above
                            		  ball.setYSpeed(-abs(ball.getYSpeed()));
                            	  } else if ( ball.getY() + (ball.getHeight()/2) > rightPaddle.getY() + (rightPaddle.getHeight()/2)  ){ //below
                            		  ball.setYSpeed(abs(ball.getYSpeed()));
                            	  }
                              }	  
                              else {
                            	  ball.setYSpeed(-ball.getYSpeed()); 
                            	  if( ball.getY() + (ball.getHeight()/2) < rightPaddle.getY() + (rightPaddle.getHeight()/2)  ) { //above
                            		  ball.setYSpeed(-abs(ball.getYSpeed()));
                            		  
                            	  } else if ( ball.getY() + (ball.getHeight()/2) > rightPaddle.getY() + (rightPaddle.getHeight()/2)  ){ //below
                            		  ball.setYSpeed(abs(ball.getYSpeed()));
                            	  }
                              } 
                              ball.speedUp();
                           }
                            

                              //see if the paddles need to be moved
                            if(keys[0] == true) {//w
                                //move left paddle up and draw it on the window
                                leftPaddle.moveUpAndDraw(graphToBack);
                          } 
                          if(keys[1] == true) {//Z
                                //move left paddle down and draw it on the window
                         	   leftPaddle.moveDownAndDraw(graphToBack);
                          }
                          if(keys[2] == true) {//I
                         	   rightPaddle.moveUpAndDraw(graphToBack);
                          }
                          if(keys[3] == true) {//M
                         	   rightPaddle.moveDownAndDraw(graphToBack);
                          }
                              twoDGraph.drawImage(back, null, 0, 0);

              }

              private int abs(int b) {
            	  if (b<0) {
            		  return -b;
            	  }
            	  return b;
              }
              
              private void gameplay() {
            	  String x = "";
            	  boolean b = false;
            	  System.out.println("Left Player : " + leftPaddle.getScore());
                  System.out.println("Right Player : " + rightPaddle.getScore() + "\n\n");
                  if(leftPaddle.getScore() >= 2) {
                	  System.out.println("LEFT PLAYER WINS!");
                	  b = true;
                  } else if (rightPaddle.getScore() >= 2) {
                	  System.out.println("RIGHT PLAYER WINS!");
                	  b = true;
                  }
                  if(b) {
                	  ball.setXSpeed(0);
                      ball.setYSpeed(0);
                      ball.setX(400);
              		  ball.setY(300);
                      leftPaddle.resetScore();
                      rightPaddle.resetScore();
                	  while(c) {
                		  System.out.println("Would you like to play again? (Y/N) :");
                          x = kb.next();
                          if(x.equals("Y")) {
                        	  ball.resetSpeed();
                        	  c = false;
                        	  b = false;
                          } else if(x.equals("N")){
                        	  System.out.println("Thank you for playing!");
                        	  c = false;
                          } else {
                        	  System.out.println("Please make sure you type either Y = for yes or N = for No");
                          }  
                	  }
                	  
                  }
                  c = true;
              }

			public void keyPressed(KeyEvent e) {
                              switch(toUpperCase(e.getKeyChar())) {
                                              case 'W' : keys[0]=true; break;
                                              case 'Z' : keys[1]=true; break;
                                              case 'I' : keys[2]=true; break;
                                              case 'M' : keys[3]=true; break;
                              }
              }

              public void keyReleased(KeyEvent e) {
                              switch(toUpperCase(e.getKeyChar())) {
                                              case 'W' : keys[0]=false; break;
                                              case 'Z' : keys[1]=false; break;
                                              case 'I' : keys[2]=false; break;
                                              case 'M' : keys[3]=false; break;
                              }
              }

              public void keyTyped(KeyEvent e){}

             

 public void run() {
              try  {
                              while(true) {
                                 Thread.currentThread().sleep(8);
          repaint();
       }
    }catch(Exception e)
    {
    }
              }             

}
