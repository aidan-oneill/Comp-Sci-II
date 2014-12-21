import java.awt.*;

public class GraphicHelloWorld
{
   public static void main( String[] args )
      {
         DrawingPanel panel = new DrawingPanel( 600, 300 );
         panel.setBackground( Color.CYAN );
         
         Graphics canvas = panel.getGraphics();
         
         canvas.drawString("Go Lions!", 500, 200);
         
         System.out.println(panel);
         
      }
}
