//********************************************************************
//  Zero.java       Java Foundations
//
//  Demonstrates an uncaught exception.
//********************************************************************

import java.util.Scanner;

public class Zero
{
   //-----------------------------------------------------------------
   //  Deliberately divides by zero to produce an exception.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      int numerator = 10;
      int denominator = 0;
      
      Scanner scan = new Scanner(System.in);
      
      while(true)
      {
         try
         {
            System.out.println("Enter the numerator and the denominator: ");
            numerator = scan.nextInt();
            denominator = scan.nextInt();
         
            System.out.println("Before the attempt to divide by zero.");

            System.out.println(numerator / denominator);

            System.out.println("This text will not be printed.");
         }
         
         catch(ArithmeticException e)
         {
            System.out.println("Arithmetic Exception because of divide by zero!");
         }
      }
   }
}
