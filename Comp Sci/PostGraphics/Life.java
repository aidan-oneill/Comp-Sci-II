//Assignment 7 Milestone 2
//Aidan O'Neill
//Game of Life
//This will allow a user to read a file and have the program play Conway's Game of Life.
//12/6/14
//Version 1.0

import java.io.*;
import java.util.*;

/**
*This reads a file and then plays Conway's Game of Life.  
**/
public class Life
{
   public static void main(String args[]) throws FileNotFoundException
   {
      Scanner console = new Scanner(System.in); 
      firstLine();
      Scanner inputScanner = inputFile(console);
      String outputFile = outputFile(console);
      int numFrames = checkIsInt(console, "Number of frames to run the simulation: ");
      int stepTime = checkIsInt(console, "Time between steps (ms): ");
      File finalState = new File(outputFile);
      getSize(inputScanner);
   }

   public static void firstLine()
   {
      System.out.println("This program runs Conway's Game of Life");
   }
   public static Scanner inputFile(Scanner console)
   {
      System.out.print("Input file name? ");
      Scanner fileScan = null;
      while (fileScan == null)
      {
         String userInput = console.nextLine();
         File userFile = new File(userInput);
         try 
         {
            fileScan = new Scanner(userFile);
         }
         catch (FileNotFoundException e)
         {
            System.out.print("File not found. Try again: ");
         }
      }
      return fileScan;
   }
   public static String outputFile(Scanner console)
   {
      boolean noOutput = false;
      String userInput = "";
      while (!noOutput)
      {
         String lastFour = "";
         userInput = "";
         System.out.print("Ouput file name? ");
         userInput = console.nextLine();
         int length = userInput.length();
         if (length>3)
         {
            char a = userInput.charAt(length-4);
            char b = userInput.charAt(length-3);
            char c = userInput.charAt(length-2);
            char d = userInput.charAt(length-1);
            lastFour = lastFour + a + b + c + d;
            if (lastFour.equals(".txt"))
            {
               noOutput = true;
            }
         }
      }
      return userInput;
   }
   public static int checkIsInt(Scanner console, String prompt)
   {
      int userInt = -1;
      while (userInt<0)
      {
         Integer userValue = null;
         while (userValue == null)
         {
            System.out.print(prompt);
            try
            {
               userValue = new Integer(console.next());
            }
            catch (Exception e)
            {
            }
         }
         userInt = userValue;
      }
      return userInt;
   }
   public static Point getSize(Scanner inputScanner)
   {
      
   }
}
   