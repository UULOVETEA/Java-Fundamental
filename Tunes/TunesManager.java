/********************************************************************
* Program Name: TunesManager.java
* Author: Xiaomeng Cao
* Date: February 11, 2016
* Course/Section: CSC 112-001
* Program Description:
*     This program can manages a CD collection
********************************************************************/

//imports
import java.util.Scanner;
import java.io.*;


public class TunesManager
{ 
   // declare data types for title, artist, value and tracks
   public static String title;
   public static String artist;
   public static double value;
   public static int tracks;
      
   // create a Scanner object called scan for keyboard input
   public static Scanner scan = new Scanner(System.in);

   public static void main (String[] args) throws Exception //Begin Main Method
   {   
      // create a CDCollection object called music
      CDCollection music = new CDCollection ();
         
      // declare an integer called selection = 0
      int selection = 0;
     
      // set up do-while loop for displaying and performing the management selections
      do
      {
      //CDCollection music = new CDCollection ();
         // call the menu() method and return the selection
         selection = menu();
   
         // use switch-case structure to perform the various selection choices
         switch (selection)
         {
            case 1:
                // read the contents of a disc file into ram memory
                music.scannerReadFile();
                System.out.println(music);
                break;
            case 2:
                // add a CD to the collection of cd's in ram memory
                System.out.println("CD to be added to collection:");
                enterCD();
                music.addCD (title, artist, value, tracks);
                break;
            case 3:
                // delete a CD from ram memory, if it exists
                scan.nextLine();
                System.out.print("Title to be deleted: ");
                title = scan.nextLine();
                music.subCD (title);
                break;
            case 4:
                // update a CD with one or more corrections
                // the key search field, title, may not be changed
                System.out.println("CD to be updated:");
                enterCD();
                music.updCD (title, artist, value, tracks);
                break;
            case 5:
                // sort by title
                music.titleBubbleSort();
                System.out.println(music);
                break;
            case 6:
                // sort by artist
                music.artistBubbleSort();
                System.out.println(music);
                break;
            case 7:
                // Find a single CD, if it exists, and display it
                // sort first by the search key; i.e. title or artist
                scan.nextLine();
                System.out.print("Title to be found: ");
                title = scan.nextLine();
                CD found = music.binarySearch (title);
                if (found == null)
                    System.out.println("\nNo such title found\n");
                else 
                    System.out.println(found);
                break;                 
            case 8:
                // display the entire music collection
                System.out.println(music);
                break;
            case 9:
                // Write the music collection to a file
                music.writeToFile();
                // If there is no file, it will be created
                File f = new File("CDCollection.txt");
                if(!f.exists())
                  System.out.println ("There is no file, it will be created.");
                // If there is an existing file, it will be overwritten
                else
                  System.out.println ("There is an existing file, it will be overwritten.");
                break;
            case 10:
                // Exit	
         }
      }
      // end of while loop
      while (selection != 10);
   }
 
   public static void enterCD()
   {
      // enter title, artist, value and tracks
      scan.nextLine();
      System.out.print("Title: ");
      title = scan.nextLine();
      
      System.out.print("Artist: ");
      artist = scan.nextLine();
      
      System.out.print("Value: ");
      value = scan.nextDouble();
      
      System.out.print("Tracks: ");
      tracks = scan.nextInt();
   }

   public static int menu()
   {
      // display menue, get and return menu choice
      System.out.println ("\n\n\nSelect from the following:  \n");
	   System.out.println ("1. Read from file\n");
		System.out.println ("2. Enter new CD\n");
		System.out.println ("3. Delete a CD\n");
		System.out.println ("4. Update a CD\n");
      System.out.println ("5. Sort by Title\n");
		System.out.println ("6. Sort by Artist\n");
		System.out.println ("7. Display a specific CD title\n");
      System.out.println ("8. Display all CD's\n");
		System.out.println ("9. Write to File\n");
		System.out.println ("10. Exit\n\n");
      
      int selection = scan.nextInt();
      return selection;
      
   }
}

/*
Menu
1.  Read from file
2.  Enter new CD
3.  Delete a CD
4.  Update a CD
5.  Sort by Title
6.  Sort by Artist
7.  Display a specific CD title
8.  Display all CD's
9.  Write to File
10. Exit
*/