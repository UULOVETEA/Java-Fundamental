/************************* Class Information **************************
   Title:         Card
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          5/5/16
   Description:   represents one of the 52 playing cards.
***********************************************************************

   UML Diagram for Class:         Card

***********************************************************************
         
   variables:
   
      -cardNumber:   int
      -rank:         int
      -front:        String
      
***********************************************************************

   Methods:
      +Card(int cardNumber, int rank, String front)
      +isAce():            boolean
      +rank():             int
      +toString:           String
   
**********************************************************************/
public class Card
{
   private int cardNumber;
   private int rank;
   private String front;
  
   //--------------------------------------------------------------------------
   //  Method for Card
   //
   //  initial card, get cardNumber, rank, and front
   //--------------------------------------------------------------------------
   public Card(int cardNumber, int rank, String front)
   {
      this.cardNumber = cardNumber;
      this.rank = rank;
      this.front = front;
   }
   
   //--------------------------------------------------------------------------
   //  Method for isAce
   //
   //  if rank equal 0, it is Ace
   //--------------------------------------------------------------------------
   public boolean isAce()  
   {
      return rank == 0;
   }

   //--------------------------------------------------------------------------
   //  Method for rank
   //
   //  return rank value
   //--------------------------------------------------------------------------
   public int rank() 
   {
      if (rank == 0)       // if rank equal 0, return 1
         return 1;      
      else if (rank >= 9)  // if rank equal and greater than 0, return 10
      {
         return 10;
      }
      return rank + 1;
   }

   //--------------------------------------------------------------------------
   //  Method for toString
   //
   //  return front
   //--------------------------------------------------------------------------
   public String toString()
   {
      return this.front;
   }
}
