import java.util.*;

public class testing
{
public static void main(String[]args)
{
   Scanner console = new Scanner(System.in);
   int price = console.nextInt();
   String symbol;
		if (price <= 50.00)
		   symbol = "$";
		if (50.00 < price <= 80.00)
		   symbol = "$$";
		if (80.00 < price <= 120.00)
		   symbol = "$$$";
		else
		   symbol = "$$$$";
		System.out.println( symbol );
}
}
