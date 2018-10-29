import jsjf.*;
import java.util.Scanner;

/**
 * Codes demonstrates the use of queues to encrypt and decrypt messages.
 *
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class Codes
{
    /**
     * Encode and decode a message using a key of values stored in
     * a queue.
     */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in); // create scanner
		String chioce;
      		
      
      do
		{
         int[] key;
         int keySize ;
         Integer keyValue;
         String encoded = "", decoded = "";
         String message = "";
         
         System.out.println("Please enter a message: "); // prompt to enter message
         message = in.nextLine();
         
         System.out.println("Please enter the length of the key: "); // prompt to enter the number of key
         keySize = in.nextInt();
         
         key = new int[keySize];
         
         for (int scan = 0; scan < key.length; scan++)
			{
			   System.out.println("Please enter key index " + (scan + 1)
						+ ": ");
				key[scan] = in.nextInt();
			}
         System.out.println("\nOriginal Message: \n" + message + "\n"); // display the original message           
         LinkedQueue<Integer> encodingQueue = new LinkedQueue<Integer>();
		   LinkedQueue<Integer> decodingQueue = new LinkedQueue<Integer>();
        
         // load key queues 
         for (int scan = 0; scan < key.length; scan++)
         {
            encodingQueue.enqueue(key[scan]);
            decodingQueue.enqueue(key[scan]);
		   }
    
         // encode message 
         for (int scan = 0; scan < message.length(); scan++)
         {
            keyValue = encodingQueue.dequeue();
            encoded += (char) (message.charAt(scan) + keyValue);
            encodingQueue.enqueue(keyValue);
         }
    
         System.out.println ("Encoded Message:\n" + encoded + "\n"); // display the encoded message
    
         // decode message 
         for (int scan = 0; scan < encoded.length(); scan++)
         {
            keyValue = decodingQueue.dequeue();
            decoded += (char) (encoded.charAt(scan) - keyValue);
            decodingQueue.enqueue(keyValue);
         }
    
         System.out.println ("Decoded Message:\n" + decoded + "\n");
         
         in = new Scanner (System.in);
         System.out.println ("Do you want enter another message? Y/N"); // ask to repeat
         chioce = in.nextLine();
         
      }while (chioce.equalsIgnoreCase("Y"));
      in.close();
   }
}

/*
Please enter a message: 
This is a sample output
Please enter the length of the key: 
3
Please enter key index 1: 
21
Please enter key index 2: 
-23
Please enter key index 3: 
12

Original Message: 
This is a sample output

Encoded Message:
iQu?	u?	m5\m?Yxz	{?]|?]

Decoded Message:
This is a sample output

Do you want enter another message? Y/N
y
Please enter a message: 
Today is Thursday
Please enter the length of the key: 
5
Please enter key index 1: 
1
Please enter key index 2: 
10
Please enter key index 3: 
8
Please enter key index 4: 
2
Please enter key index 5: 
-9

Original Message: 
Today is Thursday

Encoded Message:
Uylcp!s{"Kizu[b?

Decoded Message:
Today is Thursday

Do you want enter another message? Y/N
n
*/