import java.util.EmptyStackException;

public class SingleDeque<T> implements DequeInterface<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	private class Node<T>{
		private T data;
		private Node<T> next;
		
		private Node(T data, Node<T> nextNode)
		{
			this.data = data;
			next = nextNode;
		}
		private T getData()
		{
			return data;
		}
		
		private Node<T> getNextNode()
		{
			return next;
		}
		private void setNextNode(Node<T> node)
		{
			
				next= node;
		}
		
	}
	
	public SingleDeque() {
		lastNode = null;
	}

	
	@Override
	public void addToFront(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry, firstNode);
			if (isEmpty())
				firstNode = newNode;
			else
				newNode.setNextNode(firstNode);			
				firstNode = newNode;
	}
	@Override
	public void addToBack(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry,null);
		if (isEmpty()) {
			firstNode = newNode;
		}
			else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;
	}

	@Override
	public T removeFront() {
		T front = null;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else {
			front = firstNode.getData();		//put firstnode in temp variable
			firstNode = firstNode.getNextNode();		// FirstNode now is the next node in the link
			
			if(firstNode == null) 		//if new first node is not connected to anything then ..
				lastNode = null;
		}
		return front;
	}

	@Override
	public T removeBack() {
		T front = null;
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			front = lastNode.getData();
			lastNode = lastNode.getNextNode();	
		}		
		return front;
	}

	@Override
	public T getFront() {
		if(!isEmpty())
			return firstNode.getData();
		return null;
	}

	@Override
	public T getBack() {
		if(!isEmpty())
			return lastNode.getData();
		return null;
	}

	@Override
	public boolean isEmpty() {
		if((firstNode == null) && (lastNode ==null))
			return true;
			
		return false;
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
		
	}

}
