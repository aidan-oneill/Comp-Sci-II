/**
*Aidan O'Neill
*Assignment 4 Milestone 2
*October 23rd
*The goal of this program is to create a ball that bounces around the drawing panel interacting with the sides.
**/
import java.awt.*;
import java.util.*;
/**
*This creates a ball that bounces around the drawing panel interacting with the sides.  
**/
public class BallNewScanner
{
/**
*This sets a frame rate for the entire program.  
**/
   public static final int FRAMERATE = 80;
/**
*This sets a ballsize.
**/
   public static final int BALLSIZE = 20;
/**
*This tells the program how many iterations to do of the ball moving.  
**/
   public static final int TIMESTORUN = 10000;
/**
*This creates a scanner, then calls a method that prompts the user for input, then calls createCanvasAndBall to create the canvas and the ball.  
**/
   public static void main(String[ ] args)
   {
      Scanner console = new Scanner(System.in);
      
      System.out.println("This program will simulate a ball bouncing in a window");
      int width = getNextInt("How wide would you like the panel (in pixels)?", console);
      int height = getNextInt("How tall would you like the panel (in pixels)?", console);
      int xPosition = getNextInt("What is the initial X position of the ball?", console);
      int yPosition = getNextInt("What is the inital Y position of the ball?", console);
      int xVelocity = getNextInt("What is the initial X velocity of the ball?",console);
      int yVelocity = getNextInt("What is the initial Y velocity of the ball?",console);
      
      createCanvasAndBall(width, height, xPosition, yPosition, xVelocity, yVelocity);
   }
   /**
   *This prints out the prompt for the user, then returns the next value that the user inputs.  
   **/
   public static int getNextInt(String prompt, Scanner console)
   {
      System.out.println(prompt);
      return console.nextInt();
   }
/**
*This creates the drawing canvas and then the ball.  
**/
   public static void createCanvasAndBall(int width, int height, int xPosition, int yPosition, int xVelocity, int yVelocity)
   {
      DrawingPanel canvas = new DrawingPanel(width,height);
      Graphics g = canvas.getGraphics();
      canvas.setBackground(Color.MAGENTA);
      for (int counterIterations=0; counterIterations<=TIMESTORUN; counterIterations++)
      {
         g.setColor(Color.GREEN);
         g.fillOval(xPosition, yPosition, BALLSIZE, BALLSIZE);
         g.setColor(Color.MAGENTA);
         g.fillOval(xPosition-1, yPosition-1, BALLSIZE+2, BALLSIZE+2);
         xPosition = xPosition+xVelocity;
         yPosition = yPosition+yVelocity;
         g.setColor(Color.GREEN);
         g.fillOval(xPosition, yPosition, BALLSIZE, BALLSIZE);
         canvas.sleep(1000/FRAMERATE);
         if (0>=xPosition||xPosition>=width)
         {
            xVelocity=-xVelocity;
         }
         if (0>=yPosition||yPosition>=height)
         {
            yVelocity=-yVelocity;
         }
      }
   }
}