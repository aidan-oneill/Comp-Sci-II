// Lauren Bricker
// Homework 2
// This is the code to do problem 2 in the book - page 114
// This version uses the Scanner Object to get input from the user. 

// Chapter2Problem2Buggy - 
// Version 1.0 - 9/30/07
// Version 2.0 - 10/9/14

import java.util.*;

public class Chapter2Problem2Buggy 
{

   public static int nTimes = 4; 
   public static int nSize = 5; 
    
  /**
   * This method is the main entry point for the solution to the problem. 
   *
   * @param  args The command line arguments passed to the 
   * @return      nothing
   */
   public static void main( String[] args )
   {
      Scanner console = new Scanner(System.in);
      getInput(console); 
      
      drawLine( nSize );
      drawUpArrows( nSize, nTimes );
      drawLine( nSize );
      drawDownArrows( nSize, nTimes );
      drawLine( nSize );
   }
  
  /**
   * Getting the input from the user. Since you can't return 2 values,I'm 
   * setting global variables which is a REALLY POOR programming decision.
   *
   * @param console The scanner that is used to get input from the user
   */  

   public static void getInput(Scanner console)
   {
      System.out.println("This program will create boxes that have up or down arrows");
      System.out.println("How many boxes high would you like the output?"); 
      nTimes = console.nextInt();
      System.out.println("How wide would you like the boxes?");
      nSize = console.nextInt();
   }
  
  /**
   * This method will draw a line that has a '+' on both ends and the 
   * given size of the '-' characters
   *
   * @param       size - the size of the line, not including the '+' characters
   * @return      nothing
   */  
   public static void drawLine( int size )
   {
      System.out.print("+");
      writeChar( size * 2, '-');     
      System.out.println("+");
   }


  /**
   * This method will draw a box that is size * 2 wide, and size high. 
   * It will have up arrows showing to make a shape that looks like a ^
   * It will repeat this box nTimes. 
   *
   * @param       size - the size of the line, not including the '+' characters
   * @param       nTimes - the number of times to repeat the box. 
   * @return      nothing
   */  
   public static void drawUpArrows( int size, int nTimes )
   {
      for ( int jj = 0; jj < nTimes; jj++ )
      {
         for ( int ii = 0; ii < size; ii++ )
         {
            int temp = size - ii - 1; 
         // Debugging line: 
         //System.out.println( " jj = " + jj + " ii = " + ii + " size - ii - 1 = " + temp ); 
         
            System.out.print( "|" ); 
         // Write the blanks
            writeChar( temp, ' ' ); 
            System.out.print( "^" ); 
         // Write more blanks
            writeChar( ii * 2, ' ' ); 
            System.out.print( "^" ); 
            writeChar( temp, ' ' ); 
            System.out.println( "|" );
         }
      }
   }    

      
  /**
   * This method will draw a box that is size * 2 wide, and size high. 
   * It will have v's as down arrows showing to make a shape that looks like a v
   * It will repeat this box nTimes. 
   *
   * @param       size - the size of the line, not including the '+' characters
   * @param       nTimes - the number of times to repeat the box. 
   * @return      nothing
   */  
   
   public static void drawDownArrows( int size, int nTimes )
   {
      for ( int jj = 0; jj < nTimes; jj++ )
      {
         for ( int ii = 0; ii <= size; ii++ )
         {
         // Debugging line: 
         // System.out.println( " jj = " + jj + " ii = " + ii + " size = ii - 1 = " + (size- ii - 1) ); 
         
         
            System.out.print( "|" ); 
         // Write the blanks
            writeChar( ii, ' ' ); 
            System.out.print( "v" ); 
         // Write more blanks
            writeChar( (size- ii - 1) * 2, ' ' ); 
            System.out.print( "v" ); 
            writeChar( ii , ' ' ); 
            System.out.println( "|" );
         }
      }
   }    
      
  /**
   * A helper method to draw a given characters a given number of times. . 
   *
   * @param       nChar - the number of times to repeat the character
   * @param       cTheChar - the character to repeat. 
   * @return      nothing
   */  
   private static void writeChar( int nChar, char cTheChar )
   {
      for ( int ii = 0; ii < nChar; ii++ ) 
      {
         System.out.print( cTheChar );  
      }
   }
}