public class Hello
{
   public static void main(String[ ] args)
     {
     for (int jj=1; jj<= 3; jj++)
      {
      System.out.print("how many times dos this print: ");
      System.out.println(jj);
      }
      {
      for ( int jj = 1; jj <=3; jj++ )
      System.out.println("how many times dos this print: " +jj);
      }
      {
      for (int jj = 1; jj<=1; jj++)
      System.out.println ("How many times dos this print: "+jj);
      }   
      {
      for (int jj = 1; jj<=10; jj++)
      System.out.println(+jj);
      }
      for ( int ii = 1; ii <=3; ii++)
      {
         for ( int jj = 1; jj <= 5; jj++ )
         {
            System.out.println("ii= " + ii + " jj = " + jj);
         }
      }     
     }
}