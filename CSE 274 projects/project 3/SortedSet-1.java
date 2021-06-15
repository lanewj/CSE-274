
/**
 * A linked-node implementation of the Set ADT in which elements of the set
 * are always sorted (in this case, lexicographically, which is a fancy
 * way of saying "alphabetically").  Note that the String class has a compareTo
 * method which you should be using to assist you in keeping the set sorted.
 * 
 */

public class SortedSet implements SetInterface 
{
	private Node head;
	public SortedSet() {
		head = null;

	}

	@Override
	public int getCurrentSize() 
	{
		int count = 0;
		Node ret = head;
		if(head==null)
		{
			return 0;
		}

		while (ret!=null)
		{

				count=count+1;
				ret = ret.next;
				
		}
		return count;

	}

	@Override
	public boolean isEmpty() 
	{
		/*if(this.getCurrentSize()>0)
		{
			return false;
		}
		else {
			return false;
		}*/
		return head == null;
	}
	public String remove() 
	{
		String ret;
		if(head==null)
		{
			return null;
		}
		else
		{
			
		
			ret = head.data;
			head=head.next;
			return ret;
		}

	}

	@Override
	public void clear() 
	{
		head = null;
	}
	// i used the method given in the course text to right my add method
	@Override
	public boolean add(Object newEntry) 
	{
		/*Node n;
		if(head==null)
		{
			head = new Node((String)newEntry);
			System.out.println("empty add");
			return true;
			
		}
		if(this.contains(newEntry))
		{
			return false;
		}
		if(head.next==null)
		{
			if(head.data.compareTo((String)newEntry)> 0)
			{
				head.next = new Node((String) newEntry);
				System.out.println("head add add");
				return true;
			}
			else 
			{
				n = new Node((String)newEntry);
				n.next = head;
				head = n;
				System.out.println("adding to front");
				return true;
			}
		}
		Node prev = null;
		Node current = head;
		while(current!=null)
		{
			if(current.data.compareTo((String)newEntry)>0 && prev.data.compareTo((String)newEntry)<0)
			{
				n = new Node((String)newEntry);
				prev.next = n;
				n.next =current;
				System.out.println("big add");
				return true;
			}
			prev=current;
			current=current.next;
		}
		Node last = head;
		while(current!=null)
		{
			last = last.next;
		}
		System.out.println("adding to end");
		last.next = new Node((String)newEntry);
		return true;*/
		if(this.contains(newEntry))
		{
			return false;
		}
		Node n = new Node((String)newEntry);
		Node prev = getNodeBefore(newEntry);
		
		if(this.isEmpty()||(prev==null))
		{
			n.next = head;
			head = n;
			return true;
		}
		else
		{
			Node next = prev.next;
			n.next = next;
			prev.next = n;              
			return true;
		}
		
	}
	private Node getNodeBefore(Object anEntry)
	{
		Node current = head;
		Node prev = null;
		String entry = (String)anEntry;
		
		while((current!=null)&& ((entry.compareTo(current.data)) > 0))
		{
			prev = current;
			current = current.next;
		}
		return prev;
	}
	@Override
	public boolean remove(Object anEntry) 
	{
		Node current = head;
		Node prev = null;
		int size = this.getCurrentSize();
		if(current==null)
		{return false;}
		
		if (current.data.equals(anEntry))
		{
			remove();
			return true;
		}
		current = head.next;
		prev = head;
		while(current!=null)
		{
			if(current.data.equals(anEntry))
			{
				prev.next=current.next;
				size--;
				return true;
			}
			prev=current;
			current=current.next;
		}
		return false;
	}
	@Override
	public boolean contains(Object anEntry) {
		Node current = head;
		while(current!=null)
		{
			if(current.data.equals(anEntry))
			{
				return true;
			}
			current=current.next;
		}
		return false;
	}
	/*
	 * returns a string representation of the items in the bag,
	 * specifically a space separated list of the strings, enclosed
	 * in square brackets [].  For example, if the set contained
	 * cat, dog, then this should return "[cat dog]".  If the
	 * set were empty, then this should return "[]".
	 */
	@Override
	public String toString() 
	{
		String result = "[ ";
		Node current = head;
		while (current != null) {
			result = result + current.data + " ";
			current = current.next;
		}
		result = result + " ]";
		return result;
	}
	@Override
	public String[] toArray()
	{
		int size = this.getCurrentSize();
		String[] ret = new String[size];
		int count =0;
		Node current = head;
		while (current != null)
		{
			ret[count]=current.data;
			count++;
			current = current.next;
		}
		return ret;
	}
	private class Node {
		private String data;
		private Node next;
		
		private Node(String data) {
			this.data = data;
			this.next = null;
		}
	}
}

