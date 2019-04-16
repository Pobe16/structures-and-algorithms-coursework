package carDealershipProgram;

import java.util.ArrayList;


public class Tree {
//	Attributes
	private TreeNode root;
	
//	Constructor initialises tree with root set to null
	public Tree() 
	{
		root = null;
	}

	
//	Getters
	//Return private property root
	public TreeNode getRoot() {return root;}
	
//	If roots empty returns true
	private boolean isRootEmpty() {return root == null ? true : false;}
	
	public void insertNode(Comparable insertValue) 
	{
//		If root is empty create new node, otherwise begin recursive insert method
		root = this.isRootEmpty() ? new TreeNode(insertValue) : root.insert(insertValue);
	}
	
	public boolean removeNode(Comparable removedNode)
	{
		/*Algorithm
		 * If no root exists return false
		 * else
		 * begin recursive remove s
		 * */
		return (root == null) ? false : root.remove(null, removedNode);
	}
	
	public boolean contains (Comparable value)
	{ 
		return containsHelper( root , value); 
	} 
	
	private boolean containsHelper(TreeNode node, Comparable value) 
	{
//		System.out.println(node.data.toString());
		if(node == null)
		{
			return false;
		}
		else if( node.data.toString().toLowerCase().equals(value.toString().toLowerCase())) 
		{
			return true;
		}
		else {
			return containsHelper(node.leftNode, value) || containsHelper(node.rightNode, value);
		}
	}
	
	public boolean containsInRegistration(Comparable value) {
		return containsInRegistrationHelper(root, value);
	}
	
	public boolean containsInRegistrationHelper(TreeNode node, Comparable value) {
		if(node == null)
		{
			return false;
		}
		else if( node.data.toString().toLowerCase().contains("registration number : " + value.toString().toLowerCase() + "\n")) 
		{
			return true;
		}
		else {
			return containsInRegistrationHelper(node.leftNode, value) || containsInRegistrationHelper(node.rightNode, value);
		}
	}
	
	public void inOrderTraversal()
	{
		inOrderHelper(root);
		System.out.println("__________\nEND OF LIST");
	}
	
	private void inOrderHelper(TreeNode node)
	{
		if(node == null)
			return;
		
		inOrderHelper( node.getLeftNode() );
		System.out.println(node.getData());
//		System.out.printf( "%S ", node.getData());
		inOrderHelper( node.getRightNode() );
	}
	
	public int findNumberOf(Car inValue) {
		ArrayList<Comparable> foundMatches = new ArrayList<Comparable>();
		foundMatches = findNumberOfHelper(root, foundMatches, inValue);
		return foundMatches.size();
	}
	
	private ArrayList<Comparable> findNumberOfHelper(TreeNode node, ArrayList<Comparable> foundMatches, Car inValue) {
		if( node != null ) {
			Car tempCar = (Car)node.getData();
			String manufacturer = tempCar.getName().toLowerCase();
			String model = tempCar.getModel().toLowerCase();
			if(inValue.getName().toLowerCase().equals(manufacturer) && inValue.getModel().toLowerCase().equals(model)) {
				foundMatches.add(node.getData());
			}
			findNumberOfHelper(node.getLeftNode(), foundMatches, inValue);
			findNumberOfHelper(node.getRightNode(), foundMatches, inValue);
		}
		return foundMatches;
	}
	
//	Fix indentation
	public Tree balance() {
		ArrayList<Comparable> aux = new ArrayList<Comparable>();
		aux = BalanceHelper_GetListOfElements(root, aux);
		
		Comparable[] array = new Comparable[aux.size()]; 
		aux.toArray(array);
		
		int midPoint = array.length / 2;
		
		Tree balanced = blancedHelper_InsertElementsIntoNewTree(array, midPoint);
		
		return balanced;
   
	}

	private Tree blancedHelper_InsertElementsIntoNewTree(Comparable[] array, int midPoint) {
		Tree balanced = new Tree();
		balanced.insertNode(array[midPoint]);
		
		int leftMidPoint = midPoint / 2;
		int rightMidPoint = midPoint * 3 / 4;
		
		
	   
		for (int i = midPoint +1; i < array.length; i++) {
			balanced.insertNode(array[i]);
		}
		for (int i = 0; i< midPoint; i++) {
			balanced.insertNode(array[i]);
		}
		return balanced;
		 
	}

	private ArrayList<Comparable> BalanceHelper_GetListOfElements(TreeNode node, ArrayList<Comparable> aux) {	
		if ( node != null ) {
			BalanceHelper_GetListOfElements( node.getLeftNode(), aux );        // traverse left subtree
			aux.add(node.getData()); // output node data
			BalanceHelper_GetListOfElements( node.getRightNode(), aux );       // traverse right subtree
		}	
	    return aux;
   	}
}
