//******************************************************************************
//  Sphere.java       Java Foundations
//  Xiaomeng Cao
//  Solution to Programming Project 8.6
//******************************************************************************

import java.text.*;

public class Sphere extends Circle
{
   //---------------------------------------------------------------------------
   //  Sets up the Cylinder by entering the length of a radius.
   //---------------------------------------------------------------------------
   public Sphere (double rad)
   {
      super(rad);
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the Area.
   //---------------------------------------------------------------------------
   public double computeArea()
   {
      // 4*pi*radius*radius = 4*Super.getSurfaceArea();
      return 4 * super.computeArea();
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the volume.
   //---------------------------------------------------------------------------
   public double computeVolume()
   {
      // 4.0/3.0*pi*radius*radius*radius = computeArea()*radius/3.0
      return computeArea() * radius / 3.0;
   }
   
   //---------------------------------------------------------------------------
   //  Returns pertinent information about the Cylinder.
   //---------------------------------------------------------------------------
   public String toString()
   {
       return "Sphere: radius is " + form.format(radius) +
	           "\n        perimeter is " + form.format(super.computePerimeter()) +
	           "\n        surface area is " + form.format(computeArea()) +
              "\n        volume is " + form.format(computeVolume()) + "\n";
   }
   
}