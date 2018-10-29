/************************* Class Information **************************
   Title:         POSMenu2
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          4/22/16
   Description:   This program will allow the user to load, save, and 
                  modify a list of courses in a catalog with various
                  functions and attributes
***********************************************************************

   UML Diagram for Class:         POSMenu2

***********************************************************************
         
   variables:
   
      -another:         String
      -searchResult:    String
      -prefix:          String
      -name:            String
      -grade:           String
      -fileName:        String
      -prefix1:         String
      -name1:           String
      -grade1:          String

      -num:             int
      -numOfCourses:    int
      -choice:          int
      -num1:            int
      -quantity:        int
      
***********************************************************************

   Methods:
      +main           String
   
***********************************************************************

Course Management Project: Chapter 15, Programming Project #17 on p. 616. 

    a)  Modify Course.java to become Course2.java so that it implements the Comparable  
        interface.  Order the courses first by department and then by course number.
        
    b)  Modify ProgramOfStudy.java to become ProgramOfStudy2.java so that it uses
        ArrayOrderedList.java to add, and ArrayList.java to find and remove.
        ProgramOfStudy2.java will continue to support find, replace, size, save and load.
        
    c)  Modify POSTester.java to become POSTester2.java and test all capabilities.
    
    d)  Write a new program, POSMenu, to maintain a list of courses, including:
        1.  Load  10%                       6.  Find  5%
        2.  list   5%                       7.  Size  5%
        3.  Add   10%                       8.  Save 10%
        4.  Remove 5%                       9.  Quit  5%
        5.  Update 5%   
                                   
    e)  Grading Ruberic:  
         5% 1.  Basic version: Introduction - Author, program name, date, description;
        15% 2.  UML Diagrams - POSMenu.java, ProgramOfStudy2.java and Course2.java;  
        10% 3.  Program Logic - POSMenu.java.   
        10% 4.  Sample Output showing testing of all options
        50% 5.  Program works properly (This is split among d1 - d10 above)
        10% 6.  Creativity, includes GUI interface

***********************************************************************
/* Program Logic
--------------------------------------
   1) Create a new array ordered list: pos 
   2) Create a list of objects, "courses"
   3)  - MENU -
         load
         list
         add
         remove 
         update
         find
         size
         save 
         quit
         
   4) Ask user to enter choice
   
   5) Case 1 load
         - load courses from a file 
   6) Case 2 list 
         - print out list of courses 
   7) Case 3 add
         - add 'n' number of courses 
   8) Case 4 remove 
         - removes one selected course 
   9) Case 5 update 
         - update one selected course 
   10) Case 6 find 
         - find a course using prefix, course number 
   11) Case 7 size 
         - show the number of courses in catalog 
   12) Case 8 save 
         - save current course list 
   13) Case 9 quit 
         - exit program 
   
   14) allow user to repeat 
         - "Repeat? <Y> or <N>
**********************************************************************/


// import statements------------------
import java.io.*;
import java.util.*;
import javax.swing.*; 
import jsjf.*;
//------------------------------------

public class POSMenu2
{
	
	public static void main(String[] args) throws IOException
	{
      // local variables---------------
      String another="Y";
      String searchResult="";  
      String prefix, name, grade, fileName = "POS.txt";
      String prefix1, name1, grade1;
      int num, numOfCourses = 0, choice = 0;
      int num1, quantity;
      //--------------------------------
      
      ProgramOfStudy2 pos = new ProgramOfStudy2(); //creates a new ArrayOrderedList called 'pos'	
      
      while (another.equalsIgnoreCase("Y")) // executes the program while another = 'Y'
      {
          choice = Integer.parseInt (JOptionPane.showInputDialog("________________________ \n" // prints the list of courses to select from 
                   + "Course Catalog Version 1.0.0 \n"
                   + "________________________\n\n\nPlease select from the list: \n\n\n" 
                   + "1. Load \n" + "2. List \n"  
                   + "3. Add \n" + "4. Remove \n" + "5. Update \n" + "6. Find \n"
                   + "7. Size \n" + "8. Save \n" + "9. Quit \n\n\n\n") );
     
         switch(choice)
         {
             /*   Case 1: Load - This allows user to save catalog to a file */             
             case 1:
          
             try  //a try and catch to handle errors 
             {
                 pos = pos.load(fileName);   //loads a file containing a list of courses 
                 JOptionPane.showMessageDialog(null, "\t\t\t\t\t\t\t\t\n\n-- Load Successful --\n\n\t\t\t\t\t"); //tells user that the file loaded                   
             }
             catch(ClassNotFoundException e)
             {
                 JOptionPane.showMessageDialog(null, "EXCEPTION! FILE NOT FOUND"); //error message 
             }
             break;

             /*    Case 2: List - This will print out the catalog of courses for the user */
             case 2:     
                 JOptionPane.showMessageDialog(null, "________________________ \n" //prints the software version as the heading 
                 + "Course Catalog Version 1.0.0 \n"                               // along with the course catalog
                 + "________________________\n\n\n" + pos + "\n\n\n");
                 break;
              
            /*    Case 3: Add Course - Allows the user to add a course to the existing catalog  */           
            case 3: 
                quantity  = Integer.parseInt (JOptionPane.showInputDialog("How many courses would you like to add?: ")); //prompt user for number of new courses
                numOfCourses += quantity;    //increases the total number of courses by 1 every time a new course is added 
       
            while(quantity > 0) //executes loop while until 
            {
                prefix = (JOptionPane.showInputDialog("Please enter the course prefix: \n(i.e. CS, GER)\n\n")); //prompts for course prefix
                num = Integer.parseInt (JOptionPane.showInputDialog("Please enter the course number: \n(i.e. 110, 211)\n\n")); //prompts for course number
                name = (JOptionPane.showInputDialog("Please enter the course name: \n(i.e. Java I, Western Civilizations\n\n")); //prompts for course name 
                grade = (JOptionPane.showInputDialog("Please enter the course grade: \n(i.e. A, B, C\n\n")); //prompts for course grade 
                Course2 CourseNew = new Course2(prefix, num, name, grade); //creates a new course and fills it with the selected attributes 
                pos.addCourse(CourseNew); //adds the new course to the list 
                quantity--; //reduces the counter by 1 per course     
            }
            break;
 
            /*   Case 4: remove a course - Allows the user to remove a course from the catalog */ 
            case 4: 
                prefix = (JOptionPane.showInputDialog("Please enter the course prefix: \n(i.e. CS, GER)\n\n"));
                num = Integer.parseInt (JOptionPane.showInputDialog("Please enter the course number: \n(i.e. 110, 211)\n\n"));
                Course2 remove = pos.find(prefix, num); //creates a temporary object to remove 
                if (remove == null)  //if the course does not exist execute following 
                    JOptionPane.showMessageDialog(null,"Course not found! "); //tells user that the course is not part of the catolog 
                else //if course is found 
                {
                    pos.removeCourse(remove);      //removes course 
                    JOptionPane.showMessageDialog(null,"Found course and removed it.");      // Display "Found course and removed it"
                    numOfCourses--;      //decrements the number of courses 
                }           
                break;
            
            
            /*    Case 5: Update - This allows the user to change or update a courses information */    
            case 5: 
                prefix = (JOptionPane.showInputDialog("Please enter the course prefix: \n(i.e. CS, GER)\n\n"));
                num = Integer.parseInt (JOptionPane.showInputDialog("Please enter the course number: \n(i.e. 110, 211)\n\n"));
                if (pos.find(prefix, num) == null)
                    JOptionPane.showMessageDialog(null,"Course not found "); //tells user that the course is not part of catalog 
                else
                {
                    searchResult = pos.find(prefix, num).toString(); //finds the course from the catalog 
                    prefix1 = (JOptionPane.showInputDialog("Found course : \n" 
                        + searchResult 
                        + "\n\nPlease enter the updated course prefix: \n(i.e. CS, GER)\n\n")); //tells user they found course and asks for new prefix
                    num1 = Integer.parseInt (JOptionPane.showInputDialog(prefix1 
                        + " _____ " 
                        + "\n\nPlease enter the updated course number: \n(i.e. 101, 320)\n\n")); //asks for new course number        
                    name1 = (JOptionPane.showInputDialog(prefix1 
                        + " " 
                        + num1 
                        + " _________ \n\nPlease enter updated course name: \n(i.e. Intro to Java, Computer Architecture)\n\n")); //asks for updated course name         
                    grade1 = (JOptionPane.showInputDialog(prefix1 
                        + " " 
                        + num1 
                        + " " 
                        + name1 
                        + " ____ \n\nPlease enter updated course grade: \n(i.e A, B, C)\n\n")); //asks for new course grade 
                    Course2 course10 = new Course2(prefix1, num1, name1, grade1); //creates new course and gives it the new attributes 
                    pos.replace(pos.find(prefix, num), new Course2(prefix1, num1, name1, grade1)); //sets old course to empty and adds the "updated" course 
                }
                JOptionPane.showMessageDialog(null,"New updated Catalog:\n\n" + pos); // displays the new catalog w/ updated course 
                break;

            /*    Case 6: find course - Allows user to input credentials and find a course */    
            case 6:
                prefix = (JOptionPane.showInputDialog("Please enter the course prefix: \n(i.e. CS, GER)\n\n"));  // asks the user for the course prefix 
                num = Integer.parseInt (JOptionPane.showInputDialog("Please enter the course number: \n(i.e. 110, 211)\n\n"));   // asks for course number 
                if (pos.find(prefix, num)==null)
                    JOptionPane.showMessageDialog(null, "Course not found "); // if course does not exist, tells user 
                else
                {
                    searchResult = pos.find(prefix, num).toString();
                    JOptionPane.showMessageDialog(null, "Found class: \n\n" + searchResult); // if course exists, shows user the attributes 
                }
                break;
            
            
            /*     Case 7: Size - Displays the number of courses */
            case 7:
               JOptionPane.showMessageDialog(null,pos.size());  //shows the number of courses in the catalog      
               break;
      
            /*     Case 8: - Allows user to save the catalog */   
            case 8:   
                fileName = "POS.txt";  //sets the name of the file to be saved 
                pos.save(fileName);  //saves the file 
                JOptionPane.showMessageDialog(null, "File saved successful.");  //tells user the file saved 
                break;
       
            /*     Case 9: - Allows user to quit the program */
            case 9: 
               another = "N"; //sets the exit value, another, equal to 'N' so loop terminates
               break; 
              
        } //ends switch
      } // end continue while 			
	} // end main 
}  //end class 