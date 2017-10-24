import java.util.EmptyStackException;

/**
 * A class implementing an ADT QUEUE using a double linked node.
 * @author Zeeshan Abidi
 * @version 1.0
 * 
 * 
 *
 */

public class Deque<T> implements DequeInterface<T>
{	
	private DLNode<T> firstNode;		//pointer to beinging of line 	HEAD
	private DLNode<T> lastNode;		//pointer to end of line				TAIL
	
	
	public Deque()
	{
		firstNode = null;
		lastNode = null;
		
	}		//end constructor
	 
	@SuppressWarnings("hiding")
	public class DLNode<T>{
		private T data;
		private DLNode<T> previous;
		private DLNode<T> next;
		
		private DLNode(DLNode<T> previousNode, T data, DLNode<T> nextNode) {
			this.data = data;
			next = nextNode;
			previous = previousNode;
		}
		
		private T getData()
		{
			return data;
		}
		
		public void setNextNode(DLNode<T> node) {			
			next = node;
		}
		private DLNode<T> getNextNode()
		{
			return next;
		}
		
		
		public void setPreviousNode(DLNode<T> node) {
				previous = node;
			}
		private DLNode<T> getPreviousNode() {
				return previous;
		}
	}

	
	public void addToFront(T newEntry) {
		//create a new node
		// set it to the front of the line
		// fix all pointers 
		DLNode<T> newNode = new DLNode<T>(null, newEntry, firstNode);	//address,data,address
		
		if (isEmpty())	
			lastNode = newNode;	//if empty, new node <--- last node
		else
			firstNode.setPreviousNode(newNode);		//new node <----- old first 
		firstNode = newNode;							//first  ------> new node
		
	}

	public void addToBack(T newEntry) {
		//create a new node
		//set it to the back of the line
		// fix all pointers
		DLNode<T> newNode = new DLNode<T>(lastNode,newEntry,null);
		
		if(isEmpty())
			firstNode = newNode;		//if empty, first --> new node
		else
			lastNode.setNextNode(newNode);		//old last ---> new node
		lastNode = newNode;						// last ---> new node
		
	}

	
	public T removeFront() {
		// Check if data is there. If not throw exception
		// set data in temp variable
		// delete data in DLNode
		// move head to next
		//	ONLY IF there is DLNode that head is pointing to then, move its prev to null
		T front = null;
			if(isEmpty())
			{
				throw new EmptyStackException();
			}
			else {								// if not empty
				front = (T) firstNode.getData();  		// set first node in the list to front(temp value)
				firstNode = firstNode.getNextNode();		//set first node to next node in the list
				if(firstNode == null)					//if the new first node is not there
					lastNode = null;						// last node is set to first node (null)
				else 		
					firstNode.setPreviousNode(null);			//	ONLY IF there is DLNode that head is pointing to then, move its prev to null
				
				}
		return front;
	}

	
	
	public T removeBack() {
		//Check if there is data there if NOT throw exception
		//hold date in temp variable
		//delete data in DL NODE (for security)
		//move TAIL to prev
		//ONLY IF there is a DLNODE that 	
		T back = null;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else {
				back = (T) lastNode.getData();
				lastNode = lastNode.getPreviousNode();
				
				if(lastNode == null)
					firstNode= null;
				else 
					lastNode.setNextNode(null);
		}
		
		return back;
	}

	
	public T getFront() {
		if(!isEmpty())
			return ((T) firstNode.getData());			
		
		return null;
	}

	public T getBack() {
		if(!isEmpty())
			return ((T) lastNode.getData());
		
		return null;
	}

	
	public boolean isEmpty() {
		if(firstNode == null && lastNode == null)
			return true;
		return false;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		}	
	}