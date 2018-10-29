/************************* Class Information **************************
   Title:         Deck
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          5/5/16
   Description:   represents a deck of 52 playing cards
***********************************************************************

   UML Diagram for Class:         Deck

***********************************************************************
         
   variables:
   
      -DECK_SIZE:    int
      -cards:        Card[]
      -N:            int      
      
***********************************************************************

   Methods:
      +Deck()
      +dealFrom():   Card
      +isEmpty():    boolean
      +size():       int
      +shuffle():    void
   
**********************************************************************/

public class Deck
{
   final static int DECK_SIZE = 52;
   private Card[] cards;
   private int N = 0;

   //--------------------------------------------------------------------------
   //  Method for Deck
   //
   //  get the picture of card
   //--------------------------------------------------------------------------
   public Deck()
   {
      cards = new Card[DECK_SIZE];
      for (int i = 0; i < 4; i++)
      {
         for (int j = 0; j < 13; j++)
         {
            cards[N] = new Card(N, j, i + "" + j + ".png");
            N++;
         }
      }
   }

   //--------------------------------------------------------------------------
   //  Method for dealFrom
   //
   //  decrease the number of card
   //--------------------------------------------------------------------------
   public Card dealFrom() 
   {
      return cards[--N];
   }

   //--------------------------------------------------------------------------
   //  Method for isEmpty
   //
   //  check is empty
   //--------------------------------------------------------------------------
   public boolean isEmpty()
   {
      return (N == 0);
   }

   //--------------------------------------------------------------------------
   //  Method for size
   //
   //  get size
   //--------------------------------------------------------------------------
   public int size()
   {
      return N;
   }

   //--------------------------------------------------------------------------
   //  Method for shuffle
   //
   //  shuffle, get a new pair of card
   //--------------------------------------------------------------------------
   public void shuffle()
   {
      for (int i = 0; i < N; i++)
      {
         int r = (int) (Math.random() * i);
         Card swap = cards[i];
         cards[i] = cards[r];
         cards[r] = swap;
      }
   }
}
