import java.util.*;
//Assignment 5 Milestone 2
//Aidan O'Neill
//GuessingGame
//Your program allows the user to play a game in which the program thinks of a random integer and 
//accepts guesses from the user until the user guesses the number correctly. After each incorrect guess,
// you will tell the user whether the correct answer is higher or lower.
//11/6/14
//Version 1.0

/**
*This plays the Guessing Game
**/
public class GuessingGame 
{
/**
*This declares the maximum number for the number you are supposed to guess - 100 means the number 
*can only be between 1 and MAXNUMBER.
**/
   public static final int MAXNUMBER = 100;
/**
*This plays the Guessing Game
**/
   public static void main(String[] args)
   {
      haiku(); 
      playGame();
   }
   /**
   *This prints the Haiku and then tells the user what range they have for the number they're supposed to guess.
   **/
   public static void haiku()
   {
      System.out.println("My apologies.");
      System.out.println("I cannot write haikus well.");
      System.out.println("Programming and stuff.");
   }
   /**
   *This generates a random number between 1 and the MAXNUMBER. It then returns the random value to playGame.   
   **/
   public static int generateRandom()
   {
      Random r = new Random();
      return (r.nextInt(MAXNUMBER-1))+1;
   }
   /**
   *This prompts the user for a guess, then tells them if their guess is lower or higher than the number.
   *If they guess the number, it tells them how many guesses it took them.  Then it asks them if they 
   *want to play again.  If they do, it repeats, if they don't, it prints out overall statistics.  
   **/
   public static void playGame()
   {
      int totalGames = 0;
      int totalGuesses = 0;
      int bestGame = 0;
      Scanner console = new Scanner(System.in);
      boolean checkGuess = false;
      boolean stillWantToPlay = true;
      while (stillWantToPlay)
      {
         int randomNumber = generateRandom(); 
         System.out.println("I'm thinking of a number between 1 and " + MAXNUMBER + "...");
         boolean userInput = false;
         int numberGuesses = 1;
         while (!userInput)
         {
            System.out.print("Your guess? ");
            int userGuess = console.nextInt();
            while (!checkGuess)
            {
               if (!(0<userGuess && userGuess<MAXNUMBER))
               {
                  System.out.println("Please guess a real guess");
               }
               else
               {
                  checkGuess = true;
               }
            }
            if (userGuess<randomNumber)
            {
               System.out.println("It's higher.");
               numberGuesses = numberGuesses+1;
            }
            else if (randomNumber<userGuess)
            {
               System.out.println("It's lower.");
               numberGuesses = numberGuesses+1;
            }
            else
            {
               if (numberGuesses ==1)
               {
                  System.out.println("You got it right in " + (numberGuesses) + " guess!");
                  userInput = true;
               }
               else 
               {
                  System.out.println("You got it right in " + (numberGuesses) + " guesses!");
                  userInput = true;
               }
            }  
         }
         
         totalGames=totalGames+1;
         if (totalGames == 1)
         {
            bestGame = numberGuesses;
         }
         if (numberGuesses<bestGame)
         {
            bestGame = numberGuesses;
         }
         totalGuesses=numberGuesses+totalGuesses;
         stillWantToPlay = wantToPlay(console);
      }
      userStats(totalGames, totalGuesses, bestGame);
   }
   /**
   *This asks the user if they want to play again.  It takes the parameter console from 
   *playGame and returns a boolean indicating whether the user still wants to play or not.  
   **/
   public static boolean wantToPlay(Scanner console)
   {
      System.out.println("Do you want to play again?");
      String userResponse = console.next();
      char wantToPlay = userResponse.charAt(0);
      if (wantToPlay=='y'||wantToPlay=='Y')
      {
         System.out.println();
         return true;
      }
      else
      {
        return false;
      }
   }
   /**
   *This prints out the statistics for the user.  It takes the parameters totalGames, 
   *totalGuesses, and bestGame from playGame so that it can print out the statistics.  
   **/
   public static void userStats(int totalGames, int totalGuesses, int bestGame)
   {
      System.out.printf("Overall results: \n");
      System.out.printf("Total games   = " + totalGames + "\n");
      System.out.printf("Total guesses = " + totalGuesses + "\n");
      double guessesPerGame = ((double)totalGuesses/(double)totalGames);
      System.out.printf("Guesses/game  = " + roundToOne(guessesPerGame) + "\n");
      System.out.printf("Best game     = " + bestGame);
   }
   /**
   * This rounds totalGames/totalGuesses to one decimal place.  The code is taken from our textbook.  
   *It takes the parameter of the average guessesPerGame.  
   **/      
   public static double roundToOne(double guessesPerGame)
   {
      return Math.round(guessesPerGame*10000.0)/10000.0;
   }
}