package carDealershipProgram;

public class LinkedList {

	private Node head;
	
	private class Node{
		Comparable data;
		Node next;
		
		public Node(Comparable data) {
			data = data;
			next = null;
		}
//		TODO finish insert method
		private Node insert(Comparable value)
		{
			if(data.compareTo(value) > 0)
			{
				
			}
//			remove following line
			return null;
		}
	}
	
//	Constructor
	public LinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
	}
	
//	Returns reference to beginning of list
	public Node getHead() 
	{
		return head;
	}
	
//	Returns true if list is empty, false if nodes exist
	public boolean isListEmpty() 
	{
		return head == null ? true : false;
	}
	
	
	public void addNode(Comparable value) 
	{
		head = this.isListEmpty() ? new Node(value) : head.insert(value);
	}

}
