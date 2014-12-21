//Assignment 2 Milestone 2
//This assignment is to create an ASCII art piece of a rocket using for loops that can resize itself based on a class variable.  
//10/2/14
//Rocket
//Version 1.0

import java.util.*;

public class Rocket
{
   /**
   *This defines the variable SIZE for the entire code - change this and you change the size of the output rocket.  
   *This method calls all of the component pieces of the rocket. 
   */
   public static int SIZE = 5;
   public static void main (String[ ] args)
   {
   Scanner console = new Scanner(System.in);
   System.out.println("This program will create a rocket.");
   System.out.println("How big do you want your rocket to be?  Please specify an integer between 1 and 100.");
   SIZE=console.nextInt();
   
      coneFlame();
      middleLine();
      upperPart();
      lowerPart();
      middleLine();
      lowerPart();
      upperPart();
      middleLine();
      coneFlame();
   }
/**
*This prints out the part that is both the beginning and the end - the cone at the top of the rocket and the flame. 
*This says that starting at line 1 and going up to line 2*SIZE-1, print out as many spaces as there are in 2*SIZE-lines, 
*then print out as many forward slashes as there are lines, then print out two **, and then pritn out as many backslashes
*as there are lines
*/
   public static void coneFlame()
 
   {

      for (int lines=1; lines<=2*SIZE-1; lines++)
      {
         for (int spaces=2*SIZE-lines; spaces>=1; spaces--)
            System.out.print(" ");
         for (int times=1; times<=lines; times++)
            System.out.print("/");
               
            System.out.print("**");
            for (int times=1; times<=lines; times++)
            System.out.print("\\");
         
            System.out.println();
      }
   }
   /**
   *This prints out the line that is found in the middle of the code.  
   *It prints out a "+", then as many "=*" pairs as there are in 2*SIZE, and then finishes off with another"+".  
   */
   public static void middleLine()
   {
      System.out.print("+");
      {
         for(int times=1; times<=2*SIZE; times++)
            System.out.print("=*");
      }
      System.out.print("+");
      System.out.println();
   }  
   /**
   *This prints out the uppermost part of the main body (the topmost and the lowermost part of the main body).  
   *This prints a vertical line, then, for lines starting at 1 and going up to SIZE, it prints out a "." as many SIZE-line times,
   *then prints out as many /\ pairs as there are in the integer value for the line, then as many periods as there are in 2*SIZE-2*line,
   *then prints out the /\ pairs again, then repeats the first set of dots and the beginning vertical line.  
   */
   public static void upperPart()
   {
      for(int line=1; line<=SIZE; line++)
      {
      System.out.print("|");
         for(int dot=1; dot<=SIZE-line; dot++)
         System.out.print(".");
         
         for(int slash=1; slash<=line; slash++)
         System.out.print("/\\");
         
         for(int dots=1; dots<=2*SIZE-2*line; dots++)
         System.out.print(".");
      
         for(int slashes=1; slashes<=line; slashes++)
         System.out.print("/\\");
         
         for(int dot=1; dot<=SIZE-line; dot++)
         System.out.print(".");
         
         System.out.print("|");
         System.out.println();
      }
   }
   /**
   *This prints the lower part of the main body, using exactly the same method as the upperPart but in different orders.  
   */
   public static void lowerPart()
   {
      for(int line=1; line<=SIZE; line++)
      {
      System.out.print("|");
         for(int dot=line-1; dot>=1; dot--)
         System.out.print(".");
         
         for(int slash=SIZE-line; slash>=0; slash--)
         System.out.print("\\/");
         
         for(int dots=2*line-2; dots>=1; dots--)
         System.out.print(".");
         
         for(int slashes=SIZE-line; slashes>=0; slashes--)
         System.out.print("\\/");
         
         for(int dot=line-1; dot>=1; dot--)
         System.out.print(".");
         
         System.out.print("|");
         System.out.println();
      }
   }
}