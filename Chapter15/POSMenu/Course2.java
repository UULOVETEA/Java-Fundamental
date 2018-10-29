import java.io.Serializable;
import jsjf.*;

/**
 * Represents a course that might be taken by a student.
 * 
 * @author Xiaomeng Cao
 * @version 4.0
 */
 
/************************* Class Information **************************
   Title:         Course2
   Author:        Xiaomeng Cao
   Course:        CSC 112
   Date:          4/14/16
   Description:   Management user helper class for Program of Study
***********************************************************************

   UML Diagram for Class:         Course2

***********************************************************************
         
   variables:
   
      -prefix:    String
      -number:    int
      -title:     String
      -grade:     String
      
***********************************************************************

   Methods:
      +Course2(String prefix, int number, String title, String grade)
      +Course2(String prefix, int number, String title)
      +getPrefix():        String
      +getNumber():        int
      +getTitle():         String
      +getGrade():         String
      +setPrefix(String):  void
      +setNumber(int):     void
      +setTile(String):    void
      +setGrade(String):   void
      +taken():            boolean
      +equals(Object):     boolean
      +toString:           String
   
**********************************************************************/
              
public class Course2 implements Serializable,Comparable <Course2>
{
	private String prefix;
	private int number;
	private String title;
	private String grade;
	
	/**
	 * Constructs the course with the specified information.
	 * 
	 * @param prefix the prefix of the course designation
	 * @param number the number of the course designation
	 * @param title the title of the course
	 * @param grade the grade received for the course
	 */
	public Course2(String prefix, int number, String title, String grade)
	{
		this.prefix = prefix;
		this.number = number;
		this.title = title;
		if (grade == null)
			this.grade = "";
		else
			this.grade = grade;
	}
	
	/**
	 * Constructs the course with the specified information, with no grade
	 * established.
	 * 
	 * @param prefix the prefix of the course designation
	 * @param number the number of the course designation
	 * @param title the title of the course
	 */
	public Course2(String prefix, int number, String title)
	{
		this(prefix, number, title, "");
	}

	/**
	 * Returns the prefix of the course designation.
	 * 
	 * @return the prefix of the course designation
	 */
	public String getPrefix()
	{
		return prefix;
	}
	
	/**
	 * Returns the number of the course designation.
	 * 
	 * @return the number of the course designation
	 */
	public int getNumber()
	{
		return number;
	}
	
	/**
	 * Returns the title of this course.
	 * 
	 * @return the prefix of the course
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Returns the grade for this course.
	 * 
	 * @return the grade for this course
	 */
	public String getGrade()
	{
		return grade;
	}
   
   // student setPrefix, setNumber, setTitle
	
	/**
	 * Sets the grade for this course to the one specified.
	 * 
	 * @param grade the new grade for the course
	 */
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Returns true if this course has been taken (if a grade has been received).
	 * 
	 * @return true if this course has been taken and false otherwise
	 */
	public boolean taken()
	{
		return !grade.equals("");
	}
	
	/**
	 * Determines if this course is equal to the one specified, based on the
	 * course designation (prefix and number).
	 * 
	 * @return true if this course is equal to the parameter
	 */
	public boolean equals(Object other)
	{
		boolean result = false;
		if (other instanceof Course2)
		{
			Course2 otherCourse = (Course2) other;
			if (prefix.equals(otherCourse.getPrefix()) &&
					number == otherCourse.getNumber())
				result = true;
		}
		return result;
	}
   
	/**
	 * Determines if this course is equal to the one specified, based on the
	 * course designation (prefix and number).
	 * 
	 * @return true if this course is equal to the parameter
	 */
    
    public int compareTo(Course2 other) //****Added****
    {
      int result = 0;
      result = prefix.compareTo(other.getPrefix());
      if(result == 0)
         result = number - other.getNumber();
      return result;
    }   
	
	/**
	 * Creates and returns a string representation of this course.
	 * 
	 * @return a string representation of the course
	 */
	public String toString()
	{
		String result = prefix + "  " + number + "  " + title;
		if (!grade.equals(""))
			result += "  " + grade + "  ";
		return result;
	}
}