import java.awt.*;
import java.util.*;

public class drawing
{
   public static void main(String args[]) 
   {
      DrawingPanel panel = new DrawingPanel(12,12);
      drawMystery(panel);
   }
      public static void drawMystery (DrawingPanel panel) 
      {
            int MAX_X = 12; 
            int MAX_Y = 12; 
      	 int x = 0;
      	 int y = 0; 
      	 Color color = Color.BLACK; 
          
      	 Graphics g = panel.getGraphics();
      		
      	 while ( x < MAX_X ) 
            {
      		if ( x  % 3 == 2 )
      			color = Color.WHITE; 
      		else
      			color = Color.BLACK; 
        		g.setColor( color );
      		y = 0;  
      		while ( y < MAX_Y )
      		{
      			g.fillRect(x, y, 1, 1); 
            		y++; 
      		}
      
      		x++; 
       }
     }
   }
