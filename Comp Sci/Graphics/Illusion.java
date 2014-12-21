//Kristy Carpenter and Aidan O'Neill
//October 23, 2014, Quiz 3

import java.awt.*; //for drawingpanel

public class Illusion
{
   public static void main(String[]args)
   {
      DrawingPanel canvas = new DrawingPanel(500,400);
      Graphics g = canvas.getGraphics();
      canvas.setBackground(Color.GRAY);
      drawSubfigure(0, 0, 90, 3, g);
      drawSubfigure(120, 10, 90, 3, g);
      drawSubfigure(250, 50, 80, 5, g);
      drawGrid(10, 120, 100, 10, 2, g);
      drawGrid(350, 20, 40, 5, 3, g);
      drawGrid(240, 160, 50, 5, 4, g);
   }
   public static void drawSubfigure(int x, int y, int size, int nCircles, Graphics g)
   {
      int realRadius = size;
      int gap = size / (2 * nCircles);
      g.setColor(Color.ORANGE);
      g.fillOval(x, y, realRadius, realRadius);
      g.setColor(Color.BLACK);
      for (int circleCounter = 1; circleCounter <= nCircles; circleCounter++) //draw concentric circles
      {
         int tempRadius = realRadius - 2 * gap * (circleCounter - 1);
         int tempX = (x + gap * (circleCounter - 1));
         int tempY = (y + gap * (circleCounter - 1));
         g.drawOval(tempX, tempY, tempRadius, tempRadius);
      }
      g.drawLine(x + size / 2, y, x + size, y + size / 2);
      g.drawLine(x + size, y + size / 2, x + size / 2, y + size);
      g.drawLine(x + size / 2, y + size, x, y + size / 2);
      g.drawLine(x, y + size / 2, x + size / 2, y);
      
   }
   public static void drawGrid(int x, int y, int size, int nCircles, int rows, Graphics g)
   {
      g.setColor(Color.BLUE);
      g.fillRect(x, y, size * rows, size * rows);
      g.setColor(Color.ORANGE);
      g.drawRect(x, y, size * rows, size * rows);
      for (int columnCounter = 1; columnCounter <= rows; columnCounter++)
      {
         for (int subfigureCounter = 1; subfigureCounter <= rows; subfigureCounter++)
         {
            drawSubfigure(x + (subfigureCounter - 1) * size, y, size, nCircles, g);
         }
         y = y + size;
      }
   }
}