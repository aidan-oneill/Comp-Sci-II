//Assignment 6 Milestone 2
//Aidan O'Neill
//MadLibs
//This will allow a user to open files, and play a game of madlibs by opening it from another file.  
//11/24/14
//Version 1.0

import java.io.*;
import java.util.*;

/**
*This plays the game of MadLibs with the user, giving options for viewing a MadLib, creating a MadLib, and exiting the program.
**/
public class MadLibs
{
/**
*This initializes a scanner used throughout the whole program to prompt the user for information.  Then it 
*calls the beginning statement. It then creates a madlib,views a madlib, or exits depending on the prompt 
*the user gives the computer.  It also throws the filenotfoundexception.  
**/
   public static void main(String args[]) throws FileNotFoundException
   {
      Scanner console = new Scanner(System.in); 
      introToMadLibs();
      boolean wantsToContinue = true;
      
      while (wantsToContinue)
      {
         int checker = whatDoesUserWant(console);
         
         if (checker == 1)
         {  
            Scanner fileName = checkUserInput(console);
            
            System.out.print("Output file name: ");
            
            File outputFile = new File(console.nextLine());
            
            String completedMadLib = doMadLib(fileName, console);
            
            PrintStream outputStream = printStream(outputFile);
            
            readFile(completedMadLib, outputStream);
         }
         if (checker == 2)
         {
            Scanner fileName = checkUserInput(console);
            
            while (fileName.hasNextLine())
            {
               String line = fileName.nextLine();
               System.out.println(line);
            }
         }
         if (checker ==3)
         {
            wantsToContinue = false;
         }
      }
   }

/**
*This prints out the opening statement.
**/
   public static void introToMadLibs()
   {
      System.out.println("Welcome to the game of Mad Libs.");
      System.out.println("I will ask you to provide various words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
/**
*This asks the user what they want to do.  It also makes sure that their response is a c,C, v, V, q or Q.  
*It takes the parameter Scanner console and returns an int which tells main whether to create, view or quit.  
**/
   public static int whatDoesUserWant(Scanner console)
   {
      boolean userInput = false;
      int returnValue = 0;
      while (!userInput)
      {
         System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
         String userResponds = console.nextLine();
         if (userResponds.length()==1)
         {
            char userResponse = userResponds.charAt(0);
            if (userResponse == 'c'||userResponse == 'C')
            {
               userInput = true;
               returnValue = 1;
            }
            if (userResponse == 'v'||userResponse == 'V')
            {
               userInput = true;
               returnValue = 2;
            }
            if (userResponse == 'q'||userResponse == 'Q')
            {
               userInput = true;
               returnValue = 3;
            }
         }
      }
      return returnValue;
   }
   /**
   * This makes sure that the user gives an actual file for what file they want to open/make a MadLib from using a try catch 
   * statement. It takes the parameter Scanner console and returns a Scanner on the file they want.  
   **/
   public static Scanner checkUserInput(Scanner console)
   {
      System.out.print("Input file name:");
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
            System.out.print("File not found. Try again:");
         }
      }
      return fileScan;
   }
   /**
   *This creates a PrintStream from the string of the filename.  It takes the outputFile name as a parameter and returns 
   *a PrintStream on that file.   
   **/
   public static PrintStream printStream(File outputFile) throws FileNotFoundException
   {
      PrintStream fileStream = new PrintStream(outputFile);
      return fileStream;
   }
   /**
   *This reads the completed mad lib and converts it to the file.  It takes the PrintStream created by the method printStream
   *and the String from completedMadLib.  
   **/
   public static void readFile(String completedMadLib, PrintStream outputStream)
   {
      outputStream.println(completedMadLib);
   }
   /**
   *This takes the Scanner fileScan and Scanner console and creates the madLib string.  It does this
   *by going through  each token and if it starts with a < and ends with a >, it calls a method that asks
   *the user for input.  If then concatenates a string known as completeMadLib, and returns that to main.
   **/
   public static String doMadLib(Scanner fileScan, Scanner console)
   {
      String madLib = "";
      String completeMadLib = "";
      while(fileScan.hasNextLine())
      {
         String line = fileScan.nextLine();
         Scanner madLibScanner = new Scanner(line);
         while (madLibScanner.hasNext())
         {
            String token = madLibScanner.next();
            if (token.startsWith("<")&&token.endsWith(">"))
            {
               String toPrompt = token.substring(1, token.length()-1);
               String response = askUser(toPrompt, console);
               completeMadLib += response + ' ';
            }
            else
               completeMadLib+=token + ' ';
         }
         completeMadLib+="\n";
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
      return completeMadLib;
   }
   /**
   *This asks the user for input, taking the String toPrompt and the Scanner console as parameters.  
   *It replaces the -s with spaces and checks to see if an a or an an is grammatically correct.  
   *It then  returns the string the user types in.
   **/
   public static String askUser(String toPrompt, Scanner console)
   {
      toPrompt = toPrompt.replace("-"," ");
      if (toPrompt.charAt(0) == 'a')
      {
         System.out.print("Please type an " + toPrompt + ":");
         return console.nextLine();
      }
      else
      {
         System.out.print("Please type a " + toPrompt + ":");
         return console.nextLine();
      }
   }
}
