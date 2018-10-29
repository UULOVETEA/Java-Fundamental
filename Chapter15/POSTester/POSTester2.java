import java.io.IOException;
import jsjf.*;

/**
 * Demonstrates the use of a list to manage a set of objects.
 * 
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class POSTester2
{
	/**
	 * Creates and populates a Program of Study. Then saves it using serialization.
	 */
	public static void main(String[] args) throws IOException
	{
		ProgramOfStudy2 pos = new ProgramOfStudy2();
		
		pos.addCourse(new Course2("CS", 101, "Introduction to Programming", "A-"));
		pos.addCourse(new Course2("ARCH", 305, "Building Analysis", "A"));
		pos.addCourse(new Course2("GER", 210, "Intermediate German"));
		pos.addCourse(new Course2("CS", 320, "Computer Architecture"));
		pos.addCourse(new Course2("THE", 201, "The Theatre Experience"));
		
		Course2 arch = pos.find("CS", 320);
		//pos.addCourseAfter(arch, new Course2("CS", 321, "Operating Systems"));
   		
		Course2 theatre = pos.find("THE", 201);
		theatre.setGrade("A-");
		
		Course2 german = pos.find("GER", 210);
		pos.replace(german, new Course2("FRE", 110, "Beginning French", "B+"));

		System.out.println(pos);
		
		pos.save("ProgramOfStudy");		
	}
}