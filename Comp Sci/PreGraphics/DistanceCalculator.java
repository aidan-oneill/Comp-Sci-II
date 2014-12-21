// Lauren Bricker
// DistanceCalculator
// a Class that will determine the distance between two pre-defined points
// For now these points are statically defined. Soon we will know how to accept command line input. 

// DistanceCalculator.java
// Version 1.0 
// September 10, 2008

public class DistanceCalculator
{
  
  /** This is the entry point into the program, where it all begins. 
    * The program takes four variables x1, y1, x2, and y2 and determines the distance between the two points in the plane
    *  
    *  @param args  the command line arguments that are passed into the program
    *  
    */
  public static void main(String[] args) 
  {
    // Declare Static variables. Eventually we'll read these in from the console. 
    int X1 = 100; 
    int Y1 = 43;
    int X2 = 39; 
    int Y2 = 23;
    
    // declare variables
    int nXDistance = 0; 
    int nYDistance = 0;
    double dDistance = 0;

    //System.out.println(nXDistance);
    //System.out.println(nYDistance);
    //System.out.println(dDistance);


    // Now compute the distance. 
    nXDistance = X2 - X1;
    nYDistance = Y2 - Y1;
    dDistance = Math.sqrt( nXDistance * nXDistance + nYDistance * nYDistance );

    //System.out.println(nXDistance);
    //System.out.println(nYDistance);
    //System.out.println(dDistance);

    
    System.out.print("The distance between (" + X1 + ", " + Y1 + ") and (" + X2 + ", " + Y2 + ") is: ");
    System.out.println(dDistance);
        
    
  }
}