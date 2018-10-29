/************************* Class Information **************************
   Title:         Game
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          5/5/16
   Description:   create the GUI and rule for Game, make it is run.
***********************************************************************

   UML Diagram for Class:         Game

***********************************************************************
         
   variables:
 
      -player:          Player
      -dealer:          Player
      -deck:            Deck
      -menu1:           JMenuItem
      -menu2:           JMenuItem
      -menu3:           JMenuItem
      -menu4:           JMenuItem
      -start:           JButton
      -hit:             JButton
      -stay:            JButton
      -status:          JLabel
      -menubar:         JMenuBar
      -playerPanel:     JPanel
      -dealerPanel:     JPanel
      -buttonsPanel:    JPanel
      -statusPanel:     JPanel
      
***********************************************************************

   Methods:
      +main(String[] args)
      +hitPlayer()
      +hitDealerDown()
      +hitDealer()
      +start()
      +deal()
      +checkWinner()
      +actionPerformed(ActionEvent e)
   
***********************************************************************

   Program Logic:
      1. Set up the JFrame
      2. Set up the JPanels
      3. Set up the JBottons
      4. Set up the JMenuBar and JMenuItem
      5. Add JMenuItem to JMenuBar
      6. Add JMenubar and JBottons to JPanels
      7. Add JPanels to JFrame
      8. Form a deck
      9. Sent card to player and dealer
      10. If player hit, get another card
      11. If plater stay, finish this round
      12. If dealer do not meet 17, get another card
      13. Check who is winner and display related message
      14. Click Start, start a new game
      15. Click Quit, exit this game

**********************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame implements ActionListener
{
   // Static variables, objects, etc
   private Deck deck;
   public Player player = new Player("player");
   public Player dealer = new Player("dealer");
   
   private JMenuItem menu1;
   private JMenuItem menu2;
   private JMenuItem menu3;
   private JMenuItem menu4;
   
   private JButton start;
   private JButton hit;
   private JButton stay;
   //private JButton split;  
   private JButton quit;  

   private JLabel status = new JLabel(" ", JLabel.CENTER);

   JMenuBar menubar = new JMenuBar();
   
   JPanel playerPanel = new JPanel();
   JPanel dealerPanel = new JPanel();
   JPanel buttonsPanel = new JPanel();
   JPanel statusPanel = new JPanel();

   //--------------------------------------------------------------------------
   //  Constructor
   //
   //  Game driver
   //--------------------------------------------------------------------------
   public static void main(String[] args)
   {
      new Game();
   }

   //--------------------------------------------------------------------------
   //  Method for Game
   //
   //  create GUI for Black Jack game
   //--------------------------------------------------------------------------   
   Game()
   {
      // new frame
      JFrame frame = new JFrame("BlackJack --- by Xiaomeng Cao");
      frame.setIconImage(Toolkit.getDefaultToolkit().getImage("cards/10.png"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // create menu bar
      frame.setJMenuBar(menubar);
      
      JMenu file = new JMenu("File");      
      JMenu help = new JMenu("Help");
      
      // add menu to menu bar
      menubar.add(file);
      menubar.add(help);

      // create menu item
      menu1 = new JMenuItem("New Game");
      menu2 = new JMenuItem("Exit Black Jack");
      menu3 = new JMenuItem("Help");
      menu4 = new JMenuItem("About");
      
      // add menu item to menu
      file.add(menu1);
      file.add(menu2);
      help.add(menu3);
      help.add(menu4);
      
      // register menus event listener
      menu1.addActionListener(this);
      menu2.addActionListener(this);
      menu3.addActionListener(this);
      menu4.addActionListener(this);
            
      // creart buttons
      start = new JButton("Start");
      hit = new JButton("Hit");
      stay = new JButton("Stay");
      //split = new JButton("Split");
      quit = new JButton("Quit");
      
      // tip for each button
      start.setToolTipText("Start a new game");
      hit.setToolTipText("Get another card");
      stay.setToolTipText("Finish this round");
      quit.setToolTipText("Quit the game");
      
      // set size for each button
      start.setMargin(new Insets(5,10,5,10));
      hit.setMargin(new Insets(5,10,5,10));
      stay.setMargin(new Insets(5,10,5,10));
      //split.setMargin(new Insets(5,10,5,10));
      quit.setMargin(new Insets(5,10,5,10));
      
      // register buttons event listener
      start.addActionListener(this);
      hit.addActionListener(this);
      stay.addActionListener(this);
      //split.addActionListener(this);
      quit.addActionListener(this);
      
      // add buttons to panel
      buttonsPanel.add(start);
      buttonsPanel.add(hit);
      buttonsPanel.add(stay);
      statusPanel.add(status);
      //buttonsPanel.add(split);
      buttonsPanel.add(quit);
      
      // disable hit and stay before begin 
      hit.setEnabled(false);
      stay.setEnabled(false);
       
      dealerPanel.setBackground(new Color (0, 122, 0));
      playerPanel.setBackground(new Color (0, 122, 0));
      buttonsPanel.setBackground(new Color (0, 122, 0));
      statusPanel.setBackground(new Color (0, 122, 0));
      
      frame.setLayout(new BorderLayout());
      frame.add(dealerPanel, BorderLayout.NORTH);
      frame.add(playerPanel, BorderLayout.CENTER);
      frame.add(buttonsPanel, BorderLayout.SOUTH);
      frame.add(statusPanel, BorderLayout.WEST);
      frame.repaint();
      frame.setSize(450, 350);
      frame.setVisible(true);
   }

   //--------------------------------------------------------------------------
   //  Method for hitPlayer
   //
   //  display new card for player
   //--------------------------------------------------------------------------
   private void hitPlayer()
   {
      Card newCard = player.dealTo(deck.dealFrom());
      playerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
      playerPanel.updateUI();
   }

   //--------------------------------------------------------------------------
   //  Method for hitDealerDown
   //
   //  make the first card of dealer is hided
   //--------------------------------------------------------------------------
   private void hitDealerDown()
   {
      Card newCard = dealer.dealTo(deck.dealFrom());
      dealerPanel.add(new JLabel(new ImageIcon("cards/b2fv.png")));
      dealerPanel.updateUI();
   }

   //--------------------------------------------------------------------------
   //  Method for hitDealer
   //
   //  sent card to dealer when it is nessaray and display it
   //--------------------------------------------------------------------------
   private void hitDealer()
   {
      Card newCard = dealer.dealTo(deck.dealFrom());
      dealerPanel.add(new JLabel(new ImageIcon("cards/" + newCard.toString())));
      dealerPanel.updateUI();
   }

   //--------------------------------------------------------------------------
   //  Method for start
   //
   //  start a new game, get a new deck and shuff the card
   //--------------------------------------------------------------------------
   private void start()
   {
      playerPanel.removeAll();
      dealerPanel.removeAll();
      playerPanel.updateUI();
      dealerPanel.updateUI();
      player.reset();
      dealer.reset();
      if (deck == null || deck.size() < 15)
      {
         deck = new Deck();
         deck.shuffle();
         status.setText("Shuffling");
      }
      hitPlayer();
      hitDealerDown();
      hitPlayer();
      hitDealer();
   }

   //--------------------------------------------------------------------------
   //  Method for checkWinner
   //
   //  determine who is the winner and display the related message
   //--------------------------------------------------------------------------
   private void checkWinner()
   {
      dealerPanel.removeAll();
      for (int i = 0; i < dealer.inHand(); i++)
      {
         dealerPanel.add(new JLabel(new ImageIcon("cards/" + dealer.cards[i].toString())));
      }
      if (player.value() > 21)
         status.setText("Busted ! You lose !"); 
      else if (dealer.value() > 21)
         status.setText("Dealer Busts ! Yon win !");
      else if (dealer.value() == player.value())
         status.setText("Push !");
      else if (dealer.value() < player.value())
         status.setText("You win !");
      else
         status.setText("You lose !");
   }

   //--------------------------------------------------------------------------
   //  Method for actionPerformed
   //
   //  determine which button was pressed and performs the related function
   //--------------------------------------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      // if start was pressed, begin a new game
      if (e.getSource() == start)
      {
         start();
         status.setText(" ");
         start.setEnabled(false);
         hit.setEnabled(true);
         stay.setEnabled(true);
      }
      
      // if hit was pressed, get a new card
      else if (e.getSource() == hit) 
      {
         hitPlayer();
         
         if (player.value() > 21)
         {
            checkWinner();
            start.setEnabled(true);
            hit.setEnabled(false);
            stay.setEnabled(false);
         }
      }

      // if stay was pressed, hold player's card and check who is winner
      else if (e.getSource() == stay)
      {
         while (dealer.value() < 17 || player.value() > dealer.value()) 
         {
            hitDealer();
         }
         checkWinner();
         start.setEnabled(true);
         hit.setEnabled(false);
         stay.setEnabled(false);
      }

      // if quit was pressed, exit this game
      else if (e.getSource() == quit)
      {
         System.exit(0);
      }
      
      // if menu1 was pressed, start a new game
      else if (e.getSource() == menu1)
      {
         start();
         status.setText(" ");
         start.setEnabled(false);
         hit.setEnabled(true);
         stay.setEnabled(true);
      }
      
      // if menu2 was pressed, exit this game
      else if (e.getSource() == menu2)
      {
         System.exit(0);
      }
      
      // if menu3 was pressed, display the help information
      else if (e.getSource() == menu3)
      {
         JOptionPane.showMessageDialog(null, "If you do not over 21 and greater than dealer, you will win.\n"
                                             + "Jack, Queen, and King are all equal to 10\n"
                                             + "Ace are either 1 or 11\n"
                                             + "\n"
                                             + "Start: start a new game\n"
                                             + "Hit: you will get another card\n"
                                             + "Stay: hold your card and finish your round\n"
                                             + "Quit: you will quit this game");
      }
      
      // if menu4 was pressed, dispaly the about information
      else if (e.getSource() == menu4)
      {
         JOptionPane.showMessageDialog(null, "BlackJack Ver 1.0\n"
                                             + "Author: Xiaomeng Cao\n"
                                             + "Contact: xiaomeng516@gmail.com");
      }
   }
}
