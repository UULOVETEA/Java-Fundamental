//******************************************************************************
//  ShapeTester.java       Java Foundations
//  Xiaomeng Cao
//  Description: This program will scan Shaper.dat to get the data of shape, then
//               it will calculate every shape and print the results.
//  Solution to Programming Project 8.6
//******************************************************************************

import java.io.*;
import java.util.*;

public class ShapeTester
{
   //---------------------------------------------------------------------------
   //  Read the dimensions of various 3-D shapes from an input file, then
   //  displays pertinent information about each shape.
   //---------------------------------------------------------------------------
   public static void main (String[] args) throws IOException
   {
      Scanner scan = new Scanner (new File("Shapes.dat"));
      double width, length, height, side, radius;
   
      // Read the data from the input file
      while (scan.hasNext()) 
      {
         String shapeType = scan.next();
      
         if (shapeType.equalsIgnoreCase("prism"))
         {
            width = scan.nextDouble();
            length = scan.nextDouble();
            height = scan.nextDouble();
            System.out.println (new Prism (width, length, height));
         }
         else if (shapeType.equalsIgnoreCase("pentahedron"))
         {
            width = scan.nextDouble();
            length = scan.nextDouble();
            height = scan.nextDouble();
            System.out.println (new Pentahedron (width, length, height));
         }  
         else if (shapeType.equalsIgnoreCase("tetrahedron"))
         {
            side = scan.nextDouble();
            height = scan.nextDouble();
            System.out.println (new Tetrahedron (side, height));
         }
         else if (shapeType.equalsIgnoreCase("circle"))
         {
            radius = scan.nextDouble();
            System.out.println (new Circle (radius));
         }
         else if (shapeType.equalsIgnoreCase("cylinder"))
         {
            radius = scan.nextDouble();
            height = scan.nextDouble();
            System.out.println (new Cylinder (radius, height));
         }
         else if (shapeType.equalsIgnoreCase("sphere"))
         {
            radius = scan.nextDouble();
            System.out.println (new Sphere (radius));
         }

         else if (shapeType.equalsIgnoreCase("rectangle"))
         {
            width = scan.nextDouble();
            length = scan.nextDouble();
            System.out.println (new Rectangle (width, length));
         }
         
         else if (shapeType.equalsIgnoreCase("triangle"))
         {
            side = scan.nextDouble();
            System.out.println (new Triangle (side));
         }
      }
   }
}