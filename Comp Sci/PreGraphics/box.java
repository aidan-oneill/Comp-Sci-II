public class box {
static final int WIDTH = 2;
public static void main (String[] args)

  {
    for (int ii = 0; ii < WIDTH * 2 ; ii++)
    {
      System.out.print("|");
      for (int jj = 0; jj < WIDTH; jj++)
      {
        System.out.print(".");
      }
      System.out.println("|");
    }
  }
}
