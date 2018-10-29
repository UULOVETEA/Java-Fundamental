	/**
	 * This is the node of in a tree. It holds a value and two references to its
	 * left and right child nodes. 
	 * 
	 * @author Xiaomeng Cao
	 *
	 * @param <T>
	 */
	public class TreeNode<T extends Comparable<T>>
	{
		T value;
		TreeNode<T> left;
		TreeNode<T> right;
		
		TreeNode(T obj)
		{
			left = null;
			right = null;
			value = obj;
		}
		
	    public int compareTo(TreeNode<T> other)
	   {
	        return ( value.compareTo(other.value));
	   }
	}