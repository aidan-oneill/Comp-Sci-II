/**Assignment 3 Milestone 2
*Aidan O'Neill
*The assignment is to create both an Affine Cipher and a Rot 13 Cipher using parameters and return values.  
*Cipher
*Version 1.0
**/

import java.util.*;

   /**
*This creates an Affine Cipher after prompting the user for values for a, b, and the string they want converted.  It encrypts the string, prints that, then decrypts the string, prints that, then does the same using the simpler ROT 13 cipher.  
**/
public class Cipher 
{
/**
*This method first uses a scanner to prompt the user for a, b, and the string, then routes to other methods.  
**/
   public static void main(String[ ] args) 
   {
      beginning();
   
      Scanner console = new Scanner(System.in);
      System.out.println("Please enter an odd numeric value for a(1-25, not 13):");
      int multiply=console.nextInt();
      errorA(multiply);
      System.out.println("Please enter a numeric value for b:");
      int add=console.nextInt();
      errorB(add);
      console.nextLine();
      System.out.println("Enter the string you'd like to convert:");
      String stringToConvert=console.nextLine();
   
      String encryptedString=encrypt(multiply, add, stringToConvert);
      
      String decryptedString=decrypt(stringToConvert, encryptedString, multiply, add);
   
      String encryptedROTString=encryptedROT13(stringToConvert);
   
      decryptedROT13(stringToConvert, encryptedROTString);
   }

 /**
   *This prints out what the program is intended to do.
   **/
   public static void beginning()
  
   {
      System.out.println("This program will encode and then decode a string using the ROT13 and Affine Ciphers. An Affine Cipher encodes character with an equation (ax + b) mod 26, where x is the ASCII value of the character. ROT13 is a special case of the Affine Cipher, where a is 1 and b is 13.");
   }

   /**
   *This prints out error messages for a if a is not an odd number between 1 and 26 not including 13.  
   **/
   public static void errorA(int multiply)
   {
      if (multiply > 25)
         {
            System.out.println("The value for 'a' must be an odd number between 1 and 26 not including 13");
            System.exit(0);
         }   
      else if (multiply < 0) 
         {
            System.out.println("The value for 'a' must be an odd number between 1 and 26 not including 13");
            System.exit(0);
         }
      else if (multiply==13)
         {
            System.out.println("The value for 'a' must be an odd number between 1 and 26 not including 13");
            System.exit(0);
         }
      else if (multiply%2==0)
         {
            System.out.println("The value for 'a' must be an odd number between 1 and 26 not including 13");
            System.exit(0);
         }
   }
   /**
   *This prints out error messages for b if b is not between 0 and 26.  
   **/
   public static void errorB(int add)
   {
      if (add>26)
      {
         System.out.println("The value for 'b' must be between 0 and 26");
         System.exit(0);
      }
      else if (add<0)
      {
         System.out.println("The value for 'b' must be between 0 and 26");
         System.exit(0);
      }
   }
   public static String encrypt(int multiply, int add, String stringToConvert)
   {
   /**
   * This encodes the string.  It assigns a numerical value for each letter, then manipulates it by multiplying by a, adding b, then taking the result mod 26, then taking this numerical result and dispensing a new character value given the integer dispensed.  
   **/
   String encryptedString = "";
   System.out.println("The Affine encoded string is:");
   for (int number=0; number<stringToConvert.length(); number++)
      {
         char input = stringToConvert.charAt(number); 
         char output=input;
         int inputAsAscii = (int)input;
         
         if ((64<inputAsAscii)&&(inputAsAscii<91))
         {
            inputAsAscii=(inputAsAscii-65);
            inputAsAscii=((inputAsAscii*multiply+add)%26);
            output = (char)(inputAsAscii+65);      
         }
         else if ((96<inputAsAscii)&&(inputAsAscii<123))
         {
            inputAsAscii=(inputAsAscii-97);
            inputAsAscii=((inputAsAscii*multiply+add)%26);
            output = (char)(inputAsAscii+97); 
         }
         else
         {
         }
      encryptedString=encryptedString+output;  
      }
      System.out.println(encryptedString);
      return encryptedString;
   }
   /**
   *This decodes the encrypted string above.  It assigns numerical values to each letter, then does the reverse of an affine cipher on it, then takes the integer produced and maps it to the original letter.
   **/  
   public static String decrypt(String stringToConvert, String encryptedString, int multiply, int add) 
   {
      String decryptedString = "";
      for (int number=0; number<stringToConvert.length(); number++)
      {
         int decrypted = encryptedString.charAt(number); 
         char outputDecrypted = (char)decrypted;
         if ((64<decrypted)&&(decrypted<91))
         {
            decrypted=(decrypted-65);
            decrypted=(((inverseMOD(multiply))*(decrypted-add))%26);
            if (decrypted<0)
            {
               decrypted=(26-(Math.abs(decrypted)));
            }
            outputDecrypted = (char)(decrypted+65);    
         }
         else if ((96<decrypted)&&(decrypted<123))
         {
            decrypted=(decrypted-97);
            decrypted=(((inverseMOD(multiply))*(decrypted-add))%26);
            if (decrypted<0)
            {
               decrypted=(26-(Math.abs(decrypted)));
            }
            outputDecrypted = (char)(decrypted+97);
         }
         decryptedString=decryptedString+outputDecrypted;
         if (decryptedString.equals(stringToConvert))
         {
            System.out.println("The Affine conversion was tested and was correct, here's your output:");
            System.out.println(decryptedString);
         }
         
      }
   return decryptedString;
   }
    /**
    *This encrypts the original String with a ROT 13 cipher.  
    **/
    public static String encryptedROT13(String stringToConvert)
    {
       String encryptedROTString="";
       System.out.println("The ROT13 encoded string is:");
       for (int number=0; number<stringToConvert.length(); number++)
         {
            char input = stringToConvert.charAt(number); 
            char output = input;
            int inputAsAscii = (int)input;
            if ((64<inputAsAscii)&&(inputAsAscii<91))
            {
               inputAsAscii=(inputAsAscii-65);
               inputAsAscii=((inputAsAscii+13)%26);
               output = (char)(inputAsAscii+65);      
            }
            else if ((96<inputAsAscii)&&(inputAsAscii<123))
            {
               inputAsAscii=(inputAsAscii-97);
               inputAsAscii=((inputAsAscii+13)%26);
               output = (char)(inputAsAscii+97);
            }
            encryptedROTString=encryptedROTString+(output);
            }
      System.out.println(encryptedROTString);
      return encryptedROTString;
      }
   /**
   *This decrypts the ROT13 cipher.  
   **/   
   public static String decryptedROT13(String stringToConvert, String encryptedROTString)
   {
   String decryptedROTString="";
   for (int number=0; number<stringToConvert.length(); number++)
      {
         int decrypted = encryptedROTString.charAt(number); 
         int encryptedAsAscii = (int)decrypted;
         char outputDecrypted = (char)decrypted;
         if ((64<decrypted)&&(decrypted<91))
         {
            decrypted=(decrypted-65);
            decrypted=((decrypted+13)%26);
            outputDecrypted = (char)(decrypted+65);     
         }
         else if ((96<decrypted)&&(decrypted<123))
         {
            decrypted=(decrypted-97);
            decrypted=((decrypted+13)%26);
            outputDecrypted = (char)(decrypted+97);
         }
         decryptedROTString=decryptedROTString+outputDecrypted;
         if (decryptedROTString.equals(stringToConvert))
         {
            System.out.println("The ROT13 conversion was tested and was correct, here's your output:");
            System.out.println(decryptedROTString);
         }
      } 
      return decryptedROTString;
   }
   /**
   *This finds the modular multiplicative inverse for use in the decryption.  
   **/
   public static int inverseMOD(int multiply)
   {
      int letter;
      for (letter=1; letter<=26; letter++)
      {
         if ((letter*multiply)%26==1)
            {
            break;
            }
      }
   return letter;
   }
}