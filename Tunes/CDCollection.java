//********************************************************************
//  CDCollection.java       Author: Xiaomeng Cao
//
//  Represents a collection of compact discs.
//********************************************************************

import java.text.NumberFormat;
import java.io.*;
import java.util.Scanner;


public class CDCollection
{
   private CD[] collection;
   private int count;
   private double totalValue;
   private int currentSize;

   //-----------------------------------------------------------------
   //  Constructor: Creates an initially empty collection.
   //-----------------------------------------------------------------
   public CDCollection ()
   {
      currentSize = 100;
      collection = new CD[currentSize];
      count = 0;
      totalValue = 0.0;
   }

   //-----------------------------------------------------------------
   //  Adds a CD to the collection, increasing the size of the
   //  collection if necessary.
   //-----------------------------------------------------------------
   public void addCD (String title, String artist, double value,
                      int tracks)
   {
      if (count == currentSize)
         increaseSize();

      collection[count] = new CD (title, artist, value, tracks);
      totalValue += value;
      count++;
   }

   //-----------------------------------------------------------------
   //  Returns a report describing the CD collection.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
      report += "My CD Collection\n\n";

      report += "Number of CDs: " + count + "\n";
      report += "Total cost: " + fmt.format(totalValue) + "\n";
      report += "Average cost: " + fmt.format(totalValue/count);

      report += "\n\nCD List:\n\n";

      for (int cd = 0; cd < count; cd++)
         report += collection[cd].toString() + "\n";

      return report;
   }

   //-----------------------------------------------------------------
   //  Increases the capacity of the collection by creating a
   //  larger array and copying the existing collection into it.
   //-----------------------------------------------------------------
   private void increaseSize ()
   {
      CD[] temp = new CD[collection.length * 2];

      for (int cd = 0; cd < collection.length; cd++)
         temp[cd] = collection[cd];

      collection = temp;
      System.out.println ("CDcollection has been incrased.");
   }

   //-----------------------------------------------------------------
   //  Deletes a CD from the collection
   //-----------------------------------------------------------------
   public void subCD(String title)
   {
      // j will count the number of CD's in the newly sized collection
      int j = 0;
      // i will count the current number of CD's
      int i;
      // create a temporary array of CD objects
      // which will become the newly sized collection
      CD [] temp = new CD[currentSize];

      for(i=0; i<count; i++)
      {
         // look for a match
         if(title.compareTo(collection[i].getTitle()) != 0)
         {
            // if there is no match, copy from the old to the new
            temp[j] = collection[i];
            j++;
         }
         else
         {
            // if there is a match, do not copy from the old to the new
            // but update the total value
            totalValue -= collection[i].getValue();
         }
      }

      // check to see if there was a match and a deletion from the collection
      if (i != j)
      {
          count--;
          System.out.println("\nCD deleted\n");
          collection = temp;
      }
      else
          System.out.println("\nCD not found\n");

   }

   //-----------------------------------------------------------------
   //  Updates a CD from the collection
   //-----------------------------------------------------------------

   public void updCD(String title, String artist, double value, int tracks)
   {
      // i will count the number of CD's in the collection
      int i;
      // flag will tell if a match has been found
      int flag = 0;
      // temp will become the new CD collection
      CD [] temp = new CD[currentSize];

      for(i=0; i<count; i++)
      {
         // look for a match
         if(title.compareTo(collection[i].getTitle()) != 0)
         {
            // if there is no match, copy from the old to the new
            temp[i] = collection[i];
         }
         else
         {
            // if there is a match, replace the current CD
            // with the updated fields and correct the value
            temp[i] = new CD (title, artist, value, tracks);
            totalValue -= collection[i].getValue();
            totalValue += value;
            // set the flag which indicates a change has happened
            flag = 1;
         }
      }

      // check if an update has taken place
      if (flag == 1)
      {
          System.out.println("\nCollection Updated\n");
          collection = temp;
      }
      else
          System.out.println("\nCD not found\n");

   }

   //-----------------------------------------------------------------
   //  Use Bubble Sort to sort by title
   //-----------------------------------------------------------------
   public void titleBubbleSort()
   {
      CD temp;
      for(int i=0; i<=count-2; i++)
         for(int j=i+1; j<=count-1; j++)
            if (collection[i].getTitle().compareTo(collection[j].getTitle())>0)
            {
               temp = collection[i];
               collection[i] = collection[j];
               collection[j] = temp;
            }
      System.out.println("The titles are in alphabetical order");
   }

   //-----------------------------------------------------------------
   //  Use Bubble Sort to sort by aritst
   //-----------------------------------------------------------------
   public void artistBubbleSort()
   {
      CD temp;
      for(int i=0; i<=count-2; i++)
         for(int j=i+1; j<=count-1; j++)
            if (collection[i].getArtist().compareTo(collection[j].getArtist())>0)
            {
               temp = collection[i];
               collection[i] = collection[j];
               collection[j] = temp;
            }
      System.out.println("The artists are in alphabetical order");
   }

   //-----------------------------------------------------------------
   //  Use a binary search to find a specific CD
   //-----------------------------------------------------------------

   public CD binarySearch(String targetTitle)
   {
      int min=0;                          // lowest position for search range
      int max=count-1;                    // highest position for search range
      int mid=0;                          // middle position for search range
      boolean found = false;              // boolean variable tells if title found

      //  loop looks for a match or min > max
      while (!found && min <= max)
      {
         // calculate middle position in the range
         mid = (min+max)/2;
         // compare the title entered to the title of the mid position CD
         if(collection[mid].getTitle().compareTo(targetTitle) == 0)
            found = true;                // we have a match - found is true
         else if (collection[mid].getTitle().compareTo(targetTitle) > 0)
            max = mid-1;                // too high, use max 1 lower than mid
         else
            min = mid+1;                // too low, use min 1 higher than mid
      }

      // determine if there was a match
      if (found) 
         return collection[mid];         // if so, return the CD that matches
      else 
         return null;                    // if not, return an empty CD object
   }

   //-----------------------------------------------------------------
   //  Use a sequential search to find a specific CD
   //-----------------------------------------------------------------

   public CD sequentialSearch(String targetArtist)
   {
	   boolean found = false;
	   int counter = 0;

	   System.out.println("Sequential search by Artist");

	   while(!found && counter < count)
	   {
		   if(collection[counter].getArtist().compareTo(targetArtist) == 0)
		   {
			   found = true;
			   System.out.println("Sequential search is successful");
			   return collection[counter];
		   }
		   else
		      counter++;
       }
       if(found)
         return collection[counter];
       else
         return null;
	}  
      
   // ------------------------------------------------------
   //  Write to a file named "CDCollection.txt"
   // ------------------------------------------------------  
      
   public void writeToFile()
   {      
       // Try to write to a file
       try 
       {
          // create a file writer object called fw which will overlay any existing data
          FileWriter fw = new FileWriter("CDCollection.txt", false);
          // create a file buffered writer object called bw 
          // in which to place what will be written to the disc
          BufferedWriter bw = new BufferedWriter (fw);
          // String s will contain one CD
          String s;
          for(int i=0; i<count; i++)
          {
              // create a string S composed of fields separated by / character
	           s = "";
              s += collection[i].getTitle() + "/";
              s += collection[i].getArtist() + "/";
              s += collection[i].getValue() + "/";
              s += collection[i].getTracks() + "\r\n";
              // write the string containing one CD object to the write buffer
              bw.write (s);
          }
          // Transfer a partially filled buffer to the disc
          bw.flush();
          // Close the file (also emptys the buffer)
          bw.close();
          System.out.println("Write to file is complete\n");
       }
       
       // If there is an file IO error, display why it occurred
       catch(IOException e)
       {
          e.printStackTrace();
       }
   }

   //----------------------------------------------------------------
   //  Read a file named CDCollection.txt
   //----------------------------------------------------------------
   
   public void scannerReadFile()
   {
       // Try to read a file
       try 
       {
          Scanner fileScan, recordScan;
          
          // create the working data items
          String title, artist, record;
          double value;
          int tracks;
          count = 0;
          totalValue = 0.0;
          
          fileScan = new Scanner(new File("CDCollection.txt"));
          
          // outside loop to read consecutive CD's until all are read
          while((fileScan.hasNext()))
          {
             // each field of record is separated from the other by the | character
             record = fileScan.nextLine();
             //System.out.println("Record - "+record);
             recordScan = new Scanner(record);
             recordScan.useDelimiter("/");
             
             while (recordScan.hasNext())
             {
                 title = recordScan.next();
                    //System.out.println("Title - " + title);
                 artist = recordScan.next();
                    //System.out.println("Artist - " + artist);
                 value = recordScan.nextDouble();
                    //System.out.println("Value - " + value);
                 tracks = recordScan.nextInt();
                    //System.out.println("Tracks - " + tracks);
             
                 // create a CD object composed of the tokens just read
                 collection[count] = new CD (title, artist, value, tracks);
                 // update the totalValue and count
                 totalValue += value;
                 count++;
             }
          }
          if (currentSize == 0) 
             currentSize = 100;
          if (count >= currentSize)
             increaseSize(); 
          fileScan.close();
       }
       // If there is an file IO error, display why it occurred
       catch(IOException e)
       {
          e.printStackTrace();
       }       
   }            
}

