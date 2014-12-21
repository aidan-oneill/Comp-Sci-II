//Aidan O'Neill
//Assignment 1, Milestone 2
//The assignment is to create a program that prints out a song, it is supposed to call methods back, as there are many redundancies in the song.  
//9/18/14
//Song
//Version 1.0
public class Song {
//This method prints the entire song - it calls the redundant lines from below, and the lines that only occur once are just printed.  It is called main because it is the primary method.
   public static void main (String[ ] args) {
   System.out.println ("I once wrote a program that wouldn't compile");
   Last2lines();
   System.out.println ("My program did nothing\nSo I started typing.");
   Line3();
   Last2lines();
   System.out.println ("\"Parse error,\" cried the compiler\nLuckily I'm such a code baller.");
   Line4();
   Line3();
   Last2lines();
   System.out.println ("Now the compiler wanted an identifier\nAnd I thought the situation was getting dire.");
   Line5();
   Line4();
   Line3();
   Last2lines();
   System.out.println ("Java complained it expected an enum\nBoy, these computers really are dumb!");
   System.out.println ("I added a public class and called it Scum,");
   Line5();
   Line4();
   Line3();
   Last2lines();
   System.out.println ("I couldn't figure out how to print my line,");
   System.out.println ("I deduced my program is less than fine.");
   Line5();
   Line4();
   Line3();
   Last2lines();
   } 
//This prints out the last two lines of each stanza, hence the name "Last2lines".
public static void Last2lines(){
   System.out.println ("I don't know why it wouldn't compile, \nMy TA just smiled.\n"); 
   }
//This prints out the third from last line that is repeated, hence the name Line3.
public static void Line3(){
   System.out.println ("I added System.out.println(\"I <3 coding\"),");
   }
//This prints out the fourth from last line that is repeated, hence the name Line4. 
public static void Line4(){
   System.out.println ("I added a backlash to escape the quotes,");
   }
//This prints out the fifth from last line that is repeated, hence the name Line5.  
public static void Line5(){
   System.out.println ("I added a main method with its String[] args,");
   }
}