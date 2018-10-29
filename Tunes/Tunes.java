//********************************************************************
//  Tunes.java       Author: Xiaomeng Cao
//
//  Demonstrates the use of an array of objects.
//********************************************************************

public class Tunes
{
   //-----------------------------------------------------------------
   //  Creates a CDCollection object and adds some CDs to it. Prints
   //  reports on the status of the collection.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      CDCollection music = new CDCollection ();

      music.addCD ("Storm Front", "Billy Joel", 14.95, 10);
      music.addCD ("Come On Over", "Shania Twain", 14.95, 16);
      music.addCD ("Soundtrack", "Les Miserables", 17.95, 33);
      music.addCD ("Graceland", "Paul Simon", 13.90, 11);

      System.out.println (music);

      music.addCD ("Double Live", "Garth Brooks", 19.99, 26);
      music.addCD ("Greatest Hits", "Jimmy Buffet", 15.95, 13);

      System.out.println (music);

      music.subCD ("Double Live");
      System.out.println (music);

      music.updCD ("Greatest Hits", "Jimmy Buffett", 9.99, 16);
      System.out.println (music);

      music.titleBubbleSort();
      System.out.println (music);

      music.artistBubbleSort();
      System.out.println (music);

      System.out.println("Searching for a title");
      music.titleBubbleSort(); 
      System.out.println(music.binarySearch("Storm Front"));

      System.out.println("\nSearching for a title");
      music.titleBubbleSort(); 
      System.out.println(music.binarySearch("Stormm Front"));
      
      System.out.println("\nSearching sequentially for an artist");
      System.out.println(music.sequentialSearch("Paul Simon"));

      System.out.println("\nSearching sequentially for an artist");
      System.out.println(music.sequentialSearch("Rand Paul"));

      System.out.println("\nWriting to file named CDCollection.txt"); // add
      music.writeToFile();

      System.out.println("Reading the file named CDCollection.txt"); // add
      System.out.println(music);
      
   }
}

/*    OUTPUT
My CD Collection

___________________________________________________

Number of CD's:  4
Total Cost:  $61.75
Average Cost:  $15.44

CD List:

$14.95    10        Storm Front      Billy Joel
$14.95    16        Come On Over     Shania Twain
$17.95    33        SoundTrack       Les Miserables
$13.90    11        Graceland        Paul Simon

My CD Collection

___________________________________________________

Number of CD's:  6
Total Cost:  $97.69
Average Cost:  $16.28

CD List:

$14.95    10        Storm Front      Billy Joel
$14.95    16        Come On Over     Shania Twain
$17.95    33        SoundTrack       Les Miserables
$13.90    11        Graceland        Paul Simon
$19.99    26        Double Live      Garth Brooks
$15.95    13        Greatest Hits    Jimmy Buffet
*/