// Lauren Bricker
// DrawBuilding
// This is an example of procedural decomposition. Also an example for generating javadoc.
//
// DrawBuildingBetter.java
// Version 1.0
// September 10, 2008

/** 
 *  This will draw an ASCII art building in the console using. The code has been stepwise refined to 
 *  use procedural decomposition. Each method has been javadoc'd. 
 */
public class DrawBuildingBetter {
   
   /** This is the entry point into the program, where it all begins
   *
   *  @param args  the command line arguments that are passed into the program
   *
   */
   public static void main (String[] args) 
   {
      System.out.println("     __");
      System.out.println("    |  |");
      System.out.println("   / [] \\");
      System.out.println("  /  []  \\");
      System.out.println("I==========I");
      drawLevel();
      drawLevel();
      drawLevel();
      drawLevel();
      drawLevel();
      System.out.println("|   /  \\   |");
      System.out.println("|___|__|___|");
      System.out.println("I==========I");
   }

    
   /**
   * This method draws the windows and a divider per floor
   */
   public static void drawLevel()
   {
      System.out.println("| [] [] [] |");
      System.out.println("I==========I");
   }

}




