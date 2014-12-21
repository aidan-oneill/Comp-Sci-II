import java.util.*;

public class RandomAndWhile
{
   public static void main(String[ ] args) 
   {
      Scanner console = new Scanner(System.in);
      int numRolls=console.nextInt();
      rollDice(numRolls);
   }
   public static void rollDice(int numRolls)
   {
      for (int ii = 0; ii < numRolls; ii++)
      {
         System.out.print((int)(Math.random()*6+1));
         System.out.print("  ");
      }
   }
}
   