// Author & Date: Xiaomeng Cao & 5/9/2016
// Program Name: BinaryTreeObjectExample3
// Description: Add number into the myTree, and traverse myTree using 3 methods.

public class BinaryTreeIntegerExample 
{
    public static void main(String[] args)
    {
        // Static variables, objects, etc
        BinaryTree<Integer> myTree = new BinaryTree<Integer>();
		
        // insert each number into the myTree
        myTree.insertNode(10);
        myTree.insertNode(18);
        myTree.insertNode(6);
        myTree.insertNode(14);
        myTree.insertNode(2);
        myTree.insertNode(0);
        myTree.insertNode(-6);
		
        // Traverse myTree using 3 methods
        System.out.println("InOrder Transversal");
        myTree.displayInOrder();
        System.out.println();
        System.out.println("PreOrder Transversal");
        myTree.displayPreOrder();
        System.out.println();
        System.out.println("PostOrder Transversal");
        myTree.displayPostOrder();
        System.out.println();       
        System.out.println("Using toString");
        System.out.println(myTree);	
		
        // show that the myTree is not empty
        if (myTree.isEmpty())
            System.out.println("Tree is empty");
        else
            System.out.println("Tree is not empty");
            
		  // Show the height of the myTree, size of the myTree and the # of leaves
        System.out.println("Tree height is " + myTree.height());
        System.out.println("Size of tree is " + myTree.size());	
        System.out.println("The number of leaves is " + myTree.numLeaf());
    }
}
