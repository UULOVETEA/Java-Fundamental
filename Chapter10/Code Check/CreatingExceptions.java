//********************************************************************
//  CreatingExceptions.java       Java Foundations
//  Xiaomeng Cao
//  The program prompt user enter code, and it can check the length of
//  the code and the first character of the code
//********************************************************************

import java.util.Scanner;

public class CreatingExceptions
{
   //-----------------------------------------------------------------
   //  Creates an exception object and possibly throws it.
   //-----------------------------------------------------------------
   public static void main (String[] args)throws OutOfBoundsException, InvalidDocumentCodeException
   {
      // Create the scanner object for input
      Scanner scan = new Scanner (System.in);

      // Create the 2 exceptions
      OutOfBoundsException outOfRange = new OutOfBoundsException("String is too long");
	  	InvalidDocumentCodeException invalid = new InvalidDocumentCodeException("Invalid code in position 1");

      while (true)
		{
         // Give the directions for input
			System.out.println("Code input directions: the length of code <=20 characters and begin with U, C, P");
			
         String code;
         char str;
         
         System.out.print ("Enter product code: ");
         code = scan.nextLine();
         
         str = code.charAt(0);
			int length = code.length();
			
         try
			{
            // Check the length
				if(length > 20) 
               throw outOfRange;
			}

			catch(OutOfBoundsException e)
			{
            // Display the massage
				System.out.println(outOfRange);
			}

			try
			{
				// check the first character in str to make sure it is U, C, or P
				if(str != 'U' & str != 'C' & str != 'P')
               throw invalid;
			}

			catch(InvalidDocumentCodeException e)
			{
				// Display the massage			
				System.out.println(invalid);
			}
		}
	}
}

/*
Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: A123
 InvalidDocumentCodeException: Invalid code in position 1
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: U123
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: P123
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: C123
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: C123456789000000000000000000000000000
 OutOfBoundsException: String is too long
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: C124
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: C12414
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: A0000000000000000000000000000000000000
 OutOfBoundsException: String is too long
 InvalidDocumentCodeException: Invalid code in position 1
 Code input directions: the length of code <=20 characters and begin with U, C, P
 Enter product code: 
*/