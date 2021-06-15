import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T> {
private Node topNode;
	
	public LinkedStack()
	{
		topNode=null;
	}
	 
	public class Node {
		private T data;
		private Node next;

		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

	
		private Node(T data) {
			this(data, null);
		}
		private T getData()
		{
			return data;
		}
		private Node getNext()
		{
			return next;
		}
		private void setNext(Node n)
		{
			next=n;
		}
		private void setData(T d)
		{
			data=d;
		}
	}

	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		
		topNode=newNode;
			
		
	}

	@Override
	public T pop() {
		T top = peek();
		
		assert topNode !=null;
		topNode = topNode.getNext();
		return top;
	}

	@Override
	public T peek() {
		if(isEmpty())
		{
			throw new EmptyStackException();	
		}
		else
			return topNode.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return topNode==null;
	}

	@Override
	public void clear() {
		topNode=null;
		
	}

}
