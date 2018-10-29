/************************* Class Information **************************
   Title:         Player
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          5/5/16
   Description:   represents one of the blackjack players, either 
                  the dealer or the gambler
***********************************************************************

   UML Diagram for Class:         Player

***********************************************************************
         
   variables:
   
      -MAX_CARDS:    int
      -cards:        Card[]
      -N:            int
      -name:         String
      
***********************************************************************

   Methods:
      +Player(String name)
      +inHand():        int
      +dealTo(Card c):  Card
      +reset():         void
      +value():         int
   
**********************************************************************/

public class Player
{
   final static int MAX_CARDS = 52;
   public Card[] cards = new Card[MAX_CARDS];
   private int N = 0;
   private String name;

   //--------------------------------------------------------------------------
   //  Method for Player
   //
   //  initial player
   //--------------------------------------------------------------------------
   public Player(String name)
   {
      this.name = name;
   }

   //--------------------------------------------------------------------------
   //  Method for inHand
   //
   //  check how many card in hand
   //--------------------------------------------------------------------------
   public int inHand()
   {
      return N;
   }

   public Card dealTo(Card c)
   {
      cards[N++] = c;
      return c;
   }
 
   //--------------------------------------------------------------------------
   //  Method for reset
   //
   //  reset the number of card to 0
   //--------------------------------------------------------------------------
   public void reset()
   {
      N = 0;
   }

   //--------------------------------------------------------------------------
   //  Method for value
   //
   //  determing Ace is 1 or 11
   //--------------------------------------------------------------------------
   public int value()
   {
      int val = 0;
      boolean hasAce = false;
      for (int i = 0; i < N; i++)
      {
         val = val + cards[i].rank();
         if (cards[i].isAce())
            hasAce = true;
      }
      if (hasAce && (val <= 11))
      {
         val = val + 10;
      }
      return val;
   }
}
