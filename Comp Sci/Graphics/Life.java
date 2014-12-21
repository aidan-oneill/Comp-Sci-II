//Assignment 7 Milestone 2
//Aidan O'Neill
//Game of Life
//This will allow a user to read a file and have the program play Conway's Game of Life.
//12/6/14
//Version 1.0

import java.io.*;
import java.util.*;
import java.awt.*;

/**
*This reads a file and then plays Conway's Game of Life.  
**/
public class Life
{
   /**
   *This will be the size of the pixels in the drawing panel throughout the program.  
   **/
   public static final int PIXELSIZE = 5;
   
/**
*This reads a file and then plays Conway's Game of Life.  
**/   
   public static void main(String args[]) throws FileNotFoundException
   {
      Scanner console = new Scanner(System.in); 
      firstLine();
      Scanner inputScanner = inputFile(console, "Input file name? ");
      
      PrintStream outputStream = createFile(console, "Output file name? ");
      
      int numFrames = checkIsInt(console, "Number of frames to run the simulation: ");
      int stepTime = checkIsInt(console, "Time between steps (ms): ");
           
      boolean[][] worldArray;
      worldArray = readFile(inputScanner);
      
      boolean[][] newWorldArray = worldArray;
      
      doSimulation(numFrames, newWorldArray, stepTime, outputStream);      
   }
/**
*This prints out the introductory statement.
**/
   public static void firstLine()
   {
      System.out.println("This program runs Conway's Game of Life");
   }
   /**
   *This prompts the user for the input file and makes sure that it can actually exist using a try-catch statement.
   *@param console allows statements to be printed to the console. 
   *@param prompt passes in the prompt that will tell the user what to type in
   *@return returns a scanner on the file if it exists
   **/
   public static Scanner inputFile(Scanner console, String prompt)
   {
      System.out.print(prompt);
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
   /**
   *This makes sure that the output file is in the .txt format.  
   *@param console passes in the console to talk to user
   *@return returns the String that the user typed in for the output file
   **/
   /**
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
   **/
   /**
   *This checks to make sure the user input is an integer.  
   *@param console passes in the console to talk to the user
   *@param prompt passes in the prompt so the user knows what they should type in.  
   *@return returns the integer the user typed in.  
   **/
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
               System.out.println("Input is not valid, you need to enter a number.");
            }
         }
         userInt = userValue;
      }
      return userInt;
   }
   /**
   *This reads the file and converts it into a boolean 2d array.
   *@param inputScanner passes in the scanner on the input file.  
   *@return returns the boolean 2d array
   **/
   public static boolean[][] readFile(Scanner inputScanner)
   {
      boolean[][] worldArray = null;
      try
      {
         int row = inputScanner.nextInt();
         int column = inputScanner.nextInt();
         worldArray = new boolean[row][column];
         inputScanner.nextLine();
         for (int ii=0; ii<row; ii++)
         {
            String line = inputScanner.nextLine();
            for(int jj = 0; jj<column; jj++)
            {
               if(line.charAt(jj) == 'x')
               {
                  worldArray[ii][jj] = true;
               }
               if(line.charAt(jj) == '.')
               {
                  worldArray[ii][jj] = false;
               }
            }
         }
      }
      catch(Exception e)
      {
         System.out.println("Error found in the input file. Halting simulation.");
         System.exit(0);
      }
      return worldArray;
   }
   /**
   *This creates a drawing of the state of the world based on the array that it gets passed in.  
   *@param newWorldArray passes in the current state of the world
   *@param stepTime passes in the time the computer screen should sleep for
   *@param canvas the DrawingPanel for the system.
   **/
   public static void doDrawing(boolean[][] newWorldArray, int stepTime, DrawingPanel canvas)
   {
      int row = newWorldArray.length;
      int column = newWorldArray[0].length;
      
      Graphics g = canvas.getGraphics();
      
      g.setColor(Color.WHITE);
      g.fillRect(0,0,PIXELSIZE*column,PIXELSIZE*row);
      g.setColor(Color.BLACK);
      for(int ii = 0; ii<row; ii++)
      {
         for(int jj = 0; jj<column; jj++)
         {
            if(newWorldArray[ii][jj]==true)
            {
               g.fillRect(PIXELSIZE*jj, PIXELSIZE*ii, PIXELSIZE, PIXELSIZE);
            }
         }
      }
      canvas.sleep(stepTime);
   }
   /**
   *This method takes the old moment of life and based on the rules - whether a live cell can become dead or a dead cell
   *become live creates a new array that tells us whether or not each cell is alive or dead.  
   *@param newWorldArray passes in the old life - which cells are alive or dead
   *@return returns new array after obeying the game of life rules  
   **/
   public static boolean[][] getNewArray(boolean[][] newWorldArray)
   {
      int row = newWorldArray.length;
      int column = newWorldArray[0].length;
      boolean[][] finalWorldArray = new boolean[row][column];
      for(int ii = 0; ii<row; ii++)
      {
         for(int jj = 0; jj<column; jj++)
         {
            int sum = 0;
            if(ii==0)
            {
               if(newWorldArray[ii+1][jj])
                  sum++;
               if(!(jj==(column-1)))
               {
                  if(newWorldArray[ii][jj+1])
                     sum++;
                  if(newWorldArray[ii+1][jj+1])
                     sum++;
               }
               if(!(jj==0))
               {
                  if(newWorldArray[ii][jj-1])
                     sum++;
                  if(newWorldArray[ii+1][jj-1])
                     sum++;
               }
            }
            if(ii==(row-1))
            {
               if(newWorldArray[ii-1][jj])
                  sum++;            
               if(!(jj==column-1))
               {
                  if(newWorldArray[ii][jj+1])
                     sum++;
                  if(newWorldArray[ii-1][jj+1])
                     sum++;
               }
               if(!(jj==0))
               {
                  if(newWorldArray[ii][jj-1])
                     sum++;
                  if(newWorldArray[ii-1][jj-1])
                     sum++;
               }
            }
            if(!(ii==0)&&!(ii==row-1))
            {
               if(newWorldArray[ii+1][jj])
                  sum++;
               if(newWorldArray[ii-1][jj])
                  sum++;
                  
               if(!(jj==column-1))
               {
                  if(newWorldArray[ii-1][jj+1])
                     sum++;
                  if(newWorldArray[ii+1][jj+1])
                     sum++;
                  if(newWorldArray[ii][jj+1])
                     sum++;
               }
               if(!(jj==0))
               {
                  if(newWorldArray[ii-1][jj-1])
                     sum++;
                  if(newWorldArray[ii+1][jj-1])
                     sum++;
                  if(newWorldArray[ii][jj-1])
                     sum++;
               }
            }
            if(!newWorldArray[ii][jj])
            {
               if(sum==3)
                  finalWorldArray[ii][jj] = true;
               else
                  finalWorldArray[ii][jj] = false;
            }
            if(newWorldArray[ii][jj])
            {
               if(sum==2||sum==3)
                  finalWorldArray[ii][jj] = true;
               else
                  finalWorldArray[ii][jj] = false;
            }
         }
      }
      return finalWorldArray;
   }
   /**
   *This writes the final state of the world out to a file. 
   *@param outputFile the String for the file that it is supposed to write the file to
   *@param newWorldArray the final state of the world 
   **/
   public static void writeFile (boolean[][] newWorldArray, PrintStream fileStream)
   {
      int row = newWorldArray.length;
      int column = newWorldArray[0].length;
      //fileStream.println(row + "  " + column);
      for(int ii = 0; ii<row; ii++)
      {
         String line = "";
         for(int jj = 0; jj<column; jj++)
         { 
              if(!newWorldArray[ii][jj])
                 line+='.';
              else
                 line+='x';
         }
         fileStream.println(line);
      }
   }
   /**
   *This method creates the output file based on user input and a try catch statement on the printstream.
   *@param console passes in the console to talk to the user
   *@param prompt passes in the prompt so the user knows what they should type in
   *@return PrintStream returns a printstream on the outputfile
   **/
   public static PrintStream createFile(Scanner console, String prompt)
   {
      File outputFinal = null;
      PrintStream fileStream = null;
      while((fileStream==null))
      {
         System.out.print(prompt);
         String outputFile = console.nextLine();
         outputFinal = new File(outputFile);
         try
         {
            fileStream = new PrintStream(outputFinal);
         }
         catch(FileNotFoundException e)
         {
         }
      }
      return fileStream;
   }
   /**
   *This method creates a drawing panel
   *@param newWorldArray this is the first state of the world
   *@return DrawingPanel returns a DrawingPanel based on the pixelsize (a class constant) and the size of newWorldArray
   **/
   public static DrawingPanel getDrawPanel(boolean[][] newWorldArray)
   {
      DrawingPanel canvas = new DrawingPanel(PIXELSIZE*(newWorldArray[0].length),PIXELSIZE*(newWorldArray.length));
      return canvas;
   }
   /**
   *This method does the simulation by calling the methods that create the new array and the method that does a drawing
   *based on the array.
   *@param numFrames passes in the number of times the program should run the simulation
   *@param newWorldArray passes in the array of the world
   *@param stepTime passes in the number of milliseconds the panel should sleep for
   *@param outputStream passes in a printstream on the output file
   **/
   public static void doSimulation(int numFrames, boolean[][] newWorldArray, int stepTime, PrintStream outputStream)
   {
      DrawingPanel canvas = getDrawPanel(newWorldArray);
      doDrawing(newWorldArray, stepTime, canvas);
      
      if(numFrames==0)
      {
         while(numFrames==0)
         {
            newWorldArray = getNewArray(newWorldArray);          
            doDrawing(newWorldArray, stepTime, canvas);
         }
      }
      else
      {
         for(int ii = 1; ii<numFrames; ii++)
         {
            newWorldArray = getNewArray(newWorldArray);
            doDrawing(newWorldArray, stepTime, canvas);
         }
      }
      writeFile(newWorldArray, outputStream);
      System.out.println("Simulation successful!");
   }

}
  