import java.util.Scanner;

import jsjf.*;

/**
 * Palindrome Create a system using a stack and a queue to test whether a
 * given string is a palindrome (reads the same from either direction).
 *
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class Palindrome
{
	public static void main(String[] args)
	{
      // Create Scanner object, String and Character variables
		Scanner scan = new Scanner(System.in);
      String message; 
      char character; 
      char character2;
		String choice;
      
		do
		{
         // Create a Queue and a Stack, as an array or linked list
         LinkedStack<Character> stack = new LinkedStack<Character>();
         CircularArrayQueue<Character> queue = new CircularArrayQueue<Character>();
               
         // Ask for and enter a message
			System.out.print("Please enter a message: ");
			message = scan.nextLine();
         Scanner messageScan = new Scanner(message);
         
         while (messageScan.hasNext())
         {
         	// Place the message into a queue and a stack
            message = messageScan.next();	
			   for(int i=0; i<message.length(); i++)
			   {
				   stack.push(message.charAt(i));
               queue.enqueue(message.charAt(i));
			   }
            
            // Initialize a count = 0
            int count = 0;
            
            for (int i=0; i<message.length(); i++)
            {
               // Remove the characters in the message from the queue and the stack
               character = stack.pop();
               character2 = queue.dequeue();
               
               // If they match add 1 to the count
               if (character == character2)
                  count++;             
            }
         
            // Determine the message if palindrome or not
			   if(count == message.length())
				   System.out.println("The string is a palindrome");
			   else
				   System.out.println("The string is not a palindrome");
         }
            
         // Ask to repeat   
			System.out.println("Do you want to enter another message? Y/N");
			choice = scan.nextLine();
         
		}while(choice.equalsIgnoreCase("Y"));
	}
}

/*
Please enter a message: mom
The string is a palindrome
Do you want to enter another message? Y/N
y
Please enter a message: son
The string is not a palindrome
Do you want to enter another message? Y/N
y
Please enter a message: racecar
The string is a palindrome
Do you want to enter another message? Y/N
y
Please enter a message: student
The string is not a palindrome
Do you want to enter another message? Y/N
n
*/