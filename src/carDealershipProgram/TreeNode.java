package carDealershipProgram;

public class TreeNode {

//	Attributes
	Comparable data;
	TreeNode leftNode;
	TreeNode rightNode;
	
	public TreeNode(Comparable inputData) {
		data = inputData;
		leftNode = null;
		rightNode = null;
	}
	
//	Getters
	public Comparable getData() {return data;}
	public TreeNode getLeftNode() {return leftNode;}
	public TreeNode getRightNode() {return rightNode;}
	
//	Recursive method called by tree
	public TreeNode insert(Comparable inValue) {
//		If inValue is the same as the current nodes value
		if (inValue.equals(this.data)) {
//			TODO Add actual exception as opposed to 
			System.out.println("Error : Attempted to add duplicate");
		}
		else if( inValue.compareTo(data) < 1) { //Insert left
			if( leftNode == null) {
				leftNode = new TreeNode(inValue);
			}
			else {
				leftNode = leftNode.insert(inValue);
			}
		}
		else if( inValue.compareTo(data) >= 0) { //Insert right
			if( rightNode == null) {
				rightNode = new TreeNode(inValue);
			}
			else {
				rightNode = rightNode.insert(inValue);
			}
		}
		return this;
	}
	
	/*Recursive remove
	 * Note : Called by tree
	 * */
	public boolean remove(TreeNode parentNode, Comparable data)
	{
		//input Data is less than current nodes data => move left
		if(data.compareTo(this.getData()) == -1)
		{
			//If the left branch is empty return false, otherwise traverse
			return (this.leftNode != null)
					? this.leftNode.remove(this, data) 
					: false;
		}
		//Input Data is greater than current nodes data => move right
		else if(data.compareTo(this.getData()) == 1)
		{
			return (this.rightNode != null) 
					? this.rightNode.remove(this, data) 
					: false;
		}
//		Values match
		else {
			if(this.leftNode != null && this.rightNode != null)
			{
//				Replace nodes data with min value of right branch
				this.data = this.rightNode.minValue();
//				Remove the node thats data was duplicated
				this.rightNode.remove(this, this.data);
			}
			else if(parentNode.leftNode == this)
			{
				parentNode.leftNode = (leftNode != null) ? leftNode : rightNode;
			}
			else if(parentNode.rightNode == this)
			{
				parentNode.rightNode = (rightNode != null) ? leftNode : rightNode;
			}
			return true;
		}
	}
	
    public Comparable minValue() {
          if (leftNode == null)
                return data;
          else
                return leftNode.minValue();
    }
    

	
	@Override
	public String toString() {
		return this.data.toString();
	}
	
//	Setters

//	
	
	
}
