// Lauren Bricker
// Homework 2
// This is the code to do problem 2 in the book - page 114

// Chapter2Problem2 - 
// Version 1.0 
// 9/30/07

public class Chapter2Problem2 
{
    
  public static final boolean debug = false; 
  /**
   * This method is the main entry point for the solution to the problem. 
   *
   * @param  args The command line arguments passed to the 
   * @return      nothing
   */
  public static void main( String[] args )
  {
     int nSize = 10; 
     int nTimes = 9; 
     
     // Parse the command line
     if ( args.length != 0 && args[0] != null )
     {
       //System.out.println( "first arg = " + args[0] );
       nSize = Integer.valueOf( args[0] ); 
     }
     
     if ( args.length != 0 && args[1] != null )
     {
       System.out.println( "second arg = " + args[1] );
       nTimes = Integer.valueOf( args[1] ); 
     }
     
     drawLine( nSize );
     drawUpArrows( nSize, nTimes );
     drawLine( nSize );
     drawDownArrows( nSize, nTimes );
     drawLine( nSize );
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
        if ( debug )
        {
          System.out.println( " jj = " + jj + " ii = " + ii + " size = ii - 1 = " + temp ); 
        }
        
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
      for ( int ii = 0; ii < size; ii++ )
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