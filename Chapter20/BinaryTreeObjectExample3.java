// Author & Date: Xiaomeng Cao & 5/9/2016
// Program Name: BinaryTreeObjectExample3
// Description: Add contact (firstName, lastName, phone) in the myTree, and traverse myTree 
//              using 3 methods, then uer can search and delete it.

import java.util.Scanner;

public class BinaryTreeObjectExample3 
{
    // Static variables, objects, etc
    static Contact friend = new Contact("firstName", "lastName", "phone");
    static String firstName, lastName, phone;
    static Scanner scan = new Scanner (System.in);
    
    public static void main(String[] args)
    {
        // local variables, objects, etc
        BinaryTree<Contact> myTree = new BinaryTree<Contact>();
        Contact[] friends = new Contact[10];
        int count, additions;
        String yes;
        boolean goAgain = true;
        
        // Go again loop
        while(goAgain)
        {
            // Clear myTree from previous run
            myTree.clearTree();
            
            // Show that it is empty
            if (myTree.isEmpty())
                System.out.println("The myTree is empty");
            else
                System.out.println("The myTree is not empty");

            // seed the myTree with 7 contacts and insert them
            friends[0] = new Contact("John", "Smith", "610-555-7384");
            friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
            friends[2] = new Contact("Mark", "Riley", "733-555-2969");
            friends[3] = new Contact("Laura", "Getz", "663-555-3984");
            friends[4] = new Contact("Larry", "Smith", "464-555-3489");
            friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
            friends[6] = new Contact("Marsha", "Grant", "243-555-2837");
            count = 7;

            // insert each Contact into the myTree
            for (int i = 0;i<count;i++)
                myTree.insertNode(friends[i]);

            // Add at least 1 additional contact
            System.out.print("How many contacts do you wish to add to the myTree? "); 
            additions = scan.nextInt();
            scan.nextLine();
            
            for (int i = 1;i <= additions;i++)
            {           
                System.out.println("\nEnter #" + i);
                myTree.insertNode(EnterFullContact());
            }
              
            // Traverse myTree using 3 methods            
            System.out.println("\nInOrder Transversal");
            myTree.displayInOrder();
            System.out.println("\nPreOrder Transversal");
            myTree.displayPreOrder();
            System.out.println("\nPostOrder Transversal");
            myTree.displayPostOrder();     
            System.out.println("\nUsing toString");
            System.out.println(myTree.toString());	
		
		      // show that the myTree is not empty
            if (myTree.isEmpty())
                System.out.println("The myTree is empty");
            else
                System.out.println("The myTree is not empty");

            // Show the height of the myTree, size of the myTree and the # of leaves			
            System.out.println("Tree height is " + myTree.height());
            System.out.println("Size of myTree is " + myTree.size());	
            System.out.println("The number of leaves is " + myTree.numLeaf());          

            // Search the myTree for a node            
            System.out.println("\nFind which node in the myTree? ");              
            friend = EnterPartialContact();
            // Search the myTree if the friend is present or not present (true or false)
            System.out.println(friend + " is in this myTree is " + myTree.search(friend));

            // Delete a node from the myTree             
            System.out.println("\nDelete which node in the myTree? ");
            friend = EnterPartialContact();
            // remove the friend from the myTree
            myTree.remove(friend);
            System.out.println(friend + " has been processed, check to see if it has been removed.");                
            System.out.println("\nInOrder Transversal");    
            myTree.displayInOrder();

            // Go Again?
            System.out.println("\nGo Again (y/n)? ");
            yes = scan.next();
            if (yes.charAt(0)=='y') goAgain = true;
            else goAgain = false;
        }
    }
    
    // Enter all the fields of a Contact object
    public static Contact EnterFullContact()
    { 
        System.out.print("First name: ");
        firstName = scan.nextLine();           
        System.out.print("Last name: ");
        lastName = scan.nextLine();
        System.out.print("Phone number: ");
        phone = scan.nextLine();
        friend = new Contact(firstName, lastName, phone);
        return friend;
    }
    
    // Enter only the fields necessary for searching
    public static Contact EnterPartialContact()
    {
        System.out.print("First name: ");
        firstName = scan.nextLine();
        System.out.print("Last name: ");
        lastName = scan.nextLine();
        friend = new Contact(firstName, lastName, "");
        return friend;
    }
}

/************************** SAMPLE OUTPUT *****************************
The myTree is empty
How many contacts do you wish to add to the myTree? 2

Enter #1
First name: Margory
Last name: Riley
Phone number: 012-345-6789

Enter #2
First name: Sam
Last name: Grant
Phone number: 123-456-7890

InOrder Transversal
Barnes, Sarah	215-555-3827
Getz, Laura	663-555-3984
Grant, Marsha	243-555-2837
Grant, Sam	123-456-7890
Phelps, Frank	322-555-2284
Riley, Margory	012-345-6789
Riley, Mark	733-555-2969
Smith, John	610-555-7384
Smith, Larry	464-555-3489

PreOrder Transversal
Smith, John	610-555-7384
Barnes, Sarah	215-555-3827
Riley, Mark	733-555-2969
Getz, Laura	663-555-3984
Phelps, Frank	322-555-2284
Grant, Marsha	243-555-2837
Grant, Sam	123-456-7890
Riley, Margory	012-345-6789
Smith, Larry	464-555-3489

PostOrder Transversal
Grant, Sam	123-456-7890
Grant, Marsha	243-555-2837
Riley, Margory	012-345-6789
Phelps, Frank	322-555-2284
Getz, Laura	663-555-3984
Riley, Mark	733-555-2969
Barnes, Sarah	215-555-3827
Smith, Larry	464-555-3489
Smith, John	610-555-7384

Using toString
Smith, Larry	464-555-3489
Smith, John	610-555-7384
Riley, Mark	733-555-2969
Riley, Margory	012-345-6789
Phelps, Frank	322-555-2284
Grant, Sam	123-456-7890
Grant, Marsha	243-555-2837
Getz, Laura	663-555-3984
Barnes, Sarah	215-555-3827

The myTree is not empty
Tree height is 6
Size of myTree is 9
The number of leaves is 3

Find which node in the myTree? 
First name: Laura
Last name: Getz
Getz, Laura	 is in this myTree is true

Delete which node in the myTree? 
First name: Larry
Last name: Smith
Smith, Larry	 has been processed, check to see if it has been removed.

InOrder Transversal
Barnes, Sarah	215-555-3827
Getz, Laura	663-555-3984
Grant, Marsha	243-555-2837
Grant, Sam	123-456-7890
Phelps, Frank	322-555-2284
Riley, Margory	012-345-6789
Riley, Mark	733-555-2969
Smith, John	610-555-7384

Go Again (y/n)? 
y
The myTree is empty
How many contacts do you wish to add to the myTree? 1

Enter #1
First name: Fred
Last name: Mays
Phone number: 234-567-8901

InOrder Transversal
Barnes, Sarah	215-555-3827
Getz, Laura	663-555-3984
Grant, Marsha	243-555-2837
Mays, Fred	234-567-8901
Phelps, Frank	322-555-2284
Riley, Mark	733-555-2969
Smith, John	610-555-7384
Smith, Larry	464-555-3489

PreOrder Transversal
Smith, John	610-555-7384
Barnes, Sarah	215-555-3827
Riley, Mark	733-555-2969
Getz, Laura	663-555-3984
Phelps, Frank	322-555-2284
Grant, Marsha	243-555-2837
Mays, Fred	234-567-8901
Smith, Larry	464-555-3489

PostOrder Transversal
Mays, Fred	234-567-8901
Grant, Marsha	243-555-2837
Phelps, Frank	322-555-2284
Getz, Laura	663-555-3984
Riley, Mark	733-555-2969
Barnes, Sarah	215-555-3827
Smith, Larry	464-555-3489
Smith, John	610-555-7384

Using toString
Smith, Larry	464-555-3489
Smith, John	610-555-7384
Riley, Mark	733-555-2969
Phelps, Frank	322-555-2284
Mays, Fred	234-567-8901
Grant, Marsha	243-555-2837
Getz, Laura	663-555-3984
Barnes, Sarah	215-555-3827

The myTree is not empty
Tree height is 6
Size of myTree is 8
The number of leaves is 2

Find which node in the myTree? 
First name: Bill
Last name: Jones
Jones, Bill	 is in this myTree is false

Delete which node in the myTree? 
First name: Bill
Last name: Jones
Jones, Bill	 has been processed, check to see if it has been removed.

InOrder Transversal
Barnes, Sarah	215-555-3827
Getz, Laura	663-555-3984
Grant, Marsha	243-555-2837
Mays, Fred	234-567-8901
Phelps, Frank	322-555-2284
Riley, Mark	733-555-2969
Smith, John	610-555-7384
Smith, Larry	464-555-3489

Go Again (y/n)? 
n

**********************************************************************/