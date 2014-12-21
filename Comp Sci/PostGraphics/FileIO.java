import java.io.*;
import java.util.*;
public class FileIO
{
   public static void main (String[] args) throws FileNotFoundException
   {
   processFile("names.txt");
   }
   public static void processFile(String filename) throws FileNotFoundException
   {
      File f = new File("C:\\Users\\Aidan O'Neill\\Desktop\\11th grade\\Comp Sci\\Postgraphics\\names.txt");
      Scanner fileScan = new Scanner(f);
      while (fileScan.hasNextLine())
      {
         String line = fileScan.nextLine();
         System.out.println(line);
      }
   }
}