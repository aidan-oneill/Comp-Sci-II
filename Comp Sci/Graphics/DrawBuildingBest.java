// Lauren Bricker
// DrawBuilding
// This is an example of procedural decomposition. Also an example for generating javadoc.
//
// DrawBuildingBest.java
// Version 1.0
// September 10, 2008

/** 
 *  This will draw an ASCII art building in the console using. The code has been stepwise refined to 
 *  use procedural decomposition. Each method has been javadoc'd. 
 */
public class DrawBuildingBest {
   
   /** This is the entry point into the program, where it all begins
    *  @param args  the command line arguments that are passed into the program
    *
    */
   public static void main (String[] args)
   {
      drawBuildingTop();
      drawBuildingMiddle();
      drawBuildingBottom();
   }
   
   /**
    * This method draws the top of the building. HERE IS SOME MORE TEXT.
    */
   public static void drawBuildingTop()
   {
      System.out.println("     __");
      System.out.println("    |  |");
      System.out.println("   / [] \\");
      System.out.println("  /  []  \\");
      drawFloor();
   }
   
   /**
    * This method draws the main part of the building, the windows and floors...
    */
   public static void drawBuildingMiddle()
   {
      for ( int ii = 0; ii < 6; ii++ )
      {
         System.out.println("| [] [] [] |");
         drawFloor();
      }
   }
   
   
   /**
    * This method draws the bottom of the building. Gotta have the foundation and the door...
    */
   public static void drawBuildingBottom()
   {
      System.out.println("|   /  \\   |");
      System.out.println("|___|__|___|");
      drawFloor();
   }
   
     
   /**
    * This method draws the bottom of each floor
    */
   public static void drawFloor()
   {
      System.out.println("I==========I");
   }
   
   
   
}




