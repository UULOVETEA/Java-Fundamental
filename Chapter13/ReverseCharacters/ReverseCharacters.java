import java.util.Scanner;

import jsjf.LinkedStack;

/**
 * Read a sentence and display the sentence so that the characters of each word are backward.
 *
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class ReverseCharacters
{
	public static void main(String[] args)
	{  
      LinkedStack<Character> stack = new LinkedStack<Character>(); // Create a ArrayStack of characters      
      String sentence;
      String words;  
      Scanner sentenceIn = new Scanner(System.in); // Create a scanner called sentenceIn
     
      while(true)
      {
   		try //try method
   		{  
            System.out.println("\n\nPlease enter a sentence: "); // ask to enter a sentence
            sentence = sentenceIn.nextLine(); // get the sentence
            System.out.println(sentence); // print out the sentence
            Scanner sentenceScan = new Scanner(sentence); // create anothe scanner called sentenceScan
            
   
            while (sentenceScan.hasNext()) // peels each word from the sentence 
            {
      			words = sentenceScan.next(); // get each words from the sentence        
      
      			for(int i=0; i<words.length(); i++) // push each character that in the word into stack
      			{
      				stack.push(words.charAt(i));
      			}
               
      			while(!stack.isEmpty()) // pop each character off the stack and display it
      			{
                  System.out.print(stack.pop());
      			}
               System.out.print(" "); // display a space after each word
      		}
         }
   		catch (Exception IOException) // catch method
         {
               System.out.println("Input exception reported");
         } 
      } // End while loop
	} // End main method 
} // End class

/*
Please enter a sentence: 
Hi how are you
Hi how are you
iH woh era uoy 

Please enter a sentence: 
Today is Thursday
Today is Thursday
yadoT si yadsruhT 

Please enter a sentence: 
Tomorrow is Friday
Tomorrow is Friday
worromoT si yadirF 

Please enter a sentence: 
Good bye
Good bye
dooG eyb
*/