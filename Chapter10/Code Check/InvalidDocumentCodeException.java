//********************************************************************
//  InvalidDocumentCodeException.java       Java Foundations
//  Xiaomeng Cao
//  Represents an exceptional condition when the first character is
//  not C, U, or P
//********************************************************************

public class InvalidDocumentCodeException extends Exception
{
   //-----------------------------------------------------------------
   //  Sets up the exception object with a particular message.
   //-----------------------------------------------------------------
	InvalidDocumentCodeException(String message)
	{
      // Display massage 
		super(message);
	}
}