/************************* Class Information **************************
   Title:         Calculator
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          5/5/16
   Description:   A simple calculator
***********************************************************************

   UML Diagram for Class:         Calculator

***********************************************************************
         
   variables:
   
      -choice:    int
      -a:         long
      -b:         long
      -ans:       long
      -another:   String
      
***********************************************************************

   Methods:
      +main (String[] args):  static void
      +fact (long n)          long
      +mult (long a, long b)  long
      +div  (long a, long b)  long
      +exp  (long a, long b)  long
   
**********************************************************************/

import java.util.*;

public class Calculator
{
   public static void main (String[] args)
   {
      // Create new scanner and varible
      Scanner scan = new Scanner(System.in);
      int choice = 0;
      long a, b, ans;
      String another = "Y";

      while (another.equalsIgnoreCase("Y"))
      {
         // Display the menu
         System.out.print("Welcome to simple Calculator \n" 
                        + "1. Factorial \n"
                        + "2. Multiplication \n" 
                        + "3. Division \n"
                        + "4. Exponential \n"
                        + "5. Quit \n" 
                        + "Please slect one function: ");
         choice = scan.nextInt(); //user input
         
         switch (choice)
         {
            case 1: // Factorial
               // Ask user to input a number
               System.out.print("\n" + "Please enter a number: ");
               long n = scan.nextInt();
               // Display the answer
               System.out.print("The factorial of " + n + " is " + fact(n) + "\n");
               break;
            
            case 2: // Multiplication
               // Ask user to input two numbers
               System.out.print("\n" + "Please enter the first number: ");
               a = scan.nextInt();
               System.out.print("Please enter the second number: ");
               b = scan.nextInt();
               // Display the answer    
               System.out.print("The result is " + mult(a, b) + "\n");
               break;
               
            case 3: // Division
               // Ask user to input two numebers
               System.out.print("\n" + "Please enter the first number: ");
               a = scan.nextInt();
               System.out.print("Please enter the second number: ");
               b = scan.nextInt();
               ans = div(a, b); // Get the result
               
               // Display the answer
               if (b == 0)
                  System.out.println(ans + "\n");
               else
                  System.out.println("The result is " + ans + "\n");
               break;
               
            case 4: // Exp
               // Ask user to input two numbers
               System.out.print("\n" + "Please enter the first number: ");
               a = scan.nextInt();
               System.out.print("Please enter the second number: ");
               b = scan.nextInt();
               System.out.print("The result is " + exp(a, b) + "\n");
               break;
             
            case 5: //Quit
               another = "N";
               System.out.println("\nGoodbye!");
               break;
         }
      }
    
   }
   
   //-----------------------------------------------------------------
   //  Method for fact
   //-----------------------------------------------------------------
   public static long fact (long n)
   {
      if (n==1)
         return 1;
     
      else
         return (n*fact(n-1));
   }

   //-----------------------------------------------------------------
   //  Method for mult
   //-----------------------------------------------------------------   
   public static long mult (long a, long b)
   {      
      if (a == 0 || b == 0)
         return 0;
      else if (b < 0)
         return (-a + mult(a, b+1));
      else
         return (a + mult(a, b-1));
   }

   //-----------------------------------------------------------------
   //  Method for div
   //-----------------------------------------------------------------   
   public static long div (long a, long b)
   {
      long ans;
      String result;
        
      if (a == 0) // a = 0
         ans = 0;
      else if (b == 0) // b = 0, display error message
      {
         System.out.print ("You cannot divide by ");
         ans = 0;
      }
      else if (a < 0 && b < 0) // a and b both are negtive
      {
         a = Math.abs(a);
         b = Math.abs(b);
         ans = (1 + div(a-b,b));
      }
      else if (a < 0) // a is negtive
      {
         a = Math.abs(a);
			ans = (1 + div(a-b, b));
			result = "-" + ans;
			ans = Integer.parseInt(result);
		}
      else if (b < 0) // b is negtive
      {
         b = Math.abs(b);
			ans = (1 + div(a-b, b));
			result = "-" + ans;
			ans = Integer.parseInt(result);
		}
      else if (a < b) // a smaller than b and they are not meet above condition
         ans = 0;
      else 
         ans = (1 + div(a-b,b));
         
      return ans;
   }

   //-----------------------------------------------------------------
   //  Method for exp
   //-----------------------------------------------------------------   
   public static long exp (long a, long b)
   {
      if (b < 0)
      {
         a = -a;
         b = -b;
      }
      if (b == 0)
         return 1;
      else
         return (mult (a, exp(a, b-1)));
   }
   
}

/*
Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 3

Please enter the first number: 33
Please enter the second number: 10
The result is 3

Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 3

Please enter the first number: 33
Please enter the second number: -10
The result is -3

Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 3

Please enter the first number: -33
Please enter the second number: 10
The result is -3

Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 3

Please enter the first number: -33
Please enter the second number: -10
The result is 3

Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 3

Please enter the first number: 0
Please enter the second number: 10
The result is 0

Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 3

Please enter the first number: 10
Please enter the second number: 0
You cannot divide by 0

Welcome to simple Calculator 
1. Factorial 
2. Multiplication 
3. Division 
4. Exp 
5. Quit 
Please slect one function: 5

Goodbye!
*/