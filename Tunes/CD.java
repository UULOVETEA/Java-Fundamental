//********************************************************************
//  CD.java       Author: Xiaomeng Cao
//
//  Represents a compact disc.
//********************************************************************

import java.text.NumberFormat;

public class CD
{
   private String title, artist;
   private double value;
   private int tracks;

   //-----------------------------------------------------------------
   //  Creates a new CD with the specified information.
   //-----------------------------------------------------------------
   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      value = price;
      tracks = numTracks;
   }

   //-----------------------------------------------------------------
   //  Returns a string description of this CD.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String description;

      description = fmt.format(value) + "\t" + tracks + "\t";
      description += title + "\t\t" + artist;

      return description;
   }

   //-----------------------------------------------------------------
   // Returns title
   //-----------------------------------------------------------------
   public String getTitle()
   {
      return title;
   }

   //-----------------------------------------------------------------
   // Returns artist
   //-----------------------------------------------------------------
   public String getArtist()
   {
      return artist;
   }

   //-----------------------------------------------------------------
   // Returns value
   //-----------------------------------------------------------------
   public double getValue()
   {
      return value;
   }

   //-----------------------------------------------------------------
   // Returns tracks
   //-----------------------------------------------------------------
   public int getTracks()
   {
      return tracks;
   }

   //-----------------------------------------------------------------
   // Set Title
   //-----------------------------------------------------------------
   public void setTitle(String cdTitle)
   {
      title = cdTitle;
   }

}