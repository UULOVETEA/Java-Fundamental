//********************************************************************
//  OutOfRangeException.java       Java Foundations
//  Xiaomeng Cao
//  Represents an exceptional condition when the length greater than 20
//********************************************************************

public class OutOfBoundsException extends Exception
{
   //-----------------------------------------------------------------
   //  Sets up the exception object with a particular message.
   //-----------------------------------------------------------------
	OutOfBoundsException(String message)
	{
      // Display massage
		super(message);
	}
}