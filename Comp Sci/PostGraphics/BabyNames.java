import java.io.*;
import java.util.*;

public class BabyNames
{
   public static void main(String args[]) throws FileNotFoundException
   {
      String fileName = "names.txt";
      Scanner fileScanner = processFile(fileName);
      PrintStream outputStream = printStream("output.txt");
      readFile(fileScanner, outputStream);
   }
   
   public static Scanner processFile(String fileName) throws FileNotFoundException
   {
      File f = new File(fileName);
      Scanner fileScan = new Scanner(f);
      return fileScan;
   }
   
   public static PrintStream printStream(String fileName) throws FileNotFoundException
   {
      File f = new File(fileName);
      PrintStream fileStream = new PrintStream(fileName);
      return fileStream;
   }
   
   public static void readFile(Scanner fileScan, PrintStream outputStream)
   {
      String outputFile = "";
      while (fileScan.hasNextLine())
      {
         String line = fileScan.nextLine();
         outputFile += line + ("\r\n");
      }
      outputStream.println(outputFile);
   }
}

/**
Input                                                             What will happen
User enters something other than a file (char, int, etc.)         Program will tell the user to enter a file and reprompt.  
User enters a wrong file                                          Program will tell user that the file was not found, and reprompt.
User enters a malformed file                                      Program will tell user that the file is malformed, reprompt.  
User enters a file without the baby name requested                Program will print a not found error.
User enters a file that is correct, enters a name that is correct Program will print information about the name.  
**/