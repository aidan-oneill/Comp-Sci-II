import java.util.*;

public class average
{
   public static void main(String[]args)
   {
      double average = average();
      System.out.println(average);
   }
   public static double average()
   {
      int[] set ={1,3,4,5,8,9,11,12,15,17};
      double sum = 0;
      for (int ii = 0; ii<set.length; ii++)
      {
         sum += set[ii];
      }
      double average = sum/(set.length);
      return average;
   }
   public static int[] diceRolls(int n)
   {
      Random r = new Random();
      int[]rolls = new int[n];
      for (int ii = 0; ii< rolls.length; ii++)
      {
         rolls[r] = r.nextInt(6)+1;
      }
      return rolls;
   }
}
