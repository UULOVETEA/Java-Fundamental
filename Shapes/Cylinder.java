//******************************************************************************
//  Cylinder.java       Java Foundations
//  Xiaomeng Cao
//  Solution to Programming Project 8.6
//******************************************************************************

import java.text.*;

public class Cylinder extends Circle
{
   //protected final double PI = 3.14159;
   //protected double radius
   //protected static DecimalFormat form = new DecimalFormat("0.##");
   protected double height;
   
   //---------------------------------------------------------------------------
   //  Sets up the Cylinder by entering the length of a radius.
   //---------------------------------------------------------------------------
   public Cylinder (double rad, double hei)
   {
      super(rad);
      height = hei;
   }

   //---------------------------------------------------------------------------
   //  Returns the double value of the height of the Cylinder.
   //---------------------------------------------------------------------------
   public double getHeight()
   {
      return height;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the SurfaceArea.
   //---------------------------------------------------------------------------
   public double computeArea()
   {
      // 2*pi*radius*radius + 2*pi*radius*height
      return 2 * super.computeArea() + super.computePerimeter() * height;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the volume.
   //---------------------------------------------------------------------------
   public double computeVolume()
   {
      // volume = height*pi*radius*radius = height*computeArea()
      return height * super.computeArea();
   }
   
   //---------------------------------------------------------------------------
   //  Returns pertinent information about the Cylinder.
   //---------------------------------------------------------------------------
   public String toString()
   {
        return "Cylinder: radius is " + form.format(super.radius) +
                "\n          height is " + form.format(height)  + 
                "\n          perimeter of base is " + form.format(super.computePerimeter()) + 
                "\n          surface area is " + form.format(computeArea()) +
                "\n          volume is " + form.format(computeVolume()) + "\n";
   }
   
}