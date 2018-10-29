import java.util.Scanner;

/**
 * Demonstrates the use of a stack to evaluate postfix expressions.
 *
 * @author Xiaomeng Cao
 * @version 4.0
 */
public class PostfixTester3
//-------------------------------------
// To Compile:  javac PostfixTester.java
//-------------------------------------    
{
    /**
     * Reads and evaluates multiple postfix expressions.
     */
    public static void main(String[] args)
    {
        String expression, again;
        int result;
    
        Scanner in = new Scanner(System.in);
      
        do
        {  
            PostfixEvaluator3 evaluator = new PostfixEvaluator3();
            System.out.println("Enter a valid post-fix expression one token " +
                "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer or an operator (+,-,*,/)");
            expression = in.nextLine();

            result = evaluator.evaluate(expression);
            System.out.println();
            System.out.println("That expression equals " + result);

            System.out.print("Evaluate another expression [Y/N]? ");
            again = in.nextLine();
            System.out.println();
        }
        while (again.equalsIgnoreCase("y"));
   }
}

/*
Enter a valid post-fix expression one token at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)
Each token must be an integer or an operator (+,-,*,/)
3 4 5 * 6 / +

That expression equals 6
Evaluate another expression [Y/N]? y

Enter a valid post-fix expression one token at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)
Each token must be an integer or an operator (+,-,*,/)
5 4 + 3 2 1 - + *

That expression equals 36
Evaluate another expression [Y/N]? y

Enter a valid post-fix expression one token at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)
Each token must be an integer or an operator (+,-,*,/)
300 23 + 43 21 - * 84 7 + /

That expression equals 78
Evaluate another expression [Y/N]? n
*/ 