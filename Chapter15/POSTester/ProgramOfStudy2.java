//import java.io.IOException;
import java.io.Serializable;
import java.io.*;
import java.util.*;
import jsjf.*;

/**
 * Represents a Program of Study, a list of courses taken and planned, for an
 * individual student.
 * 
 * @author Xiaomeng Cao
 * @version 4.0
 */
 
/************************* Class Information **************************
   Title:         ProgramOfStudy2
   Author:        You
   Course:        CSC 112
   Date:          4/19/16
   Description:   Creates the methods needed to support the program of
                  study for a student
***********************************************************************

   UML Diagram for the Class:         ProgramOfStudy2

***********************************************************************
         
   variables:

      
***********************************************************************

   Methods:

   
**********************************************************************/

public class ProgramOfStudy2 implements Iterable<Course2>, Serializable
{
	private ArrayOrderedList<Course2> list;
	
	/**
	 * Constructs an initially empty Program of Study.
	 */
	public ProgramOfStudy2()
	{
		list = new ArrayOrderedList<Course2>();
	}
	
	/**
	 * Adds the specified course to the end of the course list.
	 * 
	 * @param course the course to add
	 */
	public void addCourse(Course2 course)
	{
		if (course != null)
			list.add(course);
	}
	
	/**
	 * Finds and returns the course matching the specified prefix and number.
	 * 
	 * @param prefix the prefix of the target course
	 * @param number the number of the target course
	 * @return the course, or null if not found
	 */
	public Course2 find(String prefix, int number)
	{
		for (Course2 course : list)
			if (prefix.equals(course.getPrefix()) &&
					number == course.getNumber())
				return course;

		return null;
	}
	
	/**
	 * Adds the specified course after the target course. Does nothing if
	 * either course is null or if the target is not found.
	 * 
	 * @param target the course after which the new course will be added
	 * @param newCourse the course to add
	 */
	/*public void addCourseAfter(Course target, Course newCourse)
	{
		if (target == null || newCourse == null)
			return;
		
		int targetIndex = list.indexOf(target);
		if (targetIndex != -1)
			list.add(targetIndex + 1, newCourse);
	}
   */
   
   /**
	 * returns the number of courses.
	 * 
	 * @returns the number of courses
	 */
   public int size()
   {
      return list.size();
   }
   
	/**
	 * Replaces the specified target course with the new course. Does nothing if
	 * either course is null or if the target is not found.
	 * 
	 * @param target the course to be replaced
	 * @param newCourse the new course to add
	 */
	public void removeCourse(Course2 target)  // **** remove -> removeCourse ****
	{
      if (target == null)
         return;
      else
         list.remove(target);
   }
   
   public void replace(Course2 target, Course2 newCourse)
   {
		if (target == null || newCourse == null)
			return;
         
      list.remove(target);
      System.out.println("Target removed.\n");
      list.add(newCourse);
      System.out.println("Target replaced.\n");
	}

	/**
	 * Creates and returns a string representation of this Program of Study.
	 * 
	 * @return a string representation of the Program of Study
	 */
	public String toString()
	{
		String result = "";
		for (Course2 course : list)
			result += course + "\n";
		return result;
	}
	
	/**
	 * Returns an iterator for this Program of Study.
	 * 
	 * @return an iterator for the Program of Study
	 */
	public Iterator<Course2> iterator()
	{
		return list.iterator();
	}
	
	/**
	 * Saves a serialized version of this Program of Study to the specified
	 * file name.
	 * 
	 * @param fileName the file name under which the POS will be stored
	 * @throws IOException
	 */
	public void save(String fileName) throws IOException
	{
      FileWriter fw = new FileWriter("pos.txt");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter pw = new PrintWriter(bw);

		for (Course2 course: list)
		{
			pw.println(course);
		} 
		bw.flush(); 
		bw.close(); 
	}

	/**
	 * Loads a serialized Program of Study from the specified file.
	 * 
	 * @param fileName the file from which the POS is read
	 * @return the loaded Program of Study
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ProgramOfStudy2 load(String fileName) throws IOException, ClassNotFoundException
	{
      Scanner fileScan = new Scanner(new File(fileName));
		Scanner stringScan;
      ProgramOfStudy2 pos = new ProgramOfStudy2();
      
      String record = "", prefix = "", title = "", grade = "";
      int number = 0;
      
      while(fileScan.hasNext())
      {
         record = fileScan.nextLine();
         stringScan = new Scanner (record);
         stringScan.useDelimiter("  ");
         prefix = stringScan.next();
         number = stringScan.nextInt();
         title = stringScan.nextLine();
         //grade = stringScan.next();
         //pos.addCourse(new Course2(prefix, number, title, grade));
		   pos.addCourse(new Course2(prefix, number, title));
      }
		return pos;
	}
}