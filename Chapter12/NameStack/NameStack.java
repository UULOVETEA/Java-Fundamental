import java.util.Scanner;

import jsjf.*;
import jsjf.exceptions.*;

/**
 * Ask user to enter a number and enter same number of 
 * friend's name.
 *
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class NameStack
{	

	public static void main(String[] args)
	{    
		String choice;
      int n;
      
		do
		{
         // Create an ArrayStack of strings called nameStack and a Scanner object called in
			System.out.println("Creating new stack");
			ArrayStack<String> nameStack = new ArrayStack<String>();
         
         Scanner in = new Scanner(System.in);
			
         // Check to see if nameStack is empty
         if(nameStack.isEmpty())
				System.out.println("The stack is empty");
			else
				System.out.println("The stack is not empty");
         
         // Ask for the number, n, of your friends to be added to the stack         
         System.out.println("Please enter how many numbers of your friend name you want to add: ");
         n = in.nextInt();

         // Enter the full names of n friends into nameStack using a while or for loop
			System.out.println("Please enter " + n + " full names");
         in.nextLine();
         
			for(int count = 0; count<n; count++)
			{
				System.out.print("Name " + (count+1) + ": ");
            
				nameStack.push(in.nextLine());
			}
         
         // Display the size of nameStack
			System.out.println("The size of the stack is " + nameStack.size());
         
         // Display nameStack
         System.out.println(nameStack.toString());
 
			// Peek the stack and display the entry that was peeked and the size of the stack
			System.out.println("The top entry of the stack is " + nameStack.peek());
			
         // Pop 2 names off the stack and display them
         for(int count = 0;count<3;count++)
				System.out.println(nameStack.pop());
            
			System.out.println(nameStack.toString());        
                  
			// Check to see if nameStack is empty
         if(nameStack.isEmpty())
				System.out.println("The stack is empty");
			else
				System.out.println("The stack is not empty");
            
         // Display the size of nameStack
			System.out.println("The size of the stack is " + nameStack.size());
         
         // Display nameStack
         System.out.println(nameStack.toString());
                         
			/*try
			{
				System.out.println("Peeking..." + nameStack.peek());
			}
			catch(EmptyCollectionException e)
			{
				System.out.println(e.getMessage());
			}*/
         
         // Ask to repeat
			System.out.println("Would you like to run the program again? (Y/N)");
			choice = in.nextLine();
         
		}while(choice.equalsIgnoreCase("Y"));
	}
}

/*
Creating new stack
The stack is empty
Please enter how many numbers of your friend name you want to add: 
4
Please enter 4 full names
Name 1: Michael Jordan
Name 2: Tracy McGrady
Name 3: Allen Iverson
Name 4: Vince Carter
The size of the stack is 4
[4]Vince Carter
[3]Allen Iverson
[2]Tracy McGrady
[1]Michael Jordan

The top entry of the stack is Vince Carter
Vince Carter
Allen Iverson
Tracy McGrady
[1]Michael Jordan

The stack is not empty
The size of the stack is 1
[1]Michael Jordan

Would you like to run the program again? (Y/N)
n
*/