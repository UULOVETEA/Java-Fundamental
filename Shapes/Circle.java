//******************************************************************************
//  Circle.java       Java Foundations
//  Xiaomeng Cao
//  Solution to Programming Project 8.6
//******************************************************************************

import java.text.*;

public class Circle extends Shape
{
   protected final double PI = 3.14159;
   protected double radius;
   protected static DecimalFormat form = new DecimalFormat("0.##");

   //---------------------------------------------------------------------------
   //  Sets up the circle by entering its radius
   //---------------------------------------------------------------------------
   public Circle(double rad)
   {
      radius = rad;
   }

   //---------------------------------------------------------------------------
   //  Returns the double value of the radius.
   //---------------------------------------------------------------------------
   public double getRadius()
   {
      return radius;
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the area.
   //---------------------------------------------------------------------------
   public double computeArea()
   {
      // pi*radius*radius
      return PI * Math.pow(radius, 2);
   }

   //---------------------------------------------------------------------------
   //  Returns the calculated value of the perimeter.
   //---------------------------------------------------------------------------
   public double computeDiameter()
   {
      // 2*radius
      return radius * 2;
   }
   
   //---------------------------------------------------------------------------
   //  Returns the calculated value of the perimeter.
   //---------------------------------------------------------------------------
   public double computePerimeter()
   {
      // 2*pi*radius
      return 2 * PI * radius;
   }

   //---------------------------------------------------------------------------
   //  Returns pertinent information about the rectangle.
   //---------------------------------------------------------------------------
   public String toString()
   {
      return "Circle: radius is " + form.format(radius) + 
             "\n        diameter is " + form.format(computeDiameter()) +
             "\n        perimeter is " + form.format(computePerimeter()) +
             "\n        area is " + form.format(computeArea()) + "\n";
   }
   
}
